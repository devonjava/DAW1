<%-- 
    Document   : simple
    Created on : 22.05.2015, 22:32:10
    Author     : micx
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>

    <head>

        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

        <title> Очень простая страница JSP </title>

    </head>

    <body>

    <h1> Очень простая страница JSP </h1>

    <h2> Этот пример показывает, как работать с выражениями JSP</h2>

    Текущая дата: <%= new java.util.Date()%>

    <br>

    Значение параметра "param": <%= request.getParameter("param")%>

</body>

</html>
