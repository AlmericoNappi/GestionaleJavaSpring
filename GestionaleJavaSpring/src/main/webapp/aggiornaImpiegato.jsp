<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
  <%@ page import="model.Impiegato" %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<% Impiegato imp = (Impiegato)request.getSession().getAttribute("impiegatoTrovato"); %>
<h2>Form aggiornamento impiegato</h2>

  <form id="impiegatoForm" action="<%=request.getContextPath()%>/ImpiegatoSrv" method="post">
    Nome:
    <input type="text" id="nome" name="nome" value="<%out.print(imp.getNome()); %>" ></br>

    Cognome:
    <input type="text" id="cognome" name="cognome"  value="<%=imp.getCognome() %>"></br>

    Codice Fiscale:
    <input type="text" id="codiceFiscale" name="codiceFiscale" value="<%=imp.getCodiceFiscale()%>"> </br>
    
	 Matricola:
    <input type="number" id="matricola" name="matricola" value="<%=imp.getMatricola() %>">
	</br>
    <!-- Campo hidden per tipoOperazione -->
    <input type="hidden" id="operazione" name="operazione" value="aggiorna">

    <button type="submit">Aggiorna</button>
  </form>
</body>
</html>