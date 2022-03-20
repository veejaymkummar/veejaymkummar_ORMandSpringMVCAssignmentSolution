<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"
	import="java.util.List,com.rnd.crm.entity.Customer"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Customer Relationship Management System</title>
</head>
<body>
	<div
		style="border: 1px solid red; background-color =blue; width: 70%; height: 100%; margin-left: 5%;">
		<a href="./SaveCust">Add New Customer</a>
		<h1
			style="color: red; text-decoration: underline; text-align: center;">
			All Customers</h1>

		<%
		List<Customer> customerslist = (List<Customer>) request.getAttribute("Customers");
		%>
		<table border="1" width="100%" height="100%">
			<tr>
				<th>Customer Id</th>
				<th>First Name</th>
				<th>Last Name</th>
				<th>Email Address</th>
				<th>Update</th>
				<th>Delete</th>
			</tr>
			<%
			for (Customer customer : customerslist) {
				out.println("<tr><td>" + customer.getId() + "</td> <td>" + customer.getFname() + "</td><td>"
				+ customer.getLname() + "</td><td>" + customer.getEmail() 
				+ "</td><td><a href='./OneCustomer?id="
				+ customer.getId()
				+ "'>Update</a></td><td><a href='./delete-customer?id="
				+ customer.getId() + "'>Delete</a></td></tr>");
			}
			%>
		</table>

	</div>

</body>
</html>