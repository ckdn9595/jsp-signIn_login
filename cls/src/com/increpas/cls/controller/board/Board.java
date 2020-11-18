package com.increpas.cls.controller.board;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.increpas.cls.dao.*;
import com.increpas.cls.util.PageUtil;
import com.increpas.cls.vo.*;
import java.util.*;
import com.increpas.cls.controller.ClsMain;

public class Board implements ClsMain {

	@Override
	public String exec(HttpServletRequest req, HttpServletResponse resp) {
		String view = "board/BoardList";
		BoardDAO dao = new BoardDAO();
		int nowPage = 1;
		try {
			nowPage = Integer.parseInt(req.getParameter("nowPage"));
		}catch(Exception e) {
		}
		int total = dao.getTotal();
		PageUtil Page = new PageUtil(nowPage, total);
		ArrayList<BoardVO> list = dao.getBoardList(Page);
		for(int i = 0 ; i< list.size(); i++) {
			System.out.println(list.get(i).getBno() + 
			list.get(i).getId()+
			list.get(i).getTitle()+
			list.get(i).getSdate()+
			list.get(i).getClick()+
			list.get(i).getCnt());
		}
		System.out.println(list.size());
		req.setAttribute("PAGE", Page);
		req.setAttribute("LIST", list);
		return view;
	}

}
