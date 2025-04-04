<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%-- <%@ taglib prefix="c" uri="http://java.sun.com/jstl/core" %>
 --%><%@ taglib prefix="d" uri="http://www.springframework.org/tags/form" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>register</title>
</head>
<body>
	<d:form action="registerUser" method="post" modelAttribute="user">
	<d:label path="id">ID:</d:label><br>
	<d:input path="id" name="id"/><br>
	
	<d:label path="name"> NAME: </d:label><br>
	<d:input path="name" name="name"/><br>
	<d:label path="email"> Email: </d:label><br>
	<d:input path="email" name="email"/><br>
	<d:label path="image">Image: </d:label><br>
	<d:input path="image" name="image" type="file"/><br>
	<d:button>register</d:button>
	</d:form>
</body>
</html>