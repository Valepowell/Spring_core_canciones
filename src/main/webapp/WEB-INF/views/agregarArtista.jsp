<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%> 
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>

<html>
<head>
    <meta charset="UTF-8" />
    <title>Agregar Artista</title>
</head>
<body>

<h2>Agregar Artista</h2>

<form:form action="/artistas/procesa/agregar" 
            method="post" 
            modelAttribute="artista">

    <p>
        Nombre:
        <form:input path="nombre"/>
        <form:errors path="nombre" cssClass="error"/>
    </p>

    <p>
        Apellido:
        <form:input path="apellido"/>
        <form:errors path="apellido" cssClass="error"/>
    </p>

    <p>
        Biografía:
        <form:textarea path="biografia"/>
        <form:errors path="biografia" cssClass="error"/>
    </p>

    <button type="submit">Guardar</button>
</form:form>

<br>
<a href="/artistas">Volver a lista de artistas</a>

</body>
</html>
