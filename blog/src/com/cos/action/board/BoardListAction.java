package com.cos.action.board;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.cos.action.Action;
import com.cos.dao.BoardDAO;
import com.cos.model.Board;
import com.cos.util.Utils;

public class BoardListAction implements Action {

	private final String TAG = "BoardListAction : ";
	
	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		if(request.getParameter("page") == null) return;
		int page = Integer.parseInt(request.getParameter("page"));
		if(page <= 0) {
			page = 1;
		}
		BoardDAO bDao = new BoardDAO();
		
		List<Board> boards;
		if(request.getParameter("search") == null || request.getParameter("search").equals("")) {
			boards = bDao.findAll(page);
		} else {
			String search = request.getParameter("search");
			boards = bDao.findBySearch(page, search);
			
		}
		List<Board> hotBoards = bDao.findOrderByReadCountDesc();
		Utils.getpreviewImage(boards);
		Utils.getpreviewImage(hotBoards);
		Utils.getPreviewCotent(boards);
		request.setAttribute("boards", boards);
		request.setAttribute("hotBoards", hotBoards);
		RequestDispatcher dis = request.getRequestDispatcher("/board/list.jsp");
		dis.forward(request, response);

	}

}
