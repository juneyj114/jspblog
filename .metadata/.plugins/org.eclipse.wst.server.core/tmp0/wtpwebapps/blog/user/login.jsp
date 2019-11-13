<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<html>
<%@ include file="/include/nav.jsp"%>

<!--================Contact Area =================-->
<section class="contact_area">
	<div class="container">
		<div class="row">
			<div class="col-lg-2"></div>
			<div class="col-lg-8">
				<form class="row contact_form" action="/blog/user?cmd=login" method="post">
					<div class="col-md-12">
						<div class="form-group">
							<c:choose>
								<c:when test="${empty cookie.username.value}">
									<input type="text" class="form-control" id="username" name="username" placeholder="아이디를 입력하세요">
								</c:when>
								<c:otherwise>
									<input type="text" class="form-control" id="username" name="username" placeholder="아이디를 입력하세요" value="${cookie.username.value}">
								</c:otherwise>
							</c:choose>
							
						</div>
					</div>
					<div class="col-md-12">
						<div class="form-group">
							<input type="password" class="form-control" id="password" name="password" placeholder="비밀번호를 입력하세요">
						</div>
					</div>
					<div class="custom-control custom-checkbox col-md-12 text-right">
						<input type="checkbox" class="custom-control-input" id="customCheck" name="rememberMe"> <label class="custom-control-label" for="customCheck"> Remember me </label>
					</div>
					<div class="col-md-12 text-right">
						<button type="submit" value="submit" class="btn submit_btn">Login</button>
					</div>
				</form>
			</div>
			<div class="col-lg-2"></div>
		</div>
	</div>
</section>
<!--================Contact Area =================-->

<%@ include file="/include/footer.jsp"%>
</html>