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
    <a class="list-group-item list-group-item-action list-group-item-light p-3" href="/event/${cookie.clubId.value}/add">Dodaj wydarzenie</a>
    <a class="list-group-item list-group-item-action list-group-item-light p-3" href="/event/${cookie.clubId.value}">Lista Wydarzeń</a>
    <a class="list-group-item list-group-item-action list-group-item-light p-3" href="#!">Wiadomości</a>
    <a class="list-group-item list-group-item-action list-group-item-light p-3" href="#!">Strona główna</a>

  </div>
</div>
