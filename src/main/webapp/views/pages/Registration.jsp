<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="jstl"%>
<!DOCTYPE html> 
<html lang="en"> 
<head> 
    <meta charset="UTF-8"> 
    <title>Registration</title> 
    <link rel="stylesheet" href="css/bootstrap/bootstrap.css"> 
    <link rel="stylesheet" href="css/indexCss.css"> 
    <script type="text/javascript" src="js/bootstrap/bootstrap.bundle.js"></script> 
    <script type="text/javascript" src="js/bootstrap/bootstrap.js"></script> 
</head>
<%@include file="/views/include/Header.jsp"%>
<jstl:if test="${alert != null}">
    <div class='alert alert-danger' role='alert'>
        <h4 class='alert-heading'>Error!</h4>
        <p> ${alert} </p>
        <hr>
        <p class='mb-0'>Попробуйте еще раз!</p>
    </div>
</jstl:if>
<div class="container my-5">
        <form id="reg-form">
                <div class="form-group"> 
                        <label for="InputEmail">Email address</label>
                        <input type="text" name="email" class="form-control" id="InputEmail" aria-describedby="emailHelp" placeholder="Enter email">
                        <small class="text-danger" id="emailErrorInformer"></small>
                    </div> 
                <div class="form-group"> 
                        <label for="InputLogin">Login</label>
                        <input type="text" name="login" class="form-control" id="InputLogin" placeholder="Enter Login">
                        <small class="text-danger" id="loginErrorInformer"></small>
                    </div> 
                <div class="form-group"> 
                        <label for="InputPassword">Password</label>
                        <input type="password" name="password" class="form-control" id="InputPassword" placeholder="Enter Password">
                        <small class="text-danger password_field"></small>
                    </div> 
                <div class="form-group"> 
                        <label for="InputRPassword">Repeat Password</label>
                        <input type="password" name="rPassword" class="form-control" id="InputRPassword" placeholder="Repeat Password">
                        <small class="text-danger password_field"></small>
                    </div> 
            </form>
    <button type="button" class="btn btn-primary" onclick="registration()">Submit</button>
</div>
<%@include file="/views/include/Footer.jsp"%>
</body>
</html>
