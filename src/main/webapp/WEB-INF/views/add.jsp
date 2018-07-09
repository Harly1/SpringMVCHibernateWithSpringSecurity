<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h1> Add new user</h1>
<form class="form-signin" name='addForm' action="/admin/add" method='POST'>
    <table>

        <tr><td> <input class="form-control" placeholder="Email" type="text" name="username"/>  </tr></td>

        <tr><td> <input class="form-control" placeholder="Password" type="text" name="password"/> </tr></td>

        <tr><td> <input class="form-control" placeholder="Role" type="text" name="role"/> </tr></td>

        <div class="${not empty error}?('error') bg-danger" th:text="${error}"></div>
        <div class="${not empty msg}?('msg') bg-danger" th:text="${msg}"></div>

    </table>
    <input class="btn btn-lg btn-primary btn-block" name="submit" type="submit" value="add"/>
</form>

<a href="/admin/list">List all users</a>
</body>
</html>