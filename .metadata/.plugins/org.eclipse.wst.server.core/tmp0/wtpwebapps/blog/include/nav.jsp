<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
<!-- Required meta tags -->
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
<link rel="icon" href="/blog/img/favicon.png" type="image/png">
<title>Juney's Blog</title>
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
	<!--================Header Menu Area =================-->
	<header class="header_area">
		<div class="main_menu">
			<nav class="navbar navbar-expand-lg navbar-light">
				<div class="container box_1620">
					<!-- Brand and toggle get grouped for better mobile display -->
					<a class="navbar-brand logo_h" href="#"><img src="/blog/img/logo.png" alt=""></a>
					<button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false"
						aria-label="Toggle navigation">
						<span class="icon-bar"></span> <span class="icon-bar"></span> <span class="icon-bar"></span>
					</button>
					<!-- Collect the nav links, forms, and other content for toggling -->
					<div class="collapse navbar-collapse offset" id="navbarSupportedContent">
						<ul class="nav navbar-nav menu_nav" id="mainUl">
							<li class="nav-item active"><a class="nav-link" href="/blog/index.jsp">Home</a></li>
							<li class="nav-item"><a class="nav-link" href="/blog/board/write.jsp">Posting</a></li>
							<%-- <li class="nav-item"><a class="nav-link" href="/blog/user/join.jsp">Join</a></li> --%>

							<%-- <c:choose>
								<c:when test="${empty sessionScope.username}">
									<li class="nav-item">
										<a class="nav-link" href="/blog/user/login.jsp">Login</a>
									</li>	
								</c:when>
								<c:otherwise>
									<li class="nav-item">
										<a class="nav-link" href="/blog/user?cmd=logout">Logout</a>
									</li>
								</c:otherwise>
							</c:choose> --%>

						</ul>
						<ul class="nav navbar-nav navbar-right header_social ml-auto">
							<c:choose>
								<c:when test="${empty sessionScope.user}"></c:when>
								<c:otherwise>
								<a href="/blog/user/userProfileForm.jsp"><img src="${sessionScope.user.userProfile}" style="height: 40px; border-radius: 100%; width: 40px;" /></a>
								</c:otherwise>
								
							</c:choose>
						</ul>
					</div>
				</div>
			</nav>
			<script>
				const mainUl = document.querySelector("#mainUl");
				const id = "<c:out value='${sessionScope.user}'/>";
				const li1 = document.createElement("li");
				const a1 = document.createElement("a");
				const li2 = document.createElement("li");
				const a2 = document.createElement("a");
				console.log(id);
				if (id === null || id === "") {
					a1.innerText = "Join";
					a1.href = "/blog/user/join.jsp";
					a2.innerText = "Login";
					a2.href = "/blog/user/login.jsp";
				} else {
					a1.innerText = "Profile";
					a1.href = "/blog/user/update.jsp";
					a2.innerText = "Logout";
					a2.href = "/blog/user?cmd=logout";
				}
				a1.classList.add("nav-link");
				li1.classList.add("nav-item");
				li1.appendChild(a1);
				mainUl.appendChild(li1);
				a2.classList.add("nav-link");
				li2.classList.add("nav-item");
				li2.appendChild(a2);
				mainUl.appendChild(li2);
			</script>

		</div>
	</header>

</body>
</html>