<%@ include file="../common/header.jspf" %>
<%@ include file="../common/navbar.jspf" %>

<div class="container mt-5">
    <h1 class="hello-world-text">${companyName}'s cars are</h1>



    <div class="row">
        <table class="table table-light">
            <thead class="thead-light">
            <tr>
                <th scope="col">#</th>
                <th scope="col">Client</th>
                <th scope="col">Car</th>
                <th scope="col">Start Date</th>
                <th scope="col">End Date</th>
                <th scope="col">Price</th>
                <th></th>
            </tr>
            </thead>
            <tbody>
            <c:forEach items="${rentalList}" var="rental">
                <tr>
                    <td>${rental.id}</td>
                    <td>${rental.client}</td>
                    <td>${rental.car}</td>
                    <td>${rental.startDate}</td>
                    <td>${rental.endDate}</td>
                    <td>${rental.totalPrice}</td>
                    <td>
                        <form:form cssClass="form-inline" method="post" action="/rentlist/delete" modelAttribute="deleteRental">
                            <form:hidden path="rentalId" value="${rental.id}" />
                            <form:button type="submit" class="btn btn-danger delete-client-btn">
                                <i class="fa fa-trash" aria-hidden="true"></i>
                            </form:button>
                        </form:form>
                    </td>

                </tr>
            </c:forEach>
            </tbody>
        </table>
    </div>
</div>

<%@ include file="../common/footer.jspf" %>