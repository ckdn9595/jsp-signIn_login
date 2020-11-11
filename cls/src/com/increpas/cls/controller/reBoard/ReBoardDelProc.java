package com.increpas.cls.controller.reBoard;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.increpas.cls.controller.ClsMain;
import com.increpas.cls.dao.ReBoardDao;

public class ReBoardDelProc implements ClsMain {

	@Override
	public String exec(HttpServletRequest req, HttpServletResponse resp) {
		req.setAttribute("isRedirect", true);
		String sno = req.getParameter("bno");
		String spage = req.getParameter("nowpage");
		int bno = 0 ; 
		try {
			bno = Integer.parseInt(sno);
		
		}catch(Exception e) {
			e.printStackTrace();
		}
		if(bno != 0) {
			ReBoardDao rDao = new ReBoardDao ();
			int cnt  = rDao.delReboard(bno);
			if(cnt == 1) {
				
				System.out.println("######" + bno + " 삭제");
			}
		}
		String view = "/cls/reBoard/reBoardList.cls?nowPage="+spage;
		return view;
	}

}
