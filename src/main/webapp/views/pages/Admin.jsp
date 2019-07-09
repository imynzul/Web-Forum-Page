<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="jstl"%>
<!DOCTYPE html> 
<html lang="en"> 
<head> 
    <meta charset="UTF-8"> 
    <title>Administrator</title> 
    <link rel="stylesheet" href="css/bootstrap/bootstrap.css"> 
    <link rel="stylesheet" href="css/indexCss.css"> 
    <script type="text/javascript" src="js/bootstrap/bootstrap.bundle.js"></script> 
    <script type="text/javascript" src="js/bootstrap/bootstrap.js"></script> 
</head>
<body>

<%@include file="/views/include/Header.jsp"%>

<h1>Administrator</h1> 
<hr class="border-dark"> 
 
<form> 
        <table class="table table-dark"> 
                <thead>

                <tr> 
                        <th scope="col">UserId</th>
                        <th scope="col">Email</th>
                        <th scope="col">Login</th>
                        <th scope="col">Password</th>
                        <th scope="col">Role</th>
                        <th scope="col">Action</th>
                    </tr>

                </thead> 
                <tbody id="allusers">
                </tbody> 
            </table>
        <button type="button" class="btn btn-secondary m-3" onclick="getAllUsers()">Show all Users</button><br>
        <%--<button type="button" class="btn btn-secondary m-3">Block User</button><br>
        <button type="button" class="btn btn-dark m-3">Delete User</button> --%>
    </form>

<%@include file="/views/include/Footer.jsp"%>
<script src="/js/AdminScript.js"></script>
</body>
</html>
