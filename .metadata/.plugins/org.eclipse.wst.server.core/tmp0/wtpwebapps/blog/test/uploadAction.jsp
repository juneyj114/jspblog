<%@page import="com.oreilly.servlet.multipart.DefaultFileRenamePolicy"%>
<%@page import="com.oreilly.servlet.MultipartRequest"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%
	String path = request.getRealPath("media");

 	MultipartRequest multi = new MultipartRequest(
			request,
			path,
			1024*1024*2, //2MB
			"UTF-8",
			new DefaultFileRenamePolicy() // 동일한 파일명이 들어오면 숫자 붙임.
			);
 	String username = multi.getParameter("username");
 	String filename = multi.getFilesystemName("userProfile");
 	String originFilename = multi.getOriginalFileName("userProfile");
 	String contextPath = getServletContext().getContextPath();
 	String downloadPath = getServletContext().getRealPath("media");
 	
 	String filepath = "/blog/media/"+filename;
 	
%>
<%=path %>
<%=username %>
<%=filename %>
<%=originFilename %>
contextpath:<%=contextPath %>
downloadpath:<%=downloadPath %>
<image src="<%=filepath %>" />
</body>
</html>