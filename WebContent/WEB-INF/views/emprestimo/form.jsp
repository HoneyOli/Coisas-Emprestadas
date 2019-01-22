<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Emprestar Coisas</title>
</head>
<style>
body {
	background-image: url("https://image.freepik.com/vetores-gratis/os-objectos-livres-vectors-diversos_7629.jpg");
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
label {
	padding: 12px 12px 12px 0;
	display: inline-block;
}
input[type=submit] {
	background-color: #FFAEB9;
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
	background-color:  #FFE4E1;
	padding: 20px;
}
.centralizado {
	text-align: center;
	margin: 0 auto;
}
.col-25 {
	float: left;
	width: 15%;
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
</style>
<body>
	<c:import url="../menu.jsp"></c:import>
	<div class="container">
		<div class="centralizado">
			<h1>Empréstimo de Objetos/Coisas</h1>
		</div>
		<form action="executarEmprestimo" method="post">
			<div class="row">

				<div class="col-25">
					<label for="fname">Usuário</label>
				</div>

				<div class="col-75">
					<select name="usuario.id">
						<c:forEach var="usuario" items="${usuario}">
							<option value="${usuario.id}">${usuario.nome}</option>
						</c:forEach>
					</select>
				</div>
			</div>


			<div class="row">

				<div class="col-25">
					<label for="fname">Coisas</label>
				</div>

				<div class="col-75">
					<select name="coisas.id">
						<c:forEach var="coisas" items="${coisas}">
							<option value="${coisas.id}">${coisas.nome}</option>
						</c:forEach>
					</select>
				</div>
			</div>

			<div class="row">
				<input type="submit" value="Emprestar">
			</div>
		</form>
	</div>

</body>
</html>