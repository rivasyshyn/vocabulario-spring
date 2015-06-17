<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Search results</title>
</head>
<body>
	<h3>Search For Flights</h3>
	<spring:nestedPath path="searchCriteria">
		<form action="/Vocabulario/flights/search" method="post">
			<table>
				<tr>
					<td>Depart From:</td>
					<td><spring:bind path="departFrom">
							<input type="text" name="${status.expression}"
								value="${status.value }" />
						</spring:bind></td>
					<td>Depart On:</td>
					<td><spring:bind path="departOn">
							<input type="text" name="${status.expression}"
								value="${status.value}" />
						</spring:bind> <span style="font-size: smaller">(yyyy-MM-dd HH)</span></td>
				<tr>
					<td>Arrive At:</td>
					<td><spring:bind path="arriveAt">
							<input type="text" name="${status.expression}"
								value="${status.value}" />
						</spring:bind></td>
					<td>Return On:</td>
					<td><spring:bind path="returnOn">
							<input type="text" name="${status.expression}"
								value="${status.value}" />
						</spring:bind> <span style="font-size: smaller">(yyyy-MM-dd HH)</span></td>
				</tr>
				<tr>
					<td />
					<td><input type="submit" value="Search" /></td>
					<td />
					<td />
				</tr>
				</tr>

			</table>
		</form>
	</spring:nestedPath>
</body>
</html>