<div id="header">
  <div id="title">
    <spring:message code="message.header" />
  </div>
    <div id = "local">
      <a href="?language=en"  title="English">
        <img alt="English" src=<c:url value="/resources/image/English.png"/> >
      </a>
      <a href="?language=ru"  title="Русский">
        <img alt="Russian" src=<c:url value="/resources/image/Ukraine.png"/> >
      </a>
    </div>

    <div class="log_in">
      <select onchange="top.location=this.value" class="select ">
        <option >
          <sec:authorize access="!isAuthenticated()">
            <spring:message code="message.login" />
          </sec:authorize>
          <sec:authorize access="isAuthenticated()">
            <sec:authentication property="principal.username"/>
          </sec:authorize>
        </option>
        <sec:authorize access="isAuthenticated()">
          <option value="<c:url value="/j_spring_security_logout" />">
            <spring:message code="message.logout" />
          </option>
        </sec:authorize>
        <sec:authorize access="isAuthenticated()">
          <option value="<c:url value="/personal_account" />">
            <spring:message code="message.personlRoom" />
          </option>
        </sec:authorize>
        <sec:authorize access="!isAuthenticated()">
          <option value="<c:url value="/registration" />">
            <spring:message code="message.registration" />
          </option>
        </sec:authorize>
        <sec:authorize access="!isAuthenticated()">
          <option value="<c:url value="/login" />">
            <spring:message code="message.login" />
          </option>
        </sec:authorize>
      </select>
    </div>
</div>
