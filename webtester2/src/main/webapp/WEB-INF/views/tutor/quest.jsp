<%@ page contentType="text/html; UTF-8" pageEncoding="UTF-8"
	trimDirectiveWhitespaces="true"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<table class="table">
	<thead class="thead-dark">
		<tr>
			<th scope="col">#</th>
			<th scope="col">Вопрос</th>
			<th scope="col"></th>
		</tr>
	</thead>
	<tbody>
		<c:forEach items="${questions}" var="quest">
			<c:set var="count" value="${count + 1}" scope="page" />

			<tr>
				<th scope="row">${count}</th>
				<td>${quest.name}</td>
				<td><form action="/tutor/answear" method="get">
						<button type="submit" name="questId" value="${quest.id}"
							class="btn btn-warning">Edit</button>
					</form></td>

			</tr>
		</c:forEach>
	</tbody>
</table>

<a class="btn btn-primary" href="#foo" data-toggle="modal"
	data-target="#exampleModal">Add new question</a>


<div class="modal fade" id="exampleModal" tabindex="-1" role="dialog"
	aria-labelledby="exampleModalLabel" aria-hidden="true">
	<div class="modal-dialog" role="document">
		<div class="modal-content">
			<form action="/tutor/quest" method="POST">
				<div class="modal-header">
					<h5 class="modal-title" id="exampleModalLabel">Please, fill in
						form fields and push the button «add»</h5>
					<button type="button" class="close" data-dismiss="modal"
						aria-label="Close">
						<span aria-hidden="true">&times;</span>
					</button>
				</div>
				<div class="form-group">
					<input type="text" class="form-control" name="addQuest"
						placeholder="Please enter question">
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
