<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<!DOCTYPE html>
<html lang=en>
<html>
<!DOCTYPE html> 
<html lang=en> 
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
                    <tr>
                            <td><a href="article">Topic1</a></td>
                            <td>Description1</td>
                            <td>01.01.2019</td>
                        </tr>
                    <tr>
                            <td><a href="article">Topic2</a></td>
                            <td>Description2</td>
                            <td>02.02.2019</td>
                        </tr>
                    <tr>
                            <td><a href="article">Topic3</a></td>
                            <td>Description3</td>
                            <td>03.03.2019</td>
                        </tr>
                    </tbody>
                </table>
            </div>
    </div>
</div>

<%@include file="/views/include/Footer.jsp"%>

</body>
</html>
