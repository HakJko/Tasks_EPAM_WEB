package com.epam.rd.jsp.servlets;

import com.epam.rd.jsp.currencies.Currencies;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.math.BigDecimal;

//@WebServlet ("/Convert")
public class ConvertServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

        String sourceAmount = req.getParameter("sourceAmount");
        String sourceCurrency = req.getParameter("sourceCurrency");
        String targetCurrency = req.getParameter("targetCurrency");
        BigDecimal targetAmount = Currencies.convert(new BigDecimal(sourceAmount), sourceCurrency, targetCurrency);

        req.setAttribute("sourceAmount", sourceAmount);
        req.setAttribute("sourceCurrency", sourceCurrency);
        req.setAttribute("targetCurrency", targetCurrency);
        req.setAttribute("targetAmount", targetAmount);

        req.getRequestDispatcher("convert.jsp").forward(req, resp);

    }
}
