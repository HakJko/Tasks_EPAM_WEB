package edu.epam.ik.calc.servlets;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

import static edu.epam.ik.calc.service.Status.getStatusExpression;

@WebServlet(urlPatterns = {"/calc/expression"})
public class ExpressionServlet extends HttpServlet {

    private static final int STATUS_204 = 204;

    @Override
    protected void doPut(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        HttpSession session = req.getSession();
        String expression = req.getReader().readLine();
        getStatusExpression(expression, session, resp);

    }

    @Override
    protected void doDelete(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        HttpSession session = req.getSession();
        session.setAttribute("expression", null);
        resp.setStatus(STATUS_204);
    }


}