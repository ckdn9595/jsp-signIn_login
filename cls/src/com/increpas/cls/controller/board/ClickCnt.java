package com.increpas.cls.controller.board;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.increpas.cls.controller.ClsMain;
import com.increpas.cls.dao.*;
public class ClickCnt implements ClsMain {

	@Override
	public String exec(HttpServletRequest req, HttpServletResponse resp) {
		String view = "/cls/board/BoardList.cls";
		req.setAttribute("isRedirect", true);
		int bno = 0;
		try {
			bno = Integer.parseInt(req.getParameter("bno"));
		}catch(Exception e) {
			
		}
		System.out.println("********"+ bno);
		BoardDAO dao = new BoardDAO();
		int cnt = dao.setCnt(bno);
		return view;
	}

}
