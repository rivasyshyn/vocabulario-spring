<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="s"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

	<h1>List Flights</h1>
	<p>You searched for flights leaving ${searchCriteria.departFrom} on
		or about ${searchCriteria.departOn}, heading to
		${searchCriteria.arriveAt}, returning on or about
		${searchCriteria.returnOn}.</p>
	<table>
		<thead>
			<tr>
				<th>Number of Legs</th>
				<th>Total Travel Time</th>
				<th>Total Cost</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${result}" var="flight">
				<tr>
					<td>${flight.numberOfLegs}</td>
					<td>${flight.totalTravelTime}</td>
					<td>$${flight.totalCost}</td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
	<a href="${s:mvcUrl('FC#search').build()}">New Search</a>
	<a href="${s:mvcUrl('FC#specialDials').build()}">Flights</a>
	<a href="${s:mvcUrl('MC#index').build()}">Index</a>
</body>
</html>