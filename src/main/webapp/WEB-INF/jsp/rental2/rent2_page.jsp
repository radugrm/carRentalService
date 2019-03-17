<%@ include file="../common/header.jspf" %>
<%@ include file="../common/navbar.jspf" %>
<div class="container">
    <div class="py-5 text-center">

        <h2>Rent form</h2>

    </div>
    <form:form id="rental-form" method="post" modelAttribute="rentalForm" action="/rent2/new">
        <div class="row">

            <div class="col-md-5 mb-3">
                <form:label path="client.cnp" for="cnp">CNP Client</form:label>
                <form:input path="client.cnp" cssClass="form-control" id="cnp" type="text"
                            value="${rentalForm.client.cnp}"
                            placeholder="CNP" onblur="refreshForm()"/>
            </div>

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
                             selected="true" items="${rentalForm.carCategoryOptions}" onchange="refreshForm()"/>
            </div>

            <div class="col-md-5 mb-3">
                <form:label path="carsByCategory" for="car-model">Car </form:label>
                <form:select class="custom-select d-block w-100" path="car" id="car-model"
                             multiple="false">
                    <c:forEach items="${rentalForm.carsByCategory}" var="car">
                        <form:option value="${car}">${car.make} ${car.model}</form:option>
                    </c:forEach>
                </form:select>
            </div>
        </div>

        <hr>
        <div class="row">
            <div class="col-md-5 mb-3">
                <label for="extra-options">Extra Options</label>
            </div>
        </div>
        <div class="row">
            <div class="col-md-5 mb-3" id="extra-options">
                <div class="custom-control custom-checkbox">
                    <form:checkbox path="insurance" class="custom-control-input" id="car-insurance"/>
                    <form:label path="insurance" class="custom-control-label"
                                for="car-insurance">Car Insurance</form:label>
                </div>
                <div class="custom-control custom-checkbox">
                    <form:checkbox path="navigation" class="custom-control-input" id="navigation"/>
                    <form:label path="navigation" class="custom-control-label" for="navigation">Navigation</form:label>
                </div>
                <div class="custom-control custom-checkbox">
                    <form:checkbox path="toddlerSeat" class="custom-control-input" id="toddler_seat"/>
                    <form:label path="toddlerSeat" class="custom-control-label"
                                for="toddler_seat">Toddler Seat</form:label>
                </div>
                <div class="custom-control custom-checkbox">
                    <form:checkbox path="infantSeat" class="custom-control-input" id="infant_seat"/>
                    <form:label path="infantSeat" class="custom-control-label"
                                for="infant_seat">Infant Seat</form:label>
                </div>

                <div class="custom-control custom-checkbox">
                    <form:checkbox path="additionalDriver" class="custom-control-input" id="additional-driver"
                                   onchange="toggleDisable(this)"/>
                    <form:label path="additionalDriver" class="custom-control-label"
                                for="additional-driver">Additional Driver</form:label>
                </div>

                <div class="col-md-3 mb-1">
                    <form:input path="additionalDrivers" type="text" id="disabledTextInput" class="form-control"
                                placeholder="0" disabled="true"/>
                </div>

            </div>
        </div>
        <div class="row">
            <form:form cssClass="form-inline" method="post" action="/rent2/new" modelAttribute="rentalForm">
                <form:button type="submit" class="btn btn-primary btn-lg btn-block">Rent
                </form:button>
            </form:form>
        </div>
    </form:form>


</div>


<script type="application/javascript">
    function refreshForm() {
        console.log("aaa");
        var form = document.getElementById('rental-form');
        form.action = '/rent2/refresh';
        form.submit();
    }


    function toggleDisable(checkbox) {
        var toggle = document.getElementById("disabledTextInput");
        if (checkbox.checked) {
            toggle.disabled = false;
        } else {
            toggle.value = 0;
            toggle.disabled = true;
        }
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