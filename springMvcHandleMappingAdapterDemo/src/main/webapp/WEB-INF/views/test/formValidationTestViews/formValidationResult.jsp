<%--
  Created by IntelliJ IDEA.
  User: Rudra Automation
  Date: 05/02/2018
  Time: 4:56 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Form Validation Test Result</title>
    <spring:url value="/resources/test-main-3.css" var="testMain3Css"/>
    <link href="${testMain3Css}" rel="stylesheet">
</head>
<body>
    <h1 class="ch1">Congratulations. You are now a registered representative of your organization!</h1>
    <h2 class="ch2">Details are below...</h2>
    <hr/>
    <div style="margin-left:600px;width:auto">
        <h3>Name: <b class="cb">${organizationRepresentative.firstName} ${organizationRepresentative.lastName}</b></h3>
        <h3>Age: <b class="cb">${organizationRepresentative.age}</b></h3>
        <h3>Zip Code: <b class="cb">${organizationRepresentative.zipCode}</b></h3>
        <h3>Email: <b class="cb">${organizationRepresentative.email}</b></h3>
        <h3>Password: <b class="cb">${organizationRepresentative.password}</b></h3>
    </div>
    <hr/>
    <div align="center">
        <c:set var="contextPath" value="${pageContext.request.contextPath}"/>
        <a href="${contextPath}/formValidationDemo/home" style="font-size: 17px">Click here to go back to the home page</a>
    </div>
</body>
</html>
