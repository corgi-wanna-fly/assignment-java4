<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<div class="container mt-5">
    <div class="d-flex justify-content-center row">
        <div class="col-md-10">
        <c:if test="${not empty message }">
				<div class="alert alert-danger" role="alert">${message }</div>
			</c:if>
            <div class="rounded">
                <div class="table-responsive table-borderless">
                    <table class="table">
                        <thead>
                            <tr>	                              
                                <th>Order #</th>
                                <th>Customer name</th>		
                                <th>Address</th>
                                 <th>Phone</th>
                                <th>Total</th>
                                <th>Created</th>
                                <th>Status</th>
                                <th></th>
                            </tr>
                        </thead>
                        <tbody class="table-body">
                          <c:forEach items="${listOrders }" var="item">
                          		 <tr class="cell-1">
	                                <td>#${item.idOrders }</td>
	                                <td>${item.customer.fullname }</td>
	                                <td>${item.address }</td>
	                                <td>${item.phone }</td>
	                                <td>${item.amount }</td>
	                                <td>${item.created }</td>
	                                <td><span class="badge badge-success">${item.status }</span></td>
	                                <td>
										 <a href="DetailOrderServlet?id=${item.idOrders }" class="btn btn-primary">Detail</a>
										  <c:if test="${item.status != 'Done' }">
										  		<a href="CancelOrderServlet?id=${item.idOrders }" class="btn btn-danger" disabled>Cancel</a>
										  </c:if>
									</td>
	                            </tr>
                          </c:forEach>
                           
                        </tbody>
                    </table>
                </div>
            </div>
        </div>
    </div>
</div>