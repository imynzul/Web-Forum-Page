<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="jstl"%>
<%@taglib uri="/WEB-INF/userTags" prefix="myTags"%>

<html>
<head>
    <title>Test</title>
</head>
<body>

<p id="text">
    Это поведение соответствует стандарту. Оно существует, в первую очередь, для совместимости, как осколок далёкого прошлого
    и не очень приветствуется, поскольку использует глобальные переменные. Браузер пытается помочь нам, смешивая пространства
    имён JS и DOM, но при этом возможны конфликты.
</p>

<button onclick="testFunctionAJAX()">SEND</button>

<%@include file="/views/include/Footer.jsp"%>

<jstl

</body>
</html>
