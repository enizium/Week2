<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" 
"http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>User Form</title>
</head>
<body>
	<spring:url value="/employees/save" var="saveURL" />
	<form:form modelAttribute="employeeForm" method="post" action="${saveURL }">
		<form:hidden path="employeeid" />
		<table>
			<tr>
				<td>First name:</td>
				<td><form:input path="firstname" /></td>
			</tr>
			<tr>
				<td>Last name:</td>
				<td><form:input path="lastname" /></td>
			</tr>
			<tr>
				<td>Email:</td>
				<td><form:input path="email" /></td>
			</tr>
			<tr>
				<td>Phone number:</td>
				<td><form:input path="phoneNumber" /></td>
			</tr>
			<tr>
				<td>Post:</td>
				<td><form:input path="post" /></td>
			</tr>

			<tr>
				<td></td>
				<td>
					<button type="submit">Save</button>
				</td>
			</tr>
		</table>

	</form:form>

</body>
</html>