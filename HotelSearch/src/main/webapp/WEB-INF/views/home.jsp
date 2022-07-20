<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Find a Hotel</title>
<link href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.1/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-WskhaSGFgHYWDcbwN70/dfYBj47jz9qbsMId/iRN3ewGhXQFZCSftd1LZCfmhktB" crossorigin="anonymous">
</head>
<body>
	<h1>Hotel Search</h1>
	<p>Select a city</p>
	<form action="/citySelect" method="POST">
		<select name="city">
			<option disabled selected>- Select One -</option>
			<c:forEach var="city" items="${cities}">
				<option value="${city}">${city}</option>
			</c:forEach>
		</select><br>
		Max Price: <input type="number" name="max"/><br>
		<input type="submit"/>
	</form>
</body>
</html>