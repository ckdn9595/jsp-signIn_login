package com.increpas.cls.controller.member;

import javax.servlet.http.HttpServletRequest;
import com.increpas.cls.dao.*;
import javax.servlet.http.HttpServletResponse;

import com.increpas.cls.controller.ClsMain;

public class JoinOutProc implements ClsMain {

	@Override
	public String exec(HttpServletRequest req, HttpServletResponse resp) {
		req.setAttribute("isRedirect", true);
		String view = "/cls/main.cls";
		MemberDAO mDAO = new MemberDAO();
		int cnt = 0;
		try {
			cnt = mDAO.joinOut((String)(req.getSession().getAttribute("SID")));			
		}catch(Exception e) {
			e.printStackTrace();
		}
		if(cnt == 0) {
			req.setAttribute("isRedirect", false);
			view = "member/memberInfo";
		}else {
			req.getSession().removeAttribute("SID");
		}
		return view;
	}

}
