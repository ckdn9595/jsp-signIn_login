package com.increpas.cls.controller.reBoard;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.increpas.cls.controller.ClsMain;
import com.increpas.cls.dao.*;
import com.increpas.cls.vo.*;

public class ReBoardCommentProc implements ClsMain {

	@Override
	public String exec(HttpServletRequest req, HttpServletResponse resp) {
		String view = "reBoard/ReBoardCommentProc";
		int upno = 0 ; 
		try {
			upno = Integer.parseInt(req.getParameter("bno"));
		
		}catch(Exception e) {
			System.out.println(upno + " | " + "에러남");
		}
		String body = req.getParameter("body");
		String id = (String)req.getSession().getAttribute("SID");
		ReBoardDao rd = new ReBoardDao();
//		String nowPage = req.getParameter("nowPage");
		
		int cnt = rd.addComment(id, body, upno);
		if(cnt != 1) {
			System.out.println("댓글 안들어감ㅋㅋㅋㅋ");
		}
		
		System.out.println("여긴 확실히 다돌았어");
		return view;
		
	}

}