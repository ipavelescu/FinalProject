<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>

<html>
<head>
    <title>Admin section - User listing</title>
    <link href="<s:url value="/css/userlist.css"/>" rel="stylesheet" type="text/css"/>
</head>
<body>
 
<s:actionerror/>

<h2>Users</h2>
<table>
<tr>
	<th>LastName</th>
	<th>FirstName</th>
    <th>UserName</th>
    <th>Mobile</th>
    <th>EMail</th>
    <th>Operations</th>
</tr>
<s:iterator value="userList" var="user">
    <tr>
        <td><s:property value="lastName"/></td>
        <td><s:property value="firstName"/></td> 
        <td><s:property value="userName"/></td>
        <td><s:property value="mobile"/></td>
        <td><s:property value="email"/></td>
        <td><a href="editUser?userId=<s:property value="userId"/>">update</a>
        <br><a href="deleteUser?userId=<s:property value="userId"/>">delete</a></td>
    </tr>
</s:iterator>
</table>
</body>
</html>