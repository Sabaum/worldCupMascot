<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ include file="/header.jsp" %>
<html>
<head>
<title>Login Page</title>
</head>
<body onload='document.f.j_username.focus();'>
	<div class="conteudo">
	
		<c:if test="${loginError}">
			<div class="errorblock">Login falhou. Tente novamente.</div>
		</c:if>
		<c:if test="${logout}">
			<div class="errorblock">Deslogado com sucesso.</div>
		</c:if>
	
		<h3>Entre com o usuário e a senha:</h3>
		<form action="j_spring_security_check" method="post">
			
			<table>
				<tr>
					<td>Usuário:</td>
					<td><input type='text' name='j_username' value=''></td>
				</tr>
				<tr>
					<td>Senha:</td>
					<td><input type='password' name='j_password' /></td>
				</tr>
				<tr>
					<td colspan='2'><input name="submit" type="submit"
						value="Login" /></td>
				</tr>
			</table>
	
		</form>
	</div>
</body>
</html>