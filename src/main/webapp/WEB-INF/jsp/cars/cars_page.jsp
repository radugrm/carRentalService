<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ include file="../common/header.jspf" %>
<%@ include file="../common/navbar.jspf" %>

<div class="container mt-5">
    <h1 class="hello-world-text">${companyName}'s cars are</h1>

    <div class="row">
        <form:form cssClass="form-inline" method="post" modelAttribute="newCarForm" action="/cars/new">
            <div class="form-group mb-2">
                <form:label path="make" for="make" cssClass="sr-only">Make</form:label>
                <form:input path="make" id="make" type="text" placeholder="Make"/>
            </div>
            <div class="form-group mb-2 mx-sm-3">
                <form:label path="model" for="model" cssClass="sr-only">Model</form:label>
                <form:input path="model" id="model" type="text" placeholder="Model"/>
            </div>
            <div class="form-group mb-2 mx-sm-3">
                <form:label path="numberPlate" for="number-plate" cssClass="sr-only">Number Plate</form:label>
                <form:input path="numberPlate" id="number-plate" type="text" placeholder="Number Plate"/>
            </div>
            <div class="form-group mb-2 mx-sm-3">
                <form:label path="carCategory" for="car-category" cssClass="sr-only">Car Category</form:label>
                <form:select path="carCategory" id="car-category" items="${carCategoryOptions}"/>
            </div>
            <form:button type="submit" class="btn btn-primary mb-2">Submit</form:button>
        </form:form>
    </div>

    <div class="row">
        <%@include file="cars_table.jspf" %>
    </div>
</div>

<%@ include file="../common/footer.jspf" %>