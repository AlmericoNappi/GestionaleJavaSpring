<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
      <%@ page import="model.Ruolo" %>   
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<% Ruolo ruo = (Ruolo)request.getSession().getAttribute("ruoloTrovato"); %>
<h2>Form aggiornamento ruolo</h2>

  <form id="ruoloForm" action="<%=request.getContextPath()%>/RuoloSrv" method="post">
    IdRuolo:
    <input type="text" id="idRuolo" name="idRuolo" value="<%out.print(ruo.getIdRuolo()); %>" ></br>

    Descrizione:
    <input type="text" id="descrizione" name="descrizione"  value="<%=ruo.getDescrizione() %>"></br>

    <!-- Campo hidden per tipoOperazione -->
    <input type="hidden" id="operazione" name="operazione" value="aggiorna">

    <button type="submit">Aggiorna</button>
  </form>

</body>
</html>