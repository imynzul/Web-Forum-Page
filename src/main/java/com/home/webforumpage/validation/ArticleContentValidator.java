package com.home.webforumpage.validation;

import org.json.simple.JSONObject;

/**
 * Класс валидатор, выполняет валидацию содержимого новой статьи
 * */
public class ArticleContentValidator {
    private JSONObject jsonMessages;
    private boolean valid;

    public ArticleContentValidator() {
        jsonMessages = new JSONObject();
        valid = true;
    }


    /**
     * Метод выполняет валидацию содержимого статьи
     * */
    public void validation(String topic, String article){
        if (topic.length() < 1){
            jsonMessages.put("topic", "Write the topic...");
            valid = false;
        }

        if (article.length() < 1){
            jsonMessages.put("article", "Write some content...");
            valid = false;
        }
        jsonMessages.put("status", valid ? "verified" : "failed");
    }

    public JSONObject getJsonMessages() {
        return jsonMessages;
    }

    public boolean isValid() {
        return valid;
    }
}
