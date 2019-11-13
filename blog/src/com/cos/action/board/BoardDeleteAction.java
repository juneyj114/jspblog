package com.cos.action.board;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.cos.action.Action;
import com.cos.dao.BoardDAO;
import com.cos.util.Script;

public class BoardDeleteAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));
		
		BoardDAO dao = new BoardDAO();
		int result = dao.delete(id);
		if(result == 1) {
			response.sendRedirect("/blog/board?cmd=list&page=1");
		} else if(result == 0){
			System.out.println("이미 삭제된 글입니다.");
			Script.back(response);
		} else {
			System.out.println("에러");
			Script.back(response);
		}

	}

}
