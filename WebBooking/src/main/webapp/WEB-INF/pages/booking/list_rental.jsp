<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title><spring:message code="message.booking" /></title>
    <link href="<c:url value="/resources/css/style.css"/>" type="text/css" rel="stylesheet" >
    <link rel="shortcut icon" href="/resources/image/bike-ico.png" type="image/png">
    <script src="<c:url value="/resources/js/jquery-1.11.3.min.js" />" type=""></script>
</head>
<body>
<div id="container">
    <%@include file="/WEB-INF/pages/include/header.jsp"%>
    <%@include file="/WEB-INF/pages/include/main_menu.jsp"%>
    <div id="content">
        <div class="booking_list_name">
            <sec:authorize access="hasRole('MANAGER')">
                <div class="booking_list_name">
                    <spring:message code="message.rentalList" />
                </div>
            </sec:authorize>
        </div>
        <div>
            <c:if test="${!empty rentalList}">
                <c:forEach items="${rentalList}" var="rental">
                    <div class="booking_list">
                        <div class="button_float_right">
                            <div >
                                <a class="button_manager" href="<c:url value="/rental/cancel/${rental.id}"/>">
                                    <p><spring:message code="message.cancel" /></p>
                                </a>
                            </div>
                            <div>
                                <a class="button_manager " href="<c:url value="/booking/change_booking"/>"><p><spring:message code="message.change" /></p></a>
                            </div>
                        </div>
                        <div class="booking_list_point">
                            <div class=" button_float_left"><spring:message code="message.username"/>: ${rental.userId.email}</div><br>
                            <div class=""><spring:message code="message.bikeName"/>:
                                <a href="<c:url value="/product/bike/${rental.bikeId.id}"/>">${rental.bikeId.bikeName}</a>
                            </div>
                        </div>
                        <div class="booking_list_point ">
                                <%--<div class=""><spring:message code="message.timeCreate"/>: ${booking.createTime}</div>--%>
                            <div class=""><spring:message code="message.dateBooking"/>: ${rental.dateBooking}</div>
                            <div class=""><spring:message code="message.timeBooking"/>: ${rental.timeBooking}</div>
                        </div>
                    </div>
                </c:forEach>
            </c:if>
        </div>
    </div>
    <%@include file="/WEB-INF/pages/include/footer.jsp"%>
</div>
</body>
</html>
