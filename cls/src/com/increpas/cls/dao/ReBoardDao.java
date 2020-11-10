package com.increpas.cls.dao;


import java.sql.*;
import java.util.*;

import db.*;
import com.increpas.cls.sql.*;
import com.increpas.cls.vo.*;
import com.increpas.cls.util.*;

public class ReBoardDao {
	ClsDBCP db;
	Connection con;
	Statement stmt;
	PreparedStatement pstmt;
	ResultSet rs;
	ReBoardSQL rSQL;
	
	public ReBoardDao() {
		db = new ClsDBCP();
		rSQL = new ReBoardSQL();
	}
	//댓글 게시판 게시글 가져오기 전담 처리함수
	public ArrayList<ReBoardVO> getBoardList(PageUtil page){
		ArrayList<ReBoardVO> list = new ArrayList<ReBoardVO>();
		
		con = db.getCon();
		String sql =rSQL.getSQL(rSQL.SEL_RBD_RNO);
		pstmt = db.getPSTMT(con, sql);
		try {
			pstmt.setInt(1, page.getStartCont());
			pstmt.setInt(2, page.getEndCont());
			
			rs = pstmt.executeQuery();
			while(rs.next()) {
				ReBoardVO rVO = new ReBoardVO();
				rVO.setBno(rs.getInt("bno"));
				rVO.setMno(rs.getInt("mno"));
				rVO.setId(rs.getString("id"));
				rVO.setBody(rs.getString("body"));
				rVO.setUpno(rs.getInt("upno"));
				rVO.setStep(rs.getInt("step"));
				rVO.setWdate(rs.getDate("wdate"));
				rVO.setWtime(rs.getTime("wdate"));
				
				list.add(rVO);
			}
		}catch(Exception e) {
			System.out.println("getBoardList에서 예외 발생 임 ㅋ");
		}finally {
			db.close(rs);
			db.close(pstmt);
			db.close(con);
		}
		return list;
	}
	// 댓글 원글 입력 전담 처리함수
	public int addBoard(ReBoardVO rVO) {
		int cnt = 0 ; 
		con = db.getCon();
		String sql = rSQL.getSQL(rSQL.ADD_BOARD);
		pstmt = db.getPSTMT(con, sql);
		try {
			// 질의명령 완성하고
			pstmt.setString(1, rVO.getId());
			pstmt.setString(2, rVO.getBody());
			// 질의명령 보내고 결과받고
			cnt  = pstmt.executeUpdate();
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			db.close(pstmt);
			db.close(con);
		}
		return cnt;
	}
	
	// 회원 아이디리스트 조회 전담 처리함수
	public ArrayList<ReBoardVO> getIdList(){
		ArrayList<ReBoardVO> list = new ArrayList<ReBoardVO>();
		con = db.getCon();
		String sql = rSQL.getSQL(rSQL.SEL_MEMBER_ID);
		stmt = db.getSTMT(con);
		try {
			// 질의명령 보내고 결과 받고
			rs = stmt.executeQuery(sql);
			// 데이터꺼내서 리스트에 담고
			while(rs.next()) {
				ReBoardVO rVO = new ReBoardVO();
				rVO.setId(rs.getString("id"));
				
				list.add(rVO);
			}
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			db.close(rs);
			db.close(stmt);
			db.close(con);
		}
		return list;
	}
	
	// 게시글 수 조회 전담 처리함수
	public int getCnt() {
		int cnt = 0 ; 
		con = db.getCon();
		String sql = rSQL.getSQL(rSQL.SEL_RBD_CNT);
		stmt = db.getSTMT(con);
		try {
			rs = stmt.executeQuery(sql);
			rs.next();
			
			cnt = rs.getInt("cnt");
			
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			db.close(rs);
			db.close(stmt);
			db.close(con);
		}
		
		return cnt;
	}
}
