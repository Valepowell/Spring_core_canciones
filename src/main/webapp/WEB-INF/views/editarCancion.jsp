<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%> 
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Editar Canción</title>
</head>
<body>

<h2>Editar Canción</h2>

<form:form method="POST"
    action="/canciones/procesa/editar/${cancion.id}"
    modelAttribute="cancion">

    <p>
        Título:
        <form:input path="titulo"/>
        <form:errors path="titulo" cssClass="error" />
    </p>

    <p>
        Artista:
        <form:input path="artista"/>
        <form:errors path="artista" cssClass="error"/>
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

    <button type="submit">Actualizar Canción</button>
</form:form>

<br>
<a href="/canciones">Volver a lista de canciones</a>

</body>
</html>