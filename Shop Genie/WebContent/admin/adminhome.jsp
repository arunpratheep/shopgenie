<%@page import="com.shopgenie.dao.CategoryDao"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib prefix="s" uri="/struts-tags"%>
<%@page import="java.util.List"%>
<%@page import="com.shopgenie.entities.Category"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Admin</title>
<script type="text/javascript" src="../js/jquery-2.1.4.js"></script>
<script type="text/javascript" src="../js/admin.js"></script>
</head>
<body>
	<form action="sellerVerify">
		<s:submit value="VerifySeller" id="showUnverified"></s:submit>
	</form>
	<form action="verifySeller" method="post">
		<table border="1">
			<tr>
				<th>Name</th>
				<th>Mobile</th>
				<th>AddressLine1</th>
				<th>AddressLine2</th>
				<th>District</th>
				<th>State</th>
				<th>Verify</th>
			</tr>

			<s:iterator value="unverifiedSellers">
				<tr class="data">
					<td><s:property value="sname" /></td>
					<td><s:property value="mobile" /></td>
					<td><s:property value="address.addressLine1" /></td>
					<td><s:property value="address.addressLine2" /></td>
					<td><s:property value="address.District" /></td>
					<td><s:property value="address.State" /></td>
					<td><input type="checkbox" id="chkbox" name="chkbox"
						value=<s:property value="sid"/>></td>
				</tr>
			</s:iterator>
		</table>

		<input type="submit" id="verify" name="Verify" value="VerifySeller" />
	</form>


	<form action="productVerify">
		<s:submit value="Verifyproduct" id="showUnverifiedProduct"></s:submit>
	</form>
	<form action="verifyProduct" method="get">
		<table border="1">
			<tr>
				<th>Product Name</th>
				<th>Category</th>
				<th>Verify</th>
				<th>Move to another Category</th>

			</tr>

			<s:iterator value="unverifiedProducts">
				<tr class="data">
					<td><s:property value="productName" /></td>
					<td><s:property value="category.categoryName" /></td>
					<td><input type="checkbox" id="chkbox" name="chkbox"
						value=<s:property value="productId"/>></td>
					<td><select><option selected><s:property value="category.categoryName" />(Default)</option>
							<%
							    CategoryDao cat = new CategoryDao();
									List<Category> categ = cat.getALL();
									for (Category c : categ)
									{
							%><option>
								<%
								    out.print(c.getCategoryName());
								%>
							</option>
							<%
									}
							%>
					</select></td>
				</tr>
			</s:iterator>
		</table>

		<input type="submit" id="verifyProduct" name="VerifyProduct"
			value="VerifyProduct" />
	</form>
</body>
</html>