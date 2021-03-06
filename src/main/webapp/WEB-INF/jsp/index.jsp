
<%@ include file="common/header.jspf" %>
<%@ include file="common/navbar.jspf" %>

<h1 class="hello-world-text">Hello, world!</h1>
<c:if test="${pageContext.request.userPrincipal.name != null}">
    <form id="logoutForm" method="POST" action="${contextPath}/logout">
        <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
    </form>

    <h2>Welcome ${pageContext.request.userPrincipal.name} | <a onclick="document.forms['logoutForm'].submit()">Logout</a></h2>
</c:if>

<%@ include file="common/footer.jspf" %>