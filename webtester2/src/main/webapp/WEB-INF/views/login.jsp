<%@ page contentType="text/html; UTF-8" pageEncoding="UTF-8" trimDirectiveWhitespaces="true"%>

<div class="card">
	<div class="card-header">Please login</div>
	<div class="card-body">
		<form action="/login" method="POST">
			<div class="form-group">
				<label>Login</label>
				<input type="text" class="form-control" name="login" placeholder="Enter your login">
			</div>
			<div class="form-group">
				<label>Password</label>
				<input type="password" class="form-control" name="password" placeholder="Password"><small id="emailHelp"
					class="form-text text-muted"><a class="nav-link"
					href="#foo" data-toggle="modal" data-target="#exampleModal">Forget
						password</a></small>
			</div>
			<button type="submit" class="btn btn-primary">Submit</button>
			<a href="/registration" class="btn btn-primary">Registration</a>
		</form>
		
	</div>
</div>
<div class="modal fade" id="exampleModal" tabindex="-1" role="dialog"
	aria-labelledby="exampleModalLabel" aria-hidden="true">
	<div class="modal-dialog" role="document">
		<div class="modal-content">
		<form action="/forgetPassword" method="POST">
			<div class="modal-header">
				<h5 class="modal-title" id="exampleModalLabel">If you forget
					password, we send him on the registration email</h5>
				<button type="button" class="close" data-dismiss="modal"
					aria-label="Close">
					<span aria-hidden="true">&times;</span>
				</button>
			</div>
			<div class="modal-body">
				<input type="email" class="form-control" name="forgetPassword" placeholder="Please enter you login">
			</div>
			<div class="modal-footer">
				<button type="button" class="btn btn-secondary" data-dismiss="modal">Close</button>
				<button type="submit" class="btn btn-primary">Send</button>
			</div>
			</form>
		</div>
	</div>
</div>
