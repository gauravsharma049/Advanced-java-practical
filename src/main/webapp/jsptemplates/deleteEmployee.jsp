<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="sql" uri="http://java.sun.com/jsp/jstl/sql" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page errorPage="jsptemplates/error.jsp" %>  
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<sql:setDataSource var="db" driver="com.mysql.jdbc.Driver"
    	url="jdbc:mysql://localhost:3306/employee"
    	user="root" password="root" />
    	<% String id = request.getParameter("emp_id"); %>
  	<sql:update dataSource="${db}" var="employees">
  		delete from emp where emp_id = <%= id %>;
	</sql:update>
	<c:if test="${employees > 0 }">
		<h1>Employee Data with emp id : <%= id %> Deleted Successfully</h1>
	</c:if>
	<c:if test="${employees == 0 }">
		<h1>Employee Data with emp id : <%= id %> was not found</h1>
	</c:if>
</body>
</html>