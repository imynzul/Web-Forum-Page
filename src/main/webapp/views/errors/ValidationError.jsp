<%@ page import="com.home.webforumpage.exceptions.ValidationException" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" isErrorPage="true" %>
<html>
<head>
    <title>Error</title>
</head>
<body>

<img src="images/oops.jpg" class="w-100" height="470" id="oops">

<%
    ValidationException validationException = (ValidationException) exception;
%>

<h2> <%=validationException.getType()%> </h2>
<h2> <%=validationException.getMessage()%> </h2>
<h3> <a href="<%=validationException.getBackPage()%>"> Back </a> </h3>

</body>
</html>
