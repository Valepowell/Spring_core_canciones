<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%> 
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>

<html>
<head>
    <meta charset="UTF-8" />
    <title>Agregar Canción</title>
</head>
<body>

<h2>Agregar Canción</h2>

<form:form action="/canciones/procesa/agregar" 
            method="post" 
            modelAttribute="cancion">

    <p>
        Título:
        <form:input path="titulo"/>
        <form:errors path="titulo" cssClass="error"/>
    </p>

    <p>
        Artista:
        <select name="artistaId">
            <option value="">-- Selecciona un artista --</option>
            <c:forEach var="a" items="${artistas}">
                <option value="${a.id}">
                    ${a.nombre} ${a.apellido}
                </option>
            </c:forEach>
        </select>
    </p>

    <p>
        Álbum:
        <form:input path="album"/>
        <form:errors path="album" cssClass="error"/>
    </p>

    <p>
        Género:
        <form:input path="genero"/>
        <form:errors path="genero" cssClass="error"/>
    </p>

    <p>
        Idioma:
        <form:input path="idioma"/>
        <form:errors path="idioma" cssClass="error"/>
    </p>

    <button type="submit">Guardar</button>
</form:form>

<br>
<a href="/canciones">Volver a lista de canciones</a>

</body>
</html>