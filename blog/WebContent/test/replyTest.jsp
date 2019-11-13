<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
  <head>
    <meta charset="UTF-8" />
    <title>Insert title here</title>
  </head>
  <body>
    <button onclick="send()">전송하기</button>
    <script>
      const replyJS = {
        id: null,
        boardId: 5,
        userId: 3,
        content: "Hello",
        createDate: null
      };

      async function send() {
        const replyStr = JSON.stringify(replyJS);
        const response = await fetch("/blog/test/reply", {
          method: "POST",
          body: replyStr,
          headers: {
            "Content-type": "application/json; charset=UTF-8"
          }
        });
        const responseText = await response.text();
        console.log(responseText);
      }
    </script>
  </body>
</html>
