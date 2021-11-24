<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jstl/fmt_rt" prefix="fmt"%>

<div class="container pb-5 mt-n2 mt-md-n3">
	<div class="row">
		<div class="col-xl-9 col-md-8">
			<h2
				class="h6 d-flex flex-wrap justify-content-between align-items-center px-4 py-3 bg-secondary">
				<span>Products</span><a class="font-size-sm" href="ProductServlet"><svg
						xmlns="http://www.w3.org/2000/svg" width="24" height="24"
						viewBox="0 0 24 24" fill="none" stroke="currentColor"
						stroke-width="2" stroke-linecap="round" stroke-linejoin="round"
						class="feather feather-chevron-left"
						style="width: 1rem; height: 1rem;">
						<polyline points="15 18 9 12 15 6"></polyline></svg>Continue shopping</a>
			</h2>
			<!-- Item-->
			<c:if test="${count > 0 }">
				<c:forEach begin="0" end="${count - 1 }" var="i">
					<form
						action="UpdateCartServlet?id=${listProducts.get(i).idProducts }"
						method="post">
						<div
							class="d-sm-flex justify-content-between my-4 pb-4 border-bottom">
							<div class="media d-block d-sm-flex text-center text-sm-left">
								<a class="cart-item-thumb mx-auto mr-sm-4" href="#"><img
									src="${listProducts.get(i).image }" alt="Product"></a>
								<div class="media-body pt-3">
									<h3
										class="product-card-title font-weight-semibold border-0 pb-0">
										<a href="#">${listProducts.get(i).name }</a>
									</h3>
									<div class="font-size-lg text-primary pt-2">
										<fmt:formatNumber value="${listProducts.get(i).price * (100 - listProducts.get(i).discount.percent) / 100 }"
											pattern="#,###"></fmt:formatNumber>
										VND
									</div>
								</div>
							</div>
							<div
								class="pt-2 pt-sm-0 pl-sm-3 mx-auto mx-sm-0 text-center text-sm-left"
								style="max-width: 10rem;">
								<div class="form-group mb-2">
									<label for="quantity1">Quantity</label> <input
										class="form-control form-control-sm" type="number"
										name="quantity" onblur="this.form.submit()" min="1"
										value="${listQuantities.get(i) }">
								</div>

								<a class="btn btn-outline-danger btn-sm btn-block mb-2"
									href="RemoveCartServlet?id=${listProducts.get(i).idProducts }">
									<svg xmlns="http://www.w3.org/2000/svg" width="24" height="24"
										viewBox="0 0 24 24" fill="none" stroke="currentColor"
										stroke-width="2" stroke-linecap="round"
										stroke-linejoin="round" class="feather feather-trash-2 mr-1">
				                            <polyline points="3 6 5 6 21 6"></polyline>
				                            <path
											d="M19 6v14a2 2 0 0 1-2 2H7a2 2 0 0 1-2-2V6m3 0V4a2 2 0 0 1 2-2h4a2 2 0 0 1 2 2v2"></path>
				                            <line x1="10" y1="11" x2="10" y2="17"></line>
				                            <line x1="14" y1="11" x2="14" y2="17"></line>
				                        </svg>Remove
								</a> <label for="">Total</label>
								<div class="font-size-lg text-primary pt-2">
									<fmt:formatNumber
										value="${listProducts.get(i).price * (100 - listProducts.get(i).discount.percent) / 100 * listQuantities.get(i)}"
										pattern="#,###"></fmt:formatNumber>
									VND
								</div>
							</div>
						</div>
					</form>
				</c:forEach>
			</c:if>
			<c:if test="${count == 0 }">
				<div class="alert alert-danger" role="alert">${message }</div>
			</c:if>
		</div>
		<!-- Sidebar-->
		<div class="col-xl-3 col-md-4 pt-3 pt-md-0">
			<form action="CheckoutServlet" method="post">
				<h2 class="h6 px-4 py-3 bg-secondary text-center">Subtotal</h2>
				<div class="h3 font-weight-semibold text-center py-3">
					<fmt:formatNumber value="${amount}" pattern="#,###"></fmt:formatNumber>
					VND 
				</div>
				<hr>
				<c:if test="${not empty error }">
					<div class="alert alert-danger" role="alert">${error }</div>
				</c:if>
				<h3 class="h6 pt-4 font-weight-semibold">
					<span class="badge badge-success mr-2">Note</span>Phone Number
				</h3>
				<input type="text" class="form-control mb-3" name="phone" required="required"/>
				<h3 class="h6 pt-4 font-weight-semibold">
					<span class="badge badge-success mr-2">Note</span>Detail Address
				</h3>
				<textarea class="form-control mb-3" name="address" rows="5" required="required"></textarea>
				<button type="submit" class="btn btn-primary btn-block"> <svg
						xmlns="http://www.w3.org/2000/svg" width="24" height="24"
						viewBox="0 0 24 24" fill="none" stroke="currentColor"
						stroke-width="2" stroke-linecap="round" stroke-linejoin="round"
						class="feather feather-credit-card mr-2">
                    <rect x="1" y="4" width="22" height="16" rx="2"
							ry="2"></rect>
                    <line x1="1" y1="10" x2="23" y2="10"></line>
                </svg>Proceed to Checkout
				</button>
			</form>
		</div>
	</div>
</div>