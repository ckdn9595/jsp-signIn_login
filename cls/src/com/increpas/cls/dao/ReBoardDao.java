package com.increpas.cls.dao;
import java.sql.*;
import java.util.ArrayList;

import javax.sql.*;
import com.increpas.cls.sql.*;
import com.increpas.cls.vo.*;
import com.increpas.cls.util.*;

import db.ClsDBCP;

public class ReBoardDao {
	private ClsDBCP db;
	private Connection con;
	private Statement stmt;
	private PreparedStatement pstmt;
	private ResultSet rs;
	
	private ReBoardSQL gSQL;
	
	public ReBoardDao() {
		db = new ClsDBCP();
		gSQL = new ReBoardSQL();
	}
	public ArrayList<ReBoardVO> getReBoard() {
		ArrayList<ReBoardVO> rVO = new ArrayList<ReBoardVO>();
		con = db.getCon();
		stmt = db.getSTMT(con);
		
		try {
			rs = stmt.executeQuery(gSQL.getSQL(gSQL.RB_SEL_LIST));
			while(rs.next()) {
				ReBoardVO vo = new ReBoardVO();
				vo.setBno(rs.getInt("bno"));
				vo.setB_mno(rs.getInt("B_mno"));
				vo.setBody(rs.getString("body"));
//				vo.setUpno(rs.getInt("upno"));
				vo.setWdate(rs.getDate("wdate"));
				vo.setWtime(rs.getTime("wdate"));
				vo.setIsshow(rs.getString("isshow"));
				rVO.add(vo);
			}
		}catch(Exception e) {
			System.out.println("getReBoard try 구문에서 에러");
			e.printStackTrace();
		}finally {
			db.close(rs);
			db.close(stmt);
			db.close(con);
		}
		
		return rVO;
	}
}
