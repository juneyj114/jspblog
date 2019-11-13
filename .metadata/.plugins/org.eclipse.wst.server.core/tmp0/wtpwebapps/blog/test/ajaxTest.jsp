<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>Ajax 테스트</h1>
	<hr />
	<div>
		<h2 id="demo">0</h2>
	</div>
	<div>
		<h2 id="demo2">1</h2>
	</div>
	<button type="button" onclick="loadDoc()">Change Count</button>
	<script>
		const reply = {
			id : null,
			boardId : 20,
			userId : 3,
			content : 'content',
			createDate : null
		};
		const replyString = JSON.stringify(reply);
		
		function loadDoc() {
			var xhttp = new XMLHttpRequest();
			xhttp.onreadystatechange = function() {
				if (this.readyState == 4 && this.status == 200) {
					const parsedData = JSON.parse(this.responseText);
					console.log(parsedData);
					document.querySelector("#demo").innerText = "name:"+parsedData.name+" sal:"+parsedData.sal;
					document.querySelector("#demo2").innerText = `name:${parsedData.name} sal:${parsedData.sal}`;
				}
			};
			xhttp.open("POST", "http://localhost:8000/blog/AjaxTest", true);
			xhttp.setRequestHeader("Content-type", "application/json");
			xhttp.send(replyString);
		}
	</script>

</body>
</html>