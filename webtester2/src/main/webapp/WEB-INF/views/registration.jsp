<%@ page contentType="text/html; UTF-8" pageEncoding="UTF-8" trimDirectiveWhitespaces="true"%>
		<div class="card">
			<div class="card-header">Registration new user</div>
			<div class="card-body">
				<form action="/registration" method="post">
					<div class="form-group">
						<input type="email" class="form-control" name="email" placeholder="Enter you email">
					</div>
					<div class="form-group">
						<input type="text" class="form-control" name="login" placeholder="Enter you login">
					</div>
					<div class="form-group">
						<input type="password" class="form-control mr-sm-2"
							name="password1" placeholder="Enter you Password">
					</div>
					<div class="form-group">
						<input type="password" class="form-control mr-sm-2"
							name="password2"
							placeholder="Enter you Password one more time">
					</div>
					<div class="form-group">
						<label for="exampleFormControlTextarea1">Personal data</label>

					</div>
					<div class="form-group">
						<textarea class="form-control" name="firstName"
							rows="1" placeholder="Enter you first name"></textarea>

					</div>
					<div class="form-group">
						<textarea class="form-control" name="lastName"
							rows="1" placeholder="Enter you last name"></textarea>

					</div>
					<div class="form-group">
						<textarea class="form-control" name="middleName"
							rows="1" placeholder="Enter you middle name"></textarea>

					</div>

					<div class="modal-footer">
						<a href="/login" class="btn btn-secondary"
							data-dismiss="modal">Back</a>
						<button type="submit" class="btn btn-primary">Registration</button>
					</div>


				</form>

			</div>
		</div>

	