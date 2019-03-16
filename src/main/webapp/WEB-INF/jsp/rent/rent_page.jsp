<%@ include file="../common/header.jspf" %>
<%@ include file="../common/navbar.jspf" %>

<div class="container">
    <div class="py-5 text-center">

        <h2>Rent form</h2>

    </div>

    <div class="row">

        <div class="col-md-8 order-md-1">
            <form class="needs-validation" novalidate="">
                <form:form cssClass="form-inline" method="get" modelAttribute="rentalForm" action="/rent">

                    <%@ include file="rent_client.jspf" %>


                    <div class="row">
                        <%@ include file="rent_period.jspf" %>
                    </div>

                    <div class="row">
                        <%@ include file="rent_car.jspf" %>
                    </div>
                    <hr>

                    <%@include file="extra_options.jspf" %>
                </form:form>
                <hr class="mb-4">
                <form:form cssClass="form-inline" method="post" action="/rent/new" modelAttribute="rentalForm">
                    <form:hidden path="startDate"/>
                    <form:hidden path="endDate"/>
                    <form:hidden path="carMake"/>
                    <form:hidden path="carModel"/>
                    <form:hidden path="insurance"/>
                    <form:hidden path="infantSeat"/>
                    <form:hidden path="toddlerSeat"/>
                    <form:hidden path="navigation"/>
                    <form:hidden path="additionalDrivers"/>
                    <form:hidden path="extraOptions" value="${car.id}"/>
                    <form:button type="submit" class="btn btn-primary btn-lg btn-block">Continue to checkout
                        <i class="fa fa-trash" aria-hidden="true"></i>
                    </form:button>
                </form:form>
            </form>
        </div>
    </div>

</div>
<script type="application/javascript">
    function refreshForm() {
        console.log("aaa");
        var form = document.getElementById('rental-form');
        form.action='/refresh';
        form.submit();
    }


    function getCar() {
        console.log("bbb");
        document.getElementById('submit-car-form-btn').click();
    }

    function toggleDisable(checkbox) {
        var toggle = document.getElementById("number-of-drivers");
        if (checkbox.checked) {
            toggle.disabled = false;
        } else {
            toggle.disabled = true;
        }

    }

    window.onload = function () {
        toggleDisable(document.getElementById('additional-driver'));
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