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
		<c:forEach items="${tests}" var="test">
			<c:set var="count" value="${count + 1}" scope="page" />

			<tr>
				<th scope="row">${count}</th>
				<td>${test.name}</td>
				<td>${test.discription}</td>
				<td><form action="/student/runtest" method="post">
						<button type="submit" name="testId" value="${test.id}"
							class="btn btn-warning">Run test</button>
					</form></td>

			</tr>
		</c:forEach>
	</tbody>
</table>


