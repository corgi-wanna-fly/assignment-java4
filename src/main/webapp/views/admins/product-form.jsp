<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<div class="container">
	<div class="row col-6 offset-3">
		<form action="ProductFormServlet" method="post">
			<div class="mb-3">
				<label class="form-label fw-bold">Name</label> <input type="text" name="name"
					class="form-control" required="required">
			</div>
			<div class="mb-3">
				<label class="form-label fw-bold">Price</label> <input type="number" name="price"
					class="form-control" required="required">
			</div>
			<div class="mb-3">
				<label class="form-label fw-bold">Description</label>
				<textarea class="form-control" placeholder="Leave a comment here"
					name="description" style="height: 100px" required="required"></textarea>
			</div>
			<div class="mb-3">
				<label class="form-label fw-bold">Brand</label> <select
					class="form-control" name="id_brand" aria-label="Default select example" required>
					<option value=""></option>
					<c:forEach items="${listBrands }" var="item" varStatus="loop">
						<option value="${item.idBrands}">${item.name }</option>
					</c:forEach>
				</select>
			</div>
			<div class="mb-3">
				<label class="form-label fw-bold">Category</label> <select
					class="form-control" name="id_category" aria-label="Default select example" required>
					<option value=""></option>
					<c:forEach items="${listCategories }" var="item" varStatus="loop">
						<option value="${item.idCategorys }">${item.name }</option>
					</c:forEach>
				</select>
			</div>
			<div class="mb-3">
				<label class="form-label fw-bold">Discount</label> <select
					class="form-control" name="id_discount" aria-label="Default select example" required>
					<option value=""></option>
					<c:forEach items="${listDiscounts }" var="item" varStatus="loop">
						<option value="${item.idDiscounts}"}>${item.name }</option>
					</c:forEach>
				</select>
			</div>
			<div class="mb-3">
				<label class="form-label fw-bold">Image</label> <input type="text" name="image"
					class="form-control" required="required">
			</div>
			<input type="submit" class="btn btn-primary" value="Submit"></input>
		</form>
	</div>
</div>