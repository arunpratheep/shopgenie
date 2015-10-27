<%@page import="org.apache.struts2.components.Param"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Register</title>
</head>
<body>
	<s:form action="register">
		<s:textfield label="Name" key="seller.sname" />
		<s:textfield label="Email" key="address.email" />
		<s:password label="Password" key="seller.password" />
		<s:password label="Retype Password" key="retype_password" />
		<s:textfield label="Mobile" key="seller.mobile" />
		<s:textfield label="Address Line 1" key="address.addressLine1" />
		<s:textfield label="Address Line 2" key="address.addressLine2" />
		<s:textfield label="District" key="address.District" />
		<s:textfield label="State" key="address.State" />
		<s:textfield label="Pincode" key="address.pincode" />
		<s:submit></s:submit>
	</s:form>
</body>
</html>