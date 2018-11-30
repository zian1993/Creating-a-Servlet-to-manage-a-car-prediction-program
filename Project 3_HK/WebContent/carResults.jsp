<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
    <%@ page import ="java.util.ArrayList"%>
    <%@ page import ="project1.*"%>
    <%@ page import ="project2.*"%>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Results</title>
</head>
<body>

<h1><a>So, how did your car stack up?</a></h1>

<form name="ResultsForm" method="post" action="CarServlet">

	<h2>Overall rating for your car:</h2>
	<%=(String)request.getAttribute("rating")%>
	
	<br>
	<br>
	<h2>Exact match found?</h2>
	<%=(String)request.getAttribute("match")%>
	
	<br>
	<br>
	<h2>Cars returned from search (Please select one to get value):</h2>
	<%=(String)request.getAttribute("returned")%>
	
	<br>
	<br>
	
	<input type="submit" value="Show me value of car!" name = "showvalue"/>
   
</form>

</body>
</html>