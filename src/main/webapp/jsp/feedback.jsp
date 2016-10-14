<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script type="text/javascript"
	src="main/webapp/jsp/jquery.min.js"></script>
<script type="text/javascript">
$(function(){
    $("#send").click(function(){
    	var jsondata = $("#jsondata").val();
    	var jsonobj = JSON.parse(jsondata)
    	
    	var callback = function (data) {
    		$("#result").html(JSON.stringify(data))
    	}
    	
		$.postJSON('http://localhost:8080/springrestexample/feedback', jsonobj, callback)

		});
	})

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
	JSON对象
	<br>
	<textarea id="jsondata" cols="60" rows="5">
	</textarea><br>

	<button id="send">POST</button><br>

	<font color="red" id="result"></font>
</body>
</html>