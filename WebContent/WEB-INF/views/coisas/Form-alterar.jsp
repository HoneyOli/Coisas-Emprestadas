<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>  
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %> 
    
<!DOCTYPE html >
<html>
<head>
<meta charset="UTF-8">
<title>Alterar Dados</title>
<style>
body {
	background-image: url("http://weekon.com.ar/wp-content/uploads/2016/12/biblio-web.jpg");
    background-repeat: no-repeat;
	background-size: 1366px 655px;
}
* {
	box-sizing: border-box;
}
input[type=text], select, textarea {
	width: 90%;
	padding: 12px;
	border: 1px solid #ccc;
	border-radius: 5px;
	resize: vertical;
}
input[type=password], select, textarea {
	width: 90%;
	padding: 12px;
	border: 1px solid #ccc;
	border-radius: 5px;
	resize: vertical;
}
label {
	padding: 12px 12px 12px 0;
	display: inline-block;
}
input[type=submit] {
	background-color: #333;
	color: white;
	padding: 12px 20px;
	border: none;
	border-radius: 4px;
	cursor: pointer;
	float: right;
}
input[type=submit]:hover {
	background-color: LightCoral;
}
.container {
 	position: absolute;
    top: 50%;
    left: 50%;
    width: 45%;
    transform: translateY(-50%) translateX(-50%);
	center;
	border-radius: 5px;
	background-color: #FFFFFF;
	padding: 20px;
}
.centralizado {
	text-align: center;
	margin: 0 auto;
}
.col-25 {
	float: left;
	width: 25%;
	margin-top: 8px;
}
.col-75 {
	float: left;
	width: 70%;
	margin-top: 5px;
}
.row:after {
	content: "";
	display: table;
	clear: both;
}
@media screen and (max-width: 600px) {
	.col-25, .col-75, input[type=submit] {
		width: 100%;
		margin-top: 0;
	}
	
}
</style>
</head>
<body>
<c:import url="../menu.jsp"></c:import>

	<div class="container">
	<div class="centralizado">
	<h1>Alterar Dados do Objeto/Coisa </h1>
		<form action="/coisasemprestadas/coisas/alterar" method="post">
			<input type="hidden" readonly="readonly" name="id" value="${coisas.id}">
		</div>
		<div>
			<label>Usuario: </label> 
			<input type="text" name="usuario" value="${coisas.usuario}">
		</div>
		<div>
			<label>Nome: </label> 
			<input type="text" name="nome" value="${coisas.nome}">
		</div>
		<div>
			<label>Descrição: </label> 
			<input type="text" name="descricao"value="${coisas.descricao}">
		</div>
			<button type="submit">Alterar</button>
		</div>
</body>
</html>