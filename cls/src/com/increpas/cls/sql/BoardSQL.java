package com.increpas.cls.sql;

public class BoardSQL {
	public final int SEL_BOARD_LIST = 1001;
	public final int SEL_BD_TCNT = 1002;
	
	public final int UPD_CK_CNT = 2001;
	public final int ADD_BOARD = 3001;
	public final int ADD_FILE = 3002;
	
	public String getSQL(int code) {
		StringBuffer buff = new StringBuffer();
		
		switch(code) {
		case SEL_BOARD_LIST:
			buff.append("SELECT * ");
			buff.append("FROM   (SELECT ");
			buff.append("        rownum rno, b.* ");
			buff.append("  		  FROM ");
			buff.append("       ( SELECT   ");
			buff.append("            BNO, M.ID ID, D.TITLE TITLE, D.BDATE DAT, BCLICK ");
			buff.append("        FROM BOARD D, (  ");
			buff.append("                            SELECT MNO, ID  ");
			buff.append("                            FROM MEMBER  ");
			buff.append("                                           ) M  ");
			buff.append("        WHERE BISSHOW = 'Y' AND D.BMNO = M.MNO  ");
			buff.append("        ORDER BY BDATE )b) ");
			buff.append("where ");
			buff.append("    rno BETWEEN ? AND ? ");
			break;
		case SEL_BD_TCNT:
			buff.append("SELECT ");
			buff.append("count(*) tot ");
			buff.append("FROM ");
			buff.append(" board ");
			buff.append("WHERE ");
			buff.append(" bisshow = 'Y' ");
			break;
		case UPD_CK_CNT:
			buff.append("UPDATE  ");
			buff.append("	BOARD ");
			buff.append("SET BCLICK = BCLICK + 1 ");
			buff.append("WHERE BNO = ? ");
			break;
		case ADD_BOARD:
			buff.append("INSERT INTO ");
			buff.append("BOARD(bno, title, body, bmno) ");
			buff.append("VALUES( ");
			buff.append("    (SELECT NVL(MAX(bno) + 1, 10001) FROM board), ");
			buff.append("    ?, ?,(Select mno FROM member WHERE id = ?) ");
			buff.append(") ");
			break;
		case ADD_FILE:
			buff.append("INSERT INTO ");
			buff.append("fileinfo(fno, fbno,  dir, oriname, savename, len) ");
			buff.append("VALUES( ");
			buff.append("    (SELECT NVL(MAX(FNO)+1,1000001) FROM FILEINFO),  ");
			buff.append("    (SELECT MAX(BNO) FROM BOARD, MEMBER WHERE BMNO = MNO AND ID = ?) ");
			buff.append("    ,'/img/upload/', ?, ?, ? ");
			buff.append(") ");
			break;
		};
		
		return buff.toString();
	}
}
