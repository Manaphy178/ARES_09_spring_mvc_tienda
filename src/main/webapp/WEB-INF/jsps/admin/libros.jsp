<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<jsp:include page="menu.jsp"></jsp:include>


<div>
<a href="libros-nuevo">Registrar un nuevo libro</a>
</div>

<div>
listado de libros de la tienda:
</div>

<c:forEach items="${libros}" var="elemento" >
	<div style="margin: 5px">
		${elemento.titulo} <br/>
		descripcion: ${elemento.descripcion} <br/>
		precio: ${elemento.precio} euros <br/>
		id: ${elemento.id} <br/>
		<a href="libros-borrar?id=${elemento.id}" onclick="return confirm('¿seguro?')" >borrar</a>		
		<a href="libros-editar?id=${elemento.id}">
			editar
		</a>
	</div>
</c:forEach>

</body>
</html>