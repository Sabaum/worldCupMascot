<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/header.jsp" %>

<div class="conteudo">
	<div style="float:left; width: 570px">
		<c:forEach var="error" items="${errors}">
			${error.message}
		</c:forEach>
		<fieldset>
			<legend>Confira o resultado parcial da votação</legend>
			<c:forEach var="mascot"
				items="${mascotList}">
				<label class="resultDescription">${mascot.description}</label>
				<label class="resultPercentage">${mascot.percentage}%</label>
			</c:forEach>
		</fieldset>
	</div>
</div>
