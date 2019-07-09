package com.home.webforumpage.validation;

import com.home.webforumpage.dao.UsersDao;
import com.home.webforumpage.dao.UsersInfoDao;
import com.home.webforumpage.entity.Users;
import com.home.webforumpage.entity.UsersInfo;
import org.json.simple.JSONObject;

public class AuthRegValidators {

    private static final String EMAIL_PATTERN = "^[-\\w.]+@([A-z0-9][-A-z0-9]+\\.)+[A-z]{2,4}$";
    private static final String LOGIN_PASSWORD_PATTERN = "^[а-яА-ЯёЁa-zA-Z0-9]+$";

    private JSONObject jsonMessages;
    private boolean valid;
    private Users userEntity;

    public AuthRegValidators() {
        jsonMessages = new JSONObject();
        valid = true;
    }

    public void getAuth(String login, String password){
        UsersDao usersDao = new UsersDao();

        if (!login.matches(LOGIN_PASSWORD_PATTERN)){
            jsonMessages.put("loginError", "Логин не соответсвует форме!");
            valid = false;
        }
        if (!password.matches(LOGIN_PASSWORD_PATTERN)){
            jsonMessages.put("passError", "Пароль не соответсвует форме!");
            valid = false;
        }
        if (valid){
            Users user = usersDao.getByLogin(login);
            usersDao.closeCurrentSession();
            if (user != null){
                if (password.equals(user.getPassword())) {
                    userEntity = user;
                } else{
                    jsonMessages.put("passError", "Пароль введен неверно!");
                    valid = false;
                }
            } else {
                jsonMessages.put("loginError", "Пользователь не существует!");
                    valid = false;
            }
        }
        jsonMessages.put("status", valid ? "verified" : "failed");
    }




    public void registrationCheck(String email, String login, String password, String rPassword){
        UsersDao usersDao = new UsersDao();
        UsersInfoDao usersInfoDao = new UsersInfoDao();

        if (!email.matches(EMAIL_PATTERN)){
            jsonMessages.put("emailError", "Email не соответсвует форме");
            valid = false;
        }
        if (!login.matches(LOGIN_PASSWORD_PATTERN)){
            jsonMessages.put("loginError", "Логин не соответсвует форме");
            valid = false;
        }
        if (!password.matches(LOGIN_PASSWORD_PATTERN) || !rPassword.matches(LOGIN_PASSWORD_PATTERN)){
            jsonMessages.put("passError", "Пароль не соответсвует форме");
            valid = false;
        }
        if (!password.equals(rPassword)){
            jsonMessages.put("passError", "Пароли не совпадают");
            valid = false;
        }
        if (valid){
            UsersInfo userInfo = usersInfoDao.getByEmail(email);
            usersInfoDao.closeCurrentSession();
            if (userInfo != null){
                jsonMessages.put("emailError", "Email уже занят");
                valid = false;
            }
            Users user = usersDao.getByLogin(login);
            usersDao.closeCurrentSession();
            if (user != null){
                jsonMessages.put("loginError", "Логин уже занят");
                valid = false;
            }
        }
        jsonMessages.put("status", valid ? "verified" : "failed");
    }

    public JSONObject getJsonMessages() {
        return jsonMessages;
    }

    public boolean isValid() {
        return valid;
    }

    public Users getUserEntity() {
        return userEntity;
    }
}
