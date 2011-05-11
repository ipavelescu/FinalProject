<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>

<html>

<head>

<title>Create a new group</title>

<s:head />
</head>
<body>

<h1>Group Details</h1>

<s:actionerror />

<s:form action="Group_create" method="post">

<s:textfield name="groupName" label="Name" />

<s:textarea name="description" label="Description" />

<s:submit value="Create" align="center" />

</s:form>

</body>

</html>