package com.increpas.cls.dao;
import db.ClsDBCP;
import com.increpas.cls.sql.*;
import com.increpas.cls.util.PageUtil;
import com.increpas.cls.vo.*;
import java.sql.*;
import java.util.*;

public class BoardDAO {
	ClsDBCP db;
	Connection con;
	Statement stmt;
	PreparedStatement pstmt;
	ResultSet rs;
	BoardSQL bSQL;
	public BoardDAO() {
		db = new ClsDBCP();
		bSQL = new BoardSQL();
	}
	
	public ArrayList<BoardVO> getBoardList(PageUtil page){
		ArrayList<BoardVO> list = new ArrayList<BoardVO>();
		con = db.getCon();
		String sql = bSQL.getSQL(bSQL.SEL_BOARD_LIST);
		pstmt = db.getPSTMT(con,sql);
//		System.out.println(page.getStartCont()+"****"+page.getEndCont());
		try {
			
			pstmt.setInt(1, page.getStartCont());
			pstmt.setInt(2, page.getEndCont());
			rs = pstmt.executeQuery();
			while(rs.next()) {
				BoardVO vo = new BoardVO();
				
				vo.setBno(rs.getInt("BNO"));
				vo.setId(rs.getString("ID"));
				vo.setTitle(rs.getString("TITLE"));
				vo.setSdate(rs.getString("DAT"));
				vo.setClick(rs.getInt("BCLICK"));
				list.add(vo);
			}
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			db.close(rs);
			db.close(stmt);
			db.close(con);
		}
		return list;
	}
	public int setCnt(int bno) {
		
		int cnt = 0;
		
		con = db.getCon();
		String sql = bSQL.getSQL(bSQL.UPD_CK_CNT);
		pstmt = db.getPSTMT(con,sql);
		try {
			pstmt.setInt(1, bno);
			
			cnt = pstmt.executeUpdate();
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			db.close(pstmt);
			db.close(con);
		}
		return cnt;
	}
	public int getTotal() {
		
		int cnt = 0;
		
		con = db.getCon();
		stmt = db.getSTMT(con);
		try {
			
			rs = stmt.executeQuery(bSQL.getSQL(bSQL.SEL_BD_TCNT));
			
			rs.next();
			
			cnt = rs.getInt("tot");
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			db.close(rs);
			db.close(pstmt);
			db.close(con);
		}
		return cnt;
	}
	
	//게시판 글 작성
	public int addBoard(BoardVO bVO) {
		int cnt = 0;
		con = db.getCon();
		
		String sql = bSQL.getSQL(bSQL.ADD_BOARD);
		pstmt = db.getPSTMT(con, sql);
		try {
			pstmt.setString(1, bVO.getTitle());
			pstmt.setString(2, bVO.getBody());
			pstmt.setString(3, bVO.getId());
			
			cnt = pstmt.executeUpdate();
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			db.close(pstmt);
			db.close(con);
		}
		return cnt;
	}
	
	//파일 정보 넣기 전담 처리
	public int addFile(FileVO fVO) {
		int cnt = 0;
		con = db.getCon();
		String sql = bSQL.getSQL(bSQL.ADD_FILE);
		pstmt = db.getPSTMT(con, sql);
		try {
			pstmt.setString(1, fVO.getId());
			pstmt.setString(2, fVO.getOriname());
			pstmt.setString(3, fVO.getSavename());
			pstmt.setLong(4, fVO.getLen());
			
			cnt = pstmt.executeUpdate();
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			db.close(pstmt);
			db.close(con);
		}
		return cnt;
	}
	public int addFile(ArrayList<FileVO> list) {
		int cnt = 0;
		for(FileVO fVO : list) {
			cnt += addFile(fVO);
		}
		return cnt;
	}
}
