<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<div class="container mt-5">
    <div class="d-flex justify-content-center row">
        <div class="col-md-10">
            <div class="rounded">
            
                <div class="table-responsive table-borderless">
                    <table class="table">
                        <thead>
                            <tr>	                              
                                <th>#</th>
                                <th>Fullname</th>		
                                <th>Email</th>
                                 <th>Gender</th>
                                <th></th>
                            </tr>
                        </thead>
                        <tbody class="table-body">
                          <c:forEach items="${listCustomers }" var="item">
                          <form action="AdminUpdateOrderServlet?id=${item.idCustomers }" method="post">
                          		 <tr class="cell-1">
	                                <td>#${item.idCustomers }</td>
	                                <td>${item.fullname }</td>
	                                <td>${item.email }</td>
	                                <td>${item.gender }</td>	                                
	                                <td>
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