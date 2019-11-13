package com.cos.action.board;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.cos.action.Action;
import com.cos.dao.BoardDAO;
import com.cos.dao.CommentDAO;
import com.cos.model.Board;
import com.cos.model.Comment;
import com.cos.util.Script;
import com.cos.util.Utils;

public class BoardDetailAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		if(request.getParameter("id") == null || request.getParameter("id").equals("")) return;
		
		int id = Integer.parseInt(request.getParameter("id"));
		
		BoardDAO dao = new BoardDAO();
		Board board = dao.findById(id);
		
		CommentDAO commentDao = new CommentDAO();
		
		List<Comment> comments = commentDao.findByBoardId(id);
		
		if(board != null) {
			// 조회수 증가 - 쿠키를 하루동안 저장해서 있으면 증가 방지
			int result = dao.increaseReadCount(id);
			if(result == 1) {
				// 유튜브 주소 파싱
				Utils.setPreviewYoutube(board);
				// board를 request에 담고 dispatcher로 이동
				request.setAttribute("board", board);
				request.setAttribute("comments", comments);
				RequestDispatcher dis = request.getRequestDispatcher("board/detail.jsp");
				dis.forward(request, response);
			} else {
				Script.back(response);
			}
			
		} else {
			Script.back(response);
		}
		

	}

}
