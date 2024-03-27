package pl.jc.notesApp.servlets;


import jakarta.servlet.annotation.HttpMethodConstraint;
import jakarta.servlet.annotation.ServletSecurity;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;


/**
 * Servlet that handles login page.
 * Currently, authorization is provided by Tomcat's realm container managed security,
 * Options can be found in webapp/WEB-INF/web.xml and /webapp/META-INF/context.xml
 */
@WebServlet("/login")
@ServletSecurity(
        httpMethodConstraints = {
                @HttpMethodConstraint(value = "GET", rolesAllowed = "USER"),
                @HttpMethodConstraint(value = "Post", rolesAllowed = "USER")
        }
)
public class LoginServlet extends HttpServlet {

    //TODO Add alert when user provides wrong username/password
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        resp.sendRedirect(req.getContextPath() + "/notes");
    }

}
