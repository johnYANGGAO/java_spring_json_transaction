<%@ page contentType="text/html;charset=UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>

<html>
<body>
	<link rel="stylesheet" href="<spring:theme code='styleSheet'/>"
		type="text/css" />
	<p>
		<a href="/springrestexample/register.html?siteTheme=green">Green</a> |
		<a href="/springrestexample/register.html?siteTheme=red">Red</a>

	</p>

	<a href="/springrestexample/register.html?sitelanguage=en">English</a> |
	<a href="/springrestexample/register.html?sitelanguage=zh">Chinese</a> |
	<a href="/springrestexample/register.html?sitelanguage=fr">French</a>

	<h1>${headmsg}</h1>
	<h3>this is the register page</h3>

	<form:errors path="user.*" />
	<form action="/springrestexample/registerdown.html" method="post">
		<table>
			<tr>
				<!-- <td>Name :</td> -->
				<td><spring:message code="lable.name"></spring:message></td>
				<td><input type="text" name="name" /></td>
			</tr>
			<tr>
				<td>GratuDate :</td>
				<td><input type="date" name="gratuDate" /></td>
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