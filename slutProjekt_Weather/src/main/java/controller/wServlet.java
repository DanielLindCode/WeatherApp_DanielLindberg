package controller;

import java.io.IOException;


import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.GettheWeather;
import model.weatherBean;

/**
 * Servlet implementation class Wservlet
 */
@WebServlet("/wServlet")
public class wServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public wServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub

		String cityStr = request.getParameter("citySearch");
		String countryStr = request.getParameter("countrySearch");
		
		// Creates cookies for city and Country
		
		Cookie cityCookie = new Cookie("citySearch", cityStr);
		cityCookie.setMaxAge(60 * 60 * 24 * 365);
		response.addCookie(cityCookie);
		
		Cookie countryCookie = new Cookie ("countrySearch", countryStr);
		countryCookie.setMaxAge(60*60*24*365);		
		response.addCookie(countryCookie);
		
		

		weatherBean wBean = new weatherBean(cityStr, countryStr);

		GettheWeather.getWeather(wBean);

		request.setAttribute("wBean", wBean);
		
		RequestDispatcher rd = request.getRequestDispatcher("showWeather.jsp");
		rd.forward(request, response);
		
		/*
		
		// kollar vilket v�rde sessionen har just nu
		 * 
		System.out.println(request.getSession().getAttribute("cookieq"));
		
		// Skapar en session. Jag gjorde detta eftersom den jag skapade tidigare tappa sitt v�rder
		// n�r man g�r fr�n sida till sida. Jag ecperimenterar h�r men f�r inte resultatet jag vill.
		
		HttpSession userSession = request.getSession();
		userSession.setMaxInactiveInterval(36000);
		
		String cookieq = request.getParameter("cookeQ");
		
		userSession.setAttribute("cookieQ", cookieq);
		
		System.out.println("**********************************************");

		String sessionStatus = (String) userSession.getAttribute("cookieQ");
		
		System.out.println(sessionStatus);
*/
		
		
/*
		// Jag ville g�ra en koll som se om sessionen har r�tt v�rde. Har den det s� skapas cookies.
		// Annars skickas man till showWeather.jsp utan att f� se tidigare s�kningar.
		 
		if (request.getSession().getAttribute("cookieq").equals("yes")) {

			Cookie cityCookie = new Cookie("citySearch", cityStr);
			cityCookie.setMaxAge(60 * 60 * 24 * 365);
			// Cookie CountryCookie = new Cookie ("countrySearch", countryStr);
			// CountryCookie.setMaxAge(60*60*24*365);

			response.addCookie(cityCookie);
			// response.addCookie(CountryCookie);

			Cookie searchCookies[] = request.getCookies();
			String citySearch1 = searchCookies[0].getValue();

			System.out.println(citySearch1);

			RequestDispatcher rd = request.getRequestDispatcher("showWeather.jsp");
			rd.forward(request, response);

		} else {

			RequestDispatcher rd = request.getRequestDispatcher("showWeather.jsp");
			rd.forward(request, response);

		}
*/
	}

}