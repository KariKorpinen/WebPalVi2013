<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>${book.name}</title>
    </head>
    <body>
        <h1>Book ${book.name}</h1>
        
        <h2>Kirjastot</h2>

        <div>
            <ul>
                <c:forEach var="library" items="${book.libraries}">
                    <li>${library.name}</li>
                </c:forEach>
            </ul>
        </div>

        <c:if test="${not empty libraries}">
            <h2>Assign to library</h2>

            <div>
                <form method="POST" action="${pageContext.request.contextPath}/app/books/<c:out value="${book.id}"/>/libraries">
                    <select name="libraryId">
                        <c:forEach var="library" items="${libraries}">
                            <option value="${library.id}">${library.name}</option>
                        </c:forEach>
                    </select>
                    <input type="submit" value="Assign" id="add-to-library"/>
                </form>
            </div>
        </c:if>

        <div><a href="${pageContext.request.contextPath}/app/books">Books</a></div>
    </body>
</html>
