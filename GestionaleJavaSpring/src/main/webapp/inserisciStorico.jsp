<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>inserimentoStorico.jsp</title>
</head>
<body>
<h2>Inserisci Storico</h2>
<form id="StoricoForm" action ="<%=request.getContextPath()%>/StoricoSrv" method="post">

<input type= "hidden" name="operazione" value="inserisci"/>

idStorico:
<input type= "text" name="idStorico"/>
idRuolo:
<input type= "text" name="idRuolo"/>
Data Inizio:
<input type= "text" name="dataInizio"/>
Data Fine:
<input type= "text" name="dataFine"/>
Matricola:
<input type= "number" name="matricola"/>

<input type= "submit" value="Invia"/>


</form>

</body>
</html>