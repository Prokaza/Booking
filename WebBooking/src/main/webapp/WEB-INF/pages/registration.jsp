<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
  <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
  <title><spring:message code="message.registration" /></title>
  <link href="<c:url value="/resources/css/style.css"/>" type="text/css" rel="stylesheet" >
  <link rel="shortcut icon" href="/resources/image/bike-ico.png" type="image/png">
  <script src="<c:url value="/resources/js/jquery-1.11.3.min.js" />"></script>
</head>
<body>
<div id="container">
  <%@include file="/WEB-INF/pages/include/header.jsp"%>
  <%@include file="/WEB-INF/pages/include/main_menu.jsp"%>
  <div id="content">
    <form:form method="POST" modelAttribute="user" cssClass="form">
      <fieldset class="fieldset">
        <legend><spring:message code="message.registration" /></legend>
        <fieldset class="fieldset_info">
          <legend><spring:message code="message.personalInfo" /></legend>

          <form:label path="email"><spring:message code="message.email"/></form:label>
          <form:input path="email" required = "true" cssClass="input"/>
          <span class="error"><form:errors path="email"/></span>

          <form:label path="password"><spring:message code="message.password"/></form:label>
          <form:password path="password" required = "true" cssClass="input"/>
          <span class="error"><form:errors path="password"/></span>

          <form:label path="firstname"><spring:message code="message.firstname"/></form:label>
          <form:input path="firstname" required = "true" cssClass="input"/>
          <span class="error"><form:errors path="firstname"/></span>

          <form:label path="lastname"><spring:message code="message.lastname"/></form:label>
          <form:input path="lastname" required = "true" cssClass="input"/>
          <span class="error"><form:errors path="lastname"/></span>

          <form:label path="phone"><spring:message code="message.phone"/></form:label>
          <form:input path="phone" required = "true" placeholder = "+38(012)345-67-89" cssClass="input"/>
          <span class="error"><form:errors path="phone"/></span>

          <form:label path="birthday"><spring:message code="message.birthday"/></form:label>
          <form:input path="birthday" type = "date"  required = "true" placeholder = "YYYY-MM-DD" cssClass="input"/>
          <span class="error"><form:errors path="birthday"/></span>

          <form:label path="gender"><spring:message code="message.gender_form"/></form:label><br>
          <form:select path="gender" size="1" cssClass="select">
            <form:option value="MALE" path="gender"><spring:message code="message.male"/></form:option>
            <form:option value="FEMALE" path="gender"><spring:message code="message.female"/></form:option>
          </form:select>
        </fieldset>

        <fieldset class="fieldset_address">
          <legend><spring:message code="message.address" /></legend>
          <form:label path="addressId.country"><spring:message code="message.country"/></form:label>
          <form:input path="addressId.country" required = "true" cssClass="input"/>
          <span class="error"><form:errors path="addressId.country"/></span>

          <form:label path="addressId.city"><spring:message code="message.city"/></form:label>
          <form:input path="addressId.city" required = "true" cssClass="input"/>
          <span class="error"><form:errors path="addressId.city"/></span>

          <form:label path="addressId.street"><spring:message code="message.street"/></form:label>
          <form:input path="addressId.street" required = "true" cssClass="input"/>
          <span class="error"><form:errors path="addressId.street"/></span>

          <form:label path="addressId.house"><spring:message code="message.house"/></form:label>
          <form:input path="addressId.house" required = "true" cssClass="input"/>
          <span class="error"><form:errors path="addressId.house"/></span>

          <form:label path="addressId.apartment"><spring:message code="message.apartment"/></form:label>
          <form:input path="addressId.apartment" cssClass="input"/>
          <span class="error"><form:errors path="addressId.apartment"/></span>
        </fieldset>
        <form:button name="" value="/registration" class = "button_reg"><spring:message code="message.registration"/></form:button>
      </fieldset>
    </form:form>
  </div>
  <%@include file="/WEB-INF/pages/include/footer.jsp"%>
</div>
</body>
</html>