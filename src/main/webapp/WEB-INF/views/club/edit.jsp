<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%--
  Created by IntelliJ IDEA.
  User: pawel
  Date: 14.08.2022
  Time: 14:12
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Concerts App</title>
</head>
<body>
<form:form method="post" modelAttribute="club">
    Podaj miasto: <form:input path="city" /><br>
    Podaj nazwę:  <form:input path="name"/><br>
    <form:hidden path="id"/>
    <form:hidden path="user.id"/>
    <input type="submit" value="Edytuj klub">
</form:form>
</body>
</html>
