<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>Fetch API 사용하기 - promise</h1>
<button onclick="getNum1()">클릭!</button>

<script>
let num1 = 0;
let num2 = 0;
let sum = 0;

function getNum1() {
  fetch("http://localhost:8000/blog/AjaxTest2", {
    method: "POST",
    body: "Hello" //json, object, ...
  })
    .then(data => data.text())
    .then(data => {
      num1 = data;
      getNum2();
    });
}

function getNum2() {
  fetch("http://localhost:8000/blog/AjaxTest3", {
    method: "POST"
  })
    .then(data => data.text())
    .then(data => {
      num2 = data;
      sum = parseInt(num1) + parseInt(num2);
      console.log("sum : " + sum);
    });
}
</script>
</body>
</html>