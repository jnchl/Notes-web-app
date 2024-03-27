<%--
  Created by IntelliJ IDEA.
  User: jnchl
  Date: 24.03.2024
  Time: 09:52
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <meta charset="UTF-8">
  <title>Sign up</title>
  <meta name="viewport" content="width=device-width, initial-scale=1.0">

  <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/styles/forms.css" />
</head>
<body>

<div class="login_box">
  <form action="#" method="post">

    <div class="login_header">
      <header>Register</header>
    </div>

    <div class="input_box">
      <input name="username" class="input_field" placeholder="Username" required>
    </div>

    <div class="input_box">
      <input name="email" class="input_field" placeholder="Email" type="email" required>
    </div>

    <div class="input_box">
      <input name="password" class="input_field" placeholder="Password" type="password" required>
    </div>

    <div class="input_submit">
      <button class="submit_btn" id="submit">Sign up</button>
    </div>

    <div class="sign_up_link">
      <p>Already have an account? <a href="${pageContext.request.contextPath}/login">Sign in</a></p>
    </div>

  </form>
</div>

</body>
</html>
