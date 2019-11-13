<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
  <head>
    <meta charset="UTF-8" />
    <title>Jquery</title>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
    <script>
      $(document).ready(() => {
        $.ajax("/blog/AjaxTest3", {
          type: "POST",
          dataType: "text",
          contentType: "text/plain; charset=UTF-8",
          data: "Hello"
        }).done(data => {
          $("#demo").text(data);
        });
      });

      function send() {
        const userForm = $("#user").serialize();
        console.log(userForm);
        $.ajax({
          type: "POST",
          url: "/blog/AjaxTest4",
          data: userForm
        })
          .done(data => {
            console.log(data);
          })
          .fail();
      }
    </script>
  </head>
  <body>
    <form action="" method="post" id="user">
      <input type="text" name="username" id="" value="cos" /><br />
      <input type="text" name="password" id="" value="1234" /><br />
      <input type="button" value="Submit" onclick="send()" />
    </form>
    <div id="demo"></div>
  </body>
</html>


