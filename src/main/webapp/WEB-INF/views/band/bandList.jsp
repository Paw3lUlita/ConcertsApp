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
Twoje zespoły:<br>

<c:forEach var="band" items="${userBands}">
   Nazwa: ${band.name} <br>
    <a href="/band/events/${band.id}">Zarządzaj wydarzeniami</a> <br>
    <a href="/band/edit/${band.id}">Edytuj</a>
    <a href="/band/delete/${band.id}">Usuń</a> <br>
</c:forEach>
...............
<a href="/band/add">Dodaj nowy zespół</a>

</body>
</html>
