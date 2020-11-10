package com.increpas.cls.sql;

public class GBoardSQL {
	public final int SEL_ALL_GBD = 1001;
	public final int SEL_ID_CNT = 1002;
	public final int SEL_GBD_ROW =1003;
	public final int SEL_GBD_TCNT =1004;
	
	public final int ADD_GBD = 3001;
	
	public String getSQL(int code) {
		StringBuffer buff = new StringBuffer();
		
		switch(code) {
		case SEL_ALL_GBD:
			buff.append("SELECT ");
			buff.append("gno, id, body, wdate, afile ");
			buff.append("FROM ");
			buff.append("guestboard g, member m, avatar a ");
			buff.append("WHERE ");
			buff.append(" g_mno = mno ");
			buff.append(" AND avt = ano ");
			buff.append(" AND g.isshow = 'Y' ");
			buff.append(" AND m.isshow = 'Y' ");
			buff.append("order by ");
			buff.append(" wdate desc ");
			break;
		case SEL_ID_CNT:
			buff.append("SELECT ");
			buff.append("count(*) cnt ");
			buff.append("FROM ");
			buff.append("guestboard g, member m ");
			buff.append("WHERE ");
			buff.append(" g_mno = mno ");
			buff.append(" AND id = ? ");
			break;
		case SEL_GBD_ROW:
			buff.append("SELECT ");
			buff.append("	* ");
			buff.append("FROM ");
			buff.append("	(SELECT ");
			buff.append("		ROWNUM rno,  g.* ");
			buff.append("	FROM ");
			buff.append("		(SELECT ");
			buff.append("			gno, id, body, wdate, afile avatar ");
			buff.append("		FROM ");
			buff.append("			guestboard, member, avatar ");
			buff.append("		WHERE ");
			buff.append("			g_mno = mno ");
			buff.append("			AND avt = ano ");
			buff.append("			AND guestboard.isshow = 'Y' ");
			buff.append("			AND member.isshow = 'Y' ");
			buff.append("		ORDER BY ");
			buff.append("			wdate DESC) g) ");
			buff.append("WHERE ");
			buff.append("	rno BETWEEN ? AND ? ");
			break;
		case SEL_GBD_TCNT:
			buff.append("SELECT ");
			buff.append("count(*) tot ");
			buff.append("FROM ");
			buff.append("guestboard ");
			buff.append("WHERE ");
			buff.append(" isshow = 'Y' ");
			break;
		case ADD_GBD:
			buff.append("INSERT INTO ");
			buff.append("guestboard(gno, g_mno, body) ");
			buff.append("values( ");
			buff.append(" (SELECT NVL(MAX(gno)+1,1001) from guestboard ), ");
			buff.append("  (SELECT mno FROM member WHERE id = ? AND isshow = 'Y') ");
			buff.append("  , ? ");
			buff.append(" ) ");
		break;
		}
		
		
		return buff.toString();
	}
}
