<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<!DOCTYPE HTML>
<html lang="en">
<head> 
    <title>Summary of Requests</title> 
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
    <link href="styles/bootstrap.min.css" rel="stylesheet" type="text/css">
</head>
<body>

<div class="container">

	<h1>Change Request Control Board</h1>
	<hr />
	<table class="table table-bordered">
	<tr>
	<th>
	<p>Version: <c:out value="${nextReq.version}" /></p>
	<p>Problem: <c:out value="${nextReq.problem}" /></p>
	<p>Solution: <c:out value="${nextReq.solution}" /></p>
	</th>
	</tr>
	<tr>
	<th>
	<form:form action="/evalRequest" method="post" modelAttribute="reqEval">
		Accept <form:radiobutton path="status" id="status" value="accepted" /><br>
		Reject <form:radiobutton path="status" id="status" value="rejected" />
		<br><br>
				<p> Priority: 
		<form:select path="priority">
		<option value=""></option>
		<option value="low">Low</option>
		<option value="medium">Medium</option>
		<option value="high">High</option>
		</form:select>
		</p>
	</th>
	<th>
	<p>Deadline: <form:input type="text" path="deadline" name="deadline" placeholder="Enter deadline" /></p>
	<p>Developer:
	 <form:select path="developer">
	 <option value=""></option>
	 <c:forEach var="usr" items="${userList}">
	 <option value="${usr.login}"><c:out value="${usr.login}" /></option>
	 </c:forEach>
	</form:select> 
	</p>
	<form:input path="problem" name = "problem" type="hidden" value="${nextReq.problem}" />
	<p>Assessment: <form:input type="text" path="assessment" name="assessment" placeholder="Enter assessment" /></p>
	<br>	
	</th>
	<tr>
	<th colspan=2>
	<input class="btn btn-success" style="float: right;" type="submit" name="submit" value="Submit" />
	</form:form>
	<form action="${pageContext.request.contextPath}/"><input class="btn btn-danger" type="submit" name="cancel" value="Cancel"></form>
	
	</th>
	</tr>
	</tr>
	</table>
	</div>
</body>
</html>