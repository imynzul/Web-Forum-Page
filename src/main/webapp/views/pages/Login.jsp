<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="jstl"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Login</title>
    <link rel="stylesheet" href="css/bootstrap/bootstrap.css">
    <link rel="stylesheet" href="css/indexCss.css">
    <script type="text/javascript" src="js/bootstrap/bootstrap.bundle.js"></script>
    <script type="text/javascript" src="js/bootstrap/bootstrap.js"></script>
</head>

<body>
<%@include file="/views/include/Header.jsp"%>

    <img src='images/2.jpg' class='w-100' height='470' id='image1'>

<jstl:if test="${alert != null}">
    <div class='alert alert-danger' role='alert'>
        <h4 class='alert-heading'>Error!</h4>
        <p> ${alert} </p>
        <hr>
        <p class='mb-0'>Попробуйте еще раз!</p>
    </div>
</jstl:if>
        <div class='container my-3'>
            <form class='my-5' id="auth-form">
                    <div class='form-group h-75'>
                            <label for='InputLogin'>Login</label>
                            <input type='text' class='form-control' id='InputLogin' name='login' aria-describedby='emailHelp' placeholder='Enter login'>
                            <small class="text-danger" id="loginErrorInformer"></small>
                        </div>
                    <div class='form-group'>
                            <label for='InputPassword'>Password</label>
                            <input type='password' class='form-control' id='InputPassword' name='password' placeholder='Enter Password'>
                            <small class="text-danger" id="passErrorInformer"></small>
                        </div>
                </form>
            <button type='button' class='btn btn-primary' onclick="login()">Login</button>
        </div>
<%@include file="/views/include/Footer.jsp"%>
</body>
</html>
