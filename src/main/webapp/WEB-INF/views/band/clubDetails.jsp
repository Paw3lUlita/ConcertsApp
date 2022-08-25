<%--
  Created by IntelliJ IDEA.
  User: pawel
  Date: 25.08.2022
  Time: 18:03
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

<div class="d-flex" id="wrapper">
    <jsp:include page="sidebar.jsp"></jsp:include>

    <div class="container-fluid">
        <h2>Klub ${club.name}</h2><br>

        <div class="card shadow">
            <h5>Miasto: ${club.city}</h5><br>
            <h5>Adres: ${club.address} </h5><br>
            <h5>Kontakt: </h5><br>
            <span>Nr telefonu: ${club.phoneNumber}</span>
            <span>Adres email: ${club.email}</span>
        </div>

    </div>
</div>
</body>
</html>
