<%@ taglib prefix="s" uri="/struts-tags" %>
<html>
<head>
<title>See all processes</title>
<style type="text/css">@import url(css/main.css);</style>
</head>
<body>
<div id="global">
	<h3>List of processes</h3>
	
		<ul> 
			<s:iterator value="processes">
				<li>
		
					<s:url id="url" action="Process_link">
	  					<s:param name="processId"><s:property/></s:param>
					</s:url>
					
					<s:a href="%{url}"><s:property/></s:a>

				</li>
<%-- 				<a href="/app02a/Product_link.action?text=kjhkggjuytuytuyg"><s:property/></a></li>  --%>
			</s:iterator>
		</ul>

</div>
</body>
</html>
