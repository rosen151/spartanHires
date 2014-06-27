<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html"%>
<link rel="stylesheet"
	href="http://code.jquery.com/ui/1.9.2/themes/base/jquery-ui.css" />
<script src="http://code.jquery.com/jquery-1.8.3.js"></script>
<script src="http://code.jquery.com/ui/1.9.2/jquery-ui.js"></script>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html:html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet"
	href="http://code.jquery.com/ui/1.9.2/themes/base/jquery-ui.css" />
<script src="http://code.jquery.com/jquery-1.8.3.js"></script>
<script src="http://code.jquery.com/ui/1.9.2/jquery-ui.js"></script>
<script>
	$(function() {
		$("#datepicker").datepicker();
	});
</script>
<title>Enter Personal Info</title>
</head>
<body
	style="font-family: Arial, Helvetica, sans-serrif; color: #ebefee; display: block; margin-left: auto; margin-right: auto; width: 700px; background-color: #18453B;">
	<%@ include file="header.jsp"%>
	<h2>You have added the following information to your department's
		database:</h2>
	<p>Department Name: ${departmentName}</p>
	<h1>Please enter the following information to be hired into the
		system</h1>
	<p style="color: yellow">${message}</p>
	<html:errors />
	<html:form action="/person">
		<h3>Personal Information</h3>
		<label style="text-align:right;padding-right:30px;display:inline-block;">First Name<span style="color: yellow">*</span></label>
		<input type="text" name="fname" maxlength="30" />
		<br />
		<label style="text-align:right;padding-right:20px;display:inline-block;">Last Name<span style="color: yellow">*</span></label>
		<input type="text" name="lname" maxlength="30" />
		<br />
		<label style="text-align:right;padding-right:20px;display:inline-block;">Date of Birth<span style="color: yellow">*</span></label>
		<input type="text" name="dob" id="datepicker" />
		<br /> <label style="text-align:right;padding-right:20px;display:inline-block;">Social Security Number<span style="color: yellow">*</span></label>
		<input type="text" name="ssn" maxlength="9" />
		<br /> <label style="text-align:right;padding-right:20px;display:inline-block;">Email<span style="color: yellow">*</span></label>
		<input type="text" name="email" maxlength="50" />
		<br />
		<label style="text-align:right;padding-right:20px;display:inline-block;">Net Id<span style="color: yellow">*</span></label>
		<input type="text" name="netId" maxlength="8" />
		<br />
		<label style="text-align:right;padding-right:20px;display:inline-block;">Address<span style="color: yellow">*</span></label>
		<input type="text" name="address" />
		<br />
		<br />
		&nbsp;<input type="submit" value="Submit" />
		&nbsp;<input type="reset" value="reset" />

	</html:form>
	<br />
	<%@ include file="footer.jsp"%>


</body>
</html:html>