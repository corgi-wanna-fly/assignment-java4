<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html lang="en">

<head>

<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<meta name="description" content="">
<meta name="author" content="">
<link
	href="https://fonts.googleapis.com/css?family=Poppins:100,200,300,400,500,600,700,800,900&display=swap"
	rel="stylesheet">

<base href="/java-assignment/" />
<title>${pageInfo.title }</title>

<!-- Bootstrap core CSS -->
<link href="vendor/bootstrap/css/bootstrap.min.css" rel="stylesheet">


<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
<!--

<!-- Bootstrap CSS -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
<!--
TemplateMo 546 Sixteen Clothing

https://templatemo.com/tm-546-sixteen-clothing

-->

<!-- Additional CSS Files -->
<link rel="stylesheet" href="assets/css/fontawesome.css">
<link rel="stylesheet" href="assets/css/templatemo-sixteen.css">
<link rel="stylesheet" href="assets/css/owl.css">
<link rel="stylesheet" href="assets/css/cart.css">
<link rel="stylesheet" href="assets/css/order.css">
</head>

<body>

	<!-- ***** Preloader Start ***** -->
	<div id="preloader">
		<div class="jumper">
			<div></div>
			<div></div>
			<div></div>
		</div>
	</div>
	<!-- ***** Preloader End ***** -->

	<!-- Header -->
	<header class="">
		<nav class="navbar navbar-expand-lg">
			<div class="container">
				<a class="navbar-brand" href="HomeServlet"><h2>
						Công Minh <em>Beauty</em>
					</h2></a>
				<form class="col-12 col-lg-auto mb-3 mb-lg-0 me-lg-3" action="SearchServlet" method="post">
					<input type="search" class="form-control form-control-dark"
						placeholder="Search..." aria-label="Search" name="keyword" onblur="this.form.submit()">
				</form>
				<button class="navbar-toggler" type="button" data-toggle="collapse"
					data-target="#navbarResponsive" aria-controls="navbarResponsive"
					aria-expanded="false" aria-label="Toggle navigation">
					<span class="navbar-toggler-icon"></span>
				</button>
				<div class="collapse navbar-collapse" id="navbarResponsive">
					<ul class="navbar-nav ml-auto">
						<li class="nav-item ${flag == 'Home' ? 'active' : '' }"><a
							class="nav-link" href="HomeServlet">Home </a></li>
						<li class="nav-item ${flag == 'Products' ? 'active' : '' }">
							<a class="nav-link"
							href="ProductServlet">Products</a></li>
						<c:if test="${sessionScope.customer == null }">
							<li class="nav-item"><a class="nav-link" href="LoginServlet">Sign
									In </a></li>
							<li class="nav-item"><a class="nav-link"
								href="Register	Servlet">Sign Up</a>
						</c:if>
						<c:if test="${sessionScope.customer != null }">
							<li class="nav-item ${flag == 'Cart' ? 'active' : '' }"><a class="nav-link" href="CartServlet">Cart
									
							</a></li>
							<li class="nav-item ${flag == 'Orders' ? 'active' : '' }"><a class="nav-link" href="OrderServlet">Orders
									
							</a></li>
							<li class="nav-item"><h6 style="color: blue">${sessionScope.customer.fullname }</h6>
								<a class="nav-link" href="LogoutServlet">Logout</a></li>
						</c:if>
					</ul>
				</div>
			</div>
		</nav>
	</header>

	<!-- Page Content -->
	<!-- Banner Starts Here -->
	<div class="banner header-text">
		<div class="owl-banner owl-carousel">
			<div class="banner-item-01">
				<div class="text-content">
					<h4>Best Offer</h4>
					<h2>Công Minh Idol</h2>
				</div>
			</div>
			<div class="banner-item-02">
				<div class="text-content">
					<h4>Flash Deals</h4>
					<h2>Nam Vương Poly</h2>
				</div>
			</div>
			<div class="banner-item-03">
				<div class="text-content">
					<h4>Last Minute</h4>
					<h2>Chúa tể sắc đẹp</h2>
				</div>
			</div>
		</div>
	</div>
	<!-- Banner Ends Here -->

	<c:if test="${pageInfo != null }">
		<jsp:include page="${pageInfo.contentUrl }"></jsp:include>
	</c:if>


	<div class="best-features">
		<div class="container">
			<div class="row">
				<div class="col-md-12">
					<div class="section-heading">
						<h2>About Công Minh Beauty</h2>
					</div>
				</div>
				<div class="col-md-6">
					<div class="left-content">
						<h4>Nam vương Công Minh</h4>
						<p>Công Minh luôn tôn trọng khách hàng, lấy niềm vui, sự hài
							lòng của khách hàng để làm động lực, không ngừng tìm kiếm các sản
							phẩm tốt nhất để mỗi khách hàng đều có thể trở nên tự tin và xinh
							đẹp hơn.</p>
						<ul class="featured-list">
							<li><a href="#">Khách luôn được giá ưu đãi tốt nhất</a></li>
							<li><a href="#">Dịch vụ nhanh chóng</a></li>
							<li><a href="#">Các thương hiệu uy tín, được mọi người
									tin dùng</a></li>
							<li><a href="#">Nhiều chương trình Khuyến Mãi khác</a></li>
						</ul>
					</div>
				</div>
				<div class="col-md-6">
					<div class="right-image">
						<img src="assets/images/product.jpg" alt="">
					</div>
				</div>
			</div>
		</div>
	</div>

	<footer>
		<div class="container">
			<div class="row">
				<div class="col-md-12">
					<div class="inner-content">
						<p>Copyright &copy; 2020 Công Minh Beauty Co., Ltd.</p>
					</div>
				</div>
			</div>
		</div>
	</footer>


	<!-- Bootstrap core JavaScript -->
	<script src="vendor/jquery/jquery.min.js"></script>
	<script src="vendor/bootstrap/js/bootstrap.bundle.min.js"></script>


	<!-- Additional Scripts -->
	<script src="assets/js/custom.js"></script>
	<script src="assets/js/owl.js"></script>
	<script src="assets/js/slick.js"></script>
	<script src="assets/js/isotope.js"></script>
	<script src="assets/js/accordions.js"></script>

<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM" crossorigin="anonymous"></script>
	<script language="text/Javascript"> 
      cleared[0] = cleared[1] = cleared[2] = 0; //set a cleared flag for each field
      function clearField(t){                   //declaring the array outside of the
      if(! cleared[t.id]){                      // function makes it static and global
          cleared[t.id] = 1;  // you could use true and false, but that's more typing
          t.value='';         // with more chance of typos
          t.style.color='#fff';
          }
      }
    </script>

</body>

</html>
