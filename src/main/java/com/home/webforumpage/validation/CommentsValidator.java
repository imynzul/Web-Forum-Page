package com.home.webforumpage.validation;

import org.json.simple.JSONObject;

/**
 * Класс выполняет валидацию введенного комментария
 * */
public class CommentsValidator {

    private JSONObject jsonMessages;
    private boolean valid;

    public CommentsValidator() {
        jsonMessages = new JSONObject();
        valid = false;
    }


    /**
     * Метод выполняет валидацию комментария
     * */
    public void validation(String comment){
        if (comment.length() >= 1){
            jsonMessages.put("status", "verified");
            valid = true;
        } else {
            jsonMessages.put("commentInfo", "Comment should not be empty!");
            jsonMessages.put("status", "failed");
        }
    }

    public JSONObject getJsonMessages() {
        return jsonMessages;
    }

    public boolean isValid() {
        return valid;
    }
}
