<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:url value="/entrada" var="linkServletAlteraEmpresa" />

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Alterar Empresa</title>
</head>
<body>

	<form action="${linkServletAlteraEmpresa}" method="post">
		Nome: <input type="text" name="nome" value="${empresa.nome}"> 
		Data: <input type="text"name="data" value="<fmt:formatDate
					value="${empresa.dataAbertura}" pattern="dd/MM/yyyy"/>">
		<input type="text" name="id" value="${empresa.id}" hidden="true">
		<input type="text" name="acao" value="AlteraEmpresa" hidden="true"> 
		<input type="submit">
	</form>

</body>
</html>