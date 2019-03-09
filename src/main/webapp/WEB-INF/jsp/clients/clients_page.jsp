
<%@ include file="../common/header.jspf" %>
<%@ include file="../common/navbar.jspf" %>

<div class="container mt-5">
    <h1 class="hello-world-text">${companyName}'s clients are</h1>

    <div class="row">
        <form:form cssClass="form-inline" method="post" modelAttribute="newClientForm" action="/clients/new">
            <div class="form-group mb-2">
                <form:label path="firstName" for="first-name" cssClass="sr-only">First Name</form:label>
                <form:input path="firstName" id="first-name" type="text" placeholder="First Name"/>
            </div>
            <div class="form-group mb-2 mx-sm-3">
                <form:label path="lastName" for="last-name" cssClass="sr-only">Last Name</form:label>
                <form:input path="lastName" id="last-name" type="text" placeholder="Last Name"/>
            </div>
            <div class="form-group mb-2 mx-sm-3">
                <form:label path="cnp" for="cnp" cssClass="sr-only">CNP</form:label>
                <form:input path="cnp" id="cnp" type="text" placeholder="CNP"/>
            </div>
            <div class="form-group mb-2 mx-sm-3">
                <form:label path="phoneNumber" for="phone-number" cssClass="sr-only">Phone Number</form:label>
                <form:input path="phoneNumber" id="phone-number" type="text" placeholder="Phone Number"/>
            </div>
            <form:button type="submit" class="btn btn-primary mb-2">Submit</form:button>
        </form:form>
    </div>

    <div class="row">
        <%@include file="clients_table.jspf" %>
    </div>
</div>

<%@ include file="../common/footer.jspf" %>