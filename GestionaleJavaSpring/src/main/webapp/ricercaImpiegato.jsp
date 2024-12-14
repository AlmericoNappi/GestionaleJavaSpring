<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h2>Ricerca Impiegato per Codice Fiscale</h2>

  <form id="impiegatoForm" action="<%=request.getContextPath()%>/ImpiegatoSrv" method="post">
 
    Codice Fiscale:
    <input type="text" id="codiceFiscale" name="codiceFiscale" >
	</br>
    <!-- Campo hidden per tipoOperazione -->
    <input type="hidden" id="operazione" name="operazione" value="ricerca">

    <button type="submit">Invia</button>
  </form>
</body>
</html>