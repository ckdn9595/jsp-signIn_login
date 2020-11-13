package com.increpas.cls.controller.survey;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.*;
import com.increpas.cls.controller.ClsMain;
import com.increpas.cls.dao.*;
import com.increpas.cls.vo.*;
import com.increpas.cls.util.*;
public class SurveyProc implements ClsMain {

	@Override
	public String exec(HttpServletRequest req, HttpServletResponse resp) {
		String sid = SessionUtil.procSession(req, resp);
		
		int cnt = 0 ;
		SurveyDao sDao = new SurveyDao();
		Enumeration en = req.getParameterNames(); //키값들을 받아서 배열로 만들어줌
		ArrayList<SurveyVO> list = new ArrayList<SurveyVO>();
		try {
			while(en.hasMoreElements()) {
				String key = (String)en.nextElement();
				System.out.println("key++++++++"+ key);
				String sno = req.getParameter(key);
				System.out.println("sno++++++++"+ sno);
				int qno = Integer.parseInt(sno);
				SurveyVO sVO = new SurveyVO();
				sVO.setId(sid);
				sVO.setQno(qno);
				
				list.add(sVO);
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
		String view = "survey/SurveyRedirect";
		cnt = sDao.addAnswer(list);
		if(cnt != list.size()) {
			view = "/cls/survey/surveyInfo.cls";
			req.setAttribute("VIEW", view);
			req.setAttribute("isRedirect", true);
		}
		return view;
	}

}
