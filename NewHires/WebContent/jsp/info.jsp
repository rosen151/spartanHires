<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page errorPage="/jsp/error.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>SpartanHires - added Record</title>
<link href="${pageContext.request.contextPath}/jsp/style.css"
	rel="stylesheet">
</head>
<body>

	<%@ include file="/jsp/header.jsp"%>
	<br />
	<br />
	<br />
	<p></p>
	<h2>You have added the following information to your department's
		database:</h2>
	<p>First name: ${fname}</p>
	<p>Last name: ${lname}</p>
	<p>DOB: ${dob}</p>
	<p>SSN: ${ssn}</p>
	<p>EMAIL Address: ${email}</p>
	<p>NETID : ${netid}</p>
	<p>ADDRESS : ${address}</p>
	<br />

	<p>
		<a href="jsp/logout.jsp">Logout</a>

	</p>


	<%@ include file="footer.jsp"%>
</body>
</html>