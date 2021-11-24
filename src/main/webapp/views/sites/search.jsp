<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>

<div class="latest-products">
	<div class="container">
		<div id="content" class="row">
			<div class="col-md-12">
				<div class="section-heading">
					<h2>Latest Products</h2>
				</div>
			</div>
			<c:forEach items="${listProducts }" var="item">
				<div class="product col-md-4">
					<div class="product-item">	
						<div class="col-2 mt-2" style="background-color: red; color: white;">-${item.discount.percent }%</div>	
						<a href="DetailServlet?id=${item.idProducts }"><img src="${item.image }" alt=""></a>
						<div class="down-content">
							<a href="DetailServlet?id=${item.idProducts }"><h4>${item.name }</h4></a>
							<h6><strike>${item.price }</strike></h6>	
							<h5 style="margin-left: 220px; color: red">${item.price * (100 - item.discount.percent)/100 }</h5>
							<p>${item.description }</p>
							<a href="AddCartServlet?id=${item.idProducts }"
								class="btn btn-primary" >Add to Cart</a> <span>Views
								(${item.view })</span>
						</div>
					</div>
				</div>
			</c:forEach>

		</div>
	</div>
</div>
