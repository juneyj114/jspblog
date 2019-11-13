package com.cos.action.comment;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.cos.action.Action;
import com.cos.dao.CommentDAO;
import com.cos.model.Comment;
import com.cos.model.ResponseData;
import com.google.gson.Gson;

public class CommentWriteAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		BufferedReader in = request.getReader();
		String jsonString = in.readLine();
		Gson gson = new Gson();
		System.out.println(jsonString);
		Comment comment = gson.fromJson(jsonString, Comment.class);
		
		CommentDAO commentDao = new CommentDAO();
		int result = commentDao.save(comment);
		if(result == 1) {
			System.out.println("Completed!");
			Comment lastComment = commentDao.findByMaxId();
			ResponseData responseData = lastComment.getResponseData();
			responseData.setStatusCode(1);
			responseData.setStatus("OK");
			responseData.setStatusMessage("writing comment was completed");
			System.out.println(lastComment.getId());
			System.out.println(lastComment.getUser().getUsername());
			System.out.println(lastComment.getResponseData().getStatusMessage());
			
			String jsonComment = gson.toJson(lastComment);
			PrintWriter out = response.getWriter();
			out.print(jsonComment);
			out.flush();
		} else {
			System.out.println("Fail!");
		}
		
	}

}
