<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title><spring:message code="message.userBase" /></title>
    <link href="<c:url value="/resources/css/style.css"/>" type="text/css" rel="stylesheet" >
    <link rel="shortcut icon" href="/resources/image/bike-ico.png" type="image/png">
    <script src="<c:url value="/resources/js/jquery-1.11.3.min.js" />" type=""></script>
</head>
<body>
<div id="container">
    <%@include file="/WEB-INF/pages/include/header.jsp"%>
    <%@include file="/WEB-INF/pages/include/main_menu.jsp"%>
    <div id="content">
       <div>
           <div class="button_base">
               <a href="<c:url value="/product/add_bike"/>"><spring:message code="message.addUser" /></a>
           </div> <p class="menu_user_base"><spring:message code="message.userBase" /></p>

       </div>
        <c:if test="${!empty userlist}">
            <div class="table_users">
                <c:forEach items="${userlist}" var="user">
                    <div class="table_users_one">
                        <div class="button_float_right">
                            <div class="button_user_base ">
                                <a href="/edite/${user.id}"><spring:message code="message.edit" /></a>
                            </div>
                            <div class="button_user_base">
                                <a href="/delete/${user.id}"><spring:message code="message.delete" /></a>
                            </div>
                        </div>
                        <table class="user_info_one">
                            <tr>
                                <th><spring:message code="message.email" /></th>
                                <th><spring:message code="message.firstname" /></th>
                                <th><spring:message code="message.lastname" /></th>
                                <th><spring:message code="message.phone" /></th>
                            </tr>
                            <tr>
                                <td>${user.email}</td>
                                <td>${user.firstname}</td>
                                <td>${user.lastname}</td>
                                <td>${user.phone}</td>
                            </tr>
                        </table>
                        <table class="user_info_two">
                            <tr>
                                <th><spring:message code="message.gender" /></th>
                                <th><spring:message code="message.role" /></th>
                                <th><spring:message code="message.state" /></th>
                                <th colspan="2"><spring:message code="message.address" /></th>
                                    <%--<th></th>--%>
                            </tr>
                            <tr>
                                <td class="text_top">${user.gender}</td>
                                <td>${user.role}</td>
                                <td>${user.state}</td>
                                <td>
                                    <ul class="text_right">
                                        <li class="list_li list_padding"><spring:message code="message.country"/></li>
                                        <li class="list_li list_padding"><spring:message code="message.city"/></li>
                                        <li class="list_li list_padding"><spring:message code="message.street"/></li>
                                        <li class="list_li list_padding"><spring:message code="message.house"/></li>
                                        <li class="list_li list_padding"><spring:message code="message.apartment"/></li>
                                    </ul>
                                </td>
                                <td>
                                    <ul class="text_left">
                                        <li class="list_padding"><spring:message code="message.country"/>: ${user.addressId.country}</li>
                                        <li class="list_padding">${user.addressId.city}</li>
                                        <li class="list_padding">${user.addressId.street}</li>
                                        <li class="list_padding">${user.addressId.house}</li>
                                        <li class="list_padding">${user.addressId.apartment}</li>
                                    </ul>
                                </td>

                            </tr>
                        </table>

                    </div>
                </c:forEach>
            </div>
        </c:if>
    </div>
    <%@include file="/WEB-INF/pages/include/footer.jsp"%>
</div>
</body>
</html>
