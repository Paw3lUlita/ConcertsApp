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
    <meta charset="utf-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no" />
    <meta name="description" content="" />
    <meta name="author" content="" />
    <title>Concert Manager</title>
    <!-- Favicon-->
    <link rel="icon" type="image/x-icon" href="${pageContext.request.contextPath}/assets/favicon.ico" />
    <!-- Core theme CSS (includes Bootstrap)-->
    <link href="${pageContext.request.contextPath}/css/styles.css" rel="stylesheet" />
</head>
<body>
<div class="d-flex" id="wrapper">
    <jsp:include page="sidebar.jsp"></jsp:include>
<form:form method="post" modelAttribute="event">
    Edytuj nazwę: <form:input path="name" /><br>
    Edytuj opis:  <form:input path="description"/><br>
    Edytuj datę: <input type="date" name="date" value="${event.date}"/>
    Dodaj zespoły: <br>
    <form:hidden path="bands"/>
    <form:checkboxes path="bands" items="${bandsToAdd}" itemLabel="name" itemValue="id" />
    <form:hidden path="id"/>
    <form:hidden path="club.id"/>
    <input class="btn btn-primary" type="submit" value="Edytuj wydarzenie">
</form:form>
</div>
</body>
</html>
