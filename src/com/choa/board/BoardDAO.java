package com.choa.board;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import com.choa.util.DBConnecter;

public class BoardDAO {
	private DBConnecter dbConnecter;
	
	public BoardDAO() {
		dbConnecter = new DBConnecter();
	}
	
	public ArrayList<BoardDTO> boardList() throws Exception{
		ArrayList<BoardDTO> ar = new ArrayList<BoardDTO>();
		Connection con = dbConnecter.getConnect();
		
		String sql = "select * from board order by num desc";
		PreparedStatement st = con.prepareStatement(sql);
		
		ResultSet rs = st.executeQuery();
		
		while(rs.next()) {
			BoardDTO boardDTO = new BoardDTO();
			System.out.println(rs.getLong("num"));
			boardDTO.setNum(rs.getLong("num"));
			boardDTO.setTitle(rs.getString("title"));
			boardDTO.setWriter(rs.getString("writer"));
			boardDTO.setContents(rs.getString("contents"));
			boardDTO.setRegDate(rs.getDate("regdate"));
			boardDTO.setHit(rs.getLong("hit"));
			ar.add(boardDTO);
		}
		
		rs.close();
		st.close();
		con.close();
		
		return ar;
	}
	
}
