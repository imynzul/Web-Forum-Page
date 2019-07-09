package com.home.webforumpage.tagsService;

import com.home.webforumpage.exceptions.TagException;
import org.apache.log4j.Logger;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.TagSupport;
import java.io.IOException;
import java.util.Properties;

public class LocaleLanguageTag extends TagSupport {

    private String key;
    private static final Logger ExcLOGGER = Logger.getLogger("ExceptionLogger");

    @Override
    public int doStartTag() throws JspException {

        JspWriter out = pageContext.getOut();
        String language = "eng";

        HttpServletRequest request = (HttpServletRequest) pageContext.getRequest();
        Cookie[] cookies = request.getCookies();
        if (cookies != null){
            for (Cookie temp : cookies){
                if (temp.getName().equals("language")){
                    language = temp.getValue();
                }
            }
        }

        Properties properties = new Properties();
        try {
            properties.load(getClass().getResourceAsStream("/language_patterns/" + language + "_pattern.properties"));
            out.print(properties.getProperty(key));
        } catch (IOException e) {
            TagException tagException = new TagException("[Thread - " + Thread.currentThread().getName() + "] " +
                                      "Processing tag body error - key = " + key + ", language = " + language + ".", e);
            ExcLOGGER.error(tagException.getMessage(), tagException);
            throw tagException;
        }

        return EVAL_PAGE;
    }


    public void setKey(String key) {
        this.key = key;
    }
}
