<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>  
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %> 
    
<!DOCTYPE html >
<html>
<head>
<meta charset="UTF-8">
<title>Alterar Dados</title>
</head>
<body>
<c:import url="../Menu.jsp"></c:import>

<h1>Alterar Dados</h1>
<form action="/coisasemprestadas/usuario/alterar" method="post">

<h1> <input type="hidden" readonly="readonly" name="id" value="${usuario.id }"></h1>

<h1>Nome: <input type="text" name="nome" value="${usuario.nome }"></h1>

<h1>Email: <input type="text" name="email" value="${usuario.email }" > </h1>

<h1>Endereço: <input type="text" name="endereco" value="${usuario.endereco }"></h1>

<h1>Senha: <input type="text" name="senha" value="${usuario.senha }"></h1>

<button type="submit">Alterar</button>
</body>
</html>