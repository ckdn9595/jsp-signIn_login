package com.increpas.cls.controller.member;

import javax.servlet.http.HttpServletRequest;
import com.increpas.cls.dao.*;
import com.increpas.cls.vo.*;
import javax.servlet.http.HttpServletResponse;

import com.increpas.cls.controller.ClsMain;
/**
 * 회원가입 처리 컨트롤러
 * @author 이지우
 * @since  2020.11.03
 * @version v.1.0
 */
public class Joinproc implements ClsMain {

	@Override
	public String exec(HttpServletRequest req, HttpServletResponse resp) {
		String view = "/cls/guestBoard/guestBoard.cls";
		req.setAttribute("isRedirect", true);
		//1. 파라미터 받기
		String sname = req.getParameter("name");
		String sid = req.getParameter("id");
		String spw = req.getParameter("pw");
		String smail = req.getParameter("mail");
		String stel = req.getParameter("tel");
		String sgen = req.getParameter("gen");
		String savt = req.getParameter("avt");
		// VO에 데이터 담고
		MemberVO mVO = new MemberVO();
		mVO.setName(sname);
		mVO.setId(sid);
		mVO.setPw(spw);
		mVO.setMail(smail);
		mVO.setGen(sgen);
		mVO.setAvt(Integer.parseInt(savt));
		
		MemberDAO mDAO = new MemberDAO();
		int cnt = mDAO.addMemb(mVO);
		if(cnt == 0) { // 회원가입 실패
			view = "/cls/member/join.cls";
		}else {
			req.getSession().setAttribute("SID", sid);
		}
		return view;
	}

}
