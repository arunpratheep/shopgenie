<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib prefix="s" uri="/struts-tags"%>
<% if (null != session.getAttribute("login")) {
	response.sendRedirect("home.jsp");
} %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Login</title>
</head>
<body>
	<s:form action="login">
		<s:textfield label="Login Name" key="seller.sname" />
		<s:password label="Password" key="seller.password" />
		<s:submit />
	</s:form>
</body>
</html>