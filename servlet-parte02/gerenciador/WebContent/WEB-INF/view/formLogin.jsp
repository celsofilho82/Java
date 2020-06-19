<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:url value="/entrada" var="linkServletEntrada"/>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Login</title>
</head>
<body>

	<form action="${linkServletEntrada}" method="post">
		Login: <input type="text" name="login"> 
		Senha: <input type="password"name="senha">
		<input type="text" name="acao" value="Login" hidden="true"> 
		<input type="submit">
	</form>

</body>
</html>