<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
  <%@ taglib uri="http://struts.apache.org/tags-html" prefix="html" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html:html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>SpartanHires - IT Services Admin Page</title>
<link href="${pageContext.request.contextPath}/jsp/style.css" rel="stylesheet" >
</head>
<body>

<%@ include file="/jsp/header.jsp" %>
<br/><br/><br/>
<p></p>

		<h1>Employees of the Controller's Office:</h1>
		<table border="1"> 
		<tr>
			<th>First Name</th>
			<th>Last Name</th>
			<th>SSN</th>
			<th>D.O.B.</th>
			<th>NetId</th>
		</tr>
		<c:forEach items="${list}" var="list">
			<tr>
				<td>${list.fname}</td>
				<td>${list.lname}</td>
				<td>${list.ssn}</td>
				<td>${list.dob}</td>
				<td>${list.netId}</td>
				<td><a style="text-decoration:none; color:#18453B;"
					href='<c:url value='/delete.do'> <c:param name="PID" value="${list.pid}"/></c:url>'><img alt="delete" src="images/delete.png" value="delete record"></a>
				<td><a style="text-decoration:none; color:#18453B;"
					href='<c:url value='/edit.do'> <c:param name="PID" value="${list.pid}"/></c:url>'><img alt="edit" src="images/edit.png" value="edit record"></a>
				
			</tr>
		</c:forEach>
		</table>
		<p>
		<a href="jsp/logout.jsp">Logout</a>

	</p>
		
	<%@ include file="/jsp/footer.jsp" %>
</body>
</html:html>