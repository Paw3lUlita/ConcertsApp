<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%--
  Created by IntelliJ IDEA.
  User: pawel
  Date: 09.08.2022
  Time: 09:25
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Rejestracja</title>
</head>
<body>
<form:form method="post" modelAttribute="user">
    Nazwa użytkownika:  <form:input path="username" ></form:input><br>
    Hasło: <form:password path="password"></form:password><br>
    Wybierz swoją rolę: <br>
    <form:checkboxes path="roles"
                     items="${roles}" itemLabel="description" itemValue="id"/><br>
    <input type="submit" value="Zarejestruj">
</form:form>
</body>
</html>
