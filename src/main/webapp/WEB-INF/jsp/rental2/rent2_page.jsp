<%@ include file="../common/header.jspf" %>
<%@ include file="../common/navbar.jspf" %>
<div class="container">
    <div class="py-5 text-center">

        <h2>Rent form</h2>

    </div>
    <form:form method="post" modelAttribute="rentalForm" action="/rent2/cnp">
        <div class="row">

            <div class="col-md-5 mb-3">
                <form:label path="client.cnp" for="cnp" cssClass="sr-only">Make</form:label>
                <form:input path="client.cnp" cssClass="form-control" id="cnp" type="text"
                            value="${rentalForm.client.cnp}"
                            placeholder="CNP" onblur="getName()"/>
            </div>
            <form:button type="submit" id='submit-client-form-btn' class="d-none">Submit</form:button>

        </div>
        <div class="row">
            <div class="col-md-5 mb-3">
                <label for="firstName">First Name
                    <div id="firstName">${rentalForm.client.firstName}</div>
                </label>
            </div>
        </div>
        <div class="row">
            <div class="col-md-5 mb-3">
                <label for="lastName">Last Name
                    <div id="lastName">${rentalForm.client.lastName}</div>
                </label>
            </div>
        </div>

        <%--<div class="row">--%>
        <%--<form:form cssClass="form-inline" method="post" action="/rent2/new" modelAttribute="client">--%>
        <%--<form:hidden path="cnp"/>--%>
        <%--<form:button type="submit" class="btn btn-primary btn-lg btn-block">--%>
        <%--<i class="fa fa-trash" aria-hidden="true"></i>--%>
        <%--</form:button>--%>
        <%--</form:form>--%>
        <%--</div>--%>


        <div class="row">
            <div class="col-md-5 mb-3">
                <form:label path="startDate" for="start-date">Start Date</form:label>
                <form:input path="startDate" id="start-date" cssClass="form-control" type="date"
                            value="${rentalForm.startDate}" pattern="dd-MM-yyyy"/>
            </div>
            <div class="col-md-5 mb-3">
                <form:label path="endDate" for="end-date">Start Date</form:label>
                <form:input path="endDate" id="end-date" cssClass="form-control" type="date"
                            value="${rentalForm.endDate}" pattern="dd-MM-yyyy"/>
            </div>
        </div>


        <div class="row">
            <div class="col-md-5 mb-3">
                <form:label path="carCategory" for="car-category">Car Category</form:label>
                <form:select class="custom-select d-block w-100" path="carCategory" id="car-category"
                             selected="true" onchange="getCar()">
                    <c:forEach items="${rentalForm.carCategoryOptions}" var="category">
                        <c:choose>
                            <c:when test="${rentalForm.carCategory==category}">
                                <form:option selected="true" value="${rentalForm.carCategory}">${category}</form:option>
                            </c:when>
                            <c:otherwise>
                                <form:option value="${category}">${category}</form:option>
                            </c:otherwise></c:choose>
                    </c:forEach>
                </form:select>
                <form:button type="submit" id="submit-car-form-btn" class="d-none"/>
            </div>

            <div class="col-md-5 mb-3">
                <form:label path="carsByCategory" for="car-model">Car </form:label>
                <form:select class="custom-select d-block w-100" path="carsByCategory" id="car-model"
                             multiple="false">
                    <%--<form:option value="-">- Select -</form:option>--%>
                    <c:forEach items="${rentalForm.carsByCategory}" var="car">
                        <form:option value="">${car.make} ${car.model}</form:option>
                    </c:forEach>
                </form:select>
            </div>
        </div>
    </form:form>

</div>


<script type="application/javascript">
    function getName() {
        console.log("aaa");
        document.getElementById('submit-client-form-btn').click();
    }
    function getCar() {
        console.log("bbb");
        document.getElementById('submit-car-form-btn').click();
    }
</script>
<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js"
        integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo"
        crossorigin="anonymous"></script>
<script>window.jQuery || document.write('<script src="/docs/4.3/assets/js/vendor/jquery-slim.min.js"><\/script>')</script>
<script src="/docs/4.3/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-xrRywqdh3PHs8keKZN+8zzc5TX0GRTLCcmivcbNJWm2rs5C8PRhcEn3czEjhAO9o"
        crossorigin="anonymous"></script>
<script src="form-validation.js"></script>

</body></html>