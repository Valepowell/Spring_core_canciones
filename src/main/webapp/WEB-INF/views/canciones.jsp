<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%> <%@ taglib uri="http://java.sun.com/jsp/jstl/core"
prefix="c" %>

<html>
<head>
    <meta charset="UTF-8" />
    <title>Lista de Canciones</title>
</head>
<body>
    <h2>Lista de Canciones</h2>

    <c:if test="${empty listaCanciones}">
        <p>No hay canciones registradas.</p>
    </c:if>

    <c:if test="${not empty listaCanciones}">
    <table border="1">
        <tr>
            <th>Título</th>
            <th>Artista</th>
            <th>Detalle</th>
            <th>Editar</th>
            <th>Eliminar</th>
        </tr>

        <c:forEach var="c" items="${listaCanciones}">
        <tr>
            <td>${c.titulo}</td>
            <td>${c.artista}</td>
            <td>
                <a href="/canciones/detalle/${c.id}">Detalle</a>
            </td>
            <td>
                <a href="/canciones/formulario/editar/${c.id}">Editar</a>
            </td>
            <td>
                <a href="/canciones/eliminar/${c.id}"
                onclick="return confirm('¿Esta canción será Eliminada?');">Eliminar</a>
            </td>
        </tr>
        </c:forEach>

    </table>
    </c:if>
    <br>
        <a href="/canciones/formulario/agregar">
            <button>Agregar Canción</button>
        </a>
</body>
</html>
