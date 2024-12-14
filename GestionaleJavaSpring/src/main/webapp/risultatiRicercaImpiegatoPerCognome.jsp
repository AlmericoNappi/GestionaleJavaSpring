<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

	<table border="1px">
	<tr>
	<th>Matricola</th>
	<th>Codice Fiscale</th>
	<th>Cognome</th>
	<th>Nome</th>
	<th></th>
	<th></th>
	</tr>
	<c:forEach var="i" items="${impiegatiTrovati}">
	<tr>
	<th>${i.matricola}</th>
	<th>${i.codiceFiscale}</th>
	<th>${i.cognome}</th>
	<th>${i.nome}</th>
	<th> 
	<form action="<%=request.getContextPath() %>/ImpiegatoSrv">
	<input type="hidden" id="codiceFiscale" name="codiceFiscale" value="${i.codiceFiscale}">
	<input type="hidden" id="operazione" name="operazione" value="ricerca">
	<input type="submit" value="Aggiorna">
	</form>
	</th>
	<th> 
	<form action="<%=request.getContextPath() %>/ImpiegatoSrv">
	<input type="hidden" id="codiceFiscale" name="codiceFiscale" value="${i.codiceFiscale}">
	<input type="hidden" id="operazione" name="operazione" value="elimina">
	<input type="hidden" id="cognome" name="cognome" value="${i.cognome}">
		<input type="hidden" id="matr" name="matr" value="${i.matricola}">
	
	
	<input type="submit" value="Elimina">
	</form>
	
	</tr>
	</c:forEach>
	
	</table>
</body>
</html>