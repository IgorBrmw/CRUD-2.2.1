<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<body>

<h2>All Users</h2>
<br>

<table>

    <tr>
        <th>Id</th>
        <th>Name</th>
        <th>Surname</th>
        <th>Email</th>
        <th>Operations</th>
    </tr>
    <c:forEach var="us" items="${users}">
        <c:url var="updateButton" value="/updateInfo">
            <c:param name="usID" value="${us.id}"/>
        </c:url>

        <c:url var="deleteButton" value="/deleteUser">
            <c:param name="usID" value="${us.id}"/>
        </c:url>

        <tr>
            <td>${us.id}</td>
            <td>${us.name}</td>
            <td>${us.surname}</td>
            <td>${us.email}</td>
            <td>
                <input type="button" value="Update"
                       onClick="window.location.href='${updateButton}'"/>
                <input type="button" value="Delete"
                       onClick="window.location.href='${deleteButton}'"/>
            </td>
        </tr>
    </c:forEach>
</table>

<br>

<input type="button" value="Add"
       onclick="window.location.href='addUser'"/>

</body>


</html>