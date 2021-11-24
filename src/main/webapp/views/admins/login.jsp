<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!doctype html>
<html lang="en">
<head>
<!-- Required meta tags -->
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">

<!-- Bootstrap CSS -->
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3"
	crossorigin="anonymous">

<title>Admin</title>
</head>
<body>
	<div class="container">
		<div class="row col-4 offset-4">
			<form action="/java-assignment/AdminSigninServlet" method="post">
			<c:if test="${not empty message }">
				<div class="alert alert-danger" role="alert">
					  ${message }
					</div>
			</c:if>
				<img class="mb-4" src="assets/images/admin.jpg" alt="" width="172"
					height="82" style="display: block; margin: 0 auto">
				<h1 class="h3 mb-3 fw-normal" align="center">Welcome Admin</h1>

				<div class="form-floating mb-3">
					<input type="email" class="form-control" name="username"
						placeholder="name@example.com"> <label for="floatingInput">Email
						address</label>
				</div>
				<div class="form-floating mb-3">
					<input type="password" class="form-control" name="password"
						placeholder="Password"> <label for="floatingPassword">Password</label>
				</div>
				<button class="w-100 btn btn-lg btn-primary" type="submit">Sign
					in</button>
				<p class="mt-5 mb-3 text-muted">&copy; Covid</p>
			</form>
		</div>
	</div>

	<!-- Optional JavaScript; choose one of the two! -->

	<!-- Option 1: Bootstrap Bundle with Popper -->
	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"
		integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p"
		crossorigin="anonymous"></script>

	<!-- Option 2: Separate Popper and Bootstrap JS -->
	<!--
    <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.10.2/dist/umd/popper.min.js" integrity="sha384-7+zCNj/IqJ95wo16oMtfsKbZ9ccEh31eOz1HGyDuCQ6wgnyJNSYdrPa03rtR1zdB" crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.min.js" integrity="sha384-QJHtvGhmr9XOIpI6YVutG+2QOK9T+ZnN4kzFN1RtK3zEFEIsxhlmWl5/YESvpZ13" crossorigin="anonymous"></script>
    -->
</body>
</html>