<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<style type="text/css"></style>
ul {
	list-style-type: none;
	background-color: red;
	overflow: hidden;
	background-color: #222;
}
li {
	float: right;
}
li a {
	display: block;
	margin: 0px;
	padding: 15px;
}
li a:hover {
	background-color: #222;
}
</style>
</head>
<body>
<ul>
		<li><a style="color: white;" href="./logout">Logout</a></li>
		<li><a style="color: white;" href="./search">Search pets</a></li>
		<li><a style="color: white;" href="./insert">Insert pet details</a></li>
		<li><a style="color: white;" href="./update">Update pets</a></li>
		<li><a style="color: white;" href="./remove">Remove pets	</a></li>
	</ul>

</body>
</html>