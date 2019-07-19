package com.home.webforumpage.exceptions;

/**
 * Класс сохраняет инфо об ошибках, связанных с работой пользовательских тэгов
 * */
public class TagException extends RuntimeException {

    public TagException(String message) { super(message); }

    public TagException(String message, Throwable cause) { super(message, cause); }
}
