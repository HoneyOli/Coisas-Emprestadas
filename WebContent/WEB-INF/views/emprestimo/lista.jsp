<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %> 
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %> 
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Lista de Coisas Emprestadas</title>
</head>
<style>
#customers {
    font-family: "Trebuchet MS", Arial, Helvetica, sans-serif;
    border-collapse: collapse;
     
    top: 50%;
    left: 50%;
    center;
    
     
}
#customers td, #customers th {
    border: 1px solid #000000;
    padding: 10px;
}
#customers tr:nth-child{background-color: #FFFFFF;}
#customers th {
	
    padding-top: 12px;
    padding-bottom: 12px;
    text-align: left;
    background-color: #000000;
    color: #FFFFFF;
    }
    
    
    .container {
 	position: absolute;
    top: 50%;
    left: 50%;
    width: 50%;
    transform: translateY(-50%) translateX(-50%);
	center;
	border-radius: 50px;
	background-color: #000000;
	padding: 50px;
}
.centralizado {
	
    text-align: center;
	color: #FFFFFF ;
}
</style>
<body>
<c:import url= "../menu.jsp"></c:import>

<div class="container">

<div class= "centralizado">
	<h1>Lista de Emprestimos:</h1>
</div>

<table id="customers">
		<thead>
			<tr>
				
				<th>Nome</th>
				<th>Coisa</th>
				<th>Data de Emprestimo</th>
				<th>Data de Devolução</th>
				
			</tr>
		</thead>
		<tbody>
			<c:forEach var="emprestimo" items="${emprestimos}">
				<tr>
					<td>${emprestimo.usuario.nome}</td>
					<td>${emprestimo.coisas.nome}</td>
					<td><fmt:formatDate value="${emprestimo.dataEmp.time}" pattern="dd/MM/yyyy" /></td>
					<td><fmt:formatDate value="${emprestimo.dataDev.time}" pattern="dd/MM/yyyy" /></td>
					<td><a href="/coisasemprestadas/emprestimo/devolver?id=${emprestimo.id}">Devolver</a></td>
				</tr>
			</c:forEach>

		</tbody>
		
		

	</table>
	</div>
</body>
</html>