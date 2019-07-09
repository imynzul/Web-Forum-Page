package com.home.webforumpage.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;

@RestController
public class LanguageController {

    @RequestMapping("/langselector")
    public String languageSelector(@RequestParam String lang, HttpServletResponse response){
        response.addCookie(new Cookie("language", lang));

        return "ок";
    }

}
