<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<c:set var="operation" value="Add"/>
<c:if test="${book.id>0}"> <c:set var="operation" value="Edit"/> </c:if>
<html>
<head>
    <title>${operation} book</title>
</head>
<body>
<h2>${operation} book</h2>
<form action="/adminPanel/${fn:toLowerCase(operation)}Book" method="post">
    ISBN: <input type="text" name="isbn" <c:if test="${book.id>0}"> value=${book.isbn} </c:if>><br>
    Title: <input type="text" name="title" <c:if test="${book.id>0}"> value=${book.title} </c:if>><br>
    Author: <input type="text" name="author" <c:if test="${book.id>0}"> value=${book.author} </c:if>><br>
    Publisher: <input type="text" name="publisher" <c:if test="${book.id>0}"> value=${book.publisher} </c:if>><br>
    Type: <input type="text" name="type" <c:if test="${book.id>0}"> value=${book.type} </c:if>><br>
    <input type="submit" value="Save">
    <input type="hidden" name="id"<c:if test="${book.id>0}"> value=${book.id} </c:if>><br>
</form>
</body>
</html>
