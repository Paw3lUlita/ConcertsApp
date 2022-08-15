<%--
  Created by IntelliJ IDEA.
  User: pawel
  Date: 14.08.2022
  Time: 14:44
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Concerts App</title>
</head>
<body>

Czy na pewno chcesz usunąć wydarzenie ${event.name}? <br>
<a href="/event/delete?id=${event.id}">Tak</a>    <a href="/event/${clubId}">Nie</a>
</body>
</html>
