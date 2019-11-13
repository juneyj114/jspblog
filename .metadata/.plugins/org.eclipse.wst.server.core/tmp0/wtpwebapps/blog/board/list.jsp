<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!doctype html>
<html lang="en">
<head>
<!-- Required meta tags -->
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
<link rel="icon" href="/blog/img/favicon.png" type="image/png">
<title>Opium Blog</title>
<!-- Bootstrap CSS -->
<link rel="stylesheet" href="/blog/css/bootstrap.css">
<link rel="stylesheet" href="/blog/vendors/linericon/style.css">
<link rel="stylesheet" href="/blog/css/font-awesome.min.css">
<link rel="stylesheet" href="/blog/vendors/owl-carousel/owl.carousel.min.css">
<link rel="stylesheet" href="/blog/vendors/lightbox/simpleLightbox.css">
<link rel="stylesheet" href="/blog/vendors/nice-select/css/nice-select.css">
<link rel="stylesheet" href="/blog/vendors/animate-css/animate.css">
<link rel="stylesheet" href="/blog/vendors/jquery-ui/jquery-ui.css">
<!-- main css -->
<link rel="stylesheet" href="/blog/css/style.css">
<link rel="stylesheet" href="/blog/css/responsive.css">
</head>
<body>

	<%@ include file="/include/nav.jsp"%>


	<!--================Blog Area =================-->
	<section class="blog_area">
		<div class="container">
			<div class="row">
				<div class="col-lg-8">
					<div class="blog_left_sidebar">
						<c:forEach var="board" items="${boards}">
							<article class="blog_style1">
								<div class="blog_img">
									<img class="img-fluid" src="${board.previewImage}" alt="" style="max-width: 100%; max-height: 400px; width: 770px;">
								</div>
								<div class="blog_text">
									<div class="blog_text_inner">
										<div class="cat">
											<a class="cat_btn" href="#">${ board.user.username }</a> <a href="#"><i class="fa fa-calendar" aria-hidden="true"></i> ${ board.createDate }</a> <a href="#"><i class="fa fa-comments-o" aria-hidden="true"></i>
												${ board.readCount }</a>
										</div>
										<a href="#"><h4>${ board.title }</h4></a>
										<p>${ board.content }</p>
										<a class="blog_btn" href="/blog/board?cmd=detail&id=${ board.id }">Read More</a>
									</div>
								</div>
							</article>
						</c:forEach>
						<!--  페이징하기 -->
						<nav class="blog-pagination justify-content-center d-flex">
							<ul class="pagination">
								<li class="page-item"><a href="/blog/board?cmd=list&page=${param.page - 1}" id="p" class="page-link" aria-label="Previous"> <span aria-hidden="true"> <span class="lnr lnr-chevron-left"></span>
									</span>
								</a></li>
								<li class="page-item"><a href="/blog/board?cmd=list&page=${param.page + 1}" id="n" class="page-link" aria-label="Next"> <span aria-hidden="true"> <span class="lnr lnr-chevron-right"></span>
									</span>
								</a></li>
							</ul>
						</nav>
					</div>
				</div>
				<div class="col-lg-4">
					<div class="blog_right_sidebar">
						<aside class="single_sidebar_widget search_widget">
							<div class="input-group">
								<form action="/blog/board?cmd=list&page=1" method="post">
								<input name = "search" type="text" class="form-control" placeholder="Search Posts"> <span class="input-group-btn">
									<button class="btn btn-default" type="submit">
										<i class="lnr lnr-magnifier"></i>
									</button>
								</span>
								</form>
							
							</div>
							<!-- /input-group -->
							<div class="br"></div>
						</aside>

						<aside class="single_sidebar_widget popular_post_widget">
							<h3 class="widget_title">Popular Posts</h3>
							
							<c:forEach var="board" items="${ hotBoards }">
							<div class="media post_item">
								<img src="${ board.previewImage }" alt="post" style="width: 30%">
								<div class="media-body">
									<a href="/blog/board?cmd=detail&id=${ board.id }"><h3>${ board.title }</h3></a>
									<p><fmt:formatDate value="${ board.createDate }" pattern="yyyy-MM-dd"/></p>
								</div>
							</div>
							</c:forEach>
							
							<div class="br"></div>
						</aside>


					</div>
				</div>
			</div>
		</div>
	</section>
	
	<!--================Blog Area =================-->
	<%@ include file="/include/footer.jsp"%>
	<script>
	const p = document.querySelector("#p");
	const n = document.querySelector("#n");
	const page = "<c:out value='${param.page}'/>";
	const search = "<c:out value='${param.search}'/>";
	console.log(search);
	const arr = "<c:out value='${boards}'/>";
    if(page > 1){
		p.href="/blog/board?cmd=list&page=${param.page - 1}&search=${param.search}"
    } else {
        p.href="#"
    }
	if(arr.length > 80){
        n.href="/blog/board?cmd=list&page=${param.page + 1}&search=${param.search}"
    } else {
        n.href="#"
    }
	
	
	</script>
</body>
</html>