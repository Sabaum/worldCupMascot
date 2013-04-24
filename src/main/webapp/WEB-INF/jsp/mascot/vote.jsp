<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/header.jsp" %>

<form action="/mascot/vote" method="POST">
	<div class="conteudo">
		<c:forEach var="error" items="${errors}">
			<div class="errorblock">${error.message}<br /></div>
		</c:forEach>
		<c:if test="${successVar}">
			<div class="successblock">Voto registrado com sucesso!<br /></div>
		</c:if>
		<div style="float:left; width: 450px">
			<fieldset id="voteFieldset" style="float:left">
				<legend><b>1.Escolha o melhor nome para o mascote:</b></legend>
				<table class="voteTable">
					<tr>
						<td class="voteTd">
							<input type="radio" name="vote" value="0" class="radioBtn"/>
						</td>
						<td class="voteTd">
							<label class="voteInput">Amijubi</label>
						</td>
						<td class="voteTd"><label class="voteDesc">União das palavras amizade e jubilo, que está ligado ao tupi guarani, em que jubi significa amarelo, cor predominante no mascote.</label></td>
					</tr>
					<tr>
						<td class="voteTd">
							<input type="radio" name="vote" value="1" class="radioBtn"/>
						</td>
						<td class="voteTd">
							<label class="voteInput">Fuleco</label>
						</td>
						<td class="voteTd"><label class="voteDesc">Uma mistura de futebol e ecologia. O nome busca incentivar o cuidado das pessoas com o meio ambiente.</label></td>
					</tr>
					<tr>
						<td class="voteTd">
							<input type="radio" name="vote" value="2" class="radioBtn"/>
						</td>
						<td class="voteTd">
							<label class="voteInput">Zuzeco</label>
						</td>
						<td class="voteTd"><label class="voteDesc">Mistura da cor azul com ecologia, que busca também incentivar cuidados relacionados à ecologia.</label></td>
					</tr>
				</table>
				
				<br/>
			</fieldset>
		</div>
		<div style="float:left; width: 300px">
			<fieldset id="captchaFieldset" style="border:none">
				<legend><b>2.Digite o código de verificação abaixo:</b></legend>
				<script type="text/javascript"
				    src="http://api.recaptcha.net/challenge?k=6LehGeASAAAAAHTboAlskv40gwCsoMFLAJsHbOFv">
				</script>
	
				<noscript>
				    <iframe src="http://api.recaptcha.net/noscript?k=6LehGeASAAAAAHTboAlskv40gwCsoMFLAJsHbOFv"
				        height="300" width="500" frameborder="0"></iframe><br>
				    <textarea name="recaptcha_challenge_field" rows="3" cols="40">
				    </textarea>
				    <input type="hidden" name="recaptcha_response_field" 
				        value="manual_challenge">
				</noscript>
				<input id="voteBtn" type="submit" value="Votar!"/>
			</fieldset>
		</div>
	</div>
</form>