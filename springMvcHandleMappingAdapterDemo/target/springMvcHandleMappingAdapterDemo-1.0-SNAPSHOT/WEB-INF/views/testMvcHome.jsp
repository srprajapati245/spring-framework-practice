<%--
  Created by IntelliJ IDEA.
  User: Rudra Automation
  Date: 29/01/2018
  Time: 1:51 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <title>MVC Test Home</title>
    <style>
        h2 {
            color: #08298A;
            text-align: center
        }
    </style>
</head>
<body>
<h2>MVC Test Home</h2>
<c:set var="contextPath" value="${pageContext.request.contextPath}"/>
<div style="text-align:center">
    <a href="${contextPath}/requestMappingAndParamDemo/home" style="font-size: 20px;">Click here to go to the test bed for @RequestMapping and @RequestParam</a><br/><br/>
    <a href="${contextPath}/home" style="font-size: 20px;">Click here to go to the test bed for @ModelAttribute</a><br/>
    <a href="${contextPath}/home2" style="font-size: 20px;">Click here to go to the 2nd home test bed</a><br/>
    <a href="${contextPath}/home3" style="font-size: 20px;">Click here to go to the 3rd home test bed</a><br/>
    <a href="${contextPath}/home4" style="font-size: 20px;">Click here to go to the 4th home test bed</a><br/>
    <a href="${contextPath}/home5" style="font-size: 20px;">Click here to go to the 5th home test bed</a><br/><br/>
    <a href="${contextPath}/visitorRegister/home" style="font-size: 20px;">Click here to go to the test bed for @SessionAttribute annotation</a><br/><br/>
    <a href="${contextPath}/formTagsDemo/home" style="font-size: 20px;">Click here to go to the test bed for Form Tags</a><br/><br/>
    <a href="${contextPath}/formValidationDemo/home" style="font-size: 20px;">Click here to go to the test bed for Form Validation</a><br/><br/>
</div>
</body>
</html>
