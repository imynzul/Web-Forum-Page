<%@ page contentType="text/html;charset=UTF-8" language="java"%>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Main Page</title>
    <link rel="stylesheet" href="css/bootstrap/bootstrap.css">
    <link rel="stylesheet" href="css/indexCss.css">
    <script type="text/javascript" src="js/bootstrap/bootstrap.bundle.js"></script>
    <script type="text/javascript" src="js/bootstrap/bootstrap.js"></script>
</head>
<body>

<%@include file="/views/include/Header.jsp"%>

<img src="images/1.jpg" class="w-100" height="470" id="image1">


<div class="info" name="infoName" id="infoId">
    <div class="container text-justify">
        <h1 class="text-center my-4">TravelHub</h1>
        <p class="mr-5 ml-5 p-3 borderOrange">
            <ut:locale_tag key="K_Index_Page_Text"/>
        </p>

        <br><hr class="border-secondary">

        <h3 class="text-center mt-3">Top Topics</h3>

        <div class="tableTopics">
            <div class="row my-4 mr-5 ml-5">
                <div class="col-4 bg-lightOrange">Topic</div>
                <div class="col-8 bg-ultraViolet">Description</div>
            </div>
            <div class="row my-4 mr-5 ml-5">
                <div class="col-4 bg-lightOrange">Topic</div>
                <div class="col-8 bg-ultraViolet">Description</div>
            </div>
            <div class="row my-4 mr-5 ml-5">
                <div class="col-4 bg-lightOrange">Topic</div>
                <div class="col-8 bg-ultraViolet">Description</div>
            </div>
            <div class="row my-4 mr-5 ml-5">
                <div class="col-4 bg-lightOrange">Topic</div>
                <div class="col-8 bg-ultraViolet">Description</div>
            </div>
            <div class="row my-4 mr-5 ml-5">
                <div class="col-4 bg-lightOrange">Topic</div>
                <div class="col-8 bg-ultraViolet">Description</div>
            </div>
        </div>
    </div>
</div>

<%@include file="/views/include/Footer.jsp"%>

</body>
</html>