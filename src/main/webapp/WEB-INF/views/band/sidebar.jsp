<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: pawel
  Date: 19.08.2022
  Time: 09:23
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<div class="border-end bg-white" id="sidebar-wrapper">
  <div class="sidebar-heading border-bottom bg-light">Concert Manager </div>
  <div class="list-group list-group-flush">
    <a class="list-group-item list-group-item-action list-group-item-light p-3" href="/band">Przełącz zespół</a>
    <a class="list-group-item list-group-item-action list-group-item-light p-3" href="/band/add">Dodaj zespół</a>
    <a class="list-group-item list-group-item-action list-group-item-light p-3" href="/band/search">Szukaj wydarzeń</a>
    <a class="list-group-item list-group-item-action list-group-item-light p-3" href="/band/events/<c:out value="${cookie.bandId.value}" default="err"/>">Twoje wydarzenia</a>
    <%--<a class="list-group-item list-group-item-action list-group-item-light p-3" href="/club/messages/${cookie.clubId.value}">Wiadomości</a>--%>
    <a class="list-group-item list-group-item-action list-group-item-light p-3" href="/dashboard">Strona główna</a>

  </div>
</div>
