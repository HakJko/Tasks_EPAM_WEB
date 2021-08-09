package com.epam.rd.servlets;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

import static com.epam.rd.service.Service.*;

public class CalcServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws IOException {
        PrintWriter printWriter = resp.getWriter();

        String output = getResult(req);
        printWriter.println(calculateExpression(output));
        printWriter.close();
    }

}
