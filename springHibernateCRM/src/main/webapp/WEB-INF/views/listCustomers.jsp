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
    <title>List of Customers</title>
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

            <c:set var="contextPath" value="${pageContext.request.contextPath}"/>
            <a href="${contextPath}/customer/add" class="add-button">Add Customer</a><br/><br/>

            <table style="padding-top: 10px">
                <tr>
                    <th>First Name</th>
                    <th>Last Name</th>
                    <th>Email</th>
                    <th>Action</th>
                </tr>
                <c:forEach var="customer" items="${customers}">
                    <c:url value="/customer/update" var="updateLink">
                        <c:param name="id" value="${customer.id}"/>
                    </c:url>
                    <c:url value="/customer/delete" var="deleteLink">
                        <c:param name="id" value="${customer.id}"/>
                    </c:url>
                    <tr>
                        <td><c:out value="${customer.firstName}"></c:out></td>
                        <td><c:out value="${customer.lastName}"></c:out></td>
                        <td><c:out value="${customer.email}"></c:out></td>
                        <td><a href="${updateLink}">Update</a> | <a href="${deleteLink}" onclick="if(!(confirm('Are you sure want ot delete this customer')))return false">Delete</a></td>
                    </tr>
                </c:forEach>
            </table>
        </div>
    </div>
</body>
</html>
