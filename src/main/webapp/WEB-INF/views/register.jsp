
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<html>
<body>
	<h1>${headmsg}</h1>
	<h3>this is the register page</h3>
	
	<form:errors path="user.*" />
	<form action="/springrestexample/registerdown.html" method="post">
		<table>
			<tr>
				<td>Name :</td>
				<td><input type="text" name="name" /></td>
			</tr>

			<tr>
				<td>Age :</td>
				<td><input type="text" name="age" /></td>
			</tr>
			<tr>
				<td>Gender :</td>
				<td><input type="text" name="gender" /></td>
			</tr>
			<tr>
				<td>Phone :</td>
				<td><input type="text" name="mobilePhone" /></td>
			</tr>
		</table>

		<table>
			<tr>
				<td>here is the address</td>
			</tr>
			<tr>
				<td>Country :<input type="text" name="address.country" /></td>
			</tr>
			<tr>
				<td>City :<input type="text" name="address.city" /></td>
			</tr>
			<tr>
				<td>Street :<input type="text" name="address.street" /></td>
			</tr>
			<tr>
				<td><input type="submit" value="click here" /></td>
			</tr>

		</table>
	</form>
</body>
</html>