<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: pawel
  Date: 17.08.2022
  Time: 11:38
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Concert Manager</title>
</head>
<body>
Wybierz klub:
<br>
<br>
<c:forEach items="${clubs}" var="club">
    <a href="/band/clubevent/${club.id}">${club.name}</a><br>
</c:forEach>
</body>
</html>
