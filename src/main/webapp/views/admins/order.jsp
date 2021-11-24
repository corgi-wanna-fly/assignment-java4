<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<div class="container mt-5">
    <div class="d-flex justify-content-center row">
        <div class="col-md-10">
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
                          <form action="AdminUpdateOrderServlet?id=${item.idOrders }" method="post">
                          		 <tr class="cell-1">
	                                <td>#${item.idOrders }</td>
	                                <td>${item.customer.fullname }</td>
	                                <td>${item.address }</td>
	                                <td>${item.phone }</td>	
	                                <td>${item.amount }</td>
	                                <td>${item.created }</td>
	                                <td>	
	                                	<select name="status" id="" >
	                                			<c:forEach items="${listStatus }" var="str">
	                                				<option value="${str }" ${str ==  item.status ? 'selected="selected"' : ''}>${str }</option>
	                                			</c:forEach>
	                                	</select>
	                                </td>
	                                <td>
										 <input type="submit" class="btn btn-primary" value="Update"></input>
										 <a class="btn btn-danger" >Delete</a>
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