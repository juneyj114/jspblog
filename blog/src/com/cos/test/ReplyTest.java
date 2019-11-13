package com.cos.test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.cos.model.Comment;
import com.google.gson.Gson;

@WebServlet("/test/reply")
public class ReplyTest extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public ReplyTest() {
    	super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/plain; charset=UTF-8"); //MIME 타입
		
		// 1. JSON 데이터 받기 & sout 출력
		BufferedReader in = request.getReader();
		String jsonStr = in.readLine();
		System.out.println(jsonStr);
		// 2. JAVA 오브젝트로 변환 & sout 출력
		Gson gson = new Gson();
		Comment reply = gson.fromJson(jsonStr, Comment.class);
			
		System.out.println(reply.getId());
		System.out.println(reply.getBoardId());
		System.out.println(reply.getUserId());
		System.out.println(reply.getContent());
		System.out.println(reply.getCreateDate());
		
		PrintWriter out = response.getWriter();
		out.print("Hello");
		out.flush();
	}

}