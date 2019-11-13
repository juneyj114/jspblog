package com.cos.model;

import java.sql.Timestamp;

public class Comment {

	private int id;
	private int userId;
	private int boardId;
	private String content;
	private Timestamp createDate;
	private String commentId;
	private User user = new User(); // DB와 상관없음.
	private ResponseData responseData = new ResponseData(); // DB와 상관없음.

	public Comment(int id, int userId, int boardId, String content, Timestamp createDate) {
		super();
		this.id = id;
		this.userId = userId;
		this.boardId = boardId;
		this.content = content;
		this.createDate = createDate;
	}
	
	public String getCommentId() {
		return commentId;
	}

	public void setCommentId(String commentId) {
		this.commentId = commentId;
	}

	public ResponseData getResponseData() {
		return responseData;
	}



	public void setResponseData(ResponseData responseData) {
		this.responseData = responseData;
	}



	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public int getBoardId() {
		return boardId;
	}

	public void setBoardId(int boardId) {
		this.boardId = boardId;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public Timestamp getCreateDate() {
		return createDate;
	}

	public void setCreateDate(Timestamp createDate) {
		this.createDate = createDate;
	}

	public Comment() {
		// TODO Auto-generated constructor stub
	}

}