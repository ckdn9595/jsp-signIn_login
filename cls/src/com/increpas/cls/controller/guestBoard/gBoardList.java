package com.increpas.cls.controller.guestBoard;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.increpas.cls.dao.*;
import com.increpas.cls.vo.*;
import com.increpas.cls.util.*;
import java.util.*;

import com.increpas.cls.controller.ClsMain;

public class gBoardList implements ClsMain {

	@Override
	public String exec(HttpServletRequest req, HttpServletResponse resp) {
		// TODO Auto-generated method stub
		String view = "guestBoard/gBoardList";
		int nowPage = 1;
		try {
			
			nowPage = Integer.parseInt(req.getParameter("nowPage"));
		}catch(Exception e) {}
		GBoardDao gDao = new GBoardDao();
		
		int total = gDao.getTotal();
		System.out.println("### cont total : " + total);
		PageUtil page = new PageUtil(nowPage, total);
		
		ArrayList<GuestBoardVO> list = gDao.getGBoardList(page);
		System.out.println("페이지 길이" + list.size());
		int cnt = 0;
		String sid = "";
		try {
			sid = (String) req.getSession().getAttribute("SID");
			cnt = gDao.getIdCnt(sid);
		}catch(Exception e) {
			e.printStackTrace();
		}
//		try {
//			
//			for(int i = 0 ; i<list.size(); i++) {
//				GuestBoardVO gVO = list.get(i);
//				String tid = gVO.getId();
//				if(sid.equals(tid)) {
//					cnt = 1;
//				}
//		}
//		}catch(Exception e) {
//			
//		}
		cnt = gDao.getIdCnt(sid);
		req.setAttribute("LIST", list);
		req.setAttribute("CNT", cnt);
		req.setAttribute("PAGE", page);
		
		return view;
	}

}
