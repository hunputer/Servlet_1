package com.choa.util;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBConnecter {

	public Connection getConnect() throws Exception  {
		//1. DB 연결 정보
		String user="hr";
		String password="tiger";
		String url="jdbc:oracle:thin:@localhost:1521:xe";
		String driver = "oracle.jdbc.driver.OracleDriver";
		
		//2. driver를 메모리에 로딩
		Class.forName(driver);
		
		System.out.println("드라이버 로딩 완료");
		
		Connection con = DriverManager.getConnection(url, user, password);
		System.out.println(con);
		
		return con;
	}
}
