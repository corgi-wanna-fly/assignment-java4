<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<div class="container mt-5">
    <div class="d-flex justify-content-center row">
        <div class="col-md-10">
         <a href="ProductFormServlet" class="btn btn-success">New Product</a>
            <div class="rounded">
            
                <div class="table-responsive table-borderless">
                    <table class="table">
                        <thead>
                            <tr>	                              
                                <th>#</th>
                                <th>Name</th>		
                                <th>Price</th>
                                 <th>Discount</th>
                                <th></th>
                            </tr>
                        </thead>
                        <tbody class="table-body">
                          <c:forEach items="${listProducts }" var="item">
                          <form>
                          		 <tr class="cell-1">
	                                <td>#${item.idProducts }</td>
	                                <td>${item.name }</td>
	                                <td>${item.price }</td>
	                                <td>${item.discount.percent } %</td>	                                
	                                <td>
	                                	<a href="ProductUpdateServlet?id=${item.idProducts }" class="btn btn-primary">Update</a>
										 <input type="submit" class="btn btn-danger" value="Delete"></input>
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