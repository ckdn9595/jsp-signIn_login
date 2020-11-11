package com.increpas.cls.controller.reBoard;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.increpas.cls.controller.ClsMain;
import com.increpas.cls.dao.ReBoardDao;

public class ReBoardEditProc implements ClsMain {

	@Override
	public String exec(HttpServletRequest req, HttpServletResponse resp) {
		String sid = "";
		try {
			sid = (String)req.getSession()	.getAttribute("SID");
		}catch(Exception e) {
			req.setAttribute("isRedirect", true);
			return "/cls/member/login.cls";
		}
		
		String body = req.getParameter("body");
		String tno = req.getParameter("bno");
		String nowPage = req.getParameter("nowpage");
		System.out.println(body + " | " + tno + " | " + nowPage);
		int bno = Integer.parseInt(tno);
		
		ReBoardDao dao = new ReBoardDao();
		int cnt = dao.editReBoard(bno, body);
		String view = "/cls/reBoard/reBoardList.cls?nowPage="+nowPage;
		req.setAttribute("isRedirect", true);
		return view;
	}

}
