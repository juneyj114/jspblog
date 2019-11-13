<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<div id="ImageContainer">
      <form
        action="uploadAction.jsp"
        method="POST"
        enctype="multipart/form-data"
      >
        username : <input type="text" name="username" /><br />
        image:
        <input
          type="file"
          name="userProfile"
          id="img__input"
        /><br />
        <input type="submit" value="submit" />
      </form>
    </div>
    <script>
    const imagePath = document.querySelector("#img__input");
    imagePath.addEventListener("change", event => {
      const f = event.target.files[0];
      const reader = new FileReader();
      reader.onload = e => {
        const {
          target: { result }
        } = e;
        console.log(result.length);
        const imageContainer = document.querySelector("#ImageContainer");
        const image = document.createElement("IMG");
        image.setAttribute("src", result);
        imageContainer.append(image);
      };
      reader.readAsDataURL(f);
    });
    </script>
</body>
</html>