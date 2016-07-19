<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title><spring:message code="${name}" /></title>
    <link href="<c:url value="/resources/css/style.css"/>" type="text/css" rel="stylesheet" >
    <link rel="shortcut icon" href="/resources/image/bike-ico.png" type="image/png">
    <script src="<c:url value="/resources/js/jquery-1.11.3.min.js" />" type=""></script>
</head>
<body>
<div id="container">
    <%@include file="/WEB-INF/pages/include/header.jsp"%>
    <%@include file="/WEB-INF/pages/include/main_menu.jsp"%>
    <div id="content">
        <div class="list_bicycle">
            <div class="list_bicycle_block">
                <div class="list_bicycle_name ">
                    ${name}
                </div>
                <div class="list_bicycle_info">
                    <div class="list_bicycle_type">
                        <span class="list_bicycle_span"><spring:message code="message.bikeType" /> - ${type}</span>
                        <span class="list_bicycle_span"><spring:message code="message.bikeClass" /> - ${clazz}</span>
                    </div>
                    <img class="image_bike" alt="${photo}" src = <c:url value="/resources/image/photo_bike/${photo}.jpg"/>>
                    <div class="list_bicycle_text">${info}</div>
                    <div class="list_bicycle_price_day">
                        <spring:message code="message.priceDay" />${priceDay} грн.
                    </div>
                    <div class="list_bicycle_price_hour">
                        <spring:message code="message.priceHour" />${priceHour} грн.
                    </div>
                </div>
                <sec:authorize access="hasRole('ADMIN')">
                    <div class="menu_bicycle">
                        <div class="menu_bicycle_select">
                            <spring:message code="message.changeType" />
                            <select onchange="top.location=this.value" class="select ">
                                <option><spring:message code="message.man" /> </option>
                                <option><spring:message code="message.woman" /> </option>
                            </select>
                        </div>
                        <div class="menu_bicycle_select">
                            <spring:message code="message.changeClass" />
                            <select onchange="top.location=this.value" class="select ">
                                <option><spring:message code="message.simple" /> </option>
                                <option><spring:message code="message.medium" /> </option>
                                <option><spring:message code="message.professional" /> </option>
                            </select>
                        </div>
                        <div class="button_admins">
                            <a href="<c:url value="/product/delete_bike/${id}"/>"><spring:message code="message.delete" /></a>
                        </div>
                    </div>
                </sec:authorize>
            </div>
            <sec:authorize access="!hasAnyRole('USER','MANAGER','ADMIN')">
                <div class="messageAlert">
                    <spring:message code="message.messageForAnonym" />
                </div>
            </sec:authorize>
            <div>
                <sec:authorize access="hasAnyRole('USER','MANAGER')">
                    <div class="button_user">
                        <a href="<c:url value="/booking/${id}"/>"><spring:message code="message.booking" /></a>
                    </div>
                </sec:authorize>
                <sec:authorize access="hasRole('MANAGER')">
                    <div class="button_user">
                        <a href="<c:url value="/rental/${id}"/>"><spring:message code="message.rental" /></a>
                    </div>
                </sec:authorize>
            </div>
        </div>
    </div>
    <%@include file="/WEB-INF/pages/include/footer.jsp"%>
</div>
</body>
</html>
