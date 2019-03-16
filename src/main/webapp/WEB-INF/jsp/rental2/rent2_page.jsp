<%@ include file="../common/header.jspf" %>
<%@ include file="../common/navbar.jspf" %>
<div class="container">
    <div class="py-5 text-center">

        <h2>Rent form</h2>

    </div>
    <div class="row">
        <form:form cssClass="form-inline" method="post" modelAttribute="findClient" action="/rent2/cnp">
            <div class="form-group mb-2">
                <form:label path="cnp" for="cnp" cssClass="sr-only">Make</form:label>
                <form:input path="cnp" id="cnp" type="text" value="${client.cnp}" placeholder="CNP" onblur="getName()"/>
            </div>
            <form:button type="submit" id = 'submit-client-form-btn' class="d-none">Submit</form:button>
        </form:form>
    </div>
    <div class="row">
        <label for="firstName">First Name
            <div id="firstName">${client.firstName}</div>
        </label>
    </div>
    <div class="row">
        <label for="lastName">Last Name
            <div id="lastName">${client.lastName}</div>
        </label>
    </div>

</div>


<script type="application/javascript">
        function getName() {
            console.log("aaa");
            document.getElementById('submit-client-form-btn').click();
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