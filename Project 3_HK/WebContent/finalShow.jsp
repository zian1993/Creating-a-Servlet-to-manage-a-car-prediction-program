<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>The moment</title>
</head>
<body>

<form name="ResultsForm" method="post" action="CarServlet">

<h1>Trade in value offered:</h1>
	
	<!-- Setting up radio buttons based the number of cars returned from the predictor. -->
	<h2>Value offered by us: $<%=request.getAttribute("purchase") %></h2>
	
	<br>
	<br>
    <input type="submit" value="Logout" name = "logout"/><br>
    <input type="submit" value="Do another car!" name = "anothercar"/><br>
    <input type="submit" value="I hate this site. Take me to youtube instead" name = "youtube"/><br>
    
 </form>
    
</body>
</html>