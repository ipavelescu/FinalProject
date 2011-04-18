<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ page language="java" contentType="text/html" import="java.util.*"%>
<jsp:include page="/jsp/LoginDetails.jsp" />
<html>
<head>
<title>Task details</title>
<style type="text/css">@import url(css/main.css);</style>
</head>
<body>
<div id="global">
	<h3>
		<s:set name="description" value="%{myTask.getDescription()}"/>
		Description: <s:property value="#description"></s:property> 		
	</h3>
	<h3>
		<s:form action="Update_task">
		<s:set name="description" value="%{myTask.getDescription()}"/>
		Message: <s:textarea name="userMessage"/>	
		<s:hidden name="taskId" value="%{myTask.getId()}"></s:hidden>
		<s:submit value="Claim"/>
		</s:form>
	</h3>


</div>
</body>
</html>