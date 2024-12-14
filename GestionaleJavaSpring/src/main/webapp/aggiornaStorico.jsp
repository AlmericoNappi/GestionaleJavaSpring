<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
      <%@ page import="model.Storico" %> 
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<% Storico sto = (Storico)request.getSession().getAttribute("storicoTrovato"); %>
<h2>Form aggiornamento storico</h2>

  <form id="storicoForm" action="<%=request.getContextPath()%>/StoricoSrv" method="post">
    idStorico:
    <input type="text" id="idStorico" name="idStorico" value="<%=sto.getIdStorico() %>" ></br>

    idRuolo:
    <input type="text" id="idRuolo" name="idRuolo"  value="<%=sto.getIdRuolo() %>"></br>

    dataInizio:
    <input type="text" id="dataInizio" name="dataInizio" value="<%=sto.getDataInizio()%>"> </br>
    dataFine:
    <input type="text" id="dataFine" name="dataFine" value="<%=sto.getDataFine()%>"> </br>
    
	 Matricola:
    <input type="number" id="matricola" name="matricola" value="<%=sto.getMatricola() %>">
	</br>
    <!-- Campo hidden per tipoOperazione -->
    <input type="hidden" id="operazione" name="operazione" value="aggiorna">

    <button type="submit">Aggiorna</button>
  </form>
</body>
</html>