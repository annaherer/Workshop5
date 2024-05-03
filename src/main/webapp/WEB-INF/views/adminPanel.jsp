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
        <th>Book Id</th>
        <th>ISBN</th>
        <th>Title</th>
        <th>Author</th>
        <th>Publisher</th>
        <th>Type</th>
    </tr>
    <c:forEach var="book" items="${books}">
        <tr>
            <td>${book.id}</td>
            <td>${book.isbn}</td>
            <td>${book.title}</td>
            <td>${book.author}</td>
            <td>${book.publisher}</td>
            <td>${book.type}</td>
            <td>
                <a href="/adminPanel/displayBook/${book.id}">Details</a>
                <a href="/adminPanel/editBook/${book.id}">Edit</a>
                <a href="/adminPanel/deleteBook/${book.id}">Delete</a>
            </td>
        </tr>
    </c:forEach>
</table>
<a href="/adminPanel/addBook">Add book</a>
</body>
</html>
