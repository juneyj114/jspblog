<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<button onclick="sendPost3()">Post 요청</button>
<div id = "demo"></div>
<script>
let postNum2 = 0;
let postNum3 = 0;
let sum = 0;

function sendPost2() {
  var xhttp = new XMLHttpRequest();
  const promise = new Promise((resolve, reject) => {
    xhttp.onreadystatechange = function() {
      if (this.readyState == 4 && this.status == 200) {
        resolve(this.responseText);
        console.log("postNum2: " + this.responseText);
      }
    };
  });
  xhttp.open("POST", "http://localhost:8000/blog/AjaxTest2", true);
  xhttp.setRequestHeader("Content-type", "text/plain");
  xhttp.send();

  return promise;
}

async function sendPost3() {
	postNum2 = await sendPost2();
  var xhttp = new XMLHttpRequest();
  xhttp.onreadystatechange = function() {
    if (this.readyState == 4 && this.status == 200) {
      postNum3 = this.responseText;
      console.log("postNum3: " + postNum3);
      console.log(parseInt(postNum2) + parseInt(postNum3));
    }
  };
  xhttp.open("POST", "http://localhost:8000/blog/AjaxTest3", true);
  xhttp.setRequestHeader("Content-type", "text/plain");
  xhttp.send();
}

</script>
</body>
</html>