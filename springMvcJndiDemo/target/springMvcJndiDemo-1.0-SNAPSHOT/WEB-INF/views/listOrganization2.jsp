<%--
  Created by IntelliJ IDEA.
  User: Rudra Automation
  Date: 25/01/2018
  Time: 12:24 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>List of organization using a Service</title>
</head>
<body>
<h1>List of organization using a Service</h1>
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
        <c:forEach var="organization" items="${organizationList}">
            <tr>
                <td><c:out value="${organization.getId()}"></c:out></td>
                <td><c:out value="${organization.getCompanyName()}"></c:out></td>
                <td><c:out value="${organization.getYearOfIncorporation()}"></c:out></td>
                <td><c:out value="${organization.getPostalCode()}"></c:out></td>
                <td><c:out value="${organization.getEmployeeCount()}"></c:out></td>
                <td><c:out value="${organization.getSlogan()}"></c:out></td>
            </tr>
        </c:forEach>
    </tbody>
</table>

</body>
</html>
