package com.increpas.cls.controller;
import com.increpas.cls.dao.*;
import javax.servlet.http.*;

public class MainController implements ClsMain {

	@Override
	public String exec(HttpServletRequest req, HttpServletResponse resp) {
		req.setAttribute("isRedirect", false);
		String view = "main";
		
//		System.out.println("view : " + view);
		int cnt = new ReBoardDao().getCnt();
		
		req.setAttribute("RCNT", cnt);
		return view;
	}

}
