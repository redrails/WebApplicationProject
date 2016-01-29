<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1" />
<link href="https://cdnjs.cloudflare.com/ajax/libs/twitter-bootstrap/4.0.0-alpha/css/bootstrap.min.css" rel="stylesheet" type="text/css">
<title>Login</title>
</head>


<c:if test="${logout == true}">
	<b class="logout">You have been logged out.</b>
</c:if>

<div class="container">
    <div class="row">
		<div class="span12">
			<c:url value="/login" var="loginUrl"/>
			<form action="${loginUrl}" method="post" modelAttribute="user"  class="form-horizontal">
			  <fieldset><br>
			    <div id="legend">
			      <legend class="">Login</legend>
			    </div>
			    <div class="control-group">
			      <!-- Username -->
			      <label class="control-label"  for="username">Username</label>
			      <div class="controls">
			        <input type="text" id="username" name="username" placeholder="" class="input-xlarge" size="50">
			      </div>
			    </div>
			    <div class="control-group">
			      <!-- Password-->
			      <label class="control-label" for="password">Password</label>
			      <div class="controls">
			        <input type="password" id="password" name="password" placeholder="" class="input-xlarge" size="50">
			      </div>
			    </div>
			    <input type="hidden"
				name="${_csrf.parameterName}"
				value="${_csrf.token}"/>
			    <div class="control-group"><br>
			      <!-- Button -->
			      <div class="controls">
			        <p><button class="btn btn-success" type="submit">Login</button>
			        <c:if test="${error == true}">
						&nbsp;&nbsp;&nbsp; <font color="red">Invalid username or password</font>
					</c:if></p>
			      </div>
			    </div>
			  </fieldset>
			</form>
		</div>
	</div>
</div>

</body>
</html>