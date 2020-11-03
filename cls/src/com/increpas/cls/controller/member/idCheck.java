package com.increpas.cls.controller.member;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.increpas.cls.controller.ClsMain;
import com.increpas.cls.dao.MemberDAO;

public class idCheck implements ClsMain {

	@Override
	public String exec(HttpServletRequest req, HttpServletResponse resp) {	
		System.out.println("teststet");
		req.setAttribute("isRedirect", null);
		
		StringBuffer buff = new StringBuffer();
		
		MemberDAO mDAO =new MemberDAO();
		int cnt = mDAO.getIdCnt(req.getParameter("id"));
		
		String result = "OK";
		
		if(cnt==1) {
			result = "NO";
		}
		
		buff.append("{");
		buff.append("  \"result\":\""+result+"\" ");
		buff.append("}");
		return buff.toString();
	}

}
