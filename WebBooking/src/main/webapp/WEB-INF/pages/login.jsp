<%@ page contentType="text/html; charset=UTF-8" language="java" %>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
  <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
  <title><spring:message code="message.login" /></title>
  <link href="<c:url value="/resources/css/style.css"/>" type="text/css" rel="stylesheet" >
  <link rel="shortcut icon" href="/resources/image/bike-ico.png" type="image/png">
  <script src="<c:url value="/resources/js/jquery-1.11.3.min.js" />"></script>
</head>
<body>
<div id="container">
  <%@include file="/WEB-INF/pages/include/header.jsp"%>
  <%@include file="/WEB-INF/pages/include/main_menu.jsp"%>
  <div id="content">
    <c:if test="${not empty param.error}">
      <p class="error_login">
        <spring:message code="error.login" />
      </p>
    </c:if>
    <form class="login" method="POST" action="<c:url value="/j_spring_security_check" />">
      <fieldset class="fieldset">
        <legend><spring:message code="message.login" /></legend>
        <input type="text" name="j_username"  class="input" placeholder = <spring:message code="message.login"/> required autofocus/>
        <input type="password" name="j_password" class="input" placeholder = <spring:message code="message.password"/> required autofocus/>
        <input type="checkbox" name="_spring_security_remember_me" title="<spring:message code="message.remember" />"/>
        <label ><spring:message code="message.remember" /></label>
        <button type="submit" class="button_login"><spring:message code="message.enter"/></button>
      </fieldset>
    </form>
  </div>
  <%@include file="/WEB-INF/pages/include/footer.jsp"%>
</div>
</body>
</html>