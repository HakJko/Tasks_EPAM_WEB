package edu.epam.ik.calc.servlets;

import edu.epam.ik.calc.service.Calculator;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;

import static edu.epam.ik.calc.service.ServiceResult.processingRequest;

@WebServlet(urlPatterns = {"/calc/result"})
public class ResultServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        PrintWriter writer = resp.getWriter();
        HttpSession session = req.getSession();
        String result = processingRequest(session, resp);
        try {
            writer.print(Calculator.calculateExpression(result));
            resp.setStatus(HttpServletResponse.SC_OK);
            writer.close();
        } catch (Exception e) {
            resp.sendError(HttpServletResponse.SC_CONFLICT, "The expression is missing");
        }


    }


}
