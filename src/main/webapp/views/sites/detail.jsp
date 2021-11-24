<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<div class="row">
	<div class="product col-md-4 offset-1">
		<a class="font-size-sm" href="ProductServlet"><svg
				xmlns="http://www.w3.org/2000/svg" width="24" height="24"
				viewBox="0 0 24 24" fill="none" stroke="currentColor"
				stroke-width="2" stroke-linecap="round" stroke-linejoin="round"
				class="feather feather-chevron-left"
				style="width: 1rem; height: 1rem;">
						<polyline points="15 18 9 12 15 6"></polyline></svg>Continue shopping</a>
		<div class="product-item">
			<div class="col-2 mt-2" style="background-color: red; color: white;">-${item.discount.percent }%</div>
			<a href="DetailServlet?id=${item.idProducts }"><img src="${item.image }" alt=""></a>
			<div class="down-content">
				<a href="DetailServlet?id=${item.idProducts }"><h4>${item.name }</h4></a>
				<h6>
					<strike>${item.price }</strike>
				</h6>
				<h5 style="margin-left: 300px; color: red">${item.price * (100 - item.discount.percent)/100 }</h5>
				<p>${item.description }</p>
				<a href="AddCartServlet?id=${item.idProducts }"
					class="btn btn-primary">Add to Cart</a> <span>Views
					(${item.view })</span>
			</div>
		</div>
	</div>
	<div class="col-1"></div>
	<div class="col-4">
		<h3 class="mt-3" style="color: blue; font-weight: bolder;">Reviews</h3>
		<ul class="list-group mb-3">
			<c:forEach items="${listReviews }" var="item">
				<li class="list-group-item list-group-item-primary">${item.customer.fullname } said:</li>
				<li class="list-group-item list-group-item-danger"> ${item.comment }</li>
			</c:forEach>
		</ul>
	<form action="CommentServlet?id=${item.idProducts }" method="post">
			<div class="form-floating">
  <textarea class="form-control" name="comment" placeholder="Leave a comment here" id="floatingTextarea2" style="height: 100px"></textarea>
  <input type="submit" class="btn btn-primary" value="Comment"></input>
</div>
	</form>
	</div>
</div>