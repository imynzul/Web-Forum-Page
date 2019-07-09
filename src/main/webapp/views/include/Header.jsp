<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="jstl"%>
<%@taglib uri="/WEB-INF/userTags" prefix="ut"%>

<html>
<head>
    <title>Header</title>
</head>
<body>
        <div class="header" name="headerName" id="headerId">
            <nav class="navbar navbar-expand-lg navbar-light bg-transparent my-1">
                <a class="navbar-brand" href="index"><ut:locale_tag key="K_Main_Page"/></a>
                <div class="collapse navbar-collapse" id="navbarNav">
                    <ul class="navbar-nav">
                        <li class="nav-item active">
                            <a class="nav-link" href="listOfArticles"><ut:locale_tag key="K_Articles"/></a>
                        </li>
                <jstl:choose>
                    <jstl:when test="${auth}">
                        <li class="nav-item active">
                            <a class="nav-link" href="profile"><ut:locale_tag key="K_Profile"/></a>
                        </li>
                        <jstl:if test="${admin}">
                            <li class="nav-item active">
                                <a class="nav-link" href="admin"><ut:locale_tag key="K_Admin"/></a>
                            </li>
                        </jstl:if>
                        <li class="nav-item active">
                            <a class="nav-link" href="#" onclick="out()"><ut:locale_tag key="K_Out"/></a>
                        </li>
                    </jstl:when>
                    <jstl:otherwise>
                        <li class="nav-item">
                            <a class="nav-link" href="login"><ut:locale_tag key="K_Login"/></a>
                        </li>
                        <li class="nav-item">
                            <a class="nav-link" href="registration"><ut:locale_tag key="K_Registration"/></a>
                        </li>
                    </jstl:otherwise>
                </jstl:choose>
                        <li class="nav-item">
                            <a class="nav-link" href="test">test</a>
                        </li>
                    </ul>
                </div>
                <nav class="navbar navbar-light bg-transparent">
                    <a class="navbar-brand" href="#">
                        <img src="images/45318c18895447.562d12fcf3bd6.jpg" width="60" class="d-inline-block " alt="">
                        TravelHub
                    </a>
                </nav>
            </nav>
            <button class="my-3" type="button" onclick="languageSelector('rus')">RUS</button>
            <button class="my-3" type="button" onclick="languageSelector('eng')">ENG</button>
        </div>
<script src="/js/MyScriptAJAX.js"></script>
</body>
</html>
