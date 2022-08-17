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

<c:forEach var="event" items="${clubEvents}">
   Nazwa: ${event.name} <br>
    Opis:  ${event.description}  <br>
    Data: ${event.date} <br>
    Zespoły: <br>
    <c:forEach var="band" items="${event.bands}">
    ${band.name} <a href="/event/banddetails/${band.id}">Szczegóły</a>
        <a href="/event/${event.id}/bandremove/${band.id}">Usuń z wydarzenia</a> <br>
</c:forEach><br>
    <a href="/event/edit/${event.id}">Edytuj </a><br>
    <a href="/event/delete/${event.id}">Usuń Wydarzenie</a> <br>

</c:forEach><br>
...............
<a href="/event/${clubId}/add">Dodaj nowe wydarzenie</a> <br>
<br>
Prośby o dołączenie do wydarzenia:<br>

<c:forEach var="ask" items="${asksForClub}">
    Zespół: ${ask.band.name}<br>
    Wiadomość: ${ask.message}<br>
    <a href="/event/${ask.event.id}/${ask.band.id}/${ask.id}">Dodaj do eventu</a>
    <a href="/event/rejectband/${ask.id}">Odrzuć prośbę</a>
</c:forEach>

</body>
</html>
