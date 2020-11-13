package com.increpas.cls.dao;
import java.util.*;
import com.increpas.cls.sql.*;
import com.increpas.cls.vo.*;
import java.sql.*;
import db.ClsDBCP;
public class SurveyDao {
	
	ClsDBCP db;
	Connection con;
	Statement stmt;
	PreparedStatement pstmt;
	ResultSet rs;
	SurveySQL sSQL;
	public SurveyDao() {
		db = new ClsDBCP();
		sSQL = new SurveySQL();
	}
	
	public ArrayList<SurveyVO> getSIList(String id){
		ArrayList<SurveyVO> list = new ArrayList<SurveyVO>();
		con = db.getCon();
		String sql = sSQL.getSQL(sSQL.SEL_CURR_LIST);
		pstmt = db.getPSTMT(con,sql);
		try {
			pstmt.setString(1,id);
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				SurveyVO sVO = new SurveyVO();
				sVO.setSno(rs.getInt("sno"));
				sVO.setBody(rs.getString("sbody"));
				sVO.setCnt(rs.getInt("cnt"));
				list.add(sVO);
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
	public ArrayList<SurveyVO> getQUEST(int sno){
		ArrayList<SurveyVO> list = new ArrayList<SurveyVO>();
		con = db.getCon();
		String sql = sSQL.getSQL(sSQL.SEL_QUEST_LIST);
		pstmt = db.getPSTMT(con,sql);
		try {
			pstmt.setInt(1,sno);
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				SurveyVO sVO = new SurveyVO();
				sVO.setQno(rs.getInt("sqno"));
				sVO.setSno(rs.getInt("sno"));
				sVO.setQbody(rs.getString("sqbody"));
				sVO.setBody(rs.getNString("sbody"));
				sVO.setUpno(rs.getInt("upno"));
				list.add(sVO);
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
	public ArrayList<SurveyVO> getSelect(int upno){
		ArrayList<SurveyVO> list = new ArrayList<SurveyVO>();
		con = db.getCon();
		String sql = sSQL.getSQL(sSQL.SEL_SELECT_LIST);
		pstmt = db.getPSTMT(con,sql);
		try {
			pstmt.setInt(1,upno);
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				SurveyVO sVO = new SurveyVO();
				sVO.setQno(rs.getInt("sqno"));
				sVO.setSno(rs.getInt("sno"));
				sVO.setQbody(rs.getString("sqbody"));
				list.add(sVO);
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
	public int addAnswer(ArrayList<SurveyVO> list) { 
		int cnt = 0; 
		con = db.getCon();
		String sql = sSQL.getSQL(sSQL.ADD_ANSWER);
		
		try {
			for(int i = 0 ; i<list.size(); i++) {
				pstmt = db.getPSTMT(con, sql);
				pstmt.setString(1,list.get(i).getId());
				pstmt.setInt(2,list.get(i).getQno());
				
				cnt += pstmt.executeUpdate();
				db.close(pstmt);
			}
		}catch(Exception e) {
			db.close(pstmt);
			e.printStackTrace();
		}finally {
			
			db.close(con);
		}
		return cnt;
	}
	public ArrayList<SurveyVO> getResult(int sno){
		ArrayList<SurveyVO> list = new ArrayList<SurveyVO>();
		con = db.getCon();
		String sql = sSQL.getSQL(sSQL.SEL_ANSWER_RESULT);
		pstmt = db.getPSTMT(con, sql);
		try {
			pstmt.setInt(1, sno);
			rs = pstmt.executeQuery()	;
			while(rs.next()) {
				SurveyVO sVO = new SurveyVO();
				sVO.setBody(rs.getString("sbody"));
				sVO.setQno(rs.getInt("qno"));
				sVO.setQbody(rs.getString("qbody"));
				sVO.setSno(rs.getInt("sino"));
				sVO.setUpno(rs.getInt("upno"));
				sVO.setCnt(rs.getInt("cnt"));
				sVO.setPer(rs.getInt("per"));
				
				list.add(sVO);
			}
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			db.close(rs);
			db.close(pstmt);
			db.close(con);
		}
		return list;
	}
}
