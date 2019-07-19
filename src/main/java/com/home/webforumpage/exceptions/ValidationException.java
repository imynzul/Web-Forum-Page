package com.home.webforumpage.exceptions;

import javax.servlet.ServletException;

/**
 * Класс сохраняет инфо, связанную с работой валидаторов
 * */
public class ValidationException extends ServletException {
    private String type;
    private String backPage;

    public ValidationException(String message, String type, String backPage) {
        super(message);
        this.type = type;
        this.backPage = backPage;
    }

    public String getType() { return type; }

    public void setType(String type) {
        this.type = type;
    }

    public String getBackPage() { return backPage; }

    public void setBackPage(String backPage) {
        this.backPage = backPage;
    }
}
