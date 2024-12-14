<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<h2>Ricerca Ruolo Per idRuolo</h2>

  <form id="ruoloForm" action="<%=request.getContextPath()%>/RuoloSrv" method="post">
 
    id Ruolo:
    <input type="text" id="idRuolo" name="idRuolo" >
	</br>
    <!-- Campo hidden per tipoOperazione -->
    <input type="hidden" id="operazione" name="operazione" value="ricerca">

    <button type="submit">Invia</button>
  </form>

</body>
</html>