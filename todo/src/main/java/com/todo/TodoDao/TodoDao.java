package com.todo.TodoDao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.todo.TodoDto.Todo;

public class TodoDao {
	private static String dburl = "jdbc:mysql://localhost:3306/Todo?&useSSL=false";
	private static String dbUser = "Todo";
	private static String dbPass = "todo123!";
	private static Connection connect;
	//get set (select, update, insert, delete) 등 해야할 기능을 구현하자
	
	private static void connectDB() throws ClassNotFoundException, SQLException{
		try {
			Class.forName("com.mysql.jdbc.Driver");
			TodoDao.connect = DriverManager.getConnection(dburl, dbUser, dbPass);
		}catch (Exception e) {
			e.printStackTrace();
			System.out.print("DB connection fail - connectDB");
		}
	}
	private static void disconnectDB() throws SQLException {
		if(connect != null) {
			try {
			connect.close();
			}catch (SQLException e) {
				System.out.print("DB disconnection fail - disconnectDB");
			}
		}
	}
	//필요한 쿼리들
	// 1. 첫 화면에 db에 저장되어있는 모든 Todo를 리스트로 전부 출력
	// 2. 새로운 Todo를 하나 생성
	// 3. Todo 하나를 제거함 (뭐를 기준으로 제거를 해줘야하나)
	// 4. Todo 하나의 type을 바꾸기
	// 5. 로그인은 나중에 해보자
	public static ArrayList<Todo> allTodoList(String types){
		ArrayList<Todo> todoList = new ArrayList<Todo>();
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			connectDB();
			String sql = "SELECT title, name, sequence, type, regdate "
					+ "FROM todo WHERE type=? ORDER BY sequence;";
			ps = connect.prepareStatement(sql);
			ps.setString(1, types);
			//ps.setInt(sql 물음표 몇번째, 넣을 숫자)
			rs = ps.executeQuery();
			while(rs.next()) {
				String dbTitle = rs.getString("title");
				String dbName = rs.getString("name");
				int dbSequence = rs.getInt("sequence");
				String dbType = rs.getString("type");
				String dbDate = rs.getString("regdate");
				todoList.add(new Todo(dbTitle, dbName, dbSequence, dbType, dbDate));
			}
			disconnectDB();
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			if(rs!=null) {
				try {
					rs.close();
				}catch(SQLException e) {
					e.printStackTrace();
				}
			}
			if(ps!=null) {
				try {
					ps.close();
				}catch(SQLException e) {
					e.printStackTrace();
				}
			}
		}
		return todoList;
	}
	//SELECT title, name, sequence, type, regdateFROM todo ORDER BY sequence;
	public static void insertTodo(Todo todo) {
		PreparedStatement ps = null;
		String sql = "INSERT INTO todo (title, name, sequence) VALUES (?, ?, ?)";
		try {
			connectDB();
			ps = connect.prepareStatement(sql);
			ps.setString(1, todo.getTitle());
			ps.setString(2, todo.getName());
			ps.setInt(3, todo.getSequence());
			ps.executeUpdate();
			disconnectDB();
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			if(ps!=null) {
				try {
					ps.close();
				}catch(SQLException e) {
					e.printStackTrace();
				}
			}
		}
	}
	
	public static void upgradeType(Todo todo) {
		//TODO -> DOING -> DONE
		PreparedStatement ps = null;
		String sql = "UPDATE todo SET type = ? WHERE title = ?;";
		try {
			connectDB();
			ps=connect.prepareStatement(sql);
			ps.setString(2, todo.getTitle());
			if("TODO".equals(todo.getType())) {
				ps.setString(1, "DOING");
			}else if("DOING".equals(todo.getType())) {
				ps.setString(1, "DONE");
			}
			ps.executeUpdate();
			disconnectDB();
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			if(ps!=null) {
				try {
					ps.close();
				}catch(SQLException e) {
					e.printStackTrace();
				}
			}
		}
	}
	
	public static void deleteTodo(Todo todo) {
		PreparedStatement ps = null;
		String sql = "DELETE FROM todo WHERE title = ?;";
		try {
			connectDB();
			ps=connect.prepareStatement(sql);
			ps.setString(1, todo.getTitle());
			ps.executeUpdate();
			disconnectDB();
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			if(ps!=null) {
				try {
					ps.close();
				}catch(SQLException e) {
					e.printStackTrace();
				}
			}
		}
	}
}