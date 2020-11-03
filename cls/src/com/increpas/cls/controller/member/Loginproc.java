package com.increpas.cls.controller.member;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.increpas.cls.controller.*;
import com.increpas.cls.dao.*;

public class Loginproc implements ClsMain {

	@Override
	public String exec(HttpServletRequest req, HttpServletResponse resp) {
		req.setAttribute("isRedirect", true);
		String view = "/cls/main.cls";
		
		System.out.println("view+++++" + view);
		//할일 파라미터 받고
		String sid = req.getParameter("id");
		String spw = req.getParameter("pw");
		
		//데이터베이스 작업하고 결과받고
		MemberDAO mDao = new MemberDAO();
		int cnt = mDao.getLoginCnt(sid, spw);
		
		if(cnt != 1) {
			view = "/cls/member/login.cls";
		}else {
			req.getSession().setAttribute("SID", sid);
		}
		return view;
	}
}
