<%--
  Created by IntelliJ IDEA.
  User: Rudra Automation
  Date: 13/02/2018
  Time: 1:02 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<html>
<head>
    <title>List of Employees</title>
    <spring:url value="/resources/css/style.css" var="styleCss"/>
    <link href="${styleCss}" rel="stylesheet"/>
</head>
<body>
    <div id="wrapper">
        <div id="header">
            <h1 align="center">CRM - Customer Relationship Management</h1>
        </div>
    </div>
    <div id="container">
        <div id="content">

            <%--<c:set var="contextPath" value="${pageContext.request.contextPath}"/>--%>
            <c:url value="/employee/add" var="employeeAddLink">
                <c:param name="companyId" value="${companyId}"/>
            </c:url>
            <a href="${employeeAddLink}" class="add-button">Add New Employee</a><br/><br/>

            <table style="padding-top: 10px">
                <tr>
                    <th>Company Name</th>
                    <th>First Name</th>
                    <th>Middle Name</th>
                    <th>Last Name</th>
                    <th>Aadhar Number</th>
                    <th>PAN Number</th>
                    <th>Primary Number</th>
                    <th>Secondry Number</th>
                    <th>Email Address</th>
                    <th>Date Of Birth</th>
                    <th>Action</th>
                </tr>
                <c:forEach var="employee" items="${employees}">
                    <c:url value="/employee/update" var="updateLink">
                        <c:param name="id" value="${employee.id}"/>
                    </c:url>
                    <c:url value="/employee/delete" var="deleteLink">
                        <c:param name="id" value="${employee.id}"/>
                    </c:url>
                    <tr>
                        <td><c:out value="${employee.company.companyName}"></c:out></td>
                        <td><c:out value="${employee.firstName}"></c:out></td>
                        <td><c:out value="${employee.middleName}"></c:out></td>
                        <td><c:out value="${employee.lastName}"></c:out></td>
                        <td><c:out value="${employee.aadharNumber}"></c:out></td>
                        <td><c:out value="${employee.panNumber}"></c:out></td>
                        <td><c:out value="${employee.contactNumber1}"></c:out></td>
                        <td><c:out value="${employee.contactNumber2}"></c:out></td>
                        <td><c:out value="${employee.emailAddress}"></c:out></td>
                        <td><c:out value="${employee.dateOfBirth}"></c:out></td>
                        <td><a href="${updateLink}">Update</a> | <a href="${deleteLink}" onclick="if(!(confirm('Are you sure want ot delete this employee')))return false">Delete</a></td>
                    </tr>
                </c:forEach>
            </table>
        </div>
    </div>
</body>
</html>
