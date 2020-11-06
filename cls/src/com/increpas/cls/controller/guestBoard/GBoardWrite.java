package com.increpas.cls.controller.guestBoard;

import javax.servlet.http.HttpServletRequest;
import com.increpas.cls.dao.*;
import com.increpas.cls.sql.*;
import javax.servlet.http.HttpServletResponse;

import com.increpas.cls.controller.ClsMain;

public class GBoardWrite implements ClsMain {

	@Override
	public String exec(HttpServletRequest req, HttpServletResponse resp) {
		String view = "/cls/guestBoard/guestBoard.cls";
		String sid = (String)req.getSession().getAttribute("SID");
		String sbody = req.getParameter("body");
		System.out.println(sbody + "********");
		GBoardDao dao = new GBoardDao();
		GBoardSQL sql = new GBoardSQL();
		int cnt = 0;
		try {
			cnt = dao.addGBoard(sid, sbody);
		}catch(Exception e) {
			System.out.println("dao 실행했을때 문제 생겼내??");
		}
		if(cnt == 0) {
			view = "/cls/member/login.cls";
		}
		req.setAttribute("isRedirect", true);
		return view;
	}

}
