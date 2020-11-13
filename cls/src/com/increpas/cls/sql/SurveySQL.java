package com.increpas.cls.sql;

public class SurveySQL {
	public final int SEL_CURR_LIST = 1001;
	public final int SEL_QUEST_LIST = 1002;
	public final int SEL_SELECT_LIST = 1003;
	public final int SEL_ANSWER_RESULT = 1004;
	
	public final int ADD_ANSWER = 3001;
	
	public String getSQL(int code) {
		StringBuffer buff = new StringBuffer();
		
		switch(code) {
		case SEL_CURR_LIST:
			buff.append("SELECT s.sno, sbody, ");
			buff.append(" (   SELECT ");
			buff.append("       count(*) cnt ");
			buff.append("    FROM surveyquest, surveyanser, member ");
			buff.append("   where  ");
			buff.append("      sino = s.sno ");
			buff.append("    and sqno = sq_qno ");
			buff.append("    and mno = sa_mno ");
			buff.append("     and id = ? ) cnt ");
			buff.append("FROM surveyInfo s ");
//			buff.append("WHERE SYSDATE BETWEEN SSTART AND SEND ");
		break;
		case SEL_QUEST_LIST:
			buff.append("select sqno, sqbody, upno, sbody, sno ");
			buff.append("from surveyquest, surveyinfo ");
			buff.append("where upno is null and sino = ? ");
		break;
		case SEL_SELECT_LIST:
			buff.append("select sqno, sqbody, sno ");
			buff.append("from surveyquest, surveyinfo ");
			buff.append("where upno = ? and sino = sno ");
		break;
		case SEL_ANSWER_RESULT:
			buff.append("select ");
		    buff.append("p.*, o.sbody ");
		    buff.append("from surveyinfo o,( select ");
		    buff.append(" sqno qno, sqbody qbody , sino, upno, nvl(cnt,0) cnt, ROUND(nvl(per,0), 0) per ");
		    buff.append("           from surveyquest,(    ");
		    buff.append("                          select ");
		    buff.append("                             sq_qno, count(*)cnt, (count(*)/(select ");
		    buff.append("                                                              count(DISTINCT sa_mno) mcnt ");
		    buff.append("                                                              from surveyanser)*100)per ");
		    buff.append("                          from ");
		    buff.append("                              surveyanser ");
		    buff.append("                          group by ");
		    buff.append("                              sq_qno ");
		    buff.append("                          ) ");
		    buff.append("          where  ");
		    buff.append("              sqno = sq_qno(+) ");
		    buff.append("	) p ");
		    buff.append("	where ?  = o.sno ");
		    buff.append("	order by sno , qno ");
			break;
		case ADD_ANSWER:
			buff.append("insert into ");
		    buff.append("surveyanser ");
		    buff.append("values( ");
		    buff.append("(select nvl(max(sno)+1, 10001) from surveyanser ), ");
		    buff.append("(select mno from member where id= ?), ");
		    buff.append(" ?, sysdate) ");
			break;
		}
		return buff.toString();
	}
}
