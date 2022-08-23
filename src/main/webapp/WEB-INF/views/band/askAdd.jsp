<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: pawel
  Date: 17.08.2022
  Time: 13:43
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

        <div class="container-fluid">
            <c:out value="${warningMessage}" default=""/>
<h2>Prośba o dołączenie do wydarzenia ${ask.event.name}</h2><br><br>

<h3>Klub: ${ask.event.club.name}<br>
Data: ${ask.event.date}<br>
    Napisz wiadomość:</h3><br>

<form:form method="post" modelAttribute="ask">
    <div class="form-group">
<form:textarea path="message"/><form:errors path="*" cssClass="alert-danger" element="div"/>
<form:hidden path="band"/>
<form:hidden path="event"/><br>
<input class="btn btn-primary" type="submit" value="Wyślij prośbę">
    </div>
</form:form>
        </div>

</div>
</body>
</html>
