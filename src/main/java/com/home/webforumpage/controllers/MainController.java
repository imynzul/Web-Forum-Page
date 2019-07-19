package com.home.webforumpage.controllers;

import com.home.webforumpage.dao.ArticlesDao;
import com.home.webforumpage.dao.CommentsDao;
import com.home.webforumpage.dao.UsersDao;
import com.home.webforumpage.entity.Articles;
import com.home.webforumpage.entity.Comments;
import com.home.webforumpage.entity.Users;
import com.home.webforumpage.validation.ArticleContentValidator;
import com.home.webforumpage.validation.CommentsValidator;
import org.hibernate.Hibernate;
import org.json.simple.JSONObject;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttribute;
import org.springframework.web.servlet.ModelAndView;
import java.sql.Date;
import java.time.LocalDate;

import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * Контролер, содержащий главные методы для работы
 * */
@Controller
public class MainController {


    /**
     * Метод возвращает index-страницу
     *
     * @return String с адресом index-страницы
     * */
    @RequestMapping({"/index", "/"})
    public String getIndex(){
        return "Index";
    }


    /**
     * Метод возвращает список всех статей и выполняет переход на страницу
     *
     * @return ModelAndView
     * */
    @RequestMapping("/listOfArticles")
    public ModelAndView getArticles(ModelAndView modelAndView){
        ArticlesDao articlesDao = new ArticlesDao();

        List<Articles> articlesList = articlesDao.getAll();
        articlesDao.closeCurrentSession();

        modelAndView.setViewName("ListOfArticles");
        modelAndView.addObject("articlesList",articlesList);

        return modelAndView;
    }


    /**
     * Метод возвращает список статей авторизованного пользователя и
     * выполняет переход на страницу его профиля
     *
     * @return String содержащий адрес страницы профиля
     * */
    @RequestMapping("/profile")
    public String getUserArticles(
            @SessionAttribute String login,
            Model model)
    {
        UsersDao ud = new UsersDao();
        Users user = ud.getByLogin(login);

        List<Articles> article = user.getArticlesList();
        Hibernate.initialize(article);
        model.addAttribute("articleList", article);

        ud.closeCurrentSession();
        return "Profile";
    }


    /**
     * Метод выполняет переходт на страницу админа и собирает список всех пользователей
     *
     * @return ModelAndView
     * */
    @RequestMapping("/admin")
    public ModelAndView getUsersList(ModelAndView modelAndView){

        UsersDao usersDao = new UsersDao();

        List<Users>allUsers = usersDao.getAll();
        modelAndView.setViewName("Admin");
        modelAndView.addObject("allUsers", allUsers);

        usersDao.closeCurrentSession();

        return modelAndView;
    }


    /**
     * Метод достает содержимое статьи и выполняет переход на страницу с данной статьей,
     * содержащюю контент и комментарии к данной статье
     *
     * @return String c именем страницы перехода
     * */
    @RequestMapping("/article")
    public String getArticleContent(
            @RequestParam String articleId,
            Model model,
            HttpSession session)
    {
        long id = Long.parseLong(articleId);
        ArticlesDao articlesDao = new ArticlesDao();
        Articles article = articlesDao.get(id);
        model.addAttribute("article", article);

        session.setAttribute("articleId", articleId);

        List<Comments> comments = article.getCommentsList();
        model.addAttribute("comments", comments);

        articlesDao.closeCurrentSession();

        return "Article";
    }


    /**
     * Метод сохраняет новый комментарий к статье
     *
     * @return String с результатами валидации содержимого комментария
     * */
    @RequestMapping(value = "/savecomment", produces = "application/json; charset=utf-8")
    @ResponseBody
    public String saveComment(
            @RequestParam String comment,
            HttpSession session)
    {
        CommentsValidator commentsValidator = new CommentsValidator();
        commentsValidator.validation(comment);

        if (commentsValidator.isValid()){
            CommentsDao commentsDao = new CommentsDao();
            UsersDao usersDao = new UsersDao();

            String login = (String)session.getAttribute("login");
            Users user = usersDao.getByLogin(login);
            long userId = user.getId();

            String artId = (String)session.getAttribute("articleId");
            long articleId = Long.parseLong(artId);

            Comments newComment = new Comments(articleId, comment, userId);
            commentsDao.insert(newComment);

            commentsDao.closeCurrentSession();
            usersDao.closeCurrentSession();
        }
        return commentsValidator.getJsonMessages().toJSONString();
    }


    /**
     * Метод сохраняет новую статью
     *
     * @return String строку с результатми работы валидатора
     * */
    @RequestMapping(value = "/savearticle", produces = "application/json; charset=utf-8")
    @ResponseBody
    public String saveArticle(
            @RequestParam String topic,
            @RequestParam String article,
            HttpSession session)
    {
        ArticleContentValidator contentValidator = new ArticleContentValidator();
        contentValidator.validation(topic, article);

        if (contentValidator.isValid()){

            Date date_issued = Date.valueOf(LocalDate.now());

            UsersDao usersDao = new UsersDao();
            String login = (String)session.getAttribute("login");
            Users user = usersDao.getByLogin(login);
            long userId = user.getId();
            usersDao.closeCurrentSession();

            ArticlesDao articlesDao = new ArticlesDao();
            Articles newArticle = new Articles(userId, topic, article, date_issued);
            long newArtId = articlesDao.insert(newArticle);

            JSONObject jsonObject = new JSONObject();
            jsonObject.put("newArtId", newArtId);

            articlesDao.closeCurrentSession();

            return jsonObject.toJSONString();
        } else{
            return contentValidator.getJsonMessages().toJSONString();
        }
    }


    /**
     * Метод удаялет статью из БД
     *
     * @return String со статусом операции
     * */
    @RequestMapping(value = "/delete", produces = "application/json; charset=utf-8")
    @ResponseBody
    public String deleteArticle(@RequestParam long id)
    {
        ArticlesDao articlesDao = new ArticlesDao();
        Articles article = articlesDao.get(id);
        articlesDao.delete(article);

        JSONObject jsonObject = new JSONObject();
        jsonObject.put("status", "deleted");

        articlesDao.closeCurrentSession();

        return jsonObject.toJSONString();
    }
}
