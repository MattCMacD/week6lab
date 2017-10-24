/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package classes;

import java.io.IOException;
import javax.servlet.ServletRequest;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.JspFragment;
import javax.servlet.jsp.tagext.SimpleTagSupport;
import javax.servlet.jsp.tagext.TagSupport;

/**
 *
 * @author 728918
 */
public class DebugTag extends TagSupport {

    @Override
    public int doStartTag() throws JspException {

        
        
        if (pageContext.getRequest().getServerName().startsWith("test") || pageContext.getRequest().getServerName().equals("localhost")) {
            if (pageContext.getRequest().getParameter("debug") != null) {
                return EVAL_BODY_INCLUDE;
            }
            else {
                return SKIP_BODY;
            }
        }
        return SKIP_BODY;
    }

}
