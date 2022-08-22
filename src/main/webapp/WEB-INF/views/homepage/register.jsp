<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
    <meta charset="utf-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no" />
    <meta name="description" content="" />
    <meta name="author" content="" />
    <title>Rejestracja</title>
    <!-- Favicon-->
    <link rel="icon" type="image/x-icon" href="assets/favicon.ico" />
    <!-- Core theme CSS (includes Bootstrap)-->
    <link href="css/styles.css" rel="stylesheet" />
</head>
<body>
<form:form method="post" modelAttribute="user">
    <div class="form-group">
    Nazwa użytkownika:  <form:input path="username" ></form:input><br>
    Hasło: <form:password path="password"></form:password><br>
    Wybierz swoją rolę: <br>
    <form:checkboxes path="roles"
                     items="${roles}" itemLabel="description" itemValue="id"/><br>
        <form:errors path="*" cssClass="alert-danger" element="div"/>
    <button class="btn btn-primary"  type="submit" >Zarejestruj</button>
    </div>
</form:form>

</body>
</html>
