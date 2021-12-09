<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<div class="container mt-5">
    <div class="d-flex justify-content-center row">
        <div class="col-md-10">
        <a class="btn btn-success" href="DiscountFormServlet">New Discount</a>
        <c:if test="${not empty message }">
								<div class="alert alert-danger" role="alert">
								  ${message }
								</div>
							</c:if>
            <div class="rounded">
            
                <div class="table-responsive table-borderless">
                    <table class="table">
                        <thead>
                            <tr>	                              
                                <th>#</th>
                                <th>Name</th>		
                                <th>Description</th>
                                 <th>Percent</th>
                                <th></th>
                            </tr>
                        </thead>
                        <tbody class="table-body">
                          <c:forEach items="${listDiscounts }" var="item">
                          <form>
                          		 <tr class="cell-1">
	                                <td>#${item.idDiscounts }</td>
	                                <td>${item.name }</td>
	                                <td>${item.description }</td>
	                                <td>${item.percent } %</td>	                                
	                                <td>
	                                	<a href="DiscountUpdateServlet?id=${item.idDiscounts }" class="btn btn-primary">Update</a>
										 <a href="" class="btn btn-danger">Delete</a>
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