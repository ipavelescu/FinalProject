<%@ taglib prefix="s" uri="/struts-tags" %>
<html>
<head>
<title>Current process active tasks</title>
<style type="text/css">@import url(css/main.css);</style>
</head>
<body>

<div id="global">
	<h4>Tasks</h4>
	
	<ul> 
	
	<s:if test="tasks.isEmpty() == true">
				Congrats, the process is over, all the tasks were successfully completed! 
	</s:if>
	
	<s:else>
		<s:iterator value="tasks">
		
		
		<li>
			
			
				<s:url id="url" action="Task_details">
	 					<s:param name="taskId" value="%{getId()}"><s:property/></s:param>
				</s:url>
			
			
			<s:a href="%{url}"><s:property value="%{getName()}"></s:property></s:a>
		

		</li>
<%-- 				<a href="/app02a/Product_link.action?text=kjhkggjuytuytuyg"><s:property/></a></li>  --%>
		</s:iterator>
	</s:else>
</ul>
	
</div>
</body>
</html>