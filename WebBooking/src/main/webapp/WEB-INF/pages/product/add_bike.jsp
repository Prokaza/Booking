<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title><spring:message code="message.addBike" /></title>
    <link href="<c:url value="/resources/css/style.css"/>" type="text/css" rel="stylesheet" >
    <link rel="shortcut icon" href="/resources/image/bike-ico.png" type="image/png">
    <script src="<c:url value="/resources/js/jquery-1.11.3.min.js" />"></script>
</head>
<body>
<div id="container">
    <%@include file="/WEB-INF/pages/include/header.jsp"%>
    <%@include file="/WEB-INF/pages/include/main_menu.jsp"%>
    <div id="content">
        <form:form method="POST" modelAttribute="bike" cssClass="other_form" enctype="multipart/form-data">
            <fieldset class="fieldset_info">
                <legend><spring:message code="message.addBike" /></legend>
                <form:label path="bikeName"><spring:message code="message.bikeName"/></form:label>
                <form:input path="bikeName" required = "true" cssClass="input_text"/>
                    <%--<span class="error"><form:errors path="email"/></span>--%>

                <form:label path="info"><spring:message code="message.bikeInfo"/></form:label>
                <form:textarea path="info" required = "true" cssClass="input_text_area"/>
                    <%--<span class="error"><form:errors path="email"/></span>--%>
                <br>
                <table>
                    <tr>
                        <td>
                            <form:label path="type"><spring:message code="message.bikeType"/></form:label><br>
                            <form:select path="type" size="1" cssClass="select">
                                <form:option value="MAN" path="type"><spring:message code="message.man"/></form:option>
                                <form:option value="WOMAN" path="type"><spring:message code="message.woman"/></form:option>
                            </form:select>
                        </td>
                        <td> </td>
                        <td>
                            <form:label path="clazzId.className"><spring:message code="message.bikeClass"/></form:label><br>
                            <form:select path="clazzId.className" size="1" cssClass="select">
                                <form:option value="SIMPLE" path="clazzId.className"><spring:message code="message.simple"/></form:option>
                                <form:option value="MEDIUM" path="clazzId.className"><spring:message code="message.medium"/></form:option>
                                <form:option value="PRO" path="clazzId.className"><spring:message code="message.professional"/></form:option>
                            </form:select>
                        </td>
                    </tr>
                </table>
                <fieldset class="fieldset"><legend><spring:message code="message.addPhoto" /></legend>
                    <label>File to upload:</label><br>
                    <input type="file" name="file" class="login"><br>
                    <label>Name:</label><br>
                    <input type="text" name="name" class="input"><br>
                </fieldset>
                <form:button name="" value="/product/add_bike" class = "button_reg"><spring:message code="message.addBike"/></form:button>
            </fieldset>
        </form:form>
    </div>
    <%@include file="/WEB-INF/pages/include/footer.jsp"%>
</div>
</body>
</html>