<%@ page contentType="text/html; UTF-8" pageEncoding="UTF-8" trimDirectiveWhitespaces="true"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<table class="table">
	<thead class="thead-dark">
		<tr>
			<th scope="col">#</th>
			<th scope="col">Название теста</th>
			<th scope="col">Описание теста</th>
			<th scope="col">Автор теста</th>
			<th scope="col"></th>
		</tr>
	</thead>
	<tbody>
		
			<tr>
				<th scope="row">${account.id}</th>
				<td>${account.firstName}</td>
				<td>${account.lastName}</td>
				<td>${account.middleName}</td>
				<td><a class="btn btn-warning" href="#" role="button">Edit</a> <a class="btn btn-danger" href="#" role="button">Remove</a></td>
			</tr>
		
	</tbody>
</table>
