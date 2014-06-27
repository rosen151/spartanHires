<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
   <%@ taglib uri="http://struts.apache.org/tags-html" prefix="html" %>
<html:html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link href="${pageContext.request.contextPath}/jsp/style.css" rel="stylesheet" >
<title>SpartanHires - Select a Department</title>
</head>
<body>
<%@ include file="/jsp/header.jsp" %>
<br/><br/><br/>
<html:form action="/existingDepartment">

Please select your department:
<html:select property="departmentName">
	<html:option value="ITservices">IT Services</html:option>
	<html:option value="ebs">EBS</html:option>
	<html:option value="controller">Controller</html:option>
	
	<input value="submit" type="submit" />

</html:select>


</html:form>
<br/><br/><br/>
<p></p>
<%@ include file="/jsp/footer.jsp" %>
</body>
</html:html>