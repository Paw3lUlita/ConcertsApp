<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: pawel
  Date: 17.08.2022
  Time: 11:46
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
        <h2>Wydarzenia w klubie ${club.name}:</h2><br>
        <a href="/club/clubdetails/${club.id}" >Szczegóły klubu</a> <br><br>
<c:forEach var="event" items="${clubEvents}">
        <div class="card shadow">
            <div class="card-header">
                Nazwa: ${event.name} <br>
                Miasto: ${event.club.city}
            </div>
            <div class="card-body">
    Opis:  ${event.description}  <br>
    Data: ${event.date} <br>
    Zespoły: <br>
    <c:forEach var="band" items="${event.bands}">
        ${band.name} <a href="/band/banddetails/${band.id}">Szczegóły</a><br>

    </c:forEach><br>

    <a href="/band/bandjoin/${event.id}">Poproś o dołączenie</a> <br>
            </div>
        </div>
</c:forEach><br>
    </div>
</div>
</body>
</html>
