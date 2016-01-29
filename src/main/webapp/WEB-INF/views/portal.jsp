<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE HTML>
<html lang="en">
<head> 
    <title>Control Panel</title> 
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
    <link href="styles/bootstrap.min.css" rel="stylesheet" type="text/css">
    <style type="text/css">
		th, td {
		    padding: 5px;
		    text-align: left;
		}
	</style>
</head>
<body>
<div class="container">
	<c:url value="/logout" var="logoutUrl"/>
	
	<c:if test="${user_pm == true}">
		<h1>Project Manager View</h1>
		<hr />
		<p>You have successfully logged in as a project manager! </p>
		<p>Currently logged in as <b><c:out value="${username}" />.</p></b>
	<hr />
	<table>
  	<tr>
  	<th>

		<a href="${pageContext.request.contextPath}/evaluate-request"><button type="submit" class="btn btn-info">Assess Requests</button></a>
	</th>
	<th>

		<a href="${pageContext.request.contextPath}/showSummary"><button type="submit" class="btn btn-info">Show Summary</button></a>
	</th>
		<th>

		<a href="${pageContext.request.contextPath}/manage-requests"><button type="submit" class="btn btn-info">Manage Requests</button></a>
	</th>
	</c:if>
	<c:if test="${user_dev == true}">

		<h1>Developer View</h1>
		<hr />
		<p>You have successfully logged in as developer. </p>
		<p>Currently logged in as <b><c:out value="${username}" />.</p></b>
		
		<hr />
		<table>
	  	<tr>
	  	<th>

		<a href="${pageContext.request.contextPath}/new-request"><button type="submit" class="btn btn-info">New Request</button></a>
	</th>
	<th>

		<a href="${pageContext.request.contextPath}/complete-request"><button type="submit" class="btn btn-info">Complete Request</button></a>
	</th>
	</c:if>
	<th>
	<form action="${logoutUrl}" method="get">       
		<!--  input type="hidden"                        
			name="${_csrf.parameterName}"
			value="${_csrf.token}"/ -->
		<button type="submit" class="btn btn-info">Log out</button>
	</form>	
	</th>
	</tr>
	</table>
</div>
</body>
</html>