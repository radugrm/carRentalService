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
                    <div class="col-md-6 mb-3">
                        <label for="cnp">CNP</label>
                        <form:form id="cnp-form" cssClass="form-inline" method="get" modelAttribute="clientByCnp"
                                   action="/rent">
                            <form:input path="cnp" type="text" class="form-control" placeholder=""
                                        value="${clientByCnp.cnp}" required="" id="CNP" onblur="getName()"/>
                            <form:button type="submit" id="submit-rent-form-btn" class="d-none"/>
                        </form:form>
                        <div class="invalid-feedback">
                            Valid first name is required.
                        </div>
                    </div>
                    <div class="col-md-6 mb-3">
                        <div class="invalid-feedback">
                            Valid last name is required.
                        </div>
                    </div>
                </div>

                <div class="mb-3">
                    <label for="firstName">First Name
                        <div>${clientByCnp.firstName}</div>
                    </label>
                </div>
                <div class="mb-3">
                    <label for="lastName">Last Name
                        <div>${clientByCnp.lastName}</div>
                    </label>
                </div>

                <form>
                    <label for="start-date">Start Date</label>
                    <div class="form-row align-items-center">
                        <div class="col-sm-3 my-1">
                            <label class="sr-only" for="inlineFormInputGroupUsername">Username</label>
                            <div class="input-group">
                                <input type="text" class="form-control" id="inlineFormInputGroupUsername"
                                       placeholder="Day">
                            </div>
                        </div>
                        <div class="col-sm-3 my-1">
                            <label class="sr-only" for="inlineFormInputGroupUsername">Username</label>
                            <div class="input-group">
                                <input type="text" class="form-control" id="inlineFormInputGroupUsername"
                                       placeholder="Month">
                            </div>
                        </div>
                        <div class="col-sm-3 my-1">
                            <label class="sr-only" for="inlineFormInputGroupUsername">Username</label>
                            <div class="input-group">
                                <input type="text" class="form-control" id="inlineFormInputGroupUsername"
                                       placeholder="Year">
                            </div>
                        </div>
                    </div>
                    <label for="end-date">End Date</label>
                    <div class="form-row align-items-center">
                        <div class="col-sm-3 my-1">
                            <label class="sr-only" for="inlineFormInputGroupUsername">Username</label>
                            <div class="input-group">
                                <input type="text" class="form-control" id="inlineFormInputGroupUsername"
                                       placeholder="Day">
                            </div>
                        </div>
                        <div class="col-sm-3 my-1">
                            <label class="sr-only" for="inlineFormInputGroupUsername">Username</label>
                            <div class="input-group">
                                <input type="text" class="form-control" id="inlineFormInputGroupUsername"
                                       placeholder="Month">
                            </div>
                        </div>
                        <div class="col-sm-3 my-1">
                            <label class="sr-only" for="inlineFormInputGroupUsername">Username</label>
                            <div class="input-group">
                                <input type="text" class="form-control" id="inlineFormInputGroupUsername"
                                       placeholder="Year">
                            </div>
                        </div>
                    </div>
                </form>
                <div class="row">

                    <div class="col-md-5 mb-3">
                        <form:form method="get" modelAttribute="rentalForm" action="/rent">
                            <form:label path="carCategory" for="car-category">Car Category</form:label>
                            <form:select class="custom-select d-block w-100" path="carCategory" id="car-category"
                                         items="${carCategoryOptions}" onblur="getCar()"/>
                            <form:button type="submit" id="submit-car-form-btn" class="d-none"/>
                        </form:form>
                    </div>
                    <div class="col-md-4 mb-3">
                        <form:form method="get" modelAttribute="rentalForm" action="/rent">
                            <form:label path="carsByCategory" for="car-model">Car </form:label>
                            <form:select class="custom-select d-block w-100" path="carsByCategory" id="car-model">
                            <c:forEach items="${rentalForm.carsByCategory}" var="car">
                                <form:option value="">${car.make} ${car.model}</form:option>
                            </c:forEach>
                            </form:select>
                        </form:form>

                        <select class="custom-select mr-sm-2" id="inlineFormCustomSelect">
                            <option selected>Choose...</option>
                            <option value="1">One</option>
                            <option value="2">Two</option>
                            <option value="3">Three</option>
                        </select>

                    </div>

                </div>
                <hr>
                <div class="custom-control custom-checkbox">
                    <input type="checkbox" class="custom-control-input" id="same-address">
                    <label class="custom-control-label" for="same-address">Car Insurance</label>
                </div>
                <div class="custom-control custom-checkbox">
                    <input type="checkbox" class="custom-control-input" id="save-info">
                    <label class="custom-control-label" for="save-info">Additional Driver</label>
                </div>
                <div class="custom-control custom-checkbox">
                    <input type="checkbox" class="custom-control-input" id="save-info">
                    <label class="custom-control-label" for="save-info">Navigation</label>
                </div>
                <div class="custom-control custom-checkbox">
                    <input type="checkbox" class="custom-control-input" id="save-info">
                    <label class="custom-control-label" for="save-info">Toddler Seat</label>
                </div>


                <hr class="mb-4">
                <button class="btn btn-primary btn-lg btn-block" type="submit">Continue to checkout</button>
            </form>
        </div>
    </div>

    <footer class="my-5 pt-5 text-muted text-center text-small">
        <p class="mb-1">© 2017-2019 Company Name</p>
        <ul class="list-inline">
            <li class="list-inline-item"><a href="#">Privacy</a></li>
            <li class="list-inline-item"><a href="#">Terms</a></li>
            <li class="list-inline-item"><a href="#">Support</a></li>
        </ul>
    </footer>
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