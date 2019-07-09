package com.home.webforumpage.tagsService;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.BodyTagSupport;
import java.io.IOException;

public class BodyTag extends BodyTagSupport {

    private String color;
    private String count;

    @Override
    public int doStartTag() throws JspException {
        return EVAL_BODY_BUFFERED;
    }

    @Override
    public int doAfterBody() throws JspException {
        String content = bodyContent.getString();
        JspWriter out = bodyContent.getEnclosingWriter();
        int x = Integer.parseInt(count);

        try {
            for (int i = 0; i < x; i++){
                out.print("<p style='color:"+ color + "'>" + content + "</p>");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return EVAL_PAGE;
    }

    @Override
    public int doEndTag() throws JspException {
        return EVAL_PAGE;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getCount() {
        return count;
    }

    public void setCount(String count) {
        this.count = count;
    }
}
