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

<s:form action="addOrUpdateUser" method="post">

<s:textfield name="user.firstName" label="First Name" />

<s:textfield name="user.lastName" label="Last Name" />

<s:textfield name="user.userName" label="User Name" />

<s:password name="user.password" label="Password" />

<s:select name="groupIds" value="selectedGroupIds" multiple="true" label="Group(s)" headerValue="Select" list="allGroups" size="5" listValue="%{getGroupName()}" listKey="%{getGroupId()}"/>

<s:url id="url" action="Group_create"> </s:url>			
<s:a href="%{url}">Create new group</s:a>
	

<s:textfield name="user.mobile" label="Mobile" />

<s:textfield name="user.email" label="EMail" />

<s:textarea name="user.address" label="Address" />

<s:textfield name="user.facebookUserName" label="Facebook account" />

<s:textfield name="user.linkedInUserName" label="LinkedIn account" />

<s:textfield name="user.imdbUserName" label="IMDB account" />

<s:if test="%{user.userId!=null}">
	<s:submit value="Update" align="center" />
</s:if>
<s:else>
	<s:submit value="Register" align="center" />
</s:else>
</s:form>

</body>

</html>