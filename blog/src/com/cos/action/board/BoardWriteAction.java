package com.cos.action.board;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.cos.action.Action;
import com.cos.dao.BoardDAO;
import com.cos.model.Board;
import com.cos.model.User;
import com.cos.util.Script;

public class BoardWriteAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String title = request.getParameter("title");
		String content = request.getParameter("content");
		
		// content 안의 youtube 주소 파싱해서 iframe 집어넣기.
		// youtube 주소 중 첫번째를 previewImage로 사용.
		
		HttpSession session = request.getSession();
		User user = (User)session.getAttribute("user");
		
		Board board = new Board();
		System.out.println(user.getId());
		board.setUserId(user.getId());
		board.setTitle(title);
		board.setContent(content);
			
		BoardDAO dao = new BoardDAO();
		int result = dao.save(board);
		
		if(result == 1) {
			response.sendRedirect("/blog/index.jsp");
		} else {
			Script.back(response);
		}
	}

}
