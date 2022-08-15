<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%--
  Created by IntelliJ IDEA.
  User: pawel
  Date: 12.08.2022
  Time: 15:58
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Concerts App</title>
</head>
<body>
<form:form method="post" modelAttribute="event">
    Podaj nazwę: <form:input path="name" /><br>
    Podaj opis:  <form:input path="description"/><br>
    Podaj datę: <input type="date" name="date"/>
    <form:hidden path="id"/>
    <input type="submit" value="Dodaj wydarzenie">
</form:form>
</body>
</html>
