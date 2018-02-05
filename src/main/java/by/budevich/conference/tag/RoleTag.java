package by.budevich.conference.tag;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.TagSupport;
import java.io.IOException;

@SuppressWarnings("serial")
public class RoleTag extends TagSupport {
    private String role;

    public void setRole(String role) {
        this.role = role;
    }

    @Override
    public int doStartTag() throws JspException {
        String userRole = null;
        userRole = "You are " + role;
        try {
            pageContext.getOut().write(userRole);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return SKIP_BODY;
    }
}