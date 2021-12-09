<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<div class="container">
	<div class="row col-6 offset-3">
		<form action="CustomerUpdateServlet?id=${customer.idCustomers }" method="post">
		<c:if test="${ not empty message}">
					<div class="alert alert-danger" role="alert">
					  ${message }
					</div>
				</c:if>
			<div class="mb-3">
				<label class="form-label fw-bold">Fullname</label> <input type="text" name="fullname" value="${customer.fullname }"
					class="form-control">
			</div>
			<div class="mb-3">
				<label class="form-label fw-bold disable">Email</label> <input type="email" name="email" value="${customer.email }"
					class="form-control">
			</div>
			<div class="mb-3">
				<label class="form-label fw-bold">Password</label> <input type="password" name="password" value="${customer.password }"
					class="form-control">
			</div>
			<div class="mb-3">
			<label class="form-label fw-bold">Gender</label> <br />
						<div class="form-check form-check-inline">
		  <input class="form-check-input" type="radio" name="gender" value="Male" ${customer.gender == 'Male' ? 'checked="checked"' : '' } >
		  <label class="form-check-label">Male</label>
		</div>
		<div class="form-check form-check-inline">
		  <input class="form-check-input" type="radio" name="gender" value="Female" ${customer.gender == 'Female' ? 'checked="checked"' : ''}>
		  <label class="form-check-label">Female</label>
		</div>
		<div class="form-check form-check-inline">
		  <input class="form-check-input" type="radio" name="gender" value="Other" ${customer.gender == 'Other' ? 'checked="checked"' : '' }>
		  <label class="form-check-label">Other</label>
		</div>
			</div>
			<input type="submit" class="btn btn-primary" value="Submit"></input>
		</form>
	</div>
</div>