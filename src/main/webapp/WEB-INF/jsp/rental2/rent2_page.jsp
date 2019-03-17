<%@ include file="../common/header.jspf" %>
<%@ include file="../common/navbar.jspf" %>
<div class="container">
    <div class="py-5 text-center">

        <h2>Rent form</h2>

    </div>
    <form:form id="rental-form" method="post" modelAttribute="rentalForm" action="/rent2/new">
        <%@ include file="rent2_client.jspf" %>


        <%@ include file="rent2_dates.jspf" %>


        <%@ include file="rent2_car.jspf" %>

        <hr>
        <%@ include file="rent2_extras.jspf" %>
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