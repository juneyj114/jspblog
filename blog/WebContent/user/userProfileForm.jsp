<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<html>
<%@ include file="/include/nav.jsp"%>

<!--================Contact Area =================-->
<section class="contact_area">
	<div class="container">
		<div class="row">
			<div class="col-lg-2"></div>
			<div class="col-lg-8">
				<div id="imageContainer" style="margin-left:300px;">
					<form class="row contact_form" action="/blog/user?cmd=profile" method="post" enctype="multipart/form-data">
						<input type="text" name="username" value="${sessionScope.user.username }" hidden />
						<div class="col-md-12">
							<div class="form-group">
								<label for="img__input" class="blog_btn" style="margin-top: 20px;">이미지 선택</label> <input type="file" id="img__input" class="form-control" name="userProfile" hidden readonly>
							</div>
						</div>
						<div class="col-md-12 text-right">
							<button type="submit" value="submit" class="btn submit_btn">Update</button>
						</div>
					</form>
				</div>
			</div>
			<div class="col-lg-2"></div>
		</div>
	</div>
</section>
<!--================Contact Area =================-->
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
          imageContainer.prepend(image);
        };
        reader.readAsDataURL(f);
      });
    </script>
<%@ include file="/include/footer.jsp"%>
</html>