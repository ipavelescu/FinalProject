<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>

<html>

<head>

<title>Register User</title>

<s:head />

</head>

<body>

<h1>User Details</h1>

<s:actionerror />

<s:form action="Register_user" method="post">

<s:textfield name="firstName" label="First Name" />

<s:textfield name="lastName" label="Last Name" />

<s:textfield name="userName" label="User Name" />

<s:password name="password" label="Password" />

<s:select name="groups" multiple="true" label="Group(s)" headerValue="Select" list="groups" required="true" size="5"/>
<%--  listKey="groupName" listValue="groupName"/> --%>

<s:url id="url" action="Group_create"> </s:url>			
<s:a href="%{url}">Create new group</s:a>
	

<s:textfield name="mobile" label="Mobile" />

<s:textfield name="email" label="EMail" />

<s:textarea name="address" label="Address" />

<s:textfield name="facebookUserName" label="Facebook account" />

<s:textfield name="linkedInUserName" label="LinkedIn account" />

<s:textfield name="imdbUserName" label="IMDB account" />

<s:submit value="Register" align="center" />

</s:form>

</body>

</html>