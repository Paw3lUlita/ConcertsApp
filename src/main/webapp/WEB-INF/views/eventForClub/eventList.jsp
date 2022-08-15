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
    Zespoły: <c:forEach var="band" items="${event.bands}">
    ${band.name} <br>
</c:forEach><br>
    <a href="/event/edit/${event.id}">Edytuj Wydarzenie</a>
    <a href="/event/delete/${event.id}">Usuń Wydarzenie</a> <br>
</c:forEach>
...............
<a href="/event/${clubId}/add">Dodaj nowe wydarzenie</a>

</body>
</html>
