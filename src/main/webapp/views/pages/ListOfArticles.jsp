<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="jstl"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>List of Articles</title>
    <link rel="stylesheet" href="css/bootstrap/bootstrap.css">
    <link rel="stylesheet" href="css/indexCss.css">
    <script type="text/javascript" src="js/bootstrap/bootstrap.bundle.js"></script>
    <script type="text/javascript" src="js/bootstrap/bootstrap.js"></script>
</head>
<body>
<%@include file="/views/include/Header.jsp"%>
<div class="info" name="infoName" id="infoId">
    <div class="container text-justify">
        <form action="" onsubmit="">
            <div class="form-group row">
                <div class="col-sm-10">
                    <input type="text" class="form-control" id="inputSearch" placeholder="Enter keywords">
                </div>
                <button type="submit" class="btn btn-info float-right ml-5">Search</button>
            </div>
        </form>

        <table class="table table-striped">
            <thead>
            <tr>
                <th scope="col">Topic</th>
                <th scope="col">Author</th>
                <th scope="col">Date issued</th>
            </tr>
            </thead>
            <tbody>
        <jstl:forEach var="list" items="${articlesList}">
            <tr>
                <td> ${list.getTopic()} </a></td>
                <td> ${list.getUser().getLogin()} </td>
                <td> ${list.getData_issued()} </td>
                <td><a href="article?articleId=${list.getId()}">Show Article</a></td>
            </tr>
        </jstl:forEach>
            </tbody>
        </table>
    </div>
</div>
<%@include file="/views/include/Footer.jsp"%>
</body>
</html>