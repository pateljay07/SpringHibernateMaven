<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<%-- ${message} --%>

<table border="1px" cellpadding="0" cellspacing="0">
<thead>
<tr>
<th width="10%">id</th><th width="15%">name</th><th width="10%">rating</th><th width="10%">actions</th>
</tr>
</thead>
<tbody>
<!-- something -->
<c:forEach var="team" items="${results}">
	<tr>
		<td>${team.orderNo}</td>
		<td>${team.name}</td>
		<td>
		<a href="${pageContext.request.contextPath}/team/edit/${team.orderNo}.html">Edit</a><br>
		<a href="${pageContext.request.contextPath}/team/delete/${team.orderNo}.html">Delete</a><br>
		</td>
	</tr>
</c:forEach>
</tbody>
</table>

</body>
</html>