<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/css/bootstrap.min.css">
<title>Confirmation Delete</title>
</head>
<body>
<jsp:include page="../Layouts/Navbar.jsp"></jsp:include>

<div class="container">
	<div class="row">
		<div class="col-8">
			<h2 class='bg-red'>Are you sure?</h2>
			<div class="row">
				<a class="btn btn-danger" href="<c:url value="student?page=confdelete&id=${id}" />">Delete</a>
				<a class="btn" href='<c:url value="students" />'>No</a>
			</div>
		</div>
	</div>
</div>

</body>
</html>