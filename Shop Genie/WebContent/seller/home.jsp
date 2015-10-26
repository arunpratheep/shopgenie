<%@page import="sun.rmi.log.LogOutputStream"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%
	String name = "";
	if (null == session.getAttribute("login")) {
		response.sendRedirect("login.jsp");
	} else {

		name = session.getAttribute("seller").toString();
	}
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">

<title>
	<%
		out.print(name);
	%> Home
</title>
</head>
<body>
	Welcome Seller
	<form action="${pageContext.request.contextPath}/logout" method="post">
		<input type="submit" value="Logout" />
	</form>
	<a href="profile">Profile</a>
	<a href="autoCompleteProduct">Sell</a>
	<a href="updateProduct">Update Products</a>
	<a href="showProducts">Show Products</a>
</body>
</html>