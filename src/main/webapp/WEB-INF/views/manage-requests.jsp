<!DOCTYPE HTML>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page session="false" %>
<html>
<head>
        <script src="webjars/jquery/2.0.3/jquery.min.js"></script>
        <script src="webjars/handsontable/0.17.0/handsontable.full.js"></script>
            <title>Manage Requests</title> 
    	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
    	<link href="styles/bootstrap.min.css" rel="stylesheet" type="text/css">
        <link rel="stylesheet" media="screen" 
            href="/webjars/handsontable/0.17.0/handsontable.full.css">
            <html>
	<meta name="_csrf" content="${_csrf.token}"/>
	<!-- default header name is X-CSRF-TOKEN -->
	<meta name="_csrf_header" content="${_csrf.headerName}"/>
	<!-- ... -->
</head>
<body>
<div class="container">

<h1>Edit change requests</h1>
<hr /> 
    <div id="dataTable" class="table table-hover"></div>
    <script>
    $(function () {
var token = $("meta[name='_csrf']").attr("content");
var header = $("meta[name='_csrf_header']").attr("content");
$(document).ajaxSend(function(e, xhr, options) {
	xhr.setRequestHeader(header, token);
});
});
        var data = ${jsonProducts}; 
        var ht = new Handsontable(dataTable, {
            data: data,
            startRows: data.length,
            colHeaders: true,
               columns: [
			      {data: 'id'},
	  		      {data: 'status'},
			      {data: 'problem'},
			      {data: 'solution'},
			      {data: 'version.version'},
			      {data: 'deadline'},
			      {data: 'completion'},
			      {data: 'reqType'},
			      {data: 'developer'},
			      {data: 'priority'},
			      {data: 'assessment'}
    			],
            colHeaders: ["ID", 
            			"Status", 
            			"Problem", 
            			"Solution",
            			"Version", 
            			"Deadline", 
            			"Completion", 
            			"Request Type",
            			"Developer",
            			"Priority",
            			"Assessment"
            			],
            
            afterChange: function(change,source){
                var row = this.getData();
                var selected = row[change[0][0]];
                var myJsonString = selected;
                postUpdate(myJsonString);
            }   
        });
        function postUpdate(request) {
            var request = $.ajax({
                type: "POST",
                contentType : 'application/json; charset=utf-8',
                dataType : 'json',
                url: "/sendManaged",
                data: JSON.stringify(request), 
            });
        }
    </script>
<hr>
	<form action="${pageContext.request.contextPath}/"><input class="btn btn-success" type="submit" name="cancel" value="Return"></form>

</body>
</html>