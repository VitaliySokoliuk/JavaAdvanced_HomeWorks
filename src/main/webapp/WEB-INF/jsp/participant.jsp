<!DOCTYPE html>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html lang="en">
<head>
    <title>MyClub</title>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css">
</head>
<body>

<div class="d-flex flex-column flex-md-row align-items-center p-3 px-md-4 mb-3 bg-white border-bottom shadow-sm">
    <h5 class="my-0 mr-md-auto font-weight-normal"><a class="p-2 text-dark" href="/Club/participant/">Club</a></h5>
    <nav class="my-2 my-md-0 mr-md-3">
        <a class="p-2 text-dark" href="/Club/participant/all">All participants</a>
        <a class="p-2 text-dark" href="/Club/participant/new">New participant</a>
    </nav>
    <a class="btn btn-outline-primary" href="#">Sign up</a>
</div>

<div class="container">
    <c:choose>

        <c:when test="${mode == 'HOME_VIEW'}">
            <h3>Hello, participant</h3>
        </c:when>

        <c:when test="${mode == 'PARTICIPANT_ALL'}">
            <table class="table table-striped">
                <thead>
                <tr>
                    <th>Id</th>
                    <th>Name</th>
                    <th>Email</th>
                    <th>Edit</th>
                    <th>Delete</th>
                </tr>
                </thead>
                <tbody>
                <c:forEach var="elem" items="${participants}">
                    <tr>
                        <td>${elem.id}</td>
                        <td>${elem.name}</td>
                        <td>${elem.email}</td>
                        <td><a href="/Club/participant/update?id=${elem.id}">edit</a></td>
                        <td><a href="/Club/participant/delete?id=${elem.id}">delete</a></td>
                    </tr>
                </c:forEach>
                </tbody>
            </table>
        </c:when>

        <c:when test="${mode == 'PARTICIPANT_CREATE'}">
            <div class = "container mt-3">
                <h1 class="mb-3">Add participant</h1>
                <form action="/Club/participant/new" method="post">
                    <input type="text" name = "name" placeholder="Input a participant name" class="form-control"><br>
                    <input type="email" name = "email" placeholder="Input a participant email" class="form-control"><br>
                    <button type="submit" class="btn btn-dark">Add participant</button><br>
                </form>
            </div>
        </c:when>

        <c:when test="${mode == 'PARTICIPANT_EDIT'}">
            <div class = "container mt-3">
                <h1 class="mb-3">Edit participant</h1>
                <div>
                    <form method="post">
                        <input type="text" value="${particip.name}" name = "name" placeholder="Input a participant name" class="form-control"><br>
                        <input type="email" value="${particip.email}" name = "email" placeholder="Input a participant email" class="form-control"><br>
                        <button type="submit" class="btn btn-dark">Edit</button><br>
                    </form>
                </div>
            </div>
        </c:when>

<%--        <c:when test="${mode == 'BOOK_EDIT' || mode == 'BOOK_CREATE'}">--%>
<%--            <form action="${mode == 'BOOK_EDIT' ? "/ILibrary/books/save": "/ILibrary/books/create"}" method="POST">--%>
<%--                <c:choose>--%>
<%--                    <c:when test="${mode == 'BOOK_EDIT'}">--%>
<%--                        <input type="hidden" value="${book.id}" class="form-control" id="id" name="id">--%>
<%--                    </c:when>--%>
<%--                </c:choose>--%>

<%--                <div class="form-group">--%>
<%--                    <label for="bookName">Book Name:</label> <input type="text"--%>
<%--                                                                    class="form-control" id="name" name="name"--%>
<%--                                                                    value="${book.name}">--%>
<%--                </div>--%>


<%--                <div class="form-group">--%>
<%--                    <label for="author">Author:</label> <input type="text"--%>
<%--                                                               class="form-control" id="author" name="author"--%>
<%--                                                               value="${book.author}">--%>
<%--                </div>--%>
<%--                <button type="submit" class="btn btn-default">Submit</button>--%>
<%--            </form>--%>
<%--        </c:when>--%>

    </c:choose>
</div>

</body>
</html>