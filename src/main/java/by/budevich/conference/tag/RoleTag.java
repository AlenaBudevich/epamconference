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
        try {
            String userRole = null;
            if ("ADMIN".equalsIgnoreCase(role)) {
                userRole = "Hi, " + role;
            } else {
                userRole = "Welcome, " + role;
            }
            pageContext.getOut().write(userRole);
        } catch (IOException e) {
            throw new JspException(e.getMessage());
        }
        return SKIP_BODY;
    }
}