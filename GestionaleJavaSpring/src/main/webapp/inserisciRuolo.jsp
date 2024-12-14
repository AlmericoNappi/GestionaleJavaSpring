<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>inserisciRuolo.jsp</title>
</head>
<body>
<h2>Inserisci Ruolo</h2>
<form id="ruoloForm" action ="<%=request.getContextPath()%>/RuoloSrv" method="post">

<input type= "hidden" name="operazione" value="inserisci"/>
idRuolo:
<input type= "text" name="idRuolo"/>
descrizione:
<input type= "text" name="descrizione"/>

<input type= "submit" value="Invia"/>


</form>


</body>
</html>