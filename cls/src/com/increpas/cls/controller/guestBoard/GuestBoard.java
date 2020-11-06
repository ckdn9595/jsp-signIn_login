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
		
		ArrayList<GuestBoardVO> list = new GBoardDao().getGBoardList();
		
		req.setAttribute("LIST", list);
		return view;
	}

}
