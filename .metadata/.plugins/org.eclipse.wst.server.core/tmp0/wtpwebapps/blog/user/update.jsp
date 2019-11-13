<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<html>
<%@ include file="/include/nav.jsp"%>

<!--================Contact Area =================-->
<section class="contact_area">
	<div class="container">
		<div class="row">
			<div class="col-lg-2"></div>
			<div class="col-lg-8">
				<form class="row contact_form" action="/blog/user?&cmd=update" method="post" onsubmit="return validateCheck()">
				<input type="hidden" name="id" value="${sessionScope.user.id }"/>
					<div class="col-md-12">
						<div class="form-group">
							<input type="text" class="form-control" value="${sessionScope.user.username}" name="username" placeholder="아이디를 입력하세요" maxlength="20" readonly>
						</div>
					</div>
					<div class="col-md-12">
						<div class="form-group">
							<input type="password" class="form-control" id="password" name="password" placeholder="비밀번호를 입력하세요" required="required" maxlength="20">
						</div>
					</div>
					<div class="col-md-12">
						<div class="form-group">
							<input type="password" class="form-control" id="passwordCheck" name="passwordCheck" placeholder="동일한 비밀번호를 입력하세요" required="required" maxlength="20">
						</div>
					</div>
					<div class="col-md-12">
						<div class="form-group">
							<input type="email" class="form-control" value="${sessionScope.user.email}" name="email" placeholder="이메일을 입력하세요" maxlength="40" readonly>
						</div>
					</div>
					<!-- 도로명주소 -->
					<div class="col-md-12">
						<div class="form-group float-right">
							<a class="blog_btn" onclick={goPopup()}>주소 찾기</a>
						</div>
					</div>
					<div class="col-md-12">
						<div class="form-group">
							<input type="text" class="form-control" value="${sessionScope.user.addr}" placeholder="주소 찾기를 눌러 입력하세요" name="addr" id = "roadFullAddr" required="required" readonly>
						</div>
					</div>
					<div class="col-md-12 text-right">
						<button type="submit" value="submit" class="btn submit_btn">Update</button>
					</div>
				</form>
			</div>
			<div class="col-lg-2"></div>
		</div>
	</div>
</section>
<!--================Contact Area =================-->
<script src="/blog/js/pw.js"></script>
<script language="javascript">
// opener관련 오류가 발생하는 경우 아래 주석을 해지하고, 사용자의 도메인정보를 입력합니다. ("팝업API 호출 소스"도 동일하게 적용시켜야 합니다.)
//document.domain = "abc.go.kr";

function goPopup(){
	// 주소검색을 수행할 팝업 페이지를 호출합니다.
	// 호출된 페이지(jusopopup.jsp)에서 실제 주소검색URL(http://www.juso.go.kr/addrlink/addrLinkUrl.do)를 호출하게 됩니다.
	var pop = window.open("/blog/juso/jusoPopup.jsp","pop","width=570,height=420, scrollbars=yes, resizable=yes"); 
	 
}


function jusoCallBack(roadFullAddr){
		// 팝업페이지에서 주소입력한 정보를 받아서, 현 페이지에 정보를 등록합니다.
		const addr = document.querySelector('#roadFullAddr');
		addr.value = roadFullAddr;
}

</script>
<%@ include file="/include/footer.jsp"%>
</html>