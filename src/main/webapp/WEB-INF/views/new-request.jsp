<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE HTML>
<html lang="en">
<head> 
    <title>New Request</title> 
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
    <link href="styles/bootstrap.min.css" rel="stylesheet" type="text/css">
</head>
<body>
<div class="container">

	<h1>Make Request</h1>
	<hr />
	<table class="table table-bordered">
	<tr>
	<form:form action="/sendReq" method="post" modelAttribute="reqModel">
	<th>
		Fault <form:radiobutton path="reqType" name="reqType" id="reqType" value="fault" /> <br>
		New Feature <form:radiobutton path="reqType" name="reqType" id="reqType" value="feature" /> <br><br>
	</th>
	<th>
	<p>Version:
	<form:select path="version" id="version">
	<option value=""></option>
	 <c:forEach var="ver" items="${verList}">
	 <option value="${ver.version}"><c:out value="${ver.version}" /></option>
	 </c:forEach>
	</form:select> 
	</p>
	<p>Problem: <form:input type="text" path="problem" id="problem" placeholder="Enter problem" /></p>
	<p>Solution: <form:input type="text" path="solution" id="solution" placeholder="Enter solution" /></p>
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