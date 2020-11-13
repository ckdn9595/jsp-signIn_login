package com.increpas.cls.controller.survey;

import javax.servlet.http.HttpServletRequest;
import java.util.*;
import com.increpas.cls.dao.*;
import com.increpas.cls.vo.*;
import javax.servlet.http.HttpServletResponse;

import com.increpas.cls.controller.ClsMain;

public class SurveyResult implements ClsMain {

	@Override
	public String exec(HttpServletRequest req, HttpServletResponse resp) {
		String tno = req.getParameter("sno");
		System.out.println(tno + " 여기는 tnonono");
		String view = "survey/SurveyResult";
		
		int sno = 0 ; 
		
		try {
			sno = Integer.parseInt(tno);
		}catch(Exception e) {
			view = "survey/SurveyRedirect";
			String rview = "/cls/survey/surveyInfo.cls";
			req.setAttribute("VIEW", rview);
		}
		
		SurveyDao sDao = new SurveyDao();
		ArrayList<SurveyVO> list = sDao.getResult(sno);
		
		req.setAttribute("LIST", list);
		
		return view;
	}

}
