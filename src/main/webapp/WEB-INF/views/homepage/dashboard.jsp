<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: pawel
  Date: 09.08.2022
  Time: 10:20
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="utf-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no" />
    <meta name="description" content="" />
    <meta name="author" content="" />
    <title>Concert Manager</title>
    <!-- Favicon-->
    <link rel="icon" type="image/x-icon" href="assets/favicon.ico" />
    <!-- Core theme CSS (includes Bootstrap)-->
    <link href="css/styles.css" rel="stylesheet" />
</head>
<body>

<sec:authorize access="isAuthenticated()">
    <p class="p-2">Zalogowany jako: <sec:authentication property="principal.username"/></p>

</sec:authorize><br><br>

<sec:authorize access="hasRole('CLUBMANAGER')">
   <a href="/club" class="btn btn-dark">Przejdź do zarządzania klubem</a>
</sec:authorize><br>

<sec:authorize access="hasRole('BANDMANAGER')">
   <a href="/band" class="btn btn-dark">Przejdź do zarządzania zespołem</a>
</sec:authorize>

<sec:authorize access="isAuthenticated()">
    <form action="<c:url value="/logout"/>" method="post">
        <input class="btn btn-primary" type="submit" value="Wyloguj">
        <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
    </form>
</sec:authorize>


</body>
</html>
