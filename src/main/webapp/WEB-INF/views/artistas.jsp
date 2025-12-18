<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>
<head>
    <meta charset="UTF-8" />
    <title>Artistas</title>
</head>
<body>

<h2>Artistas</h2>

<c:forEach var="a" items="${artistas}">
    <p>
        <a href="/artistas/detalle/${a.id}">
            ${a.nombre} ${a.apellido}
        </a>
    </p>
</c:forEach>

<br>
<a href="/artistas/formulario/agregar">
    <button>Agregar Artista</button>
</a>
<br>
<br>
<a href="/canciones">Volver a Canciones</a>

</body>
</html>