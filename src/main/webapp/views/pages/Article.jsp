<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html> 
<html lang="en"> 
<head> 
    <meta charset="UTF-8"> 
    <title>Article</title> 
    <link rel="stylesheet" href="css/bootstrap/bootstrap.css"> 
    <link rel="stylesheet" href="css/indexCss.css"> 
    <script type="text/javascript" src="js/bootstrap/bootstrap.bundle.js"></script> 
    <script type="text/javascript" src="js/bootstrap/bootstrap.js"></script> 
</head>
<body>
<%@include file="/views/include/Header.jsp"%>

<div class="container w-50"> 
        <h2> ${article.getTopic()} </h2>
        <hr noshade> 
    <div class="row m-5 bg-info"> 
            <div class="col-3"> 
                    <img src="images/img_311846.png" class="w-25 float-left m-2"> 
                    <p class="float-right m-2">
                        <b>
                            ${article.getUser().getLogin()}
                        </b>
                    </p>
                </div>
            <div class="col-9"> 
                    <p div class="text-justify m-1">
                        ${article.getContent()}
                    </p>
                </div> 
        </div> 

        <hr noshade>
     
        <h3>Replies on the article</h3>

    <jstl:forEach var="comments" items="${comments}">
        <div class="row m-10 bg-light">
            <div class="col-3">
                <img src="images/img_311846.png" class="w-25 float-left m-2">
                <p div class="float-right">
                        ${comments.getUser().getLogin()}
                </p>
            </div>
            <div class="col-9">
                <p div class="text-justify m-1">
                    ${comments.getComments_content()}
                </p>
            </div>
        </div>
    </jstl:forEach>
     
        <hr noshade>

    <jstl:choose>
        <jstl:when test="${auth}">
            <form class="m-5" action="#" id="commentForm" method="post">
                <p><b>Post your reply:</b></p>
                <p><textarea class="form-text" rows="8" cols="115" name="comment" id="commentField" placeholder="Write your text here..."></textarea></p>
                <small class="text-danger" id="commentErrorInformer"></small>
            </form>
            <button type="button" onclick="insertComment()" class="m-3 btn btn-warning w-25 align-items-lg-center">Save</button>
        </jstl:when>
        <jstl:otherwise>
            <form class="m-5" action="#" method="post">
                <p><b>Post your reply:</b></p>
                <p><textarea disabled class="form-text" rows="8" cols="115" name="text" placeholder="Need to login to type your comment..."></textarea></p>
            </form>
        </jstl:otherwise>
    </jstl:choose>

    </div>

<%@include file="/views/include/Footer.jsp"%>
</body>
</html>
