<%--
  Created by IntelliJ IDEA.
  User: jnchl
  Date: 24.03.2024
  Time: 13:22
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page import="java.time.format.DateTimeFormatter" %>
<html>
<head>
    <title>Your notes</title>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/styles/page.css" />
</head>
<body>

    <ul class="navbar_list">
        <li class="navbar_element"><a href="${pageContext.request.contextPath}/noteCreator">Create new note</a></li>
        <li class="navbar_element"><p>Sort by</p></li>
        <li class="navbar_element">
            <form action="#" method="get">
                <select name="sort_order" id="sort_order" onchange="this.form.submit()">
                    <option value="dateEarliest" >Date: earliest</option>
                    <option value="dateOldest">Date: oldest</option>
                    <option value="titleAscending">Title ascending</option>
                    <option value="titleDescending">Title descending</option>
                </select>
            </form>
        </li>
        <li class="navbar_element_last"><a href="${pageContext.request.contextPath}/logout">Log out</a></li>
    </ul>

    <div class="notes-area">
        <c:forEach var="note" items="${requestScope.notes}">
            <article class="note">
                <h2 class="note_title"><c:out value="${note.title()}"/></h2>
                <p class="note_content"><c:out value="${note.content()}"/></p>
                <p class="note_date">Note created: ${note.creationDate().format(DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm"))}</p>
                <button class="note_button" onclick="location.href='${pageContext.request.contextPath.concat('/delete?id=').concat(note.id())}'" id="reg_button">Delete</button>
            </article>
        </c:forEach>
    </div>

</body>
</html>
