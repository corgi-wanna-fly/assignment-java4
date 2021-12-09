<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<div class="container mt-5">
	<div class="d-flex justify-content-center row">
		<div class="col-md-10">
			<div class="row">
				<div class="col-3">
					<a href="CustomerFormServlet" class="btn btn-success">New
						Customer</a>
				</div>
				<c:if test="${not empty message }">
								<div class="alert alert-danger" role="alert">
								  ${message }
								</div>
							</c:if>
				<div class="col-3 offset-6">
					<form action="AdminCustomerServlet" method="post"> 
						<div class="mb-3 form-check">
							<input type="checkbox" class="form-check-input" name="reload"> <label
								class="form-check-label mr-3">In-active</label>
							<button type="submit" class="btn btn-primary">Reload</button>
						</div>
					</form>
				</div>
			</div>
			<div class="rounded">

				<div class="table-responsive table-borderless">

					<table class="table">
						<thead>
							<tr>
								<th>#</th>
								<th>Fullname</th>
								<th>Email</th>
								<th>Gender</th>
								<th>IsActive?</th>
								<th></th>
							</tr>
						</thead>
						<tbody class="table-body">
							<c:forEach items="${listCustomers }" var="item">
								<form action="AdminUpdateOrderServlet?id=${item.idCustomers }"
									method="post">
									<tr class="cell-1 ${item.active == false ? 'table-danger' : '' }">
										<td>#${item.idCustomers }</td>
										<td>${item.fullname }</td>
										<td>${item.email }</td>
										<td>${item.gender }</td>
										<td>${item.active }</td>
										<td>
											<c:if test="${item.active == true }">
												<a
											href="CustomerUpdateServlet?id=${item.idCustomers }"
											class="btn btn-primary">Update</a>
											<a customer-id="${item.idCustomers }" onclick="confirmDeleteCustomer(this.getAttribute('customer-id'))" class="btn btn-danger"
												>
												Delete</a>
											</c:if>
											
											<c:if test="${item.active == false }">
												<a href="CustomerRestoreServlet?id=${item.idCustomers }" class="btn btn-success">Restore</a>
											</c:if>
										</td>
									</tr>
								</form>
							</c:forEach>

						</tbody>
					</table>
				</div>

			</div>
		</div>
	</div>
</div>

<!-- Modal -->
<div class="modal fade" id="deleteCustomer" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true">
  <div class="modal-dialog">
    <div class="modal-content">
      <div class="modal-header">
        <h5 class="modal-title" id="exampleModalLabel">Confirmation</h5>
        <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
      </div>
      <div class="modal-body">
        Are you sure to delete this customer?
      </div>
      <div class="modal-footer">
       <a id="yesOption" class="btn btn-primary">Yes</a>
        <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">No</button>
      </div>
    </div>
  </div>
</div>
<script>
	function confirmDeleteCustomer(id) {
		$('#yesOption').attr('href', '/java-assignment/CustomerDeleteServlet?id=' + id)
		$('#deleteCustomer').modal('show');
	}
</script>