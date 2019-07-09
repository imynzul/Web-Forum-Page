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

@Controller
public class MainController {


    @RequestMapping({"/index", "/"})
    public String getIndex(){
        return "Index";
    }


    @RequestMapping("/listOfArticles")
    public ModelAndView getArticles(ModelAndView modelAndView){
        ArticlesDao articlesDao = new ArticlesDao();

        List<Articles> articlesList = articlesDao.getAll();
        articlesDao.closeCurrentSession();

        modelAndView.setViewName("ListOfArticles");
        modelAndView.addObject("articlesList",articlesList);

        return modelAndView;
    }


    @RequestMapping("/profile")
    public String getUserArticles(@SessionAttribute String login, Model model){
        UsersDao ud = new UsersDao();
        Users user = ud.getByLogin(login);

        List<Articles> article = user.getArticlesList();
        Hibernate.initialize(article);
        model.addAttribute("articleList", article);

        ud.closeCurrentSession();
        return "Profile";
    }


    @RequestMapping("/admin")
    public ModelAndView getUsersList(ModelAndView modelAndView){
        UsersDao usersDao = new UsersDao();

        List<Users>allUsers = usersDao.getAll();
        modelAndView.setViewName("Admin");
        modelAndView.addObject("allUsers", allUsers);

        usersDao.closeCurrentSession();

        return modelAndView;
    }


    @RequestMapping("/article")
    public String getArticleContent(@RequestParam String articleId, Model model, HttpSession session){
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


    @RequestMapping(value = "/savecomment", produces = "application/json; charset=utf-8")
    @ResponseBody
    public String saveComment(@RequestParam String comment, HttpSession session){

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
        return commentsValidator.getJsonMessages().toJSONString(); //при возникновении ошибки в валидации, не выводится нужный текст об ошибке
    }


    @RequestMapping(value = "/savearticle", produces = "application/json; charset=utf-8")
    @ResponseBody
    public String saveArticle(@RequestParam String topic ,@RequestParam String article , HttpSession session){

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
     * TODO
     * дописать возможность удаления статьи
     **/
    public String deleteArticle(){
        return "ok";
    }


    @RequestMapping("/testController")
    @ResponseBody
    public String testController(){
        return "Hello AJAX!!";
    }
}
