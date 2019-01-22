<!DOCTYPE html>
<html>
<head>
<style>
ul {
    list-style-type: none;
    margin: 0;
    padding: 0;
    overflow: hidden;
    background-color: #000000;
}
body {
	background-image: url("https://image.freepik.com/vetores-gratis/os-objectos-livres-vectors-diversos_7629.jpg");
    background-repeat: no-repeat;
	background-size: 1600px 800px;
}
li {
    float: left;
}
li a, .dropbtn {
    display: inline-block;
    color: #FFFFFF;
    text-align: center;
    padding: 14px 150px;
    text-decoration: none;
}
li a:hover, .dropdown:hover .dropbtn {
    background-color: #F9E846;
}
li.dropdown {
    display: inline-block;
}
.dropdown-content {
    display: none;
    position: absolute;
    background-color: #f9f9f9;
    min-width: 340px;
    box-shadow: 0px 8px 16px 0px rgba(0,0,0,0.2);
    z-index: 1;
}
.dropdown-content a {
    color: black;
    padding: 16px 16px;
    text-decoration: none;
    display: block;
    text-align: center;
}
.dropdown-content a:hover {background-color: #f1f1f1}
.dropdown:hover .dropdown-content {
    display: block;
}
</style>
</head>
<ul>
  <li><a href="/coisasemprestadas/">Home</a></li>
  
  <li class= "dropdown">
  <a href="javascript:void(0)" class= "dropbtn">Usuário</a>
  <div class="dropdown-content">
      <a href="/coisasemprestadas/usuario/form">Cadastrar Usuário</a>
      <a href="/coisasemprestadas/usuario/">Listar Usuários</a>
    </div></li>
 
 
 <li class="dropdown">
    <a href="javascript:void(0)" class="dropbtn">Coisas</a>
    <div class="dropdown-content">
      <a href="/coisasemprestadas/coisas/form">Cadastrar Coisas</a>
      <a href="/coisasemprestadas/coisas/">Listar Coisas</a>
    </div>
  </li>
  
  <li class="dropdown">
    <a href="javascript:void(0)" class="dropbtn">Emprestimo</a>
    <div class="dropdown-content">
    	<a href="/coisasemprestadas/emprestimo/form">Fazer Emprestimo</a>
    	<a href="/coisasemprestadas/emprestimo/listarEmprestimo">Lista de Emprestimos</a>
    	</div>
    </li>
</ul>

</body>
</html>