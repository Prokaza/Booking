<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title><spring:message code="message.editBooking" /></title>
    <link href="<c:url value="/resources/css/style.css"/>" type="text/css" rel="stylesheet" >
    <link rel="shortcut icon" href="/resources/image/bike-ico.png" type="image/png">
    <script src="<c:url value="/resources/js/jquery-1.11.3.min.js" />"></script>
</head>
<body>
<div id="container">
    <%@include file="/WEB-INF/pages/include/header.jsp"%>
    <%@include file="/WEB-INF/pages/include/main_menu.jsp"%>
    <div id="content">
        <form:form method="POST" modelAttribute="booking" cssClass="other_form" >
            <fieldset class="fieldset_info">
                <legend><spring:message code="message.booking" /></legend>
                <form:label path=";dateBooking"><spring:message code="message.dateBooking"/></form:label>
                <form:input path="dateBooking" type = "date"  required = "true" class="input"/>

                <form:label path="timeBooking"><spring:message code="message.timeBooking"/></form:label>
                <form:input path="timeBooking" type = "text" placeholder = "ГГ:ХХ:СС" required = "true" class="input"/>

                <form:button class = "button_login" value="/product/bike/booking/edit"><spring:message code="message.editBooking"/></form:button>
            </fieldset>
        </form:form>
    </div>
    <%@include file="/WEB-INF/pages/include/footer.jsp"%>
</div>
</body>
</html>