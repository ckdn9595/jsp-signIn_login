package com.increpas.cls.controller.guestBoard;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.increpas.cls.dao.*;
import com.increpas.cls.vo.*;
import java.util.*;

import com.increpas.cls.controller.ClsMain;

public class GuestBoard implements ClsMain {

	@Override
	public String exec(HttpServletRequest req, HttpServletResponse resp) {
		// TODO Auto-generated method stub
		String view = "guestBoard/GuestBoard";
		GBoardDao gDao = new GBoardDao();
		ArrayList<GuestBoardVO> list = gDao.getGBoardList();
		String sid = "";
		try {
			sid = (String) req.getSession().getAttribute("SID");

		}catch(Exception e) {
			e.printStackTrace();
		}
		int cnt = 0;
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
		return view;
	}

}
