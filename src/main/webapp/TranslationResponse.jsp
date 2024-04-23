<%-- 
    Document   : TranslationResponse
    Created on : 22 de abr. de 2024, 19:58:42
    Author     : ausier
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%--<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>--%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Translation</title>
    </head>
    <body>
        <h1>Word Translation</h1>
        <br>
        <h2>Original word: <%=request.getParameter("inputString")%></h2>
        <h2>Word translation: <%=request.getAttribute("translation")%></h2>
    </body>
</html>
