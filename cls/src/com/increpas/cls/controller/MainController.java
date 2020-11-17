package com.increpas.cls.controller;
import com.increpas.cls.dao.*;

import java.io.UnsupportedEncodingException;
import java.math.BigInteger;
import java.net.URLEncoder;
import java.security.SecureRandom;

import javax.servlet.http.*;

import org.apache.catalina.Session;

public class MainController implements ClsMain {

	@Override
	public String exec(HttpServletRequest req, HttpServletResponse resp) {
//		String clientId = "2zF0slKFPpw3BrSwHK9t";
//		String redirectURI;
//		try {
//			redirectURI = URLEncoder.encode("/cls/main.cls", "UTF-8");
//			SecureRandom random = new SecureRandom();
//			String state = new BigInteger(130, random).toString();
//			String apiURL = "https://nid.naver.com/oauth2.0/authorize?response_type=code";
//			apiURL += "&client_id=" + clientId;
//		    apiURL += "&redirect_uri=" + redirectURI;
//		    apiURL += "&state=" + state;
////		    session.setAttribute("state", state);
//		    req.setAttribute("STATE", state);
//		    req.setAttribute("API", apiURL);
//	   
//		} catch (UnsupportedEncodingException e) {
//			// TODO Auto-generated catch block
//			System.out.println("씨바 역시 안되내 ㅋㅋ");
//			e.printStackTrace();
//		}
	    
		
		
		
		
		req.setAttribute("isRedirect", false);
		String view = "main";
		
//		System.out.println("view : " + view);
		int cnt = new ReBoardDao().getCnt();
//		Cookie ck = new Cookie("firstCk", "icanusethis");
//		ck.setMaxAge(60*60);
//		resp.addCookie(ck);
		req.setAttribute("RCNT", cnt);
		return view;
	}

	

}
