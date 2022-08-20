<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: pawel
  Date: 10.08.2022
  Time: 14:11
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




 <h1> Prośby o dołączenie do wydarzenia:</h1><br>

  <c:forEach var="ask" items="${asksForClub}">
    Zespół: ${ask.band.name}<br>
    Wiadomość: ${ask.message}<br>
    <a href="/event/${ask.event.id}/${ask.band.id}/${ask.id}">Dodaj do eventu</a>
    <a href="/event/rejectband/${ask.id}">Odrzuć prośbę</a>
  </c:forEach>
</div>


</body>
</html>