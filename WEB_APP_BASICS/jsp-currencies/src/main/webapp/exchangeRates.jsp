<%--
    /**
    *Dev by Ihar Koshman
    */
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> <%-- directive --%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %> <%-- directive --%>
<%@ page import="java.util.*, java.text.*, com.epam.rd.jsp.currencies.CurrenciesOfCurrentTestCase" %> <%-- directive --%>
<%@ page import="com.epam.rd.jsp.currencies.Currencies" %>

<jsp:useBean id="currenciesTest" class="com.epam.rd.jsp.currencies.CurrenciesOfCurrentTestCase" scope="request"/>



<!DOCTYPE html>
<html>
    <head>
        <title>Exchange Rates for "${sourceCurrency}"</title>
        <link href="/css/style.css" rel="stylesheet" type="text/css">
    </head>
    <body>
        <h1>Exchange Rates for "${sourceCurrency}"</h1>
        <ul>
            <c:forEach var="entry" items="${exchangeRates}">
                <li>
                    <c:out value="${currencies}"/> = <c:out value="${exchangeRates}"/>
                </li>
            </c:forEach>
        </ul>
    </body>

</html>


