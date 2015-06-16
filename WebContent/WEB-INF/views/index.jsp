<%@page import="org.springframework.web.servlet.handler.SimpleUrlHandlerMapping"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Vocabulario::Cards</title>
<style type="text/css">
.error {
	color: orange;
}

.add_button {
    background: blue;
    border-radius: 15px;
    width: 30px;
    height: 30px;
    position: fixed;
    right: 50px;
    bottom: 50px;
    font-size: 20px;
    font-weight: bold;
    color: white;
    text-align: center;
}
</style>
</head>
<body>

	<form:form method="POST" action="/Vocabulario/addCard" modelAttribute="newCard">
		<table>
			<tr>
				<td><form:label path="word" title="Word" /></td>
				<td><form:input path="word" /></td>
				<td><form:errors path="word" cssClass="error" /></td>
			</tr>
			<tr>
				<td><form:label path="translation" title="Translation" /></td>
				<td><form:input path="translation" /></td>
				<td><form:errors path="translation" cssClass="error" /></td>
			</tr>
			<tr>
				<td colspan="2"><input title="Add" value="Add" type="submit"></td>
			</tr>
		</table>
	</form:form>

	<c:if test="${not empty cards}">
		<table>
			<c:forEach var="card" items="${cards}">
				<tr>
					<td>${card.word}</td>
					<td>${card.translation}</td>
					<td><a href='/Vocabulario/edit/${card.id}'>edit</a></td>
					<td><a href='/Vocabulario/delete/${card.id}'>delete</a></td>
				</tr>
			</c:forEach>
		</table>
	</c:if>
	
	<!-- <div class="add_button">+</div> -->
	
</body>
</html>