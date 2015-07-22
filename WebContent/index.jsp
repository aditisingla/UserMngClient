<!DOCTYPE html>
<%@ taglib prefix="s" uri="/struts-tags"%>
<html>
<head>
<title>Add and Retrieve Users</title>
</head>
<body>
	<table style="width: 80%;">
		<tr>
			<td><b>Add User:</td>
		</tr>
		<tr>
			<td>
				<form action="add" method="post">
					<table style="width: 50%;">
						<tr align="center">
							<td>First Name: <input type="text" name="user.firstName" /></td>
						</tr>
						<tr align="center">
							<td>Last Name: <input type="text" name="user.lastName" /></td>
						</tr>
						<tr align="center">
							<td><input type="submit" name="Save" value="Save" /></td>
						</tr>
						<tr><td>&nbsp;&nbsp;</td></tr>
						<tr align="center">
							<td><input type="submit" value="Retrieve Users" /></td>
						</tr>
					</table>
				</form>
			</td>
		</tr>
	</table>
	<table style="width: 80%;">
		<tr>
			<td>
				<form action="retrieve">
					<table style="width: 70%;" border="1">
						<s:iterator value="userList">
							<tr align="center">
								<td><s:property value="id" /></td>
								<td><s:property value="firstName" /></td>
								<td><s:property value="lastName" /></td>
							</tr>
						</s:iterator>
					</table>
				</form>
			</td>
		</tr>
	</table>
</body>
</html>