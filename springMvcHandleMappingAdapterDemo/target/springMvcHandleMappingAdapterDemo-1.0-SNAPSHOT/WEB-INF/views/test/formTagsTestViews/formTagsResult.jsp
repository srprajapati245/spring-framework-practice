<%--
  Created by IntelliJ IDEA.
  User: Rudra Automation
  Date: 04/02/2018
  Time: 10:41 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Form Tags Test Result</title>
    <spring:url value="/resources/test-main-2.css" var="testMainCss2"/>
    <link href="${testMainCss2}" rel="stylesheet"/>
</head>
<body>
    <h1>Congratulation! You have register your organization</h1>
    <h2>Details below...</h2>
    <div style="margin-left: 600px; width: auto">
        <h3>Organization Name: <b>${orgReg.organizationName}</b></h3>
        <h3>Country Name: <b>${orgReg.country}</b></h3>

        <h3>Turnover:
            <c:forEach var="entry" items="${turnoverlist}">
                <c:if test="${orgReg.turnover eq entry.key}">
                    <b>${entry.value}</b>
                </c:if>
            </c:forEach>
        </h3>
        <h3>Organization Type:
            <c:forEach var="entry" items="${orgtypelist}">
                <c:if test="${orgReg.orgType eq entry.key}">
                    <b>${entry.value}</b>
                </c:if>
            </c:forEach>
        </h3>
        <h3>Organization Age:
            <c:forEach var="entry" items="${servicelengthlist}">
                <c:if test="${orgReg.serviceLength eq entry.key}">
                    <b>${entry.value}</b>
                </c:if>
            </c:forEach>
        </h3>
        <h3>Register Already?:
            <c:forEach var="entry" items="${registeralready}">
                <c:if test="${orgReg.registerAlready eq entry.key}">
                    <b>${entry.value}</b>
                </c:if>
            </c:forEach>
        </h3>
        <h3>Like our website?:
            <c:choose>
                <c:when test="${orgReg.like eq 'yes'}"><b>Like</b></c:when>
                <c:otherwise><b>Do not like</b></c:otherwise>
            </c:choose>
        </h3>
        <h3>Optional Servies Signed up for:
            <c:forEach var="entry1" items="${subscriptionlist}">
                <c:forEach var="entry2" items="${orgReg.optionalService}">
                    <c:if test="${entry2 eq entry1.key}">
                        <c:set var="optService" value="${optService}${entry1.value}, "></c:set>
                    </c:if>
                </c:forEach>
            </c:forEach>
            <b>${optService.substring(0, optService.length() - 2)}</b>
        </h3>
        <h3>Primiun Servies Signed up for:
            <c:forEach var="entry1" items="${primiunservicelist}">
                <c:forEach var="entry2" items="${orgReg.primiumService}">
                    <c:if test="${entry2 eq entry1.key}">
                        <c:set var="primiunService" value="${primiunService}${entry1.value}, "></c:set>
                    </c:if>
                </c:forEach>
            </c:forEach>
            <b>${primiunService.substring(0, primiunService.length() - 2)}</b>
        </h3>
        <h3>Has Overseas Operations: <b>${orgReg.overseasOperation}</b></h3>
        <h3>Workforce size:
            <c:forEach var="entry" items="${employeestrengthlist}">
                <c:if test="${orgReg.employeeStrength eq entry.key}">
                    <b>${entry.value}</b>
                </c:if>
            </c:forEach>
        </h3>
    </div>
</body>
</html>
