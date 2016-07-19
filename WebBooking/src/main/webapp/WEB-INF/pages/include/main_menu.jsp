<div id="main_menu">
    <div><a href="<c:url value="/main" />"><spring:message code="message.main" /></a></div>
    <div><a href="<c:url value="/product"/>"><spring:message code="message.assortment" /></a></div>
    <sec:authorize access="hasAnyRole('MANAGER','USER')">
        <sec:authorize access="hasRole('USER')">
            <div><a href="<c:url value="/booking/list_for_user"/>"><spring:message code="message.booking" /></a></div>
        </sec:authorize>
        <sec:authorize access="hasRole('MANAGER')">
            <div><a href="<c:url value="/booking/list"/>"><spring:message code="message.booking" /></a></div>
        </sec:authorize>
    </sec:authorize>
    <sec:authorize access="hasRole('MANAGER')">
        <div><a href="<c:url value="/rental/list"/>"><spring:message code="message.rental" /></a></div>
    </sec:authorize>
    <sec:authorize access="hasRole('ADMIN')">
        <div><a href="<c:url value="/user_base"/>"><spring:message code="message.userBase" /></a></div>
    </sec:authorize>
    <div><a href="<c:url value="/contact"/>"><spring:message code="message.contacts" /></a></div>
</div>