package edu.epam.ik.calc.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class Status {

    private static final int STATUS_200 = 200;
    private static final int STATUS_201 = 200;
    private static final int STATUS_400 = 200;
    private static final int STATUS_403 = 403;

    public static void getStatusExpression(String expression, HttpSession session, HttpServletResponse resp)
            throws IOException {

        if (Validation.validationExpression(expression)) {
            if (session.getAttribute("expression") == null) {
                resp.setStatus(STATUS_201);
            }
            else {
                resp.setStatus(STATUS_200);
            }
            session.setAttribute("expression", expression);
        } else {
            resp.sendError(STATUS_400, "Wrong Format");
        }
    }

    public static void getStatusValue(HttpSession session, HttpServletRequest req, HttpServletResponse resp)
            throws IOException {
        String str = req.getRequestURI().substring(6);
        String value = req.getReader().readLine();

        if (Validation.validationVariable(value)) {
            if (session.getAttribute(str) == null) {
                resp.setStatus(STATUS_201);
            }
            else {
                resp.setStatus(STATUS_200);
            }
            session.setAttribute(str, value);
        } else {
            resp.setStatus(STATUS_403);
        }
    }

}
