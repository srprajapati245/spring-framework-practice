<%--
  Created by IntelliJ IDEA.
  User: Rudra Automation
  Date: 05/02/2018
  Time: 4:42 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<html>
<head>
    <title>Test Bed</title>
    <spring:url value="/resources/test-main-3.css" var="testMain3Css"/>
    <link href="${testMain3Css}" rel="stylesheet">
</head>
<body>
    <div align="center">
        <h1 class="ch1">Welcome to the Form Validation Test Bed</h1>
        <hr/>
        <h3>Please register yourself as your Organizations Respresentative.</h3>
        <form:form action="registerOrpRep" modelAttribute="organizationRepresentative">
            <table>
                <tr>
                    <td><form:label path="firstName" cssClass="clabel">First Name</form:label></td>
                    <td><form:input path="firstName" cssClass="cinput" placeholder="Enter First Name"></form:input></td>
                    <td><form:errors path="firstName" cssClass="cb"></form:errors></td>
                </tr>
                <tr>
                    <td><form:label path="lastName" cssClass="clabel">Last Name</form:label></td>
                    <td><form:input path="lastName" cssClass="cinput" placeholder="Enter Last Name"></form:input></td>
                    <td><form:errors path="lastName" cssClass="cb"></form:errors></td>
                </tr>
                <tr>
                    <td><form:label path="age" cssClass="clabel">Age</form:label></td>
                    <td><form:input path="age" cssClass="cinput" placeholder="Enter Age"></form:input></td>
                    <td><form:errors path="age" cssClass="cb"></form:errors></td>
                </tr>
                <tr>
                    <td><form:label path="zipCode" cssClass="clabel">Zip Code</form:label></td>
                    <td><form:input path="zipCode" cssClass="cinput" placeholder="Enter Zip Code"></form:input></td>
                    <td><form:errors path="zipCode" cssClass="cb"></form:errors></td>
                </tr>
                <tr>
                    <td><form:label path="email" cssClass="clabel">Email</form:label></td>
                    <td><form:input path="email" cssClass="cinput" placeholder="Enter Email"></form:input></td>
                    <td class="cb">
                        <form:errors path="email"></form:errors>

                        <spring:hasBindErrors name="organizationRepresentative">
                            <c:forEach var="globalError" items="${errors.globalErrors}">
                                <c:if test="${fn:contains(globalError, 'Email')}">
                                    <c:out value="${globalError.defaultMessage}"/>
                                </c:if>
                            </c:forEach>
                        </spring:hasBindErrors>
                    </td>
                </tr>
                <tr>
                    <td><form:label path="verifyEmail" cssClass="clabel">Verify Email</form:label></td>
                    <td><form:input path="verifyEmail" cssClass="cinput" placeholder="Verify Email"></form:input></td>
                    <td><form:errors path="verifyEmail" cssClass="cb"></form:errors></td>
                </tr>
                <tr>
                    <td><form:label path="password" cssClass="clabel">Password</form:label></td>
                    <td><form:password path="password" cssClass="cinput" placeholder="Enter Password"></form:password></td>
                    <td><form:errors path="password" cssClass="cb"></form:errors></td>
                </tr>
                <tr>
                    <td><form:label path="verifyPassword" cssClass="clabel">Verify Password</form:label></td>
                    <td><form:password path="verifyPassword" cssClass="cinput" placeholder="Verify Password"></form:password></td>
                    <td class="cb">
                        <form:errors path="verifyPassword"></form:errors>

                        <spring:hasBindErrors name="organizationRepresentative">
                            <c:forEach var="globalError" items="${errors.globalErrors}">
                                <c:if test="${fn:contains(globalError, 'Password')}">
                                    <c:out value="${globalError.defaultMessage}"/>
                                </c:if>
                            </c:forEach>
                        </spring:hasBindErrors>
                    </td>
                </tr>
                <tr>
                    <td></td>
                    <td align="center"><input type="submit" value="Submit" class="csubmit"/></td>
                    <td></td>
                </tr>
            </table>
            <c:set var="contextPath" value="${pageContext.request.contextPath}"/>
            <c:if test="${formErrors ne null}">
                <a href="${contextPath}/formValidationDemo/home" style="font-size: 17px">Click here to start a fresh form!</a>
            </c:if>
        </form:form>
    </div>
</body>
</html>
