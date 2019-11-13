package com.cos.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.cos.model.Board;
import com.cos.model.User;
import com.cos.util.DBClose;
import com.cos.util.Utils;

public class BoardDAO {

	private PreparedStatement pstmt; // 쿼리문 작성 - 실행담당
	private Connection conn;
	private ResultSet rs;

	public int save(Board board) {
		final String SQL = "insert into board(userId, title, content, createDate) values(?, ?, ?, now())";
		conn = DBConn.getConnection();

		try {
			pstmt = conn.prepareStatement(SQL);
			pstmt.setInt(1, board.getUserId());
			pstmt.setString(2, board.getTitle());
			pstmt.setString(3, board.getContent());
			int result = pstmt.executeUpdate();
			return result;
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBClose.close(conn, pstmt);
		}
		return -1;
	}

	public List<Board> findAll() {
		final String SQL = "select * from board order by id desc";
		List<Board> boards = new ArrayList<Board>();
		conn = DBConn.getConnection();
		try {
			pstmt = conn.prepareStatement(SQL);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				Board board = new Board();
				board.setId(rs.getInt("id"));
				board.setUserId(rs.getInt("userId"));
				board.setTitle(rs.getString("title"));
				board.setContent(rs.getString("content"));
				board.setReadCount(rs.getInt("readCount"));
				board.setCreateDate(rs.getTimestamp("createDate"));
				boards.add(board);
			}
			return boards;
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBClose.close(conn, pstmt, rs);
		}
		return boards;

	}

	public List<Board> findAll(int page) {
		final String SQL = "select * from board b, user u where b.userId = u.id order by b.id desc limit ?, 3";
		List<Board> boards = new ArrayList<Board>();
		conn = DBConn.getConnection();
		try {
			pstmt = conn.prepareStatement(SQL);
			pstmt.setInt(1, (page - 1) * 3);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				Board board = new Board();
				User user = board.getUser();
				board.setId(rs.getInt("b.id"));
				board.setUserId(rs.getInt("b.userId"));
				board.setTitle(rs.getString("b.title"));
				board.setContent(rs.getString("b.content") + " ");
				board.setReadCount(rs.getInt("b.readCount"));
				board.setCreateDate(rs.getTimestamp("b.createDate"));

				user.setUsername(rs.getString("u.username"));
				boards.add(board);
			}
			return boards;
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBClose.close(conn, pstmt, rs);
		}
		return boards;

	}

	public Board findById(int id) {
		final String SQL = "select * from board b, user u where b.userId = u.id and b.id = ?";
		Board board = new Board();
		User user = board.getUser();
		conn = DBConn.getConnection();
		try {
			pstmt = conn.prepareStatement(SQL);
			pstmt.setInt(1, id);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				board.setId(rs.getInt("b.id"));
				board.setUserId(rs.getInt("b.userId"));
				board.setTitle(rs.getString("b.title"));
				board.setContent(rs.getString("b.content") + " ");
				board.setReadCount(rs.getInt("b.readCount"));
				board.setCreateDate(rs.getTimestamp("b.createDate"));
				user.setUserProfile(rs.getString("u.userProfile"));
				user.setUsername(rs.getString("u.username"));
			}
			return board;
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBClose.close(conn, pstmt, rs);
		}
		return board;
	}

	public int increaseReadCount(int id) {
		final String SQL = "update board set readCount = readCount + 1 where id = ?";
		conn = DBConn.getConnection();

		try {
			pstmt = conn.prepareStatement(SQL);
			pstmt.setInt(1, id);
			int result = pstmt.executeUpdate();
			return result;
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBClose.close(conn, pstmt);
		}
		return -1;
	}

	public List<Board> findOrderByReadCountDesc() {
		final String SQL = "select * from board order by readCount desc limit 3";
		List<Board> boards = new ArrayList<Board>();
		conn = DBConn.getConnection();
		try {
			pstmt = conn.prepareStatement(SQL);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				Board board = new Board();
				board.setId(rs.getInt("id"));
				board.setUserId(rs.getInt("userId"));
				board.setTitle(rs.getString("title"));
				board.setContent(rs.getString("content"));
				board.setReadCount(rs.getInt("readCount"));
				board.setCreateDate(rs.getTimestamp("createDate"));
				boards.add(board);
			}
			return boards;
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBClose.close(conn, pstmt, rs);
		}
		return boards;
	}

	public int delete(int id) {
		final String SQL = "delete from board where id = ?";
		conn = DBConn.getConnection();

		try {
			pstmt = conn.prepareStatement(SQL);
			pstmt.setInt(1, id);
			int result = pstmt.executeUpdate();
			return result;
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBClose.close(conn, pstmt);
		}
		return -1;

	}

	public int update(Board board) {
		final String SQL = "update board set title = ?, content = ? where id = ?";
		conn = DBConn.getConnection();

		try {
			pstmt = conn.prepareStatement(SQL);
			pstmt.setString(1, board.getTitle());
			pstmt.setString(2, board.getContent());
			pstmt.setInt(3, board.getId());
			int result = pstmt.executeUpdate();
			return result;
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBClose.close(conn, pstmt);
		}
		return -1;
	}

	public List<Board> findBySearch(int page, String search) {
		final String SQL = "select * from board b, user u where b.userId = u.id and (b.content like concat ('%',?,'%') or b.title like concat ('%',?,'%')) order by b.id desc limit ?, 3";
		List<Board> boards = new ArrayList<Board>();
		conn = DBConn.getConnection();
		try {
			pstmt = conn.prepareStatement(SQL);

			pstmt.setString(1, search);
			pstmt.setString(2, search);
			pstmt.setInt(3, (page - 1) * 3);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				Board board = new Board();
				User user = board.getUser();
				board.setId(rs.getInt("b.id"));
				board.setUserId(rs.getInt("b.userId"));
				board.setTitle(rs.getString("b.title"));
				board.setContent(rs.getString("b.content") + " ");
				board.setReadCount(rs.getInt("b.readCount"));
				board.setCreateDate(rs.getTimestamp("b.createDate"));

				user.setUsername(rs.getString("u.username"));
				boards.add(board);
			}
			return boards;
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBClose.close(conn, pstmt, rs);
		}
		return boards;
	}

}
