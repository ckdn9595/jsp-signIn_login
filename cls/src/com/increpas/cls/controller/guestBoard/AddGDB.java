package com.increpas.cls.controller.guestBoard;

import javax.servlet.http.HttpServletRequest;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.HttpServletResponse;

import com.increpas.cls.controller.ClsMain;
import com.increpas.cls.dao.*;

public class AddGDB implements ClsMain {

	@Override
	public String exec(HttpServletRequest req, HttpServletResponse resp) {
		String view = "/cls/guestBoard/guestBoard.cls";
		
		ArrayList<String> name = new ArrayList<String>();
		name.add("jjang");
		name.add("kys");
		name.add("wook");
		name.add("jang");
		name.add("smkim");
		name.add("mygusdnd");
		name.add("euns");
		name.add("jieun");
		name.add("jeong");
		name.add("juhyun");
		name.add("park");
		name.add("joseph");
		name.add("dhgpcks");
		
		req.setAttribute("isRedirect", true);
		ArrayList<HashMap<String,String>> arr = new ArrayList<HashMap<String,String>>();
//		arr = getList();
		arr = getList(name);
		GBoardDao dao = new GBoardDao();
		
		int cnt = dao.addGBoard(arr);
		System.out.println(cnt);
		return view;
	}
	
	public ArrayList<HashMap<String,String>> getList(){
		ArrayList<HashMap<String,String>> list = new ArrayList<HashMap<String,String>>();
		HashMap<String,String> map1 = new HashMap<String,String>();
		map1.put("id", "euisan");
		map1.put("body", "인사말을 등록하세요!");
		HashMap<String,String> map2 = new HashMap<String,String>();
		map2.put("id", "joo");
		map2.put("body", "내가 1등이야");
		HashMap<String,String> map3 = new HashMap<String,String>();
		map3.put("id", "sun");
		map3.put("body", "그러지마세요 선생님..");
		HashMap<String,String> map4 = new HashMap<String,String>();
		map4.put("id", "jinwoo");
		map4.put("body", "내가 짱이야");
		HashMap<String,String> map5 = new HashMap<String,String>();
		map5.put("id", "dooly");
		map5.put("body", "호의가 계속되면 둘리");
		
		list.add(map1);
		list.add(map2);
		list.add(map3);
		list.add(map4);
		list.add(map5);
		
		return list;		
	}
	public ArrayList<HashMap<String,String>> getList(ArrayList<String> name){
		ArrayList<HashMap<String,String>> list = new ArrayList<HashMap<String,String>>();
		for (int i = 0 ; i < name.size(); i++) {
			HashMap<String,String> map = new HashMap<String,String>();
			map.put("id", name.get(i));
			map.put("body", "오늘가입함 ㅋ");
			
			list.add(map);
		}
		
		return list;
	}

}
