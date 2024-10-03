<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>


Bienvenido a mi tienda de libros

<div>
	<a href="admin/">acceder a la administracion de la tienda</a>
</div>


<div style="text-align: center;margin:10px">
Bienvenido a la parte publica de la tienda de libros
</div>

<div style="margin: 10px">
<a href="#" id="menu-inicio" >inicio</a> 
<a href="#" id="menu-identificarme" >identificarme</a>
<a href="#" id="menu-registrarme" >registrarme</a>
<a href="#" id="menu-carrito" >carrito</a>
<a href="#" id="menu-mis-pedidos" >mis pedidos</a>
<a href="#" id="menu-mis-datos" >mis datos personales</a>
</div>

<div id="contenedor">
</div>

<script src="jquery.js" ></script>
<script src="mustache.js" ></script>
<script>




//operaciones con ajax:
function obtenerProductos(){
	$.ajax("ServicioProductos").done( function( respuesta ) {
		//vamos a procesar la respuesta con el json de los libros:
		//transformamos el json recibido a array de javascript:
		let libros = JSON.parse(respuesta)
		console.log(libros)
		let texto_html = ""
		
		texto_html = Mustache.render( html_listado_productos, libros )
		
		$("#contenedor").html(texto_html)
	} )//end ajax
}//end obtenerProductos

function enviarInfoUsuarioAlServidor(){
	let nombre = $("#nombre").val()
	let email = $("#email").val()
	let pass = $("#pass").val()
	//falta validar los datos antes de mandarlos a ServicioUsuarios
	$.post("ServicioUsuarios",
		{
			nombre: nombre,
			email: email,
			pass: pass
		}		
	).done(function(res){
		alert(res)		
	})

}//end enviarInfoUsuarioAlServidor

//fin operaciones con ajax


//operaciones del menu:
$("#menu-inicio").click(obtenerProductos);
$("#menu-registrarme").click(mostrarFormularioRegistroUsuario);
//fin operaciones del menu

//operaciones con plantillas
function mostrarFormularioRegistroUsuario(){
	$("#contenedor").html(html_formulario_registro_usuario)
	$("#boton_registro_usuario").click(enviarInfoUsuarioAlServidor)
}//end mostrarFormularioRegistroUsuario

//vamos a descargar de primeras todas las plantillas
//para no ir pidiendolas una a una, segun lo que quiera
//el usuario

//estas variables tienen los bloques de html 
//que iremos mostrando al usuario segun donde haga click
let html_formulario_registro_usuario = ""
let html_listado_productos = ""

//vamos a descargar todas las plantillas:
$.get("plantillas/formulario-registro-usuario.html").
	done(function(res){
		html_formulario_registro_usuario = res
	})
$.get("plantillas/listado-productos.html").
	done(function(res){
		html_listado_productos = res
	})
	
// lo que no queremos:
// 	let texto_html = ""
// 	//lo siguiente no queremos hacerlo, porque formar un formulario
// 	//o cualquier cosa con html dentro de js es muy incomodo
// 	//y da pie a errores
// 	texto_html += "html del formulario incrustado desde js"
// 	$("#contenedor").html(texto_html);	

//fin operaciones con plantillas


obtenerProductos()

</script>


</body>
</html>