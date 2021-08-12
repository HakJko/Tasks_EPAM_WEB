package com.epam.rd.jsp.servlets;

import com.epam.rd.jsp.currencies.Currencies;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.Map;

//@WebServlet ("/ExchangeRates")
public class ExchangeRatesServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

        String referenceCurrency = req.getParameter("from");
        Map<String, BigDecimal> exchangeRates = Currencies.getExchangeRates(referenceCurrency);
        exchangeRates.keySet().removeIf(key -> key.equalsIgnoreCase(referenceCurrency));

        req.setAttribute("currencies", exchangeRates.keySet());
        req.setAttribute("sourceCurrency", referenceCurrency);
        req.setAttribute("exchangeRates", exchangeRates);

        req.getRequestDispatcher("exchangeRates.jsp").forward(req, resp);

    }

}
