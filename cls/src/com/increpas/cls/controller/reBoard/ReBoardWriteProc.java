package com.increpas.cls.controller.reBoard;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.increpas.cls.dao.*;

import com.increpas.cls.controller.ClsMain;

public class ReBoardWriteProc implements ClsMain {

	@Override
	public String exec(HttpServletRequest req, HttpServletResponse resp) {
		//데이터 받고 데이터베이스 작업을 하고 뷰를 불르고
		String sid = req.getParameter("id");
		String body = req.getParameter("body");
		
		ReBoardDao rDao = new ReBoardDao();
		int cnt = rDao.addContent(sid, body);
		
		if(cnt == 0) {
			System.out.println("글등록 실패");
		}
		
		String view = "/cls/reBoard/reBoardList.cls";
		req.setAttribute("isRedirect", true);
		return view;
	}

}
