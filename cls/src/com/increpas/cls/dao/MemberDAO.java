package com.increpas.cls.dao;
import com.increpas.cls.vo.*;
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
	
	public ArrayList<avatarVO> getAvtAll(){
		ArrayList<avatarVO> list = new ArrayList<avatarVO>();
		con = db.getCon();
		String sql = msql.getSQL(msql.SEL_AVT_ALL);
		stmt = db.getSTMT(con);
		try {
			rs = stmt.executeQuery(sql);
			while(rs.next()) {
				avatarVO aVO = new avatarVO();
				aVO.setAno(rs.getInt("ano"));
				aVO.setSavename(rs.getNString("sname"));
				aVO.setGen(rs.getString("gen"));
				
				list.add(aVO);
			}
		}catch(Exception e) {
			e.printStackTrace();
		}finally{
			db.close(rs);
			db.close(stmt);
			db.close(con);
		}
		return list;
	}
	
	public MemberVO getInfo(String id) {
		MemberVO mVO = new MemberVO();
		con = db.getCon();
		String sql = msql.getSQL(msql.SEL_INFO_ALL);
		
		pstmt = db.getPSTMT(con, sql);
		
		try {
			pstmt.setString(1, id);
			
			rs = pstmt.executeQuery();
			rs.next();
			
			mVO.setMno(rs.getInt("mno"));
			mVO.setAvt(rs.getInt("avt"));
			mVO.setId(rs.getString("id"));
			mVO.setName(rs.getString("name"));
			mVO.setMail(rs.getString("mail"));
			mVO.setGen(rs.getString("gen"));
			mVO.setJoinDate(rs.getDate("joindate"));
			mVO.setJoinTime(rs.getTime("joindate"));
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			db.close(rs);
			db.close(pstmt);
			db.close(con);
		}
		
		return mVO;
	}
	public int editMemb(String id, String mail) {
		int cnt = 0;
		//할일
		//1. 커넥션
		con = db.getCon();
		String sql = msql.getSQL(msql.UPD_INFO);
		
		pstmt = db.getPSTMT(con, sql);
		
		try {
			pstmt.setNString(1, mail);
			pstmt.setNString(2, id);
			
			cnt = pstmt.executeUpdate();
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			db.close(pstmt);
			db.close(con);
		}
		return cnt;
	}
	public int joinOut(String id) {
		int cnt = 0;
		//할일
		//1. 커넥션
		con = db.getCon();
		String sql = msql.getSQL(msql.UPD_OUT);
		
		pstmt = db.getPSTMT(con, sql);
		
		try {
			pstmt.setNString(1, id);
			
			cnt = pstmt.executeUpdate();
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			db.close(pstmt);
			db.close(con);
		}
		return cnt;
	}
	public int addMemb(MemberVO mVO) {
		int cnt = 0;
		//할일
		//1. 커넥션
		con = db.getCon();
		String sql = msql.getSQL(msql.ADD_MEMB);
		
		pstmt = db.getPSTMT(con, sql);
		
		try {
			pstmt.setString(1, mVO.getId());
			pstmt.setString(2, mVO.getPw());
			pstmt.setString(3, mVO.getName());
			pstmt.setString(4, mVO.getMail());
			pstmt.setString(5, mVO.getGen());
			pstmt.setInt(6, mVO.getAvt());
			
			cnt = pstmt.executeUpdate();
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			db.close(pstmt);
			db.close(con);
		}
		return cnt;
	}
	//방명록 리스트 꺼내오기 전담 함수
	
	
}
