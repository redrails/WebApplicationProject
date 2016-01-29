<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1" />
<title>Successfully logged in!</title>
</head>
<body>
<meta http-equiv="refresh" content="0;URL='/'" /> 
<input type="hidden"                         
			name="${_csrf.parameterName}"
			value="${_csrf.token}"/>
</body>
</html>