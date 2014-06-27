<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@ page errorPage="/jsp/error.jsp"%>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://struts.apache.org/tags-tiles" prefix="tiles"%>


<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html:html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link href="${pageContext.request.contextPath}/jsp/style.css"
	rel="stylesheet">
<title>New Hire Form</title>
</head>
<body>
	<%@ include file="header.jsp"%>

	<h1>Please enter the following information to be hired into the
		system</h1>
	<p>${message}</p>
	<html:errors />
	<html:form action="/employee">
		<br />
		<br />
		<table>
	Employee Status:<html:select property="employeeStatus">
			<html:option value="Probationary">Probationary</html:option>
			<html:option value="Unrestricted">Unrestricted</html:option>
		</html:select>
		<br />
		<br>
		Employee Status: <html:select property="employeeType">
			<html:option value="Full Time">Full Time</html:option>
			<html:option value="Part Time">Part Time</html:option>
			<html:option value="Student">Student</html:option>
		</html:select>
		<br>
		<br>
		Salary<span style="color: yellow">*</span><html:text property="salary"
			maxlength="10" title="Please enter only numbers" />
		<br>
		<br>
		<input type="submit" Value="Submit">
		<input type="reset" Value="Reset">
		</table>
	</html:form>
	<br />
	<%@ include file="footer.jsp"%>
</body>
</html:html>