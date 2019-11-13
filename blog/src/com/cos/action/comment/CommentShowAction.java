package com.cos.action.comment;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.cos.action.Action;
import com.cos.dao.CommentDAO;
import com.cos.model.Comment;
import com.cos.util.Script;
import com.google.gson.Gson;

public class CommentShowAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		BufferedReader in = request.getReader();
		int commentId = Integer.parseInt(in.readLine());
		System.out.println(commentId);
		
		CommentDAO commentDao = new CommentDAO();
		List<Comment> comments = commentDao.show(commentId);
		if(comments != null) {
			Gson gson = new Gson();
			String jsonComments = gson.toJson(comments);
			PrintWriter out = response.getWriter();
			out.print(jsonComments);
			out.flush();
		} else {
			Script.back(response);
		}

	}

}