<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %> 
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Adicionar Coisas</title>
</head>
<style>
body {
	background-image: url("https://image.freepik.com/vetores-gratis/os-objectos-livres-vectors-diversos_7629.jpg");
    background-repeat: no-repeat;
	background-size: 1366px 655px;
}

 {
	box-sizing: border-box;
}
input[type=text], select, textarea {
	width: 50%;
	padding: 10px;
	border: 2px solid #000000;
	border-radius: 5px;
	resize: vertical;
}
label {
	padding: 12px 12px 12px 0;
	display: inline-block;
}
input[type=submit] {
	background-color: #000000;
	color: white;
	padding: 12px 50px;
	border: none;
	border-radius: 10px;
	cursor: pointer;
	float: right;
}
input[type=submit]:hover {
	background-color: #F9E846;
}
.container {
 	position: absolute;
    top: 50%;
    left: 50%;
    width: 45%;
    transform: translateY(-50%) translateX(-50%);
	center;
	border-radius: 20px;
	background-color: #FFFFFF;
	padding: 10px;
}
.centralizado {
	text-align: center;
	margin: 0 auto;
	
}
.col-25 {
	float: left;
	width: 45%;
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
<body>
<c:import url="../menu.jsp"></c:import>
<div class="container">
	<div class="centralizado">
		<h1>Adicionar Coisas</h1>
		</div>
		<form action="/coisasemprestadas/coisas" method="post">

			<div class="row">
				<div class="col-25">
					<label for="fname">Usuário</label>
				</div>
				<div class="col-75">
				<input type="text" id="fname" name="usuario">
				</div>
			</div>

			<div class="row">
				<div class="col-25">
					<label for="lname">Nome do Objeto/Coisa</label>
				</div>
				<div class="col-75">
					<input type="text" id="lname" name="nome" >
				</div>
			</div>

			<div class="row">
				<div class="col-25">
					<label for="country">Descrição</label>
				</div>
				<div class="col-75">
					<input type="text" id="lname" name="descricao">
				</div>
			</div>


			<div class="row">
				<input type="submit" value="Cadastrar">
			</div>
		</form>
	</div>
</body>
</html>