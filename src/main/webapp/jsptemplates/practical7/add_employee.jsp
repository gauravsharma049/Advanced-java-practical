<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="sql" uri="http://java.sun.com/jsp/jstl/sql" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page errorPage="../error.jsp" %>  
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Add Employee Details</title>
</head>
<body>
<sql:setDataSource var="db" driver="com.mysql.jdbc.Driver"
    url="jdbc:mysql://localhost:3306/employee"
    user="root" password="root" />
	<%  String id = request.getParameter("emp_id");
		String name = request.getParameter("name");
		String age = request.getParameter("age");
		String designation = request.getParameter("designation");
		String salary = request.getParameter("salary");
		
	%>
	
  <sql:update dataSource="${db}" var="employees">
    insert into emp values (<%= id %>, '<%= name %>', <%= age %>, '<%= designation %>', <%= salary %>);
  </sql:update>
	<c:if test="${employees > 0 }">
		<h1>Employee Data Inserted Successfully</h1>
	</c:if>
	
</body>
</html>