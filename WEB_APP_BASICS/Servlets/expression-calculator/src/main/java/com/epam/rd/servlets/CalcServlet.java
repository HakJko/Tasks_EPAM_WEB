package com.epam.rd.servlets;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.regex.Pattern;

public class CalcServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws IOException {
        PrintWriter printWriter = resp.getWriter();
        Map<String, String[]> parameter = req.getParameterMap();
        String expression = req.getParameter("expression").replaceAll(" ", "");

        expression = parsingExpression(expression, parameter);

        List<String> stringParts = processingExpression(expression);
        String output = stringParts.get(0);

        for (int i = stringParts.size() - 1; 0 < i; --i) {
            String regex = "[()]";
            String withoutRegex = stringParts.get(i);
            String wuthRegex = withoutRegex;

            withoutRegex = withoutRegex.replaceAll(regex, "");
            output = output.replace(wuthRegex, calculateExpression(withoutRegex));
        }
        output = output.replaceAll("[()]", "");
        printWriter.println(calculateExpression(output));
        printWriter.close();
    }

    private String parsingExpression(String expression, Map<String, String[]> parameter) {
        String regexMath = "^[0-9*+-/()]+$";
        while (!Pattern.matches(regexMath, expression)) {
            for (Map.Entry<String, String[]> e : parameter.entrySet())
                expression = expression.replace(e.getKey(), e.getValue()[0]);
        }
        return expression;
    }

    private List<String> processingExpression(String mathExpression) {
        List<String> stringParts = new ArrayList<>();
        char firstBracket = '(';
        char lastBracket = ')';
        stringParts.add(mathExpression);
        while (mathExpression.contains(Character.toString(firstBracket))) {
            int num = mathExpression.indexOf(firstBracket);
            int ordinal = 1;
            for (int i = num + 1; i < mathExpression.length(); ++i) {
                if (mathExpression.charAt(i) == firstBracket) {
                    ++ordinal;
                } else if (mathExpression.charAt(i) == lastBracket) {
                    --ordinal;
                }
                if (mathExpression.charAt(i) == lastBracket
                                            && ordinal == 0) {
                    stringParts.add(mathExpression.substring(num, ++i));
                    break;
                }
            }
            mathExpression = mathExpression.substring(++num);
        }
        return stringParts;
    }

    private String calculateExpression(String expression) {
        expression = addSpace(expression);
        String[] arrExpr = expression.split(" ");
        int length = arrExpr.length;
        int i = 1;
        while (i < length - 1) {
            if (arrExpr[i].equals("*") || arrExpr[i].equals("/")) {
                arrExpr[i - 1] = calculate(Integer.parseInt(arrExpr[i - 1]),
                                           Integer.parseInt(arrExpr[i + 1]),
                                           arrExpr[i]);
                overwriting(arrExpr, i);
                i = 1;
                length -= 2;
            } else
                i += 2;
        }
        i = 1;
        while (i < length - 1) {
            if (arrExpr[i].equals("-") || arrExpr[i].equals("+")) {
                arrExpr[i - 1] = calculate(Integer.parseInt(arrExpr[i - 1]),
                                           Integer.parseInt(arrExpr[i + 1]),
                                           arrExpr[i]);
                overwriting(arrExpr, i);
                i = 1;
                length -= 2;
            } else
                i += 2;
        }
        return arrExpr[0];
    }

    private String addSpace(String s) {
        StringBuilder output = new StringBuilder();
        String space = " ";
        for (int i = 0; i < s.length(); ++i) {
            char c = s.charAt(i);
            if (c == '*' || c == '/' || c == '+') {
                output.append(space).append(c).append(space);
            } else if (c == '-') {
                if (i != 0 && Character.isDigit(s.charAt(i - 1))) {
                    output.append(space).append(c).append(space);
                }
                else {
                    output.append(c);
                }
            } else {
                output.append(c);
            }
        }
        return output.toString();
    }

    private String calculate(int valueX, int valueY, String operator) {
        int result = 0;
        switch (operator) {
            case "*": {
                result = valueX * valueY;
                break;
            }
            case "/": {
                result = valueX / valueY;
                break;
            }
            case "+": {
                result = valueX + valueY;
                break;
            }
            case "-": {
                result = valueX - valueY;
                break;
            }
        }
        return String.valueOf(result);
    }

    private String[] overwriting(String[] arrStr, int position) {
        if (arrStr.length - (position + 2) >= 0) {
            System.arraycopy(arrStr, position + 2,
                             arrStr, position, arrStr.length - (position + 2));
        }
        return arrStr;
    }


}
