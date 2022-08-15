<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%--
  Created by IntelliJ IDEA.
  User: pawel
  Date: 15.08.2022
  Time: 13:15
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Concerts app</title>
</head>
<body>
<form:form method="post" modelAttribute="event">
    Edytuj nazwę: <form:input path="name" /><br>
    Edytuj opis:  <form:input path="description"/><br>
    Edytuj datę: <input type="date" name="date" value="${event.date}"/>
    <form:hidden path="club.id"/>
    <input type="submit" value="Edytuj wydarzenie">
</form:form>
</body>
</html>
