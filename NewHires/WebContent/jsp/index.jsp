<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ page errorPage="/jsp/error.jsp" %>
    <%@ taglib uri="http://struts.apache.org/tags-html" prefix="html" %>
    <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html:html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>SpartanHires - Welcome</title>
<link href="${pageContext.request.contextPath}/jsp/style.css" rel="stylesheet" >
</head>
<body>

<%@ include file="/jsp/header.jsp" %>
<br/><br/><br/>
<p></p>
<html:form action="login">
<p>If you are a new employee, please click <a href='<c:url value='/jsp/employee.jsp'></c:url>'>here</a> to enter your information into the system.</p>

<hr style="color:#000;"></hr>
<br/>

<p>If you are a department administrator, please login here to view your department's employee data</p>
<p>Username:<html:text property="name"></html:text></p>
<p>Password:<html:password property="password"></html:password></p>

 
<input type="submit" value="Login" />
<input type="reset" value="Reset" />

</html:form>
<br/><br/><br/>
<p></p>
<%@ include file="/jsp/footer.jsp" %>
</body>
</html:html>