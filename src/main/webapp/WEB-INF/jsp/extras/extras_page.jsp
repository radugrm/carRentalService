<%@ include file="../common/header.jspf" %>
<%@ include file="../common/navbar.jspf" %>

<div class="container mt-5">
    <h1 class="hello-world-text">${companyName}'s cars are</h1>

    <div class="row">
        <form:form cssClass="form-inline" method="post" modelAttribute="newExtraOptionForm" action="/extras/new">

            <div class="form-group mb-2 mx-sm-3">
                <form:label path="extraOptionCategoryEnum" for="extra-option-category" cssClass="sr-only">Extra Option Category</form:label>
                <form:select path="extraOptionCategoryEnum" id="extra-option-category" items="${extraOptionsCategory}"/>
            </div>
            <form:button type="submit" class="btn btn-primary mb-2">Submit</form:button>
        </form:form>
    </div>

    <div class="row">
        <%@include file="extras_table.jspf" %>
    </div>
</div>

<%@ include file="../common/footer.jspf" %>