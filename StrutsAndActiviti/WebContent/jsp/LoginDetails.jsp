<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ page language="java" contentType="text/html" import="java.util.*"%>
<html>
    <head>
        <title>CineSoft</title>
  </head>
    <body>
      <s:if test="#session.user != ''">
      	<s:set name="authentifiedUser" value="#session.user"/>
      	<div align="right">
		Hi, <s:property value="#authentifiedUser"></s:property>!
		<a href="<%= request.getContextPath() %>/main/Logout.action">Logout</a>
		</div>
      </s:if>
      <s:else>
      	      <jsp:forward page="jsp/Login.jsp" /> 
      </s:else>
    </body>
</html>