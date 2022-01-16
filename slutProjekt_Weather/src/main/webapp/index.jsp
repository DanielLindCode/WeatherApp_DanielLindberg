<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>


<%
/*	
	This didnt turn out well so Ive commented it out. 
	-------------------------------------------------------------------------
	//I dont know how to make a promt to save cookies or not so Im doing a page for it.
	//This checks if there is any value in my session. If there is a value you can do a serach.
	//If not, you will get dispatched to the cookieq.jsp
	
if (session.getAttribute("cookieQ") != null) {
	System.out.println("-----------------------------------");
	System.out.println(session.getAttribute("cookieQ"));
	System.out.println("-----------------------------------");
	
	*/
%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link href="css/style.css" rel="stylesheet" />
<title>OpenWeather</title>
</head>
<body>

	<div class="container">

		<form action="wServlet" method="get">
			<h1>Weather Search!</h1>
			<div class="form-box">

				<input type="text" name="citySearch" placeholder="City"
					class="search-field city" />
				<input type="text" name="countrySearch" placeholder="country"
					class="search-field country" />

				<button type="submit" class="search-btn">Submit</button>
			</div>
		</form>
	</div>

	<%
	// If you didnt have a value in session you would be sent to my "allow cookies page".

	/*
	} else {
		response.sendRedirect("cookieq.jsp");
	}
	*/
	%>
	<div class="history">
		<%
		// Checks if there is cookies saved
		Cookie[] cookies = request.getCookies();

		if (cookies != null) {

			String cityCookie = cookies[1].getValue().toString();
			System.out.println(cityCookie);

			String countryCookie = cookies[2].getValue().toString();
			System.out.println(countryCookie);

			out.print("<h3> History: <br>" + cityCookie + " , " + countryCookie + "</h3>");

			/*
			
			// This was a experiment if cookies just kept adding to the array after every search.
			// They dont.
			String cityCookie2 = cookies[3].getValue().toString();
			System.out.println(cityCookie);
			
			String countryCookie2 = cookies[4].getValue();
			System.out.println(countryCookie);			
			
			out.print("<h1> Earlier searches: " + cityCookie2 + " , " + countryCookie2 + "</h1>");
			*/

		} else {
			out.println("<h2>No history found</h2>");
		}
		%>
	</div>

</body>
</html>