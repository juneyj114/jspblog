<%@page import="com.cos.dao.UserDAO"%>
<%@page import="java.io.PrintWriter"%>
<%@page import="com.cos.util.SHA256"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%
	// code값 받기
	String code = request.getParameter("code");
	System.out.println(code);

	// 보낸 code와 받은 code 비교
	boolean rightCode = SHA256.getEncrypt("acto2002@naver.com", "cos").equals(code);
	PrintWriter script = response.getWriter();
	if (rightCode) {
		// DB에 칼럼 emailCheck(Number) 1 = 인증, 0 = 미인증 update해주기	
		UserDAO userDao = new UserDAO();
		int result = userDao.updateEmailValid("acto2002@naver.com");
		System.out.println(result);
		if (result != 0) {
			script.println("<script>");
			script.println("alert('이메일 인증에 성공하였습니다.')");
			script.println("location.href='/blog/index.jsp'");
			script.println("</script>");
		} else {
			script.println("<script>");
			script.println("alert('이메일 인증을 실패하였습니다.')");
			script.println("location.href='/blog/index.jsp'");
			script.println("</script>");
		}

	} else {
		script.println("<script>");
		script.println("alert('이메일 인증을 실패하였습니다.')");
		script.println("location.href='/blog/index.jsp'");
		script.println("</script>");
	}

	// 인증 완료 로그인 페이지 이동

	// 미인증 error 페이지 이동
%>