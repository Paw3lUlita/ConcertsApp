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
  <div class="sidebar-heading border-bottom bg-light">Concert Manager</div>
  <div class="list-group list-group-flush">
    <a class="list-group-item list-group-item-action list-group-item-light p-3" href="/club">Przełącz klub</a>
    <a class="list-group-item list-group-item-action list-group-item-light p-3" href="/club/add">Dodaj klub</a>
    <a class="list-group-item list-group-item-action list-group-item-light p-3" href="/event/<c:out value="${cookie.clubId.value}" default="err"/>/add">Dodaj wydarzenie</a>
    <a class="list-group-item list-group-item-action list-group-item-light p-3" href="/event/<c:out value="${cookie.clubId.value}" default="err"/>">Lista Wydarzeń</a>
    <a class="list-group-item list-group-item-action list-group-item-light p-3" href="/club/messages/<c:out value="${cookie.clubId.value}" default="err"/>">Wiadomości</a>
    <a class="list-group-item list-group-item-action list-group-item-light p-3" href="/dashboard">Strona główna</a>

  </div>
</div>
