<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%--
  Created by IntelliJ IDEA.
  User: pawel
  Date: 17.08.2022
  Time: 13:43
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Concerts Manager</title>
</head>
<body>
Prośba o dołączenie do wydarzenia ${ask.event.name}<br><br>

Klub: ${ask.event.club.name}
Data: ${ask.event.date}
Napisz wiadomość:
<form:form method="post" modelAttribute="ask">
<form:textarea path="message"/>
<form:hidden path="band"/>
<form:hidden path="event"/>
<input type="submit" value="Wyślij prośbę">
</form:form>
</body>
</html>
