<%@ page contentType="text/html; UTF-8" pageEncoding="UTF-8" trimDirectiveWhitespaces="true"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<table class="table">
	<thead class="thead-dark">
		<tr>
			<th scope="col">#</th>
			<th scope="col">Имя</th>
			<th scope="col">Фамилия</th>
			<th scope="col">Отчество</th>
			<th scope="col">Эл. почта</th>
			<th scope="col">Дата создания</th>
			<th scope="col">Активный?</th>
			<th scope="col"></th>
		</tr>
	</thead>
	<tbody>
		<c:forEach items="${accounts}" var="account">
			<tr>
				<th scope="row">${account.id}</th>
				<td>${account.firstName}</td>
				<td>${account.lastName}</td>
				<td>${account.middleName}</td>
				<td>${account.email}</td>
				<td>${account.created}</td>
				<td>${account.active}</td>
				<td><a class="btn btn-warning" href="#" role="button">Edit</a> <a class="btn btn-danger" href="#" role="button">Remove</a></td>
			</tr>
		</c:forEach>
	</tbody>
</table>
