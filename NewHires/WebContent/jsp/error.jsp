<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

    

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>User Error</title>
<link href="${pageContext.request.contextPath}/jsp/style.css" rel="stylesheet" >
</head>
<body>

<%@ include file="/jsp/header.jsp" %>
<br/><br/><br/>
<p></p>

<p>You have encountered an error with the information you entered</p>
<p>
	Please Click <a href="${pageContext.request.contextPath}">here</a> to try again
	
</p>


<%@ include file="/jsp/footer.jsp" %>

</body>
</html>