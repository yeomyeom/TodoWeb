package com.todo.TodoDao;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.todo.TodoDto.Todo;

/**
 * Servlet implementation class IndexServlet
 */
@WebServlet({ "/index", "/" })
public class IndexServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public IndexServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		ArrayList<Todo> todoListTODO = new ArrayList<Todo>();
		ArrayList<Todo> todoListDOING = new ArrayList<Todo>();
		ArrayList<Todo> todoListDONE = new ArrayList<Todo>();
		todoListTODO = TodoDao.allTodoList("TODO");
		todoListDOING = TodoDao.allTodoList("DOING");
		todoListDONE = TodoDao.allTodoList("DONE");
		request.setAttribute("todoListTODO", todoListTODO);
		request.setAttribute("todoListDOING", todoListDOING);
		request.setAttribute("todoListDONE", todoListDONE);
		RequestDispatcher reqDis = request.getRequestDispatcher("index.jsp");
		reqDis.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
