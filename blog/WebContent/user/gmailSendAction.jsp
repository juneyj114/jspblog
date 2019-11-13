<%@page import="javax.mail.Message"%>
<%@page import="javax.mail.internet.InternetAddress"%>
<%@page import="java.io.PrintWriter"%>
<%@page import="javax.mail.Transport"%>
<%@page import="javax.mail.Address"%>
<%@page import="javax.mail.internet.MimeMessage"%>
<%@page import="javax.mail.Session"%>
<%@page import="com.cos.util.Gmail"%>
<%@page import="javax.mail.Authenticator"%>
<%@page import="java.util.Properties"%>
<%@page import="com.cos.util.SHA256"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<% 
	// 메일 전송
	String to = request.getParameter("email"); // (1) 이메일 받기
 	String from = "acto2001@gmail.com";
 	String code = SHA256.getEncrypt(to, "cos"); // (2) code hash하기
 	
 	// (3) 사용자에게 보낼 메시지
 	String subject = "이메일을 인증해주세요.";
 	StringBuffer sb = new StringBuffer();
 	sb.append("다음 링크에 접속하여 이메일 인증을 진행해주세요.");
 	sb.append("<a href = 'http://localhost:8000/blog/user/gmailCheckAction.jsp?code="+code+"'>");
 	sb.append("이메일 인증하기</a>");
 	String content = sb.toString();
 	
 	// 설정 값
 	Properties p = new Properties();
 	p.put("mail.smtp.user", from); // (4) from
	p.put("mail.smtp.host", "smtp.googlemail.com");
	p.put("mail.smtp.port", "465"); //TLS 587, SSL 465
	p.put("mail.smtp.starttls.enable", "true");
	p.put("mail.smtp.auth", "true");
	p.put("mail.smtp.debug", "true");
	p.put("mail.smtp.socketFactory.port", "465"); 
	p.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
	p.put("mail.smtp.sockerFactory.fallback", "false");
 	
	// 이메일 전송
	try {
		Authenticator auth = new Gmail(); // (5) 내가 설정한 아이디, 비번 들고오기
		Session ses = Session.getInstance(p, auth);
		ses.setDebug(true);
		MimeMessage msg = new MimeMessage(ses);
		msg.setSubject(subject);
		Address fromAddr = new InternetAddress(from); // gmail 메일주소
		msg.setFrom(fromAddr);
		Address toAddr = new InternetAddress(to); // naver 메일주소
		msg.addRecipient(Message.RecipientType.TO, toAddr);
		msg.setContent(content, "text/html; charset=UTF8");
		Transport.send(msg);

		session.setAttribute("toEmail", to); // 세션에 email주소 저장
		// 정상 = 가만히. 비정상 = Back()
	} catch (Exception e) {
		PrintWriter script = response.getWriter();
		script.println("<script>");
		script.println("alert('이메일 인증 오류')");
		script.println("history.back();");
		script.println("</script>");
	}
	
	
 	
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>인증메일이 전송되었습니다. 이메일을 확인해주세요.</h1>
</body>
</html>