<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/css/bootstrap.min.css">

<title>Home</title>
</head>
<body>
<jsp:include page="Layouts/Navbar.jsp" />

<div class="container">
	<h1>Devoir</h1>
	<h2>HAYANE Lahcen</h2>
	<h3>MIAGE 5</h3>
	<hr>
	<a class="btn btn-primary" href="<c:url value="students" />"><h1>List Student</h1></a>
</div>

</body>
</html>