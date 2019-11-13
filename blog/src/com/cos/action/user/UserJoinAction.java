package com.cos.action.user;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.cos.action.Action;
import com.cos.dao.UserDAO;
import com.cos.model.User;
import com.cos.util.SHA256;

public class UserJoinAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 목적: form태그에 있는 name값을 받아서 DB에 insert하고나서 페이지 이동
		
		// null값 처리하기(나중에), 유효성검사(공백, 특문 등) 
		String username = request.getParameter("username");
		String rawPassword = request.getParameter("password");
		String email = request.getParameter("email");
		String password = SHA256.getEncrypt(rawPassword, "cos");
		String addr = request.getParameter("address");
		
		User user = new User();
		user.setUsername(username);
		user.setPassword(password); // Encryption 하기
		user.setEmail(email);
		user.setAddr(addr);
		System.out.println(user.getAddr());
		
		//DAO 연결하기
		UserDAO dao = new UserDAO();
//		int result = dao.save(user);
		dao.save(user); // 명령 - 상태변경
		int result = dao.result(); // 쿼리 - 상태변경 없음
		if(result == 1) {
			response.sendRedirect("/blog/user/gmailSendAction.jsp?email="+email);
		} else {
			PrintWriter out = response.getWriter();
			out.println("<script>");
			out.println("alert('WTF');");
			out.println("history.back();");
			out.println("</script>");
			out.flush();
		}

	}

}
