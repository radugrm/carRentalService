<%@ include file="../common/header.jspf" %>
<%@ include file="../common/navbar.jspf" %>

<div class="container">
    <div class="py-5 text-center">

        <h2>Rent form</h2>

    </div>

    <div class="row">

        <div class="col-md-8 order-md-1">

            <form class="needs-validation" novalidate="">
                <div class="row">
                    <%@ include file="rent_client.jspf" %>
                </div>

                <div class="mb-3">
                    <label for="firstName">First Name
                        <div id="firstName">${clientByCnp.firstName}</div>
                    </label>
                </div>
                <div class="mb-3">
                    <label for="lastName">Last Name
                        <div id="lastName">${clientByCnp.lastName}</div>
                    </label>
                </div>

                <form>
                    <%@ include file="rent_period.jspf" %>
                </form>

                <div class="row">
                    <%@ include file="rent_car.jspf" %>
                </div>
                <hr>
                <%@include file="extra_options.jspf" %>

                <hr class="mb-4">
                <button class="btn btn-primary btn-lg btn-block" type="submit">Continue to checkout</button>
            </form>
        </div>
    </div>

</div>
<script type="application/javascript">
    function getName() {
        console.log("aaa");
        document.getElementById('submit-rent-form-btn').click();
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