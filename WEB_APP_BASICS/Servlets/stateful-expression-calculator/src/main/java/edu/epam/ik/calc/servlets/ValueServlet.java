package edu.epam.ik.calc.servlets;

import edu.epam.ik.calc.service.Validation;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

import static edu.epam.ik.calc.service.Status.getStatusValue;

@WebServlet(urlPatterns = {"/calc/*"})
public class ValueServlet extends HttpServlet {

    private static final int STATUS_204 = 204;

    @Override
    protected void doPut(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        HttpSession session = req.getSession();

        getStatusValue(session, req, resp);

    }

    @Override
    protected void doDelete(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        HttpSession session = req.getSession();
        String str = req.getRequestURI().substring(6);
        session.setAttribute(str, null);
        resp.setStatus(STATUS_204);
    }
}
