<%@page import="org.apache.jasper.tagplugins.jstl.core.ForEach"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/css/bootstrap.min.css">
<title>Home Student</title>
</head>
<body>

<jsp:include page="../Layouts/Navbar.jsp"></jsp:include>

<div class="container">
	<h1>List Student</h1>
	<a class="btn btn-sm btn-success my-1" href="<c:url value="student?page=add" />">Add New Student</a>
	
	<form class="form-inline my-1" method="get" action="<c:url value="student" />">
		<input type="hidden" name="page" class="form-control" id="search" value="search">
		<input type="text" name="search" class="form-control" id="search" placeholder="Search By ID">
		<button type="submit" class="btn btn-primary">Search</button>
	</form>
	
	<table class="table">
	  <thead class="thead-light">
	    <tr>
	      <th scope="col">ID</th>
	      <th scope="col">Student Id</th>
	      <th scope="col">First Name</th>
	      <th scope="col">Last Name</th>
	      <th scope="col">School</th>
	      <th scope="col">Study Option</th>
	      <th scope="col">Registration Year</th>
	      <th scope="col">Actions</th>
	    </tr>
	  </thead>
	  <tbody>
	  	<c:forEach var="row" items="${students}">
		    <tr>
		      <th><c:out value='${row.id}' /></th>
		      <td><c:out value="${row.studentId}" /></td>
		      <td><c:out value="${row.firstname}" /></td>
		      <td><c:out value="${row.lastname}" /></td>
		      <td><c:out value="${row.school}" /></td>
		      <td><c:out value="${row.studyOption}" /></td>
		      <td><c:out value="${row.registrationYear}" /></td>
		      <td>
		      	<a class="btn btn-sm btn-primary" href='<c:url value="student?page=edit&id=${row.id}" />'>Edit</a>
		      	<a class="btn btn-sm btn-danger" href='<c:url value="student?page=delete&id=${row.id}"></c:url>'>Delete</a>
		      </td>
		    </tr>
	    </c:forEach>
	  </tbody>
	</table>
</div>
</body>
</html>