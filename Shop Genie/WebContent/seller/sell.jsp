<%@page import="com.shopgenie.dao.GenericDao"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@taglib prefix="s" uri="/struts-tags"%>
    <%@ taglib prefix="sx" uri="/struts-dojo-tags" %>
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
<script type="text/javascript"
            src="http://ajax.googleapis.com/ajax/libs/jquery/1.3.2/jquery.min.js"></script>
    <link rel="stylesheet" href="//code.jquery.com/ui/1.11.4/themes/smoothness/jquery-ui.css">
  <script src="//code.jquery.com/jquery-1.10.2.js"></script>
  <script src="//code.jquery.com/ui/1.11.4/jquery-ui.js"></script>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title><%
		out.print(name);
	%></title>
</head>
<body>
	<s:form action="selectProduct" method="POST">
		<input type="text" id="product" name="product"/>
     
    <script>$(this.target).find('input').autocomplete();
        $("#product").autocomplete("/seller/getProducts.jsp");
    </script>
		<s:submit></s:submit>
	</s:form>
</body>
</html>