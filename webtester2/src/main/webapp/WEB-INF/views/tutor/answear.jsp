<%@ page contentType="text/html; UTF-8" pageEncoding="UTF-8"
	trimDirectiveWhitespaces="true"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<table class="table">
	<thead class="thead-dark">
		<tr>
			<th scope="col">#</th>
			<th scope="col">Ответ</th>
			<th scope="col">Ответ верный?</th>
			<th scope="col"></th>
		</tr>
	</thead>
	<tbody>
		<c:forEach items="${answears}" var="answear">
			<c:set var="count" value="${count + 1}" scope="page" />

			<tr>
				<th scope="row">${count}</th>
				<td>${answear.name}</td>
				<td>${answear.correct}</td>
				<td><form action="/tutor/answear/edit" method="get">
						<button type="submit" name="answearId" value="${answear.id}"
							class="btn btn-warning">Edit</button>
					</form></td>

			</tr>
		</c:forEach>
	</tbody>
</table>

<a class="btn btn-primary" href="#foo" data-toggle="modal"
	data-target="#exampleModal">Add new answear</a>


<div class="modal fade" id="exampleModal" tabindex="-1" role="dialog"
	aria-labelledby="exampleModalLabel" aria-hidden="true">
	<div class="modal-dialog" role="document">
		<div class="modal-content">
			<form action="/tutor/answear" method="POST">
				<div class="modal-header">
					<h5 class="modal-title" id="exampleModalLabel">Please, fill in
						form fields and push the button «add»</h5>
					<button type="button" class="close" data-dismiss="modal"
						aria-label="Close">
						<span aria-hidden="true">&times;</span>
					</button>
				</div>
				<div class="form-group">
					<input type="text" class="form-control" name="addAnswear"
						placeholder="Please enter answear">
				</div>
				<div class="form-check">
					<input class="form-check-input" type="radio" name="correct"
						id="exampleRadios1" value="true" checked> <label
						class="form-check-label" for="exampleRadios1"> Default
						radio </label>
				</div>
				<div class="form-check">
					<input class="form-check-input" type="radio" name="correct"
						id="exampleRadios2" value="false"> <label
						class="form-check-label" for="exampleRadios2"> Second
						default radio </label></div>

					<div class="modal-footer">
						<button type="button" class="btn btn-secondary"
							data-dismiss="modal">Close</button>
						<button type="submit" class="btn btn-primary">add</button>
					</div>
			</form>
		</div>
	</div>
</div>
