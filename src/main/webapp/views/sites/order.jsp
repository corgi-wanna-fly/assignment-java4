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
										  <c:if test="${item.status != 'Giao thanh cong' }">
										  		<a style="color: white;" order-id="${item.idOrders }" onclick="confirmCancelOrder(this.getAttribute('order-id'))"" class="btn btn-danger">Cancel</a>
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

<!-- Modal -->
<div class="modal fade" id="cancelOrder" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true">
  <div class="modal-dialog">
    <div class="modal-content">
      <div class="modal-header">
        <h5 class="modal-title" id="exampleModalLabel">Confirmation</h5>
        <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
      </div>
      <div class="modal-body">
        Are you sure to cancel this order?
      </div>
      <div class="modal-footer">
       <a id="yesOption" class="btn btn-primary">Yes</a>
        <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">No</button>
      </div>
    </div>
  </div>
</div>
<script>
	function confirmCancelOrder(id) {
		$('#yesOption').attr('href', '/java-assignment/CancelOrderServlet?id=' + id)
		$('#cancelOrder').modal('show');
	}
</script>