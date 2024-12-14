<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h2>Menu</h2>
<ul id="menu">
<li><a
	href="<%=request.getContextPath() %>/inserimentoImpiegato.jsp">Inserisci
		Impiegato</a></li>
	
	<li><a href="<%=request.getContextPath() %>/ricercaImpiegato.jsp">Ricerca
		Impiegato per codice fiscale </a></li>
	
	<li><a href="<%=request.getContextPath() %>/ricercaImpiegatoPerCognome.jsp">Ricerca
		Impiegato per cognome </a></li>
	
	<li><a href="<%=request.getContextPath() %>/inserisciRuolo.jsp">Inserisci
		Ruolo</a></li>
		
		<li><a href="<%=request.getContextPath() %>/ricercaRuolo.jsp">Ricerca
		Ruolo</a></li>
		
	<li><a href="<%=request.getContextPath() %>/inserisciStorico.jsp">Inserisci
		Storico</a></li>
		
	<li><a href="<%=request.getContextPath() %>/ricercaStorico.jsp">Ricerca
		Storico</a></li>

</ul>
</body>
</html>