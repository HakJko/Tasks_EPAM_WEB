package edu.epam.ik.calc;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

@WebServlet(urlPatterns = {"/calc/result"})
public class ResultServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        PrintWriter writer = resp.getWriter();
        HttpSession session = req.getSession();
        String expression = (String) session.getAttribute("expression");
        if (expression == null) {
            resp.sendError(409, "The expression is missing");
        } else {
            expression = expression.replaceAll(" ", "");
            StringBuilder output = new StringBuilder();
            for (int i = 0; i < expression.length(); i++) {
                String ch = String.valueOf(expression.charAt(i));
                if (Character.isLetter(expression.charAt(i))) {
                    String value = (String) session.getAttribute(ch);
                    if (value != null) {
                        if (Character.isLetter(value.charAt(0))) {
                            value = (String) session.getAttribute(String.valueOf(value.charAt(0)));
                        }
                    }
                    output.append(value);
                } else {
                    output.append(ch);
                }
            }


            List<String> list = Calculator.processingExpression(output.toString());
            String result = list.get(0);

            for (int i = list.size() - 1; i > 0; i--) {
                String s1 = list.get(i);
                String s2 = s1;
                s1 = s1.replaceAll("[()]", "");
                try {
                    result = result.replace(s2, Calculator.calculateExpression(s1));
                } catch (Exception e) {
                    break;
                }
            }
            result = result.replaceAll("[()<>]", "");

            try {
                writer.print(Calculator.calculateExpression(result));
                resp.setStatus(200);
                writer.close();
            } catch (Exception e) {
                resp.sendError(409, "The expression is missing");
            }
        }


    }


}
