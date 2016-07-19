<%@ page contentType="text/html; charset=UTF-8" language="java" %>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
  <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
  <title><spring:message code="message.error" /></title>
  <link rel="shortcut icon" href="/resources/image/bike-ico.png" type="image/png">
  <link href="<c:url value="/resources/css/style.css"/>" type="text/css" rel="stylesheet" >
</head>
<body id="error_403">
<div>
  <spring:message code="error.403_first"/> ${message}<spring:message code="error.403_second"/><br>
  <a href="/" >//<spring:message code="message.main" />//</a>
</div>
</body>
</html>