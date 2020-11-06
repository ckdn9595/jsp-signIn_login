package com.increpas.cls.dao;
import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;

import javax.sql.*;
import com.increpas.cls.sql.*;
import com.increpas.cls.vo.GuestBoardVO;

import db.ClsDBCP;

public class GBoardDao {
	
	private ClsDBCP db;
	private Connection con;
	private Statement stmt;
	private PreparedStatement pstmt;
	private ResultSet rs;
	
	private GBoardSQL gSQL;
	
	public GBoardDao() {
		db = new ClsDBCP();
		gSQL = new GBoardSQL();
	}
	public int addGBoard(String id, String body) {
		int cnt = 0;
		con = db.getCon();
		String sql = gSQL.getSQL(gSQL.ADD_GBD);
		try {
		pstmt = db.getPSTMT(con, sql);
		
		pstmt.setString(1, id);
		pstmt.setString(2, body);
		
		cnt = pstmt.executeUpdate();
		
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			db.close(pstmt);
			db.close(con);
		}
		return cnt;
	}
	
	public int addGBoard(ArrayList<HashMap<String,String>> list) {
		int cnt = 0;
		con = db.getCon();
		String sql = gSQL.getSQL(gSQL.ADD_GBD);
		try {
			for(int i = 0 ; i < list.size(); i++) {
				pstmt = db.getPSTMT(con, sql);
				
				pstmt.setString(1, list.get(i).get("id"));
				pstmt.setString(2, list.get(i).get("body"));
				
				cnt += pstmt.executeUpdate();
				db.close(pstmt);
			}
			
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			db.close(con);
		}
		return cnt;
	}
	public ArrayList<GuestBoardVO> getGBoardList(){
		ArrayList<GuestBoardVO>list = new ArrayList<GuestBoardVO>();
		con = db.getCon();
		stmt = db.getSTMT(con);
		
		try {
			rs = stmt.executeQuery(gSQL.getSQL(gSQL.SEL_ALL_GBD));
			
			while(rs.next()) {
				GuestBoardVO gVO = new GuestBoardVO();
				
				gVO.setGno(rs.getInt("gno"));
				gVO.setId(rs.getString("id"));
				gVO.setBody(rs.getString("body"));
				gVO.setAvatar(rs.getString("afile"));
				gVO.setWdate(rs.getDate("wdate"));
				gVO.setWtime(rs.getTime("wdate"));
				
				list.add(gVO);
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
	//글 작성여부 카운트 전단 처리함수
	public int getIdCnt(String id) {
		
		int cnt = 0;
		
		con = db.getCon();
		
		String sql = gSQL.getSQL(gSQL.SEL_ID_CNT);
		pstmt = db.getPSTMT(con, sql);
		try {
			pstmt.setNString(1, id);
			rs = pstmt.executeQuery();
			rs.next();
			
			cnt = rs.getInt("cnt");
			System.out.println("cnt = " + cnt);
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			db.close(rs);
			db.close(pstmt);
			db.close(con);
		}
		return cnt;
	}
}
