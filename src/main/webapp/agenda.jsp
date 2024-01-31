<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="model.JavaBeans" %>
<%@ page import="java.util.ArrayList" %>
<%
ArrayList<JavaBeans>lista =(ArrayList<JavaBeans>)request.getAttribute("contato");
  
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Agenda de Contato</title>
<link rel="icon" href="imagens/favicon.png">
<link rel="stylesheet" href="style.css">
<link rel="stylesheet" href="css/bootstrap.min.css">
</head>
<body>
<div class="d-flex flex-column wrapper">
        <nav class="navbar navbar-expand-lg navbar-dark bg-black border-bottom shadow-sm mb-3">
            <div class="container-fluid flex p-3 -my-3">
                <a class="navbar-brand" href="/"><b>Agência de Viagem</b></a>
                <button class="navbar-toggler" type="button" data-bs-toggle="collapse"
                    data-bs-target=".navbar-collapse">
                    <span class="navbar-toggler-icon"></span>
                </button>
                <div class="collapse navbar-collapse">
                    <ul class="navbar-nav flex-grow-1">
                        <li class="nav-item">
                            <a class="nav-link text-white" href="index.html">Página Inicial</a>
                        </li>
                        <li class="nav-item">
                            <a class="nav-link text-white" href="destinos.html">Destinos</a>
                        </li>
                        <li class="nav-item">
                            <a class="nav-link text-white" href="promocoes.html">Promoções</a>
                        </li> 
                                                                        
                    </ul>
                    <div class="align-self-end">
                        <ul class="navbar-nav">
                            <li class="nav-item">
                                <a href="main" class="nav-link text-white">Contato</a>
                            </li>
                            <li class="nav-item">                                
                                <a href="main" class="nav-link text-white">Cadastre - se</a>
                            </li>
                            <li class="nav-item">
                                <a href="./login/index.html" class="nav-link text-white">Entrar</a>
                            </li>                            
                        </ul>
                    </div>
                </div>
            </div>
        </nav>
    </div>
    
<div class="container">
<h4>Agência de Viagem</h4>
<img src="imagens/agenda02.png">
<h2>Cadastro de Contato</h2>
<a href="novo.html" class="botao">Novo Contato</a>
<div class="lista">
<table class="table table-hover">
      <thead>
        <tr>
          <th>Idcon</th>
          <th>Nome</th>
          <th>Fone</th>
          <th>E-mail</th>
           <th>Opções</th>
         </tr> 
      </thead>
      <tbody>
      <%for(int i= 0; i<lista.size(); i++) {%>
         <tr>
             <td><%=lista.get(i).getIdcon()%></td>
             <td><%=lista.get(i).getNome()%></td>
             <td><%=lista.get(i).getFone()%></td>
             <td><%=lista.get(i).getEmail()%></td>
             <td><a href="select?idcon=<%=lista.get(i).getIdcon() %>" class="botao">Editar</a>
             <a href="javascript: confirmar(<%=lista.get(i).getIdcon() %>) " class="botao1">Exluir</a>
             </td>
         </tr>
      <%} %>
      </tbody>
</table>
</div>
<script src="scripts/confirmador.js"></script>
</div>
</body>
</html>