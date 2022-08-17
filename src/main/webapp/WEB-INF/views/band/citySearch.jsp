<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: pawel
  Date: 17.08.2022
  Time: 10:40
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Concerts Manager</title>
</head>
<body>
Wybierz miasto:
<br>
<br>
<c:forEach items="${cities}" var="city">
    <a href="/band/cityevent/${city}">${city}</a><br>
</c:forEach>

</body>
</html>
