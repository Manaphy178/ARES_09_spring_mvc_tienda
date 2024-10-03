<%@ taglib uri="http://www.springframework.org/tags/form"
	prefix="springform"%>
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

	<springform:form modelAttribute="nuevoLibro"
		action="libros-guardar-nuevo" enctype="multipart/form-data">
	titulo : <springform:input path="titulo" />
		<br>
	descripcion: <springform:textarea path="descripcion" rows="3" cols="12" />
		<br>
	precio: <springform:input path="precio" />
		<br>
	portada: <springform:input path="portada" />
		<br>
		<input type="submit" value="REGISTRAR LIBRO">

	</springform:form>
</body>
</html>