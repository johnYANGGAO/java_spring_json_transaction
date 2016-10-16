<!-- there is no need do this if you have used Servlet  >=2.5 -->
<%-- <%@ page isELIgnored="false" %> --%>

<html>
<body>
	<h1>${headmsg}</h1>
	<h3>congratulations , the engineering college has processed your
		application from successfully</h3>

	<h2>here is details :</h2>
	<table>
		<tr>
			<td>Name :</td>
			<td>${user.name}</td>
		</tr>
		<tr>
			<td>Age :</td>
			<td>${user.age}</td>
		</tr>
		<tr>
			<td>Gender :</td>
			<td>${user.gender}</td>
		</tr>
		<tr>
			<td>Phone :</td>
			<td>${user.mobilePhone}</td>
		</tr>
		<tr>
			<td>Address:</td>
			<td>country :${user.address.country} city:${user.address.city}
				street:${user.address.city}</td>
		</tr>

	</table>

</body>

</html>