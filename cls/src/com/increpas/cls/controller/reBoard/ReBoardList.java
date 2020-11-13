package com.increpas.cls.controller.reBoard;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.increpas.cls.controller.ClsMain;
import com.increpas.cls.dao.*;
import com.increpas.cls.vo.*;
import com.increpas.cls.util.*;

public class ReBoardList implements ClsMain {

	@Override
	public String exec(HttpServletRequest req, HttpServletResponse resp) {
		String view = "reBoard/ReBoard";
		ReBoardDao rDao = new ReBoardDao();
		String sid = "";
		String avatar = "noimage.jpg";
		int nowPage = 1;
		try {
			sid = (String)req.getSession().getAttribute("SID");
			avatar = rDao.getAvtFile(sid);
			nowPage = Integer.parseInt(req.getParameter("nowPage"));
		}catch(Exception e) {}
		
		int total = rDao.getCnt();
		PageUtil page = new PageUtil(nowPage, total);
		
		ArrayList<ReBoardVO> list = rDao.getBoardList(page);
		String sname = "";
		System.out.println("#######"+nowPage);
		req.setAttribute("AVTIMG", avatar);
		req.setAttribute("LIST", list);
		req.setAttribute("PAGE", page);
		
		return view;
	}

}
