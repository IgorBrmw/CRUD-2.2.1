<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>

<body>
<h2>User info</h2>
<br>

<form:form action="saveUser" modelAttribute="user">
 <form:hidden path="id"/>
    Name <form:input path="name"/>
    <br><br>
    Surname <form:input path="surname"/>
    <br><br>
    Email <form:input path="email"/>
    <br><br>
    <input type="submit" value="OK">



</form:form>






</body>

</html>
