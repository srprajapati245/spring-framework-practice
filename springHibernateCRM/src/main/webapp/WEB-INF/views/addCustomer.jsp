<%--
  Created by IntelliJ IDEA.
  User: Rudra Automation
  Date: 13/02/2018
  Time: 6:03 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>Add Customer</title>
    <spring:url value="/resources/css/add-customer-style.css" var="addCustomerStyleCss"/>
    <spring:url value="/resources/css/style.css" var="styleCss"/>
    <link href="${styleCss}" rel="stylesheet"/>
    <link href="${addCustomerStyleCss}" rel="stylesheet"/>

</head>
<body>
<div id="wrapper">
    <div id="header">
        <h1 align="center">CRM - Customer Relationship Management</h1>
    </div>
</div>
<div id="container">
    <h3>Save Customer</h3>
    <form:form action="save" method="post" modelAttribute="customer">
        <form:hidden path="id" />
        <table>
            <tr>
                <td><form:label path="firstName">First Name</form:label></td>
                <td><form:input path="firstName" placeholder="Enter First Name"></form:input></td>
            </tr>
            <tr>
                <td></td>
                <td><form:errors path="firstName"></form:errors></td>
            </tr>
            <tr>
                <td><form:label path="lastName">Last Name</form:label></td>
                <td><form:input path="lastName" placeholder="Enter Last Name"></form:input></td>
            </tr>
            <tr>
                <td></td>
                <td><form:errors path="lastName"></form:errors></td>
            </tr>
            <tr>
                <td><form:label path="email">Email Address</form:label></td>
                <td><form:input path="email" placeholder="Enter Email Address"></form:input></td>
            </tr>
            <tr>
                <td></td>
                <td><form:errors path="email"></form:errors></td>
            </tr>
            <tr>
                <td></td>
                <td><input type="submit" value="Save" class="save"></td>
            </tr>
        </table>
    </form:form>

    <c:set var="contextPath" value="${pageContext.request.contextPath}"/>
    <a href="${contextPath}/customer/list" class="add-button">Back to List</a><br/><br/>
</div>
</body>
</html>
