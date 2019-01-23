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
.modal-content {
  background-color: #fefefe;
  margin: 5% auto 15% auto; 
  border: 1px solid #888;
  width: 30%; 
}
.modal {
  display: none; 
  position: fixed; 
  z-index: 1; 
  left: 0;
  top: 0;
  width: 100%; 
  height: 100%; 
  overflow: auto; 
  background-color: rgb(0,0,0); 
  background-color: rgba(0,0,0,0.4); 
  padding-top: 60px;
}
.container {
  padding: 16px;
}

</style>
</head>
<ul>
  <li><a href="/coisasemprestadas/">Home</a></li>
  
  <li class= "dropdown">
  <a href="javascript:void(0)" class= "dropbtn">Usu�rio</a>
  <div class="dropdown-content">
      <a href="/coisasemprestadas/usuario/form">Cadastrar Usu�rio</a>
      <a href="/coisasemprestadas/usuario/">Listar Usu�rios</a>
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
    
     
  <li style="float:right">
 <button onclick="document.getElementById('id01').style.display='block'" style="float:right">Entrar</button>
<div id="id01" class="modal">
  
  <form class="modal-content animate" action="/action_page.php">
   
    <div class="container">
      <label for="uname"><b>Nome</b></label>
      <input type="text"  name="uname" required>
      <label for="psw"><b>Senha</b></label>
      <input type="password"  name="psw" required>
        
      <button type="submit">Entrar</button>
      <label>
        <input type="checkbox" checked="checked" name="remember"> Lembra-me
      </label>
    </div>
    <div class="container" style="background-color:#f1f1f1">
      <button type="button" onclick="document.getElementById('id01').style.display='none'" class="cancelbtn">Cancelar</button>
    </div>
  </form>
</div>
    
</ul>

</body>
</html>