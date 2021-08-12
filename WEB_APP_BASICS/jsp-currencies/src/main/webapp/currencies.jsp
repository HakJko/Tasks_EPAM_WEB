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

<%
    List<String> currencies = request.getAttribute("currencies");
%>

<!DOCTYPE html>
<html>
    <head>
        <title>Currencies</title>
        <link href="/css/style.css" rel="stylesheet" type="text/css">
    </head>
    <body>
        <h1>Currencies</h1>
        <ul>
            <c:forEach var="currency" items="${currencies}">
                <li>
                    <p><c:out value="${currency}" /></p>
                </li>
            </c:forEach>
        </ul>
    </body>

</html>


