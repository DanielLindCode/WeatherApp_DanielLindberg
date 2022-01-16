<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@page import="model.weatherBean"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link href="css/style.css" rel="stylesheet" />

<title>the weather</title>
</head>
<body>


	<%
	weatherBean wBean = (weatherBean) request.getAttribute("wBean");
	/*
	out.print(wBean.getCityStr());
	out.print("<br>");	
	out.print("Clouds: " + wBean.getCloudsStr());
	out.print("<br>");	
	out.print("Weather: " + wBean.getWeatherStr());
	out.print("<br>");
	out.print("Temprature: " + wBean.getTempStr());
	*/
	%>
	<main>

		<div class="container">
			<div class="form-box">
				<%
				out.print("<p>Weather Status in " + wBean.getCityStr() + " : " + wBean.getWeatherStr() + "</p>");
				out.print("<br>");
				out.print("<p>The temperature is " + wBean.getTempStr() + " °C</p>");
				out.print("<br>");
				out.print("<p>You made this search: " + wBean.getTimeStamp() + "</p>");
				%>
			</div>
		</div>
		<div class="returnLink"><a  href="index.jsp">Do another search?</a></div>

	</main>

</body>
</html>