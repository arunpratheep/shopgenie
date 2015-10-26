<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@page import="java.util.Iterator"%>
<%@page import="com.shopgenie.entities.Product"%>
<%@page import="java.util.List"%>
<%@page import="com.shopgenie.dao.ProductDao"%>
<%
out.println("getproduct");
     ProductDao productDao=new ProductDao();
			
    List<Product> products =productDao.getALL();
    Iterator<Product> iterator = products.iterator();
    while(iterator.hasNext()) {
       	System.out.println(iterator.next().getProductName());
        out.println("hello");
    }
%>