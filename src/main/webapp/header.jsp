<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<title>TQI - Votação do Mascote da Copa do Mundo</title>
<link href="<c:url value="/css/mascot.css"/>" rel="stylesheet" type="text/css" media="screen" />
</head>
<body bgcolor="F3F2CF" style="margin:0 auto">
	<a href="<c:url value="j_spring_security_logout" />" style="float:right" >| Logout</a>
	<a href="<c:url value="/admin" />" style="float:right" >| Admin | </a>
	<a href="<c:url value="/mascot/votes" />" style="float:right" >| Resultado | </a>
	<a href="<c:url value="/mascot/vote" />" style="float:right" > Votação | </a>
	
	<div class="conteudo">
		<table>
			<tr>
				<td><img src="/img/mascote.jpg" alt="Mascote" /></td>
				<td>
					<h1>Copa do Mundo 2014</h1><br/>
					<label style="font-size:large;color: gray;">Enquete</label>
				</td>
			</tr>
		</table>
	</div>
	<br/>
	
</body>
</html>