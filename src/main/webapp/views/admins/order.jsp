<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<div class="container mt-5">
	<div class="d-flex justify-content-center row">
		<div class="col-md-10">
			<div class="row">
				<form action="OrderSearchServlet" method="post">
					<div class="mb-3 form-check">
						<div class="form-check form-check-inline">
							<input class="form-check-input" name="statuses" type="checkbox"
								value="Cho duyet"> <label
								class="form-check-label">Cho duyet</label>
						</div>
						<div class="form-check form-check-inline">
							<input class="form-check-input" name="statuses" type="checkbox"
								value="Da duyet"> <label
								class="form-check-label">Da duyet</label>
						</div>
						<div class="form-check form-check-inline">
							<input class="form-check-input" name="statuses" type="checkbox"
								value="Dang van chuyen"> <label
								class="form-check-label">Dang van
								chuyen</label>
						</div>
						<div class="form-check form-check-inline">
							<input class="form-check-input" name="statuses" type="checkbox"
								value="Giao thanh cong"> <label
								class="form-check-label">Giao
								thanh cong</label>
						</div>
						<button type="submit" class="btn btn-primary">Reload</button>
					</div>
				</form>

			</div>
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
								<form action="AdminUpdateOrderServlet?id=${item.idOrders }"
									method="post">
									<tr class="cell-1">
										<td>#${item.idOrders }</td>
										<td>${item.customer.fullname }</td>
										<td>${item.address }</td>
										<td>${item.phone }</td>
										<td>${item.amount }</td>
										<td>${item.created }</td>
										<td><select name="status" id="">
												<c:forEach items="${listStatus }" var="str">
													<option value="${str }"
														${str ==  item.status ? 'selected="selected"' : ''}>${str }</option>
												</c:forEach>
										</select></td>
										<td><input type="submit" class="btn btn-primary"
											value="Update"></input> <a class="btn btn-danger">Cancel</a>
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