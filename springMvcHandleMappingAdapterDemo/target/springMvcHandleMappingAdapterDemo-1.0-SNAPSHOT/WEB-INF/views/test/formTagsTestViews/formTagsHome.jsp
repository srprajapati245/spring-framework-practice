<%--
  Created by IntelliJ IDEA.
  User: Rudra Automation
  Date: 04/02/2018
  Time: 10:33 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<html>
<head>
    <title>Test Bed</title>
    <spring:url value="/resources/test-main-2.css" var="testMainCss2"/>
    <link href="${testMainCss2}" rel="stylesheet"/>
</head>
<body>
    <div align="center">
        <h1>Welcome to Form Tags Test Bed</h1>
        <hr/>
        <h3>Register your organization with us!</h3>
        <form:form action="registerOrg" modelAttribute="organizationRegistration" method="post">
            <table>
                <tr>
                    <td><form:label path="organizationName">Name of Organization</form:label></td>
                    <td><form:input path="organizationName" placeholder="Enter organization name" /></td>
                </tr>
                <tr>
                    <td><form:label path="country">Country</form:label></td>
                    <td>
                        <form:select path="country">
                            <form:option value="None">----Select----</form:option>
                            <form:option value="Australia">Australia</form:option>
                            <form:option value="India">India</form:option>
                            <form:option value="Sweden">Sweden</form:option>
                            <form:option value="United States">United States</form:option>
                            <form:option value="Egypt">Egypt</form:option>
                        </form:select>
                    </td>
                </tr>
                <tr>
                    <td><form:label path="turnover">Turnover</form:label></td>
                    <td><form:select path="turnover" items="${turnoverlist}"/></td>
                </tr>
                <tr>
                    <td><form:label path="orgType">Organization Type</form:label></td>
                    <td>
                        <form:select path="orgType">
                            <form:option value="None">----SELECT----</form:option>
                            <form:options items="${orgtypelist}"></form:options>
                        </form:select>
                    </td>
                </tr>
                <tr>
                    <td><form:label path="serviceLength">Organization Age</form:label></td>
                    <td>
                        <form:select path="serviceLength" items="${servicelengthlist}"></form:select>
                    </td>
                </tr>
                <tr>
                    <td><form:label path="registerAlready">Register Already?</form:label></td>
                    <td>
                        <form:checkbox path="registerAlready" items="${registeralready}"></form:checkbox>
                    </td>
                </tr>
                <tr>
                    <td><form:label path="like">Like our website?</form:label></td>
                    <td>
                        <form:checkbox path="like" value="yes"></form:checkbox>Like
                    </td>
                </tr>
                <tr>
                    <td><form:label path="optionalService">Option Services Subscription:</form:label></td>
                    <td>
                        <form:checkbox path="optionalService" value="emailService"></form:checkbox>${subscriptionlist.emailService}
                        <form:checkbox path="optionalService" value="promotionalService"></form:checkbox>${subscriptionlist.promotionalService}
                        <form:checkbox path="optionalService" value="newsLetterService"></form:checkbox>${subscriptionlist.newsLetterService}
                    </td>
                </tr>
                <tr>
                    <td><form:label path="primiumService">Primiun Services</form:label></td>
                    <td>
                        <form:checkboxes path="primiumService" items="${primiunservicelist}"></form:checkboxes>
                    </td>
                </tr>
                <tr>
                    <td><form:label path="overseasOperation">Overseas operation?</form:label></td>
                    <td>
                        <form:radiobutton path="overseasOperation" value="Yes"></form:radiobutton>Yes
                        <form:radiobutton path="overseasOperation" value="No"></form:radiobutton>No
                    </td>
                </tr>
                <tr>
                    <td><form:label path="employeeStrength">Workforce size</form:label></td>
                    <td>
                        <form:radiobuttons path="employeeStrength" items="${employeestrengthlist}"></form:radiobuttons>
                    </td>
                </tr>
                <tr>
                    <td></td>
                    <td align="center"><input type="submit" value="Submit"/></td>
                </tr>
            </table>

        </form:form>
    </div>
</body>
</html>
