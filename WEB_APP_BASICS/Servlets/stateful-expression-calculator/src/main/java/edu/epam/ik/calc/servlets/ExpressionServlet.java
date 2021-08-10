package edu.epam.ik.calc.servlets;

import edu.epam.ik.calc.service.Validation;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet(urlPatterns = {"/calc/expression"})
public class ExpressionServlet extends HttpServlet {

    private static final int STATUS_200 = 200;
    private static final int STATUS_201 = 201;
    private static final int STATUS_204 = 204;
    private static final int STATUS_400 = 400;
    private static final int STATUS_403 = 403;

    @Override
    protected void doPut(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        HttpSession session = req.getSession();
        String expression = req.getReader().readLine();

        if (Validation.validationExpression(expression)) {
            if (session.getAttribute("expression") == null) {
                resp.setStatus(STATUS_201);
            } else {
                resp.setStatus(STATUS_200);
            }
            session.setAttribute("expression", expression);
        } else {
            resp.sendError(STATUS_400, "Wrong Format");
        }

    }

    @Override
    protected void doDelete(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        HttpSession session = req.getSession();
        session.setAttribute("expression", null);
        resp.setStatus(STATUS_204);
    }


}
