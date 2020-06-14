
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Nova empresa criada</title>
</head>
<body>
	<% 
String nomeEmpresa = (String) request.getAttribute("empresa");
%>
	Empresa
	<%= nomeEmpresa %>
	cadastrada com sucesso!
</body>
</html>