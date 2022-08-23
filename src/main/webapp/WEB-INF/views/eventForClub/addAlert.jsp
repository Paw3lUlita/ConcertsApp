<%--
  Created by IntelliJ IDEA.
  User: pawel
  Date: 23.08.2022
  Time: 12:06
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

<span>Wydarzenie zapełnione. Nie możesz dodać zespołu do wydarzenia. <br>
      Skontaktuj się z zespołem w celu uzgodnienia innego terminu</span><br>
<a class="btn btn-primary" href="/club/messages/${cookie.clubId.value}">Powrót do wiadomości</a>
</body>
</html>
