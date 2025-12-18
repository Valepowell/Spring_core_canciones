<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>
<head>
    <meta charset="UTF-8" />
    <title>Detalle Artista</title>
</head>
<body>

<h2>${artista.nombre} ${artista.apellido}</h2>
<p>${artista.biografia}</p>

<h3>Canciones</h3>
<c:if test="${empty artista.canciones}">
    <p>No hay canciones registradas para este artista.</p>
</c:if>

<c:if test="${not empty artista.canciones}">
<ul>
    <c:forEach var="c" items="${artista.canciones}">
        <li>${c.titulo}</li>
    </c:forEach>
</ul>
</c:if>

<br>
<a href="/artistas">Volver a lista de artistas</a>

</body>
</html>