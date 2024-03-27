<%--
  Created by IntelliJ IDEA.
  User: jnchl
  Date: 24.03.2024
  Time: 10:00
  To change this template use File | Settings | File Templates.
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8"%>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">

    <title>Sign into notes</title>

    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/styles/forms.css" />
</head>

<body>
<div class="login_box">
    <form action="j_security_check" method="post">

        <div class="login_header">
            <header>Login</header>
        </div>

        <div class="input_box">
            <input name="j_username" class="input_field" id="usernameTextBox" placeholder="Username" required>
        </div>

        <div class="input_box">
            <input name="j_password" class="input_field" id="passwordTextBox" placeholder="Password" type="password" required>
        </div>

        <div class="input_submit">
            <button class="submit_btn" id="submit">Sign in</button>
        </div>

        <div class="sign_up_link">
            <p>New to notes? <a href="${pageContext.request.contextPath}/register">Sign up</a></p>
        </div>

    </form>
</div>
</body>
</html>
