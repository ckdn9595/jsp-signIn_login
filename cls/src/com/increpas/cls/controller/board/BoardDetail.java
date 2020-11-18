package com.increpas.cls.controller.board;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.increpas.cls.controller.ClsMain;

public class BoardDetail implements ClsMain {

	@Override
	public String exec(HttpServletRequest req, HttpServletResponse resp) {
		String view = "board/BoardDetail";
		req.setAttribute("isRedirect", false);
		
		String sid = req.getParameter("bno");
		System.out.println(1);
		return view;
	}

}
