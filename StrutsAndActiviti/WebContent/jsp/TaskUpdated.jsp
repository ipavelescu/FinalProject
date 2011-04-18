<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ page language="java" contentType="text/html" import="java.util.*"%>
<jsp:include page="/jsp/LoginDetails.jsp" />
<html>
<head>
<title>Updated task's details</title>
<style type="text/css">@import url(css/main.css);</style>
</head>
<body>
<div id="global">
	<h3>
		<s:set name="description" value="%{myTask.getDescription()}"/>
		New Description: <s:property value="#description"></s:property> 		
	</h3>
	<h3>
		<s:url id="url" action="Process_link">
			<s:param name="processId" value="%{myTask.getProcessDefinitionId()}"><s:property/></s:param>
		</s:url>
		
		<s:a href="%{url}">Go back to tasks' list -></s:a>
	</h3>



</div>
</body>
</html>