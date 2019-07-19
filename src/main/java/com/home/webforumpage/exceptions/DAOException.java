package com.home.webforumpage.exceptions;

/**
 * Класс сохраняет инфо об ошибках, связанных с работой dao-методов
 * */
public class DAOException extends RuntimeException {

    public DAOException(String message) { super(message); }

    public DAOException(String message, Throwable cause) { super(message, cause); }
}
