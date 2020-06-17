<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:url value="/entrada" var="linkServletNovaEmpresa"/>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Nova Empresa</title>
</head>
<body>

	<form action="${linkServletNovaEmpresa}" method="post">
		Nome: <input type="text" name="nome"> 
		Data: <input type="text"name="data">
		<input type="text" name="acao" value="novaEmpresa" hidden="true"> 
		<input type="submit">
	</form>

</body>
</html>