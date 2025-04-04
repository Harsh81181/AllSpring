<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://www.springframework.org/tags/form" %>
    <%@ taglib prefix="d" uri="http://java.sun.com/jsp/jstl/core" %>
    <%@ taglib prefix="p" uri="http://www.springframework.org/tags" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>display</title>
</head>
<body>
	<center><table border="2">
	<thead>
		<tr>
			<th>Id</th>
			<th>Name</th>
			<th>Email</th>
			<th>Image</th>
			<th colspan="2">Action</th>
		</tr>
		</thead>
		<tbody>
		<d:forEach var="user" items="${users}">
		<tr>
		<td>${user.id}</td>
		<td>${user.name}</td>
		<td>${user.email}</td>
		<td>
		<img src="" alt="User Image" width="100" height="100" />
		</td>
		<td><a href="update?id=${user.getId()}">Update</a></td>
		<td><a href="delete?id=${user.getId()}">Delete</a></td>
		</tr>
		</d:forEach></tbody>
	</table></center>
</body>
</html>