<%@ page contentType="text/html; UTF-8" pageEncoding="UTF-8"
	trimDirectiveWhitespaces="true"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>




<blockquote class="blockquote text-center">
	<p class="mb-0">You current test is ${testName}</p>
	<p class="text-muted">Discription: ${testDiscription}</p>


</blockquote>


<form class="needs-validation" action="/student/home" method="get">





	<div class="card">
		<c:forEach items="${questions}" var="question">
			<div class="card-header">${question.name}</div>
			<div class="card-body">
				<form>
					<c:forEach items="${question.answears}" var="answear">
						<div class="custom-control custom-checkbox">
							<input type="checkbox" name="${question.id}"
								class="custom-control-input" id="customCheck${answear.id}">
							<label class="custom-control-label"
								for="customCheck${answear.id}">${answear.name}</label>
						</div>
					</c:forEach>
				</form>
			</div>
		</c:forEach>
		<button type="submit" action="/student/home"
			class="btn btn-primary">Submit</button>



	</div>
</form>








