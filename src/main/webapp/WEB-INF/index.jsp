<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Notes</title>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/styles/forms.css" />

</head>
<body>

<div class="login_box">

    <div class="login_header">
        <header>Welcome to Notes</header>
        <p>Log in or register to view more</p>
    </div>

    <div class="input_submit">
        <button onclick="location.href='<%=request.getContextPath() + "/login"%>'" class="button" id="log_button">Login</button>
    </div>

    <div class="input_submit">
        <button onclick="location.href='<%=request.getContextPath() + "/register"%>'" class="button" id="reg_button">Register</button>
    </div>

</div>


</body>
</html>