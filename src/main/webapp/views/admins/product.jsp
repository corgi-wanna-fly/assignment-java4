<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<div class="container mt-5">
    <div class="d-flex justify-content-center row">
        <div class="col-md-10">
         <div class="row">
						<div class="col-2">
							<a href="ProductFormServlet" class="btn btn-success">New Product</a>
						</div>
						<div class="col-7">
							<form action="ProductUploadServlet" method="post" enctype="multipart/form-data">
							<c:if test="${not empty message }">
								<div class="alert alert-danger" role="alert">
								  ${message }
								</div>
							</c:if>
								<div class="input-group mb-3">
								  <input type="file" class="form-control" name="excelFile">
								</div>
								<input type="submit" class="btn btn-primary" value="Import"></input>	
							</form>
						</div>
						<div class="col-3">
							<form action="AdminProductServlet" method="post">
								<div class="mb-3 form-check">
									<input type="checkbox" class="form-check-input" name="reload">
									<label class="form-check-label mr-3">In-active</label>
									
								</div>
								<button type="submit" class="btn btn-primary">Reload</button>
							</form>
						</div>
					</div>
            <div class="rounded">
            
                <div class="table-responsive table-borderless">
                    <table class="table">
                        <thead>
                            <tr>	                              
                                <th>#</th>
                                <th>Name</th>		
                                <th>Price</th>
                                 <th>Discount</th>
                                 <th>IsActive?</th>
                                <th></th>
                            </tr>
                        </thead>
                        <tbody class="table-body">
                          <c:forEach items="${listProducts }" var="item">
                          <form>
                          		 <tr class="cell-1 ${item.active == false ? 'table-danger' : '' }">
	                                <td>#${item.idProducts }</td>
	                                <td>${item.name }</td>
	                                <td>${item.price }</td>
	                                <td>${item.discount.percent } %</td>	 
	                                <td>${item.active }</td>                              
	                                <td>
	                                	<c:if test="${item.active == true }">
	                                		<a href="ProductUpdateServlet?id=${item.idProducts }" class="btn btn-primary">Update</a>
										 <a product-id="${item.idProducts }" onclick="confirmDeleteProduct(this.getAttribute('product-id'))" class="btn btn-danger"
												>
												Delete</a>
	                                	</c:if>
	                                	
	                                	<c:if test="${item.active == false }">
	                                		<a href="ProductRestoreServlet?id=${item.idProducts }" class="btn btn-success">Restore</a>
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
<div class="modal fade" id="deleteProduct" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true">
  <div class="modal-dialog">
    <div class="modal-content">
      <div class="modal-header">
        <h5 class="modal-title" id="exampleModalLabel">Confirmation</h5>
        <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
      </div>
      <div class="modal-body">
        Are you sure to delete this product?
      </div>
      <div class="modal-footer">
       <a id="yesOption" class="btn btn-primary">Yes</a>
        <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">No</button>
      </div>
    </div>
  </div>
</div>
<script>
	function confirmDeleteProduct(id) {
		$('#yesOption').attr('href', '/java-assignment/ProductDeleteServlet?id=' + id)
		$('#deleteProduct').modal('show');
	}
</script>