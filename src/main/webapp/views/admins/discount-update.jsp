<div class="container">
		<div class="row col-6 offset-3">
			<h1 align="center">Discount Form</h1>
			<form action="DiscountUpdateServlet?id=${discount.idDiscounts }" method="post">
				<div class="mb-3">
					<label class="form-label">Name</label> <input type="text"
						class="form-control" required="required" name="name" value="${discount.name }">
				</div>
				<div class="mb-3">
					<label class="form-label">Description</label> <input type="text"
						class="form-control" required="required" name="description" value="${discount.description }">
				</div>
				<div class="mb-3">
					<label class="form-label">Percent</label> <input type="number"
						class="form-control" min="0" max="100" required="required"
						name="percent" value="${discount.percent }">
				</div>
				<button type="submit" class="btn btn-primary">Submit</button>
			</form>
		</div>
	</div>