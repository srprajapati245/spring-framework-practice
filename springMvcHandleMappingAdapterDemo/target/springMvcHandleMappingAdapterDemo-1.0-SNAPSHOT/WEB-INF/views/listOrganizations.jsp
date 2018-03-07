<%--
  Created by IntelliJ IDEA.
  User: Rudra Automation
  Date: 28/01/2018
  Time: 11:27 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>List of organizations</title>
    <style>
        table {
            border-collapse: collapse;
        }
        table, thead, tbody {
            padding: 5px;
            margin: 10px;
            font-size: 20px;
            border: 1px solid black;
        }
    </style>
</head>
<body>
<h2 align="center" style="color: #DF0101">
    <c:out value="${greeting}"></c:out>
</h2>
<hr/>
<div align="center">
    <table>
        <caption style="font-size: 40px; margin-bottom: 10px">
            <c:out value="${locationName}"/> Organization Directory
        </caption>
        <thead>
            <td>No</td>
            <td>Company Name</td>
            <td>Year Of Incorporation</td>
            <td>Postal Code</td>
            <td>Employee Count</td>
            <td>Slogan</td>
        </thead>
        <tbody>
            <c:forEach var="organization" items="${organizationList}">
                <tr>
                    <td><c:out value="${organization.id}"></c:out></td>
                    <td><c:out value="${organization.companyName}"></c:out></td>
                    <td><c:out value="${organization.yearOfIncorporation}"></c:out></td>
                    <td><c:out value="${organization.postalCode}"></c:out></td>
                    <td><c:out value="${organization.employeeCount}"></c:out></td>
                    <td><c:out value="${organization.slogan}"></c:out></td>
                </tr>
            </c:forEach>
        </tbody>
    </table>
</div>

</body>
</html>
