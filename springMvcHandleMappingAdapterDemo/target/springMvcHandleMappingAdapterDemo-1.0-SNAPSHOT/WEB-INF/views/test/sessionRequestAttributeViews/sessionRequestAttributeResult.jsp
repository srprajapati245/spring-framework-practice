<%--
  Created by IntelliJ IDEA.
  User: Rudra Automation
  Date: 02/02/2018
  Time: 1:30 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Test Results</title>
    <spring:url value="/resources/test-main.css" var="testMainCss"/>
    <link href="${testMainCss}" rel="stylesheet">
</head>
<body>
    <div align="center">
        <h1>@SessionAttribute Test Results</h1>
        <h3>${timeHeading}, ${durationHeading}</h3>
        <hr/>
        <h3>No of page visits in this session: <c:out value="${visitorcount.count}"/></h3>
        <h3>List of visitor to this site</h3>

        <ul>
            <c:forEach var="visitor" items="${visitordata.visitors}">
                <li><b><c:out value="${visitor.name}"/>, <c:out value="${visitor.email}"/></b></li>
            </c:forEach>
        </ul>
        <br/>
        <br/>
        <c:set var="contextPath" value="${pageContext.request.contextPath}"/>
        <a href="${contextPath}/visitorRegister/home" style="font: 20px;">Generate Another Visit</a>
    </div>
</body>
</html>
