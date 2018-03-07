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
    <title>Add Company</title>
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
    <h3>Add New Company</h3>
    <form:form action="save" method="post" modelAttribute="company">
        <form:hidden path="id" />
        <table>
            <tr>
                <td><form:label path="companyName">Company Name</form:label></td>
                <td><form:input path="companyName" placeholder="Enter Company Name"></form:input></td>
            </tr>
            <tr>
                <td><form:label path="address">Address</form:label></td>
                <td><form:input path="address" placeholder="Enter Address"></form:input></td>
            </tr>
            <tr>
                <td></td>
                <td><input type="submit" value="Save" class="save"></td>
            </tr>
        </table>
    </form:form>

    <c:set var="contextPath" value="${pageContext.request.contextPath}"/>
    <a href="${contextPath}/company/list" class="add-button">Back to List</a><br/><br/>
</div>
</body>
</html>
