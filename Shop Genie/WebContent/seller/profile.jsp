<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
	<%@taglib prefix="s" uri="/struts-tags"%>
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
	%>
</title>
</head>
<body>

<s:property value="seller.sname"/>
<s:property value="address.email"/>
<s:property value="seller.mobile"/>
<s:property value="seller.verified"/>
update details to be done later			
</body>
</html>