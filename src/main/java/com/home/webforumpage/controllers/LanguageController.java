package com.home.webforumpage.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;

/**
 * Контролер переключает язык приложения
 * */
@RestController
public class LanguageController {

    /**
     * Метод переключает язык приложения
     *
     * @return String
     * */
    @RequestMapping("/langselector")
    public String languageSelector(
            @RequestParam String lang,
            HttpServletResponse response
    ){
        response.addCookie(new Cookie("language", lang));
        return "ок";
    }

}
