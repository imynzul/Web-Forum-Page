package com.home.webforumpage.controllers;

import com.home.webforumpage.dao.UsersDao;
import com.home.webforumpage.dao.UsersInfoDao;
import com.home.webforumpage.entity.Users;
import com.home.webforumpage.entity.UsersInfo;
import com.home.webforumpage.validation.AuthRegValidators;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@RestController
public class AuthRegController {

    @RequestMapping(value = "/auth", produces = "application/json; charset=utf-8")
    public String authorization(
            @RequestParam String login,
            @RequestParam String password,
            HttpSession session)
    {

        AuthRegValidators authRegValidators = new AuthRegValidators();
        authRegValidators.getAuth(login, password);

        if (authRegValidators.isValid()) {
            Users user = authRegValidators.getUserEntity();
            session.setAttribute("auth", true);
            session.setAttribute("login", login);
            session.setAttribute("admin", user.getUserInfo().getRole() == 2);
        }
        return authRegValidators.getJsonMessages().toJSONString();
    }

    @RequestMapping(value = "/reg", produces = "application/json; charset=utf-8")
    public String registration(
            @RequestParam String email,
            @RequestParam String login,
            @RequestParam String password,
            @RequestParam String rPassword,
            Model model
    ){

        AuthRegValidators authRegValidators = new AuthRegValidators();
        authRegValidators.registrationCheck(email, login, password, rPassword);

        if (authRegValidators.isValid()){
            UsersDao usersDao = new UsersDao();
            UsersInfoDao usersInfoDao = new UsersInfoDao();

            Users newUser = new Users(login, password);
            long newId = usersDao.insert(newUser);
            usersDao.closeCurrentSession();

            UsersInfo usersInfo = new UsersInfo(newId, email);
            usersInfoDao.insert(usersInfo);
            usersInfoDao.closeCurrentSession();
        }
        return authRegValidators.getJsonMessages().toJSONString();
    }

    @RequestMapping("/out")
    public String out(HttpSession session, HttpServletRequest request) {
        session.invalidate();
        Cookie[] cookies = request.getCookies();
        if (cookies != null){
            for(Cookie temp : cookies){
                if (temp.getName().equals("auth")){
                    temp.setValue("false");
                }
            }
        }
        return "ОК";
    }

}
