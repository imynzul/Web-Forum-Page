package com.home.webforumpage.tagsService;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.TagSupport;
import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class FormatDateTag extends TagSupport {
    private String format;

    @Override
    public int doStartTag() throws JspException {
        JspWriter out = pageContext.getOut();
        LocalDate date = LocalDate.now();
        DateTimeFormatter timeFormatter = DateTimeFormatter.ofPattern(format);

        try {
            out.print(date.format(timeFormatter));
        } catch (IOException e) {
            e.printStackTrace();
        }

        return EVAL_PAGE;
    }

    public String getFormat() {
        return format;
    }

    public void setFormat(String format) {
        this.format = format;
    }
}
