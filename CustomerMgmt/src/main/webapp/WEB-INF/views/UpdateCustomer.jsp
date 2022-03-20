<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Save Customer Information</title>
</head>
<body>
	<div
		style="border: 1px solid red; background-color: blue width: 100% margin-left=5%;">
		<h1>Save Customer</h1>
		<form action="./CustUpdate" method="post">
			<input type="text" name="id" value="${customer.id}" placeholder="id" />
			<br /> <input type="text" name="fname" value="${customer.fname}"
				placeholder="fname" /> <br /> <input type="text" name="lname"
				value="${customer.lname}" placeholder="lname" /> <br /> <input
				type="text" name="email" value="${customer.email}"
				placeholder="Email" /> <br /> <br /> <input type="submit"
				name="s2" value="Upd.Customer" />
		</form>

	</div>
</body>
</html>