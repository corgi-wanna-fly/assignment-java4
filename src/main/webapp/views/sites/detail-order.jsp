<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<div class="container mt-5">
    <div class="d-flex justify-content-center row">
        <div class="col-md-10">
        <a class="font-size-sm" href="OrderServlet"><svg
						xmlns="http://www.w3.org/2000/svg" width="24" height="24"
						viewBox="0 0 24 24" fill="none" stroke="currentColor"
						stroke-width="2" stroke-linecap="round" stroke-linejoin="round"
						class="feather feather-chevron-left"
						style="width: 1rem; height: 1rem;">
						<polyline points="15 18 9 12 15 6"></polyline></svg>Back to Order</a>
        <c:if test="${not empty message }">
				<div class="alert alert-danger" role="alert">${message }</div>
			</c:if>
            <div class="rounded">
                <div class="table-responsive table-borderless">
                    <table class="table">
                        <thead>
                            <tr>	                              
                                <th>#</th>
                                <th>Product</th>		
                                <th>Price</th>
                                 <th>Quantity</th>
                                <th>Total</th>
                            </tr>
                        </thead>
                        <tbody class="table-body">
                          <c:forEach items="${list }" var="item" varStatus="loop">
                          		 <tr class="cell-1">
	                                <td>#${loop.index + 1}</td>
	                                <td>${item.product.name }</td>
	                                <td>${item.price }</td>
	                                <td>${item.quantity }</td>
	                                <td>${item.price * item.quantity }</td>
	                            </tr>
                          </c:forEach>                       
                        </tbody>
                    </table>
                </div>
            </div>
        </div>
    </div>
</div>