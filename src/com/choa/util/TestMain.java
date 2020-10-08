package com.choa.util;

public class TestMain {

	public static void main(String[] args) {
		DBConnecter db =new DBConnecter();
		try {
			db.getConnect();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
}
