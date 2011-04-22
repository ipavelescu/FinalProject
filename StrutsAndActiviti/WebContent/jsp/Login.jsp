<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ page language="java" import="java.util.*"%>
<jsp:include page="/jsp/SignUp.jsp" />
<html>
<head>
    <title>Login page</title>
    <link href="<s:url value="/css/loginForm.css"/>" rel="stylesheet" type="text/css"/>
</head>

<body>
<s:form action="Login">
    <s:textfield key="userName" label="Username"/>
    <s:password key="password" label="Password"/>
    <s:submit value="Login"/>
</s:form>
</body>

</html>
