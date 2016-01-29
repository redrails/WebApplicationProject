<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<!DOCTYPE HTML>
<html lang="en">
<head> 
    <title>Complete Requests</title> 
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
    <link href="styles/bootstrap.min.css" rel="stylesheet" type="text/css">
<c:if test="${nomore == true}">
<script> window.alert("No more pending"); </script>
<meta http-equiv="refresh" content="0;URL='/'" /> 
</c:if>
</head>
<body>
<div class="container">

	<h1>Complete Request</h1>
	<hr />
	<table class="table table-bordered">
	<tr>
	<th>
	<form:form action="/completeRequest" method="post" modelAttribute="reqComp">
	<p>Assigned problems:
	<form:select path="problem" id="problem">
	<option></option>
	 <c:forEach var="arq" items="${nextAss}">
	 <option value="${arq.problem}"><c:out value="${arq.problem}" /></option>
	 </c:forEach>
	</form:select> 
	
	</p>	
	<p>Completion Date: <form:input path="completion" name="completion" type="text" placeholder="Enter date" /></p>
	<br>	
	</th>
	<tr>
	<th colspan=2>
	<input class="btn btn-success" style="float: right;" type="submit" name="submit" value="Complete">
	</form:form>
	<form action="${pageContext.request.contextPath}/"><input class="btn btn-danger" type="submit" name="cancel" value="Cancel"></form>	
	</th>
	</tr>
	</tr>
	</table>
	</div>
</body>
</html>