<%--
  Created by IntelliJ IDEA.
  User: jnchl
  Date: 24.03.2024
  Time: 20:23
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <title>Make a note</title>
  <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/styles/forms.css" />
</head>

<body>
<div class="login_box">
  <form action="#" method="post">

    <div class="login_header">
      <header>Add new note</header>
    </div>

    <div class="input_box">
      <input name="title" class="input_field"  placeholder="Title" required>
    </div>

    <div class="input_box">
      <textarea name="content" class="text_field" placeholder="Note contents" ></textarea>
    </div>

    <div class="input_submit">
      <button type="submit" class="submit_btn" id="submit">Add</button>
    </div>
  </form>


</div>
</body>

</html>
