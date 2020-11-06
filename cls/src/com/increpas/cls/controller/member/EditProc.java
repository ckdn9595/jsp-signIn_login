package com.increpas.cls.controller.member;
import com.increpas.cls.dao.*;
import com.increpas.cls.vo.*;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.increpas.cls.controller.ClsMain;

public class EditProc implements ClsMain {

	@Override
	public String exec(HttpServletRequest req, HttpServletResponse resp) {
		String view = "member/MemberInfo";
		ArrayList<avatarVO> arr = new ArrayList<avatarVO>();
		System.out.println("여기까지 가고");
		String smail = req.getParameter("pmail");
		System.out.println("여기까지 가고");
		System.out.println("samil :"+smail);
		
		
		MemberDAO mDAO = new MemberDAO();
		MemberVO mVO = new MemberVO();
		avatarVO aVO = new avatarVO();
		
		
		String sid = (String)(req.getSession().getAttribute("SID"));
		System.out.println("sid :" +sid);
		
		mDAO.editMemb(sid, smail);
		
		
		mVO = mDAO.getInfo((String)(req.getSession().getAttribute("SID")));
		arr = mDAO.getAvtAll();
		
		for(int i = 0 ; i<arr.size(); i++) {
			aVO = arr.get(i);
			System.out.println(aVO.getAno() +"|"+mVO.getAvt());
			if(aVO.getAno()==mVO.getAvt())break;
		}
		
		req.setAttribute("VO", mVO);
		req.setAttribute("AVT", aVO);
		
		
		return view;
	}

}
