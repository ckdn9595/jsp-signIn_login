package com.increpas.cls.controller.member;

import javax.servlet.http.HttpServletRequest;
import java.util.*;
import javax.servlet.http.HttpServletResponse;
import com.increpas.cls.vo.*;
import com.increpas.cls.controller.ClsMain;
import com.increpas.cls.dao.*;
public class Join implements ClsMain {

	@Override
	public String exec(HttpServletRequest req, HttpServletResponse resp) {
		
		String view = "member/Join";
		
		MemberDAO mDao = new MemberDAO();
		
		ArrayList<avatarVO> list = mDao.getAvtAll();
		req.setAttribute("LIST", list);
		return view;
	}

}
