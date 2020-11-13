package com.increpas.cls.vo;
import java.sql.*;
import java.text.*;
public class SurveyVO {
	private int sno, qno, sano, mno, upno, cnt;
	private double per;
	private String body, qbody, id, sdate, ssdate, sedate;
	private Date startdate, enddate, sadate;
	private Time starttime, endtime, satime;
	
	public String strForm(Date d, Time t) {
		String str = "";
		SimpleDateFormat form1 = new SimpleDateFormat("yyyy/MM/dd");
		SimpleDateFormat form2 = new SimpleDateFormat("HH:mm");
		str = form1.format(d) + " " + form2.format(t);
		return str;
	}
	public int getSno() {
		return sno;
	}
	public void setSno(int sno) {
		this.sno = sno;
	}
	public double getPer() {
		return per;
	}
	public void setPer(double per) {
		this.per = per;
	}
	public int getQno() {
		return qno;
	}
	public void setQno(int qno) {
		this.qno = qno;
	}
	public int getSano() {
		return sano;
	}
	public void setSano(int sano) {
		this.sano = sano;
	}
	public int getMno() {
		return mno;
	}
	public void setMno(int mno) {
		this.mno = mno;
	}
	public int getUpno() {
		return upno;
	}
	public void setUpno(int upno) {
		this.upno = upno;
	}
	public int getCnt() {
		return cnt;
	}
	public void setCnt(int cnt) {
		this.cnt = cnt;
	}
	public String getBody() {
		return body;
	}
	public void setBody(String body) {
		this.body = body;
	}
	public String getQbody() {
		return qbody;
	}
	public void setQbody(String qbody) {
		this.qbody = qbody;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getSdate() {
		return sdate;
	}
	public void setSdate(String sdate) {
		this.sdate = sdate;
	}
	public void setSdate() {
		sdate = strForm(sadate, satime);
	}
	public String getSsdate() {
		return ssdate;
	}
	public void setSsdate(String ssdate) {
		this.ssdate = ssdate;
	}
	public void setSsdate() {
		ssdate = strForm(startdate, starttime);
	}
	public String getSedate() {
		return sedate;
	}
	public void setSedate(String sedate) {
		this.sedate = sedate;
	}
	public void setSedate() {
		sedate = strForm(enddate, endtime);
	}
	public Date getStartdate() {
		return startdate;
	}
	public void setStartdate(Date startdate) {
		this.startdate = startdate;
	}
	public Date getEnddate() {
		return enddate;
	}
	public void setEnddate(Date enddate) {
		this.enddate = enddate;
	}
	public Date getSadate() {
		return sadate;
	}
	public void setSadate(Date sadate) {
		this.sadate = sadate;
	}
	public Time getStarttime() {
		return starttime;
	}
	public void setStarttime(Time starttime) {
		this.starttime = starttime;
		setSsdate();
	}
	public Time getEndtime() {
		return endtime;
	}
	public void setEndtime(Time endtime) {
		this.endtime = endtime;
		setSedate();
	}
	public Time getSatime() {
		return satime;
	}
	public void setSatime(Time satime) {
		this.satime = satime;
		setSdate();
	}
}
