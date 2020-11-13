package com.increpas.cls.controller.survey;

import java.util.ArrayList;
import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.increpas.cls.controller.ClsMain;
import com.increpas.cls.dao.*;
import com.increpas.cls.vo.SurveyVO;

public class Survey implements ClsMain {

	@Override
	public String exec(HttpServletRequest req, HttpServletResponse resp) {
		int sno = 0;
		try {
			sno = Integer.parseInt(req.getParameter("sno"));			
		}catch(Exception e) {
			System.out.println("여기야여기");
		}
		SurveyDao dao = new SurveyDao();
		System.out.println("여기야여기"+ sno);
		ArrayList<SurveyVO> quest = dao.getQUEST(sno);
		HashMap<Integer,ArrayList<SurveyVO>> Select = new HashMap<Integer,ArrayList<SurveyVO>>();
		for(int i = 0 ; i < quest.size(); i++) {
			ArrayList<SurveyVO> sel = dao.getSelect(quest.get(i).getQno());
//			System.out.println("quest.get(i).getUpno()"+quest.get(i).getQno());
//			System.out.println("sel.get(i).getQbody()"+sel.get(i).getQbody());
			Select.put(quest.get(i).getQno(), sel);
		}
		req.setAttribute("QUEST", quest);
		req.setAttribute("SELECT", Select);
		String view = "survey/Survey";
		return view;
	}

}
