package com.epam.rd.jsp.servlets;

import com.epam.rd.jsp.currencies.Currencies;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

//@WebServlet ("/Currencies")
public class CurrenciesServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

        List<String> currencies = (List<String>) Currencies.getCurrencies();
        
        req.setAttribute("currencies", currencies);
        req.getRequestDispatcher("currencies.jsp").forward(req, resp);
        
    }
}
