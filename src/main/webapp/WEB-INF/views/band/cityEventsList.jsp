<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: pawel
  Date: 17.08.2022
  Time: 11:21
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Concert Manager</title>
</head>
<body>
Wydarzenia w mieście ${city}:<br>

<c:forEach var="event" items="${cityEvents}">
    Nazwa: ${event.name} <br>
    Klub: ${event.club.name} <br>
    Opis:  ${event.description}  <br>
    Data: ${event.date} <br>
    Zespoły: <br>
    <c:forEach var="band" items="${event.bands}">
        ${band.name} <a href="/band/banddetails/${band.id}">Szczegóły</a>

    </c:forEach><br>

    <a href="/band/bandjoin/${event.id}">Poproś o dołączenie</a> <br>

</c:forEach><br>
</body>
</html>
