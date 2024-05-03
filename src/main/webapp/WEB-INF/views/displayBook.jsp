<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Books</title>
</head>
<body>
<h2>Books</h2>
<table border="1">
    <tr>
        <td>Book Id</td>
        <td>${book.id}</td>
    </tr>
    <tr>
        <td>ISBN</td>
        <td>${book.isbn}</td>
    </tr>
    <tr>
        <td>Title</td>
        <td>${book.title}</td>
    </tr>
    <tr>
        <td>Author</td>
        <td>${book.author}</td>
    </tr>
    <tr>
        <td>Publisher</td>
        <td>${book.publisher}</td>
    </tr>
    <tr>
        <td>Type</td>
        <td>${book.type}</td>
    </tr>
</table>
<a href="/adminPanel">Return to panel</a>
</body>
</html>
