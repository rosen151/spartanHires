<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://struts.apache.org/tags-html" prefix="html"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html:html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Record Successfully Deleted</title>
<link href="${pageContext.request.contextPath}/jsp/style.css" rel="stylesheet" >
</head>
<body>
<%@ include file="/jsp/header.jsp" %>
	<p>Thank you, the indicated record has been deleted from your department's employee list</p>
	
	<a href="${pageContext.request.contextPath }">Go Back to Your Page</a>
	
	<%@ include file="/jsp/footer.jsp" %>
</body>
</html:html>