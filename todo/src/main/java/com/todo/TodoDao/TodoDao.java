package com.todo.TodoDao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class TodoDao {
	private static String dburl = "jdbc:mysql://localhost:3306/Todo";
	private static String dbUser = "Todo";
	private static String dbPass = "todo123!";
	private static Connection connect;
	//get set (select, update, insert, delete) 등 해야할 기능을 구현하자
	
	private void connectDB() throws ClassNotFoundException, SQLException{
		Class.forName("com.mysql.jdbc.Driver");
		TodoDao.connect = DriverManager.getConnection(dburl, dbUser, dbPass);
	}
	//필요한 쿼리들
	// 1. 첫 화면에 db에 저장되어있는 모든 Todo를 리스트로 전부 출력
	// 2. 새로운 Todo를 하나 생성
	// 3. Todo 하나를 제거함 (뭐를 기준으로 제거를 해줘야하나)
	// 4. Todo 하나의 type을 바꾸기
	// 5. 로그인은 나중에 해보자
	
}