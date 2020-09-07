<%@ page contentType="text/html; UTF-8" pageEncoding="UTF-8"
	trimDirectiveWhitespaces="true"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<blockquote class="blockquote text-center">
	<p class="mb-0">You have more then 1 available role. Please choose
		you role.</p>
	<p class="text-muted">After press button, you will be transferred
		on you homepage</p>


</blockquote>

<p></p>
<p></p>


<form class="needs-validation" action="/getRole" method="post">
	<c:forEach items="${roles}" var="role">
		<div class="form-check">
			<input class="form-check-input" type="radio" name="roles"
				value="${role.name}"> <label class="form-check-label"
				for="exampleRadios1"> ${role.name} </label>
		</div>
		<p></p>
	</c:forEach>
	<a href="/logout" class="btn btn-secondary" data-dismiss="modal">Back</a>
	<button class="btn btn-outline-success" type="submit">Submit</button>

</form>

