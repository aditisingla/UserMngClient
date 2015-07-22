<!DOCTYPE html>
<%@ taglib prefix="s" uri="/struts-tags"%>
<html>
<head>
<title>Add and Retrieve Users</title>
</head>
<body>
<s:if test="hasActionErrors()">
    <div class="errorDiv">
        <s:actionerror/>
    </div>
</s:if>
	<table style="width: 50%;">
		<tr>
			<td><b>Add User:</td>
		</tr>
		<tr>
			<td align="center">
				<form action="add" method="post">
					<table >
						<tr align="center">
							<td>First Name: <input type="text" name="user.firstName" /></td>
						</tr>
						<tr align="center">
							<td>Last Name: <input type="text" name="user.lastName" /></td>
						</tr>
						<tr align="center">
							<td style="padding: 10px"><input type="submit" name="Save" value="Save" /></td>
						</tr>
					</table>
				</form>
			</td>
		</tr>
		<tr>
			<td style="text-align: center; padding: 5px">
				<form action="retrieve">
					<input type="submit" value="Retrieve Users" />
				</form>
			</td>
		</tr>
	</table>
	<s:if test="%{userList.size>0}">
	<table style="width: 80%;">
		<tr>
			<td>
				<table style="width: 80%;border-collapse: collapse" border="1">
					<tr align="center">
						<td><b>Id</b></td>
						<td><b>First Name</b></td>
						<td><b>Last Name</b></td>
					</tr>
					<s:iterator value="userList">
						<tr align="center">
							<td><s:property value="getText('{0,number,#,##0}',{id})" /></td>
							<td><s:property value="firstName" /></td>
							<td><s:property value="lastName" /></td>
						</tr>
					</s:iterator>
				</table>
			</td>
		</tr>
	</table>
	</s:if>
</body>
</html>