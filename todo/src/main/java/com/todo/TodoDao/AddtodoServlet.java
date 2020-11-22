package com.todo.TodoDao;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.todo.TodoDto.Todo;

/**
 * Servlet implementation class AddtodoServlet
 */
@WebServlet({ "/add", "/addtodo" })
public class AddtodoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddtodoServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
  //SELECT title, name, sequence, type, regdateFROM todo ORDER BY sequence;
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String title = request.getParameter("title");
		String name = request.getParameter("name");
		int sequence = Integer.parseInt(request.getParameter("sequence"));
		Todo todo = new Todo(title, name, sequence, "", "");
		TodoDao.insertTodo(todo);
		response.sendRedirect("/todo/index");
	}

}
