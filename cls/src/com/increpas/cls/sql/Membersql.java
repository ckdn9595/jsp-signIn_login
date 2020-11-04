package com.increpas.cls.sql;

public class Membersql {
	public final int SEL_LOGIN_CNT = 1001;
	public final int SEL_ID_CNT = 1002;
	public final int SEL_AVT_ALL = 1003;
	public final int SEL_INFO_ALL = 1004;
	public final int UPD_INFO = 2001;
	public final int ADD_MEMB = 3001;
	
	public String getSQL(int code) {
		StringBuffer buff = new StringBuffer();
		
		switch(code) {
		case SEL_LOGIN_CNT:
			buff.append("SELECT ");
			buff.append("	count(*) cnt ");
			buff.append("FROM ");
			buff.append("	member ");
			buff.append("WHERE ");
			buff.append("	id = ? ");
			buff.append("	AND pw = ? ");
			break;
		case SEL_ID_CNT:
			buff.append("SELECT ");
			buff.append("	count(*) cnt ");
			buff.append("FROM ");
			buff.append("	member ");
			buff.append("WHERE ");
			buff.append("	id = ? ");
			break;
		case SEL_AVT_ALL:
			buff.append("SELECT ");
			buff.append("	ano, afile sname, gen ");
			buff.append("FROM ");
			buff.append("	avatar ");
			break;
		case SEL_INFO_ALL:
			buff.append("SELECT ");
			buff.append("	mno, id, name, mail, gen, joindate ");
			buff.append("FROM ");
			buff.append("	member ");
			buff.append("WHERE ");
			buff.append(" id = ? ");
			break;
		case UPD_INFO:
			buff.append("UPDATE ");
			buff.append("	member ");
			buff.append("set ");
			buff.append("	mail = ? ");
			buff.append("WHERE ");
			buff.append(" id = ? ");
			break;
		case ADD_MEMB:
			buff.append("INSERT INTO ");
			buff.append("member(mno, id, pw, name, mail, gen, avt) ");
			buff.append("values( ");
			buff.append("( SELECT NVL(MAX(mno)+1,1001) FROM member ), ");
			buff.append(" ?,?,?,?,?,?) " );
			break;
		}
		
		return buff.toString();
	}
}
