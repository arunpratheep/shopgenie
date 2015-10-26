<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Admin</title>
</head>
<body>

<s:submit value="Verify" action="sellerVerify"></s:submit>
<s:iterator value="unverifiedSellers">
	<s:property value="name"/> , 
	<s:property value="department"/><br/>

</s:iterator>

</body>
</html>