package com.increpas.cls.controller.board;

import java.io.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Enumeration;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.increpas.cls.controller.ClsMain;
import com.increpas.cls.util.SessionUtil;
import com.increpas.cls.vo.*;
import com.increpas.cls.dao.*;
import com.oreilly.servlet.*;
import com.oreilly.servlet.multipart.*;

public class BoardWriteProc implements ClsMain {

	@Override
	public String exec(HttpServletRequest req, HttpServletResponse resp) {
		String view = "/cls/board/BoardList.cls";
		req.setAttribute("isRedirect", true);
		
		/*
		  파일은 파라미터에서 데이터를 꺼내와서 작업을 못한당
		  이 컨트롤러는 지금까지와는 조금 다르당
		  지금까지는 파라미터 방식으로 데이터가 전달되었지만.....ㅜㅜ
		  지금은 파라미터방식이 아닌 스트림 방식으로 데이터가 전달 되기 때문엥
		 */
		String sid = SessionUtil.procSession(req, resp);
		String path = req.getSession().getServletContext().getRealPath("\\WEB-INF\\resources\\img\\upload");
		
		
//		MultipartRequest multi = null;
		try {
			MultipartRequest multi = new MultipartRequest(req,path,1024*1024*10,"UTF-8",
					new DefaultFileRenamePolicy());
			String title = multi.getParameter("title");
			String body = multi.getParameter("body");
			
			BoardVO bVO = new BoardVO();
			bVO.setId(sid);
			bVO.setTitle(title);
			bVO.setBody(body);
			
			BoardDAO bDao = new BoardDAO();
			int cnt = bDao.addBoard(bVO);
			
			if(cnt != 1) {
				view = "/cls/board/boardWrite.cls";
				return view;
			}
			ArrayList<FileVO> list = null;
			
			try{
				list = getFileInfo(sid, multi);
				cnt = bDao.addFile(list);
			} catch(Exception e) {
				// 보여줄 뷰 부르고....
			}
		}catch(IOException e) {
			e.printStackTrace();
		}
		
		return view;
	}
	public ArrayList<FileVO> getFileInfo(String id,MultipartRequest multi) {
		ArrayList<FileVO> list = new ArrayList<FileVO>();
		
		Enumeration en = multi.getFileNames();
		
		while (en.hasMoreElements()) {
			
			String name = (String) en.nextElement();
			String oriname = "";
			String savename= "";
			File file = null;
			long len = 0;
			try {
				oriname  = multi.getOriginalFileName(name);
				savename = multi.getFilesystemName(name);
				file = multi.getFile(name);
				len = file.length();
			}catch(Exception e) {
				System.out.println("널인거 추가여"+name);
				continue;
			}
			
			FileVO fVO = new FileVO();
			fVO.setLen(len);
			fVO.setSavename(savename);
			fVO.setOriname(oriname);
			fVO.setId(id);
			list.add(fVO);
		}
		return list;
	}
}
