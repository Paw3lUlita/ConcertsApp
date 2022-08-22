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
        <h1 class="mt-4">Twoje Zespoły</h1>
        <table class="table table-striped">
            <thead>
            <tr>

                <th scope="col">Nazwa</th>

            </tr>
            </thead>
            <tbody>

<c:forEach var="band" items="${userBands}">
    <tr>
        <td>${band.name} </td>
        <td><a href="/band/chooseband/${band.id}">Wybierz zespół</a> </td>
        <td><a href="/band/edit/${band.id}">Edytuj</a></td>
        <td><a href="/band/delete/${band.id}">Usuń</a> </td>
    </tr>
</c:forEach>
            </tbody>
        </table>
    </div>
    </div>


</body>
</html>
