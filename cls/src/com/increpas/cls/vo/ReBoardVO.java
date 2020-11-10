package com.increpas.cls.vo;

import java.util.*;
import java.sql.Time;
import java.text.*;

public class ReBoardVO {
	
	private int bno, b_mno, upno;
	private String body, isshow, date;
	private Date wdate;
	private Time wtime;
	public int getBno() {
		return bno;
	}
	public void setBno(int bno) {
		this.bno = bno;
	}
	public int getB_mno() {
		return b_mno;
	}
	public void setB_mno(int b_mno) {
		this.b_mno = b_mno;
	}
	public int getUpno() {
		return upno;
	}
	public void setUpno(int upno) {
		this.upno = upno;
	}
	public String getBody() {
		return body;
	}
	public void setBody(String body) {
		this.body = body;
	}
	public String getIsshow() {
		return isshow;
	}
	public void setIsshow(String isshow) {
		this.isshow = isshow;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public void setDate() {
		SimpleDateFormat form1 = new SimpleDateFormat("YYYY/MM/DD");
		SimpleDateFormat form2 = new SimpleDateFormat("HH/mm");
		this.date = form1.format(wdate) + form2.format(wtime);
	}
	public Date getWdate() {
		return wdate;
	}
	public void setWdate(Date wdate) {
		this.wdate = wdate;
	}
	public Time getWtime() {
		return wtime;
	}
	public void setWtime(Time wtime) {
		this.wtime = wtime;
		setDate();
	}
	

}
