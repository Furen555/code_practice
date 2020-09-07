<%@ page contentType="text/html; UTF-8" pageEncoding="UTF-8"
	trimDirectiveWhitespaces="true"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<table class="table">
	<thead class="thead-dark">
		<tr>
			<th scope="col">#</th>
			<th scope="col">Название теста</th>
			<th scope="col">Описание теста</th>
			<th scope="col"></th>
		</tr>
	</thead>
	<tbody>
		<c:forEach items="${tests}" var="test" varStatus="loop">
			

			<tr>
				<th scope="row">${loop.index+1}</th>
				<td>${test.name}</td>
				<td>${test.discription}</td>
				<td><form action="/tutor/quest" method="get">
						<button type="submit" name="testId" value="${test.id}" class="btn btn-warning" >Edit</button> 
					</form></td>

			</tr>
		</c:forEach>
	</tbody>
</table>

<a class="btn btn-primary" href="#foo" data-toggle="modal"
	data-target="#exampleModal">Add new TEST</a>


<div class="modal fade" id="exampleModal" tabindex="-1" role="dialog"
	aria-labelledby="exampleModalLabel" aria-hidden="true">
	<div class="modal-dialog" role="document">
		<div class="modal-content">
			<form action="/tutor/home" method="POST">
				<div class="modal-header">
					<h5 class="modal-title" id="exampleModalLabel">Please, fill in
						form fields and push the button «add»</h5>
					<button type="button" class="close" data-dismiss="modal"
						aria-label="Close">
						<span aria-hidden="true">&times;</span>
					</button>
				</div>
				<div class="form-group">
					<input type="text" class="form-control" name="addTestName"
						placeholder="Please enter name of test">
				</div>
				<div class="form-group">
					<input type="text" class="form-control" name="addTestDescription"
						placeholder="Please enter description">
				</div>
				<div class="modal-footer">
					<button type="button" class="btn btn-secondary"
						data-dismiss="modal">Close</button>
					<button type="submit" class="btn btn-primary">add</button>
				</div>
			</form>
		</div>
	</div>
</div>
