<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>
<head>
    <title>List of Users</title>
</head>
<body>
<center>
    <h1>Users Management</h1>
    <h2>
        <a href="/admin/add">Add New User</a>
        &nbsp;&nbsp;&nbsp;
        <a href="/admin/list">List All Users</a>

    </h2>
</center>
<div align="center">
    <table border="1" cellpadding="5">
        <caption><h2>List of Users</h2></caption>
        <tr>
            <th>ID</th>
            <th>NAME</th>
            <th>PASSWORD</th>
            <th>ROLE</th>
            <th>ACTIONS</th>
        </tr>


          <c:forEach var="users" items="${listUsers}" >

            <tr>
                <td><c:out value="${users.id}" /></td>
                <td><c:out value="${users.login}" /></td>
                <td><c:out value="${users.password}" /></td>
                <td>
                     <c:forEach var="roles" items="${users.roles}" >
                      <c:out value="${roles.name}" />
                     </c:forEach>
                </td>
                <td>
                    <a href="/admin/edit?id=<c:out value='${users.id}' />">Edit</a>
                    &nbsp;&nbsp;&nbsp;&nbsp;
                    <a href="/admin/delete?id=<c:out value='${users.id}' />">Delete</a>
                </td>
            </tr>
          </c:forEach>


    </table>
</div>
</body>

</html>