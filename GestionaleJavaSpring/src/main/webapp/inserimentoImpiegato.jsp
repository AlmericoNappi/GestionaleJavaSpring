<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>InserimentoImpiegato.jsp</title>

</head>
<body>
<h2>Inserisci nuovo Impiegato</h2>
<form id="impiegatoForm" action ="<%=request.getContextPath()%>/ImpiegatoSrv" method="post">

<input type= "hidden" name="operazione" value="inserisci"/>
Nome:
<input type= "text" name="nome"/>
Cognome:
<input type= "text" name="cognome"/>
Codice Fiscale:
<input type= "text" name="codiceFiscale"/>
Matricola:
<input type= "number" name="matricola"/>

<input type= "submit" value="Invia"/>


</form>
</body>
</html>