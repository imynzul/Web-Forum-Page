<%@ page import="com.home.webforumpage.dao.UsersDao" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="jstl"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Personal Profile</title>
    <link rel="stylesheet" href="css/bootstrap/bootstrap.css">
    <link rel="stylesheet" href="css/indexCss.css">
    <script type="text/javascript" src="js/bootstrap/bootstrap.bundle.js"></script>
    <script type="text/javascript" src="js/bootstrap/bootstrap.js"></script>
</head>
<body>
<%@include file="/views/include/Header.jsp"%>
<div class="container">
    <div class="row m-5">
        <div class="col-3 bg-light">
            <img src="images/img_311846.png" class="w-50 float-left m-2">
            <p div class="float-right mt-5">Name</p>
        </div>
        <div class="col-9">
            <table class="table table-striped">
                <thead>
                <tr>
                    <th scope="col">Topic</th>
                    <th scope="col">Description</th>
                    <th scope="col">Date issued</th>
                </tr>
                </thead>
                <tbody>
                <jstl:forEach var="articles" items="${articleList}">
                    <form id="articleInfo-${articles.getId()}">
                        <tr>
                            <input type="hidden" name="id" value="${articles.getId()}"/>
                            <td name="topic"> <a href="article?articleId=${articles.getId()}"> ${articles.getTopic()} </a></td>
                            <td name="content"> ${articles.getContent()} </td>
                            <td> ${articles.getData_issued()} </td>
                            <td><button type="button" class="btn btn-dark"
                                        onclick="deleteArticle('articleInfo-${articles.getId()}')">Delete</button></td>
                        </tr>
                    </form>




                </jstl:forEach>
                </tbody>
            </table>
        </div>
    </div>
    <form div class="m-5" id="newArticleForm" action="#" method="post">
        <p><b>Topic</b></p>
        <input type="text" class="form-control mb-3 mr-5 pr-5" id="exampleInputLogin1" name="topic" placeholder="Enter the topic...">
        <p><b>New Post:</b></p>
        <p><textarea class="form-text" rows="8" cols="140" name="article" placeholder="Write your text here..."></textarea></p>
        <small class="text-danger" id="textAreaErrorInformer"></small>
    </form>
    <button type="button" onclick="postNewArticle()" class="my-3 btn btn-primary w-25 align-items-lg-center">Post</button>
</div>
<%@include file="/views/include/Footer.jsp"%>
</body>
</html>
