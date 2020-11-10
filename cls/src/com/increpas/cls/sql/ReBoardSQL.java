package com.increpas.cls.sql;

public class ReBoardSQL {
	public final int RB_SEL_LIST = 1001;
	public final int RB_ADD_SET = 3001;
	
	public String getSQL(int code) {
		StringBuffer buff = new StringBuffer();
		
		switch(code) {
		case RB_SEL_LIST:
			buff.append("select * ");
			buff.append("from REBOARD ");
			buff.append("WHERE  ");
			buff.append(" ISSHOW = 'Y' ");
		break;	
		case RB_ADD_SET:
			buff.append("INSERT INTO ");
			buff.append("REBOARD(bno, b_mno, body) ");
			buff.append("values ");
			buff.append("( (select NVL(MAX(bno)+1,10000) from REBOARD ), ");
			buff.append("1001, '첫번째 행 삽입') ");
		break;	
		}
		
		return buff.toString();
	}
}
