<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Libraries</title>
    </head>
    <body>
        <h1>Libraries</h1>

        <h2>Add new library</h2>

        <div>
            Enter name and length and press Submit:<br/>
            <form action="${pageContext.request.contextPath}/app/libraries" method="POST">
                Name: <input type="text" name="name" id="name"/><br/>
                Length: <input type="text" name="lengthInMinutes" id="lengthInMinutes"/><br/>
                <input type="submit"/>            
            </form>
        </div>

        <h2>Current libraries</h2>

        <ol>
            <c:forEach var="library" items="${libraries}">
                <li>${library.name} (${library.lengthInMinutes} min)
                    <form method="POST" action="${pageContext.request.contextPath}/app/libraries/${library.id}/delete">
                        <input type="submit" value="Remove" id="remove-${library.id}"/>
                    </form><br/>

                    Books:</br>
                    <ul>
                        <c:forEach var="book" items="${library.books}">
                            <li>${book.name}</li>
                        </c:forEach>
                    </ul>
                </li>
            </c:forEach>
        </ol>

        <div><a href="${pageContext.request.contextPath}/app/books">Books</a></div>
    </body>
</html>
