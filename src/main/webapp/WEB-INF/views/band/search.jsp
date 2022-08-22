<%--
  Created by IntelliJ IDEA.
  User: pawel
  Date: 22.08.2022
  Time: 08:15
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
  <div><a class="btn btn-dark" href="/band/allevents/cities">Szukaj wydarzeń wg Miast</a></div><br>
  <div><a class="btn btn-dark"  href="/band/allevents/clubs">Szukaj wydarzeń wg Klubów</a></div>
</div>
</div>

</body>
</html>
