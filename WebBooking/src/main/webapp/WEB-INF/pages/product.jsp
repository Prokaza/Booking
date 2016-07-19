<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title><spring:message code="message.assortment" /></title>
    <link href="<c:url value="/resources/css/style.css"/>" type="text/css" rel="stylesheet" >
    <link rel="shortcut icon" href="/resources/image/bike-ico.png" type="image/png">
    <script src="<c:url value="/resources/js/jquery-1.11.3.min.js" />" type=""></script>
</head>
<body>
<div id="container">
    <%@include file="/WEB-INF/pages/include/header.jsp"%>
    <%@include file="/WEB-INF/pages/include/main_menu.jsp"%>
    <div id="content">
        <c:if test="${not empty param.alertAdd}">
            <script type="text/javascript">
                alert("<spring:message code="message.successAddBike" />")
            </script>
        </c:if>
        <c:if test="${not empty param.alertDelete}">
            <script type="text/javascript">
                alert("<spring:message code="message.successDeleteBike" />")
            </script>
        </c:if>
        <div class="menu_bicycle">
            <p><spring:message code="message.bicyclePark" /></p>
            <div class="menu_bicycle_select">
                <select onchange="top.location=this.value" class="select ">
                    <option ><spring:message code="message.selectType" /> </option>
                    <option value="<c:url value="/product/type/MAN" />"><spring:message code="message.man" /> </option>
                    <option value="<c:url value="/product/type/WOMAN" />"><spring:message code="message.woman" /> </option>
                </select>
            </div>
            <div class="menu_bicycle_select">
                <select onchange="top.location=this.value" class="select ">
                    <option><spring:message code="message.selectClass" /> </option>
                    <option value="<c:url value="/product/clazz/SIMPLE/" />"><spring:message code="message.simple" /> </option>
                    <option value="<c:url value="/product/clazz/MEDIUM/" />"><spring:message code="message.medium" /> </option>
                    <option value="<c:url value="/product/clazz/

                    PRO/" />"><spring:message code="message.professional" /> </option>
                </select>
            </div>
            <sec:authorize access="hasRole('ADMIN')">
                <div class="menu_bicycle_a">
                    <a href="<c:url value="/product/add_bike"/>"><spring:message code="message.addBike" /></a>
                </div>
            </sec:authorize>
        </div>
        <c:if test="${!empty bikeList}">
            <c:forEach items="${bikeList}" var="bike">
                <div class="list_bicycle">
                    <div class="list_bicycle_block">
                        <div class="list_bicycle_name">
                            <a href="/product/bike/${bike.id}">${bike.bikeName}</a>
                        </div>
                        <div class="list_bicycle_info">
                            <div class="list_bicycle_type">
                                <span class="list_bicycle_span"><spring:message code="message.bikeType" /> - ${bike.type}</span>
                                <span class="list_bicycle_span"><spring:message code="message.bikeClass" /> - ${bike.clazzId.className}</span>
                            </div>
                            <c:forEach items="${photoList}" var="photo">
                                <c:if test="${bike.id eq photo.bikeId.id}">
                                    <img class="image_bike" alt="${photo.photoName}" src = <c:url value="/resources/image/photo_bike/${photo.photoName}.jpg"/> >
                                </c:if>
                            </c:forEach>
                            <div class="list_bicycle_text">
                                    ${bike.info}
                            </div>
                            <div class="list_bicycle_price_day">
                                <spring:message code="message.priceDay" />
                                    ${bike.clazzId.priceDay} грн.
                            </div>
                            <div class="list_bicycle_price_hour">
                                <spring:message code="message.priceHour" />
                                    ${bike.clazzId.priceHour} грн.
                            </div>
                        </div>
                    </div>
                </div>
            </c:forEach>
        </c:if>
    </div>
    <%@include file="/WEB-INF/pages/include/footer.jsp"%>
</div>
</body>
</html>
