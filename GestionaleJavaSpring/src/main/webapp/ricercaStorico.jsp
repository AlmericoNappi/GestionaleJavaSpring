<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<h2>Ricerca Storico Per ID Storico</h2>

  <form id="storicoForm" action="<%=request.getContextPath()%>/StoricoSrv" method="post">
 
    ID Storico:
    <input type="text" id="idStorico" name="idStorico" >
	</br>
    <!-- Campo hidden per tipoOperazione -->
    <input type="hidden" id="operazione" name="operazione" value="ricerca">

    <button type="submit">Invia</button>
  </form>


</body>
</html>