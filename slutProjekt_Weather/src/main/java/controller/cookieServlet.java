package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class cookieServlet
 */
@WebServlet("/cookieServlet")
public class cookieServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public cookieServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		// Im not using this servet anymore. The idea was to create a session with value 
		// deciding if the site would use cookies or not. 
		// I didnt find a solution to save value to more then one page.
		
		String cookieq = request.getParameter("cookeQ");
		
		HttpSession userSession = request.getSession();
		userSession.setMaxInactiveInterval(36000);
		
		
		if (cookieq.equals("yes") || cookieq.equals("no")) {

			userSession.setAttribute("cookieQ", cookieq);

			String sessionStatus = (String) userSession.getAttribute("cookieQ");
			
			System.out.println(sessionStatus);

			RequestDispatcher rd = request.getRequestDispatcher("index.jsp");
			rd.forward(request, response);

		} else {

			response.sendRedirect("cookieq.jsp");

		}

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
