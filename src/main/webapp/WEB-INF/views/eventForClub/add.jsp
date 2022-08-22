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
    Podaj nazwę: <form:input path="name" /><br>
    Podaj opis:  <form:input path="description"/><br>
    Podaj datę: <input type="date" name="date"/>
    Dodaj zespoły: <br>
    <form:checkboxes path="bands" items="${allBands}" itemLabel="name" itemValue="id" />
    <form:hidden path="club.id"/><form:errors path="*" cssClass="alert-danger" element="div"/>
    <input type="submit" value="Dodaj wydarzenie">
</form:form>
</div>
</body>
</html>
