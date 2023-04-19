<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sql" uri="http://java.sun.com/jsp/jstl/sql" %>

<html>
<head>
  <title>Employee Details</title>
</head>
<body>
  <sql:setDataSource var="db" driver="com.mysql.jdbc.Driver"
    url="jdbc:mysql://localhost:3306/employee"
    user="root" password="root" />
    
  <sql:query dataSource="${db}" var="employees">
    SELECT * FROM emp;
  </sql:query>

  <table border="1">
    <tr>
      <th>ID</th>
      <th>Name</th>
      <th>age</th>
      <th>designation</th>
      <th>Salary</th>
    </tr>
    <c:forEach var="employee" items="${employees.rows}">
      <tr>
        <td><c:out value="${employee.emp_id}" /></td>
        <td><c:out value="${employee.name}" /></td>
        <td><c:out value="${employee.age}" /></td>
        <td><c:out value="${employee.designation}" /></td>
        <td><c:out value="${employee.salary}" /></td>
      </tr>
    </c:forEach>
  </table>
</body>
</html>
