package com.increpas.cls.dao;

import java.sql.*;
import java.util.*;
//import cls.vo.*;
import db.*;
import com.increpas.cls.sql.*;
public class MemberDAO {
//	clsJDBC db;
	ClsDBCP db;
	Connection con;
	Statement stmt;
	PreparedStatement pstmt;
	ResultSet rs;
	Membersql msql;
	
	public MemberDAO() {
		db = new ClsDBCP();
		msql = new Membersql();
	}
	
	public int getLoginCnt(String id, String pw) {
		int cnt = 0;
		con = db.getCon();
		String sql = msql.getSQL(msql.SEL_LOGIN_CNT);
		pstmt = db.getPSTMT(con, sql);
		try {
			pstmt.setString(1, id);
			pstmt.setString(2, pw);
			
			rs = pstmt.executeQuery();
			
			rs.next();
			
			cnt = rs.getInt("cnt");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			db.close(rs);
			db.close(pstmt);
			db.close(con);
		}
		
		return cnt;
	}
	
	public int getIdCnt(String id) {
		int cnt = 0 ;
		//todo
		con = db.getCon();
		String sql = msql.getSQL(msql.SEL_ID_CNT);
		pstmt = db.getPSTMT(con, sql);
		try {
			pstmt.setString(1, id);
			
			rs = pstmt.executeQuery();
			
			rs.next();
			
			cnt = rs.getInt("cnt");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			db.close(rs);
			db.close(pstmt);
			db.close(con);
		}
		return cnt;
	}
	
//	public ArrayList<AvatarVO> getAvtAll(){
//		
//	}
}
