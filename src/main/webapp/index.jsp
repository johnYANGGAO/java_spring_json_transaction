<%@ page language="java" import="java.util.*" pageEncoding="ISO-8859-1"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>pass json to server</title>
<script type="text/javascript"
	src="http://code.jquery.com/jquery-1.9.1.min.js"></script>
<script type="text/javascript">
$(function(){
    $("#send").click(function(){
      	var jsondata = $("#jsondata").val();
     	var jsonobj = JSON.parse(jsondata);
    	
    	    var callback = function (data) {
    		    $("#result").html(JSON.stringify(data));
    	    };
    	
		$.postJSON('<%=basePath%>feedback', jsonobj, callback);

		});
	});

	$.postJSON = function(url, data, callback) {
		return jQuery.ajax({
			'type' : 'POST',
			'url' : url,
			'contentType' : 'application/json',
			'data' : JSON.stringify(data),
			'dataType' : 'json',
			'success' : callback
		});
	};
</script>
</head>
<body>
	JSON object
	<br>
	<textarea id="jsondata" cols="60" rows="5">
	</textarea>
     <br></br>
	<button id="send">POST</button><br>
	<font color="blue" id="result"></font>
	<br></br>
</body>
</html>