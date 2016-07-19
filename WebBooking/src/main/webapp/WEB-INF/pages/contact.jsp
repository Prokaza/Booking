</html><%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<!DOCTYPE html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title><spring:message code="message.contacts" /></title>
	<link href="<c:url value="/resources/css/style.css"/>" type="text/css" rel="stylesheet" >
	<link rel="shortcut icon" href="/resources/image/bike-ico.png" type="image/png">
	<script src="<c:url value="/resources/js/jquery-1.11.3.min.js" />" type=""></script>
</head>
<body>
<div id="container">
	<%@include file="/WEB-INF/pages/include/header.jsp"%>
	<%@include file="/WEB-INF/pages/include/main_menu.jsp"%>
	<div id="content">
		<p id="center_text">Адресс: г. Харьков, ул. Уборевича, д. 28/64</p>
		<p id="center_text">Email: sfirate@mail.ru</p>
		<p id="center_text">тел: +38-093-866-31-93</p>
		<p id="center_text">С уважением,</p>
		<p id="center_text">Проказа Александр</p>
	</div>
	<%@include file="/WEB-INF/pages/include/footer.jsp"%>
</div>
</body>
</html>


<%--<a href="<c:url value="/logout" />">
	<spring:message code="message.logout" />
</a>

<h2><spring:message code="message.title" /></h2>

<form:form method="post" action="add" commandName="contact">

	<table>
		<tr>
			<td><form:label path="username">
				<spring:message code="message.username" />
			</form:label></td>
			<td><form:input path="username" /></td>
		</tr>
		<tr>
			<td><form:label path="firstname">
				<spring:message code="message.firstname" />
			</form:label></td>
			<td><form:input path="firstname" /></td>
		</tr>
		<tr>
			<td><form:label path="lastname">
				<spring:message code="message.lastname" />
			</form:label></td>
			<td><form:input path="lastname" /></td>
		</tr>
		<tr>
			<td>
				<form:label path="email">
					<spring:message code="message.email" />
				</form:label>
			</td>
			<td>
				<form:input path="email" />
			</td>
		</tr>
		<tr>
			<td><form:label path="phone">
				<spring:message code="message.phone" />
			</form:label></td>
			<td><form:input path="phone" /></td>
		</tr>

		<tr>
			<td><form:label path="role">
				<spring:message code="message.role" />
			</form:label></td>
			<td>
				<form:select path="role" size="1">
					<form:options></form:options>
				</form:select>
			</td>
		</tr>
		<tr>
			<td><form:label path="addressId">
				<spring:message code="message.address" />
			</form:label></td>
		<tr>
			<td><spring:message code="message.city"/><form:input path="addressId.city" /></td>
		</tr>
		<tr>
			<td><spring:message code="message.street"/><form:input path="addressId.street" /></td>
		</tr>
		<tr>
			<td><spring:message code="message.house"/><form:input path="addressId.house" /></td>
		</tr>
		</tr>

		<tr>
			<td colspan="2"><input type="submit"
				value="<spring:message code="message.addcontact"/>" /></td>
		</tr>
	</table>
</form:form>

<h3><spring:message code="message.contacts" /></h3>
<c:if test="${!empty contactList}">
	<table class="data">
		<tr>
			<th><spring:message code="message.username" /></th>
			<th><spring:message code="message.lastname" /></th>
			<th><spring:message code="message.firstname" /></th>
			<th><spring:message code="message.email" /></th>
			<th><spring:message code="message.phone" /></th>
			<th><spring:message code="message.role" /></th>
			<th><spring:message code="message.time" /></th>
			<th><spring:message code="message.address" /></th>
			<th>&nbsp;</th>
		</tr>
		<c:forEach items="${contactList}" var="contact">
			<tr>
				<td>${contact.username}</td>
				<td>${contact.lastname}</td>
				<td>${contact.firstname}</td>
				<td>${contact.email}</td>
				<td>${contact.phone}</td>
				<td>${contact.role}</td>
				<td>${contact.createDate}</td>
				<td>${contact.addressId.city}, ${contact.addressId.street}, ${contact.addressId.house}</td>
				<td><a href="delete/${contact.id}"><spring:message code="label.delete" /></a></td>
			</tr>
		</c:forEach>
	</table>
</c:if>--%>
