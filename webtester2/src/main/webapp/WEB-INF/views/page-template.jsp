<%@ page contentType="text/html; UTF-8" pageEncoding="UTF-8"
	trimDirectiveWhitespaces="true"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!doctype html>
<html lang="en">
<head>
<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">

<link rel="stylesheet" href="/static/css/bootstrap.css">
<link rel="stylesheet" href="/static/css/app.css">

<link rel="shortcut icon" href="/static/icons8-google-24.ico"
	type="image/x-icon" />
<title>${title}</title>
</head>
<body>



	<nav class="navbar navbar-light bg-light my-header-class">
		<a class="navbar-brand">WEBTESTER</a>
		<nav class="nav nav-pills nav-fill">
			<c:if test="${not empty CURRENT_ACCOUNT}">
				<a class="nav-item nav-link disabled" href="#">Hello,
					${CURRENT_ACCOUNT.firstName }</a>
				<a class="nav-item nav-link" href="/logout" tabindex="-1"
					aria-disabled="true">Logout</a>

			</c:if>
		</nav>
	</nav>



	<div class="container" style="min-height: 500px">
		<c:if test="${not empty SUCCESS_MESSAGE}">
			<div class="alert alert-success alert-dismissible fade show"
				role="alert">
				${SUCCESS_MESSAGE}
				<button type="button" class="close" data-dismiss="alert"
					aria-label="Close">
					<span aria-hidden="true">&times;</span>
				</button>
			</div>
		</c:if>
		<c:if test="${not empty ERROR_MESSAGE}">
			<div class="alert alert-danger alert-dismissible fade show"
				role="alert">
				${ERROR_MESSAGE}
				<button type="button" class="close" data-dismiss="alert"
					aria-label="Close">
					<span aria-hidden="true">&times;</span>
				</button>
			</div>
		</c:if>
		<jsp:include page="${currentPage}" />
	</div>
	<footer> </footer>
	<script src="/static/js/popper.js"></script>
	<script src="/static/js/jquery-3.3.1.js"></script>
	<script src="/static/js/bootstrap.js"></script>
	<script src="/static/js/app.js"></script>
</body>

</html>