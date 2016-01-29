<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE HTML>
<html lang="en">
<head> 
    <title>Summary of Requests</title> 
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
    <link href="styles/bootstrap.min.css" rel="stylesheet" type="text/css">
</head>
<body>
<div class="container">

	<h1>Summary of Requests</h1>
	<hr />	
	<table class="table table-hover">
		<thead>
			<tr >
				<th>ID</th>
				<th>Problem</th>
				<th>Version</th>				
				<th>Solution</th>
				<th>Deadline</th>
				<th>Completed</th>
				<th>Type</th>
				<th>Status</th>
				<th>Developer</th>
				<th>Priority</th>
			</tr>
		</thead>
		
			<c:forEach var="request" items="${listRequests}">
			<tr>
			<th><c:out value="${request.id}" /></th>
			<th><c:out value="${request.problem}" /></th>
			<th><c:out value="${request.version}" /></th>
			<th><c:out value="${request.solution}" /></th>
			<th><c:out value="${request.deadline}" /></th>
			<th><c:out value="${request.completion}" /></th>
			<th><c:out value="${request.reqType}" /></th>
			<th><c:out value="${request.status}" /></th>
			<th><c:out value="${request.developer}" /></th>
			<th><c:out value="${request.priority}" /></th>
			</tr>
			</c:forEach>
			
	</table>
	<form action="${pageContext.request.contextPath}/"><input class="btn btn-success" type="submit" name="cancel" value="Return"></form>
	
	</div>
</body>
</html>