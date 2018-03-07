<%--
  Created by IntelliJ IDEA.
  User: Rudra Automation
  Date: 28/01/2018
  Time: 11:27 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sql" uri="http://java.sun.com/jsp/jstl/sql" %>
<html>
<head>
    <title>List of organization using the JSTL Sql tag</title>
</head>
<body>
<h1>List of organization using the JSTL Sql tag</h1>
<sql:query var="rs" dataSource="jdbc/springdb">
    SELECT * FROM organization
</sql:query>
<table>
    <thead>
    <tr>
        <td>No</td>
        <td>Company Name</td>
        <td>Year Of Incorporation</td>
        <td>Postal Code</td>
        <td>Employee Count</td>
        <td>Slogan</td>
    </tr>
    </thead>
    <tbody>
    <c:forEach var="row" items="${rs.rows}">
        <tr>
            <td><c:out value="${row.id}"></c:out></td>
            <td><c:out value="${row.company_name}"></c:out></td>
            <td><c:out value="${row.year_of_incorporation}"></c:out></td>
            <td><c:out value="${row.postal_code}"></c:out></td>
            <td><c:out value="${row.employee_count}"></c:out></td>
            <td><c:out value="${row.slogan}"></c:out></td>
        </tr>
    </c:forEach>
    </tbody>
</table>

</body>
</html>
