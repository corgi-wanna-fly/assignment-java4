<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<div class="container">
	<div class="row col-6 offset-3">
		<form action="CustomerFormServlet" method="post">
			<c:if test="${ not empty message}">
					<div class="alert alert-danger" role="alert">
					  ${message }
					</div>
				</c:if>
			<div class="mb-3">
				<label class="form-label fw-bold">Fullname</label> <input type="text" name="fullname"
					class="form-control">
			</div>
			<div class="mb-3">
				<label class="form-label fw-bold">Email</label> <input type="email" name="email"
					class="form-control">
			</div>
			<div class="mb-3">
				<label class="form-label fw-bold">Password</label> <input type="password" name="password"
					class="form-control">
			</div>
			<div class="mb-3">
			<label class="form-label fw-bold">Gender</label> <br />
						<div class="form-check form-check-inline">
		  <input class="form-check-input" type="radio" name="gender" value="Male">
		  <label class="form-check-label">Male</label>
		</div>
		<div class="form-check form-check-inline">
		  <input class="form-check-input" type="radio" name="gender" value="Female">
		  <label class="form-check-label">Female</label>
		</div>
		<div class="form-check form-check-inline">
		  <input class="form-check-input" type="radio" name="gender" value="Other">
		  <label class="form-check-label">Other</label>
		</div>
			</div>
			<input type="submit" class="btn btn-primary" value="Submit"></input>
		</form>
	</div>
</div>