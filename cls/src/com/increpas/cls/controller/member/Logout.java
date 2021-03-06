package com.increpas.cls.controller.member;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.increpas.cls.controller.ClsMain;

public class Logout implements ClsMain{
	String view = "/cls/main.cls";

	@Override
	public String exec(HttpServletRequest req, HttpServletResponse resp) {
		
		req.setAttribute("isRedirect",true);
		
		try {
			req.getSession().removeAttribute("SID");
		}catch(Exception e) {
			e.printStackTrace();
		}
		return view;
	
	}
	
}
