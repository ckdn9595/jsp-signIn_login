package com.increpas.cls.controller.member;
import com.increpas.cls.dao.*;
import com.increpas.cls.vo.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.*;

import com.increpas.cls.controller.ClsMain;

public class MemberInfo implements ClsMain {

	@Override
	public String exec(HttpServletRequest req, HttpServletResponse resp) {
		ArrayList arr = new ArrayList();
		String view = "member/MemberInfo";
		MemberVO mVO = new MemberVO();
		MemberDAO mDAO = new MemberDAO();
		avatarVO aVO = new avatarVO();
		mVO = mDAO.getInfo((String)(req.getSession().getAttribute("SID")));
		arr = mDAO.getAvtAll();
		
		for(int i = 0 ; i<arr.size(); i++) {
			aVO = (avatarVO)(arr.get(i));
			if(aVO.getAno()==mVO.getAvt())break;
		}
		
		req.setAttribute("VO", mVO);
		req.setAttribute("AVT", aVO);
		return view;
	}

}
