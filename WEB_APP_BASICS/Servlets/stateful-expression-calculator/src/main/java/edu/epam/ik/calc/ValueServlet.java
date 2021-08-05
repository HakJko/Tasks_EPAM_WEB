package edu.epam.ik.calc;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet(urlPatterns = {"/calc/*"})
public class ValueServlet extends HttpServlet {

    @Override
    protected void doPut(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        HttpSession session = req.getSession();
        String str = req.getRequestURI().substring(6);
        String value = req.getReader().readLine();
        if (Validation.validationVariable(value)) {
            if (session.getAttribute(str) == null) {
                resp.setStatus(201);
            }
            else {
                resp.setStatus(200);
            }
            session.setAttribute(str, value);
        } else {
            resp.setStatus(403);
        }
    }

    @Override
    protected void doDelete(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        HttpSession session = req.getSession();
        String str = req.getRequestURI().substring(6);
        session.setAttribute(str, null);
        resp.setStatus(204);
    }
}
