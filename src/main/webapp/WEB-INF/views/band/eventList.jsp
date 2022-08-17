<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: pawel
  Date: 09.08.2022
  Time: 17:28
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Concert Manager</title>
</head>
<body>
Twoje wydarzenia:<br>

<c:forEach var="event" items="${eventsForBand}">
   Nazwa: ${event.name} <br>
    Opis:  ${event.description}  <br>
    Data: ${event.date} <br>
    Zespoły: <br>
    <c:forEach var="band" items="${event.bands}">
    ${band.name} <a href="/band/banddetails/${band.id}">Szczegóły</a>

</c:forEach><br>

    <a href="/band/${bandId}/cancel/${event.id}">Opuść Wydarzenie</a> <br>

</c:forEach><br>
...............
<a href="/band/allevents">Szukaj wydarzeń</a>

</body>
</html>
