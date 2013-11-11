<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Books</title>
    </head>
    <body>
        <h1>Books</h1>

        <h2>Add new book</h2>

        <div>
            Enter information and press submit:<br/>
            <form action="${pageContext.request.contextPath}/app/books" method="POST">
                Name: <input type="text" name="name" id="name"/><br/>
                <input type="submit"/>
            </form>
        </div>

        <h2>Existing books</h2>

        <ol>
            <c:forEach var="book" items="${books}">
            <li><a href="${pageContext.request.contextPath}/app/books/${book.id}">${book.name}</a>
                    <form method="POST" action="${pageContext.request.contextPath}/app/books/${book.id}/delete">
                        <input type="submit" value="Remove" id="remove-${book.id}"/>
                    </form><br/>

                    Known for:<br/>
                    <ul>
                        <c:forEach var="library" items="${book.libraries}">
                            <li>${library.name}</li>
                        </c:forEach>
                    </ul>
                </li>
            </c:forEach>
        </ol>

        <div><a href="${pageContext.request.contextPath}/app/libraries">Libraries</a></div>
    </body>
</html>
