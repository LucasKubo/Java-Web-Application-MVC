<%@page import="org.apache.jasper.tagplugins.jstl.core.ForEach"%>
<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ page import="java.util.Collection" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="java.text.SimpleDateFormat" %>
<%@ page import="modelo.PessoaFisica" %>
<%
//Pegando atributo da request para utilizar posteriormente
//obs: instanciado como ArrayList para que, caso haja erro na recuperacao dos valores da request, utilizar um array vazio
Collection<PessoaFisica> pessoasFisicas = new ArrayList<PessoaFisica>();

//request -> propriedade nativa de um arquivo .jsp
//request.getAttribute("pessoasFisicas");

//Atribuindo valor recuperado do atributo da request ao objeto pessoasFisicas
if(request.getAttribute("pessoasFisicas") != null){
	pessoasFisicas = (Collection<PessoaFisica>)request.getAttribute("pessoasFisicas");
}
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>Pessoas Físicas Cadastradas</title>
</head>
<body>
	<h1>Pessoas Físicas Cadastradas</h1>
	<table>
		<thead>
			<tr>
				<th>ID</th>	
				<th>Nome</th>	
				<th>CPF</th>	
				<th>Data de Nascimento</th>	
				<th>Telefone</th>	
				<th>Situação </th>	
			</tr>
		</thead>
		<tbody>
			<%
				for(PessoaFisica p : pessoasFisicas){
					out.write("<tr>");
					out.write("<td>"+ p.getId() + "</td>");
					out.write("<td>"+ p.getNome() + "</td>");
					out.write("<td>"+ p.getCpf() + "</td>");
					SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
					out.write("<td>"+ sdf.format(p.getNascto()) + "</td>");
					out.write("<td>"+ p.getTelefone() + "</td>");
					out.write("<td>"+ (p.getSituacao() == 1 ? "Ativado" : "Desativado") + "</td>");
					out.write("</tr>");
				}
			%>
		</tbody>
	</table>
</body>
</html>