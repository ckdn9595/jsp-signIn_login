package com.increpas.cls.controller.member;
import com.increpas.cls.dao.*;
import com.increpas.cls.vo.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.increpas.cls.controller.ClsMain;

public class EditProc implements ClsMain {

	@Override
	public String exec(HttpServletRequest req, HttpServletResponse resp) {
		String view = "member/MemberInfo";
		MemberVO mVO = new MemberVO();
		MemberDAO mDAO = new MemberDAO();
		mVO = (MemberVO) req.getAttribute("VO");
		
		String sid = mVO.getId();
		
		mDAO.editMemb(sid);
		
		
		
		req.setAttribute("VO", mVO);
		req.setAttribute("AVT", aVO);
		return view;
	}

}
