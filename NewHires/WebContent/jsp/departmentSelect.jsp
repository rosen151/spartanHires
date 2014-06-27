<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html:html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link href="${pageContext.request.contextPath}/jsp/style.css"
	rel="stylesheet">
<title>SpartanHires - Select a Department</title>
</head>
<body>
	<%@ include file="/jsp/header.jsp"%>
	<br />
	<br />
	<br />
	<html:form action="/department">
	<h2>You have added the following information to your department's database:</h2>
		<p>Employee Status: ${employeestatus}</p>
		<p>Employee Type: ${employeeType}</p>
		<p>Employee salary: ${salary}</p>
Please select your new department<span style="color: yellow">*</span>
<select name="department_name">
			<option value="ITservices">IT Services</option>
			<option value="ebs">EBS</option>
			<option value="controller">Controller</option>

			<input value="Next" type="submit" />

		</select>


	</html:form>
	<br />
	<br />
	<br />
	<p></p>
	<%@ include file="/jsp/footer.jsp"%>
</body>
</html:html>