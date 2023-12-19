<%--
  Created by IntelliJ IDEA.
  User: thann
  Date: 11/19/2023
  Time: 7:01 PM
  To change this template use File | Settings | File Templates.
--%>
// 64130500038 Thannicha
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
</head>
<body>
<form action="DeleteOfficeServlet" method="post">
    <div class=" m-3 p-2">
        Delete OfficeCode :<br><input class="col-3 border border-secondary p-2 m-2" type="text" name="officeCode" ><br>
        <input class="m-3" type="submit" value="Delete">
        <button><a href="index.jsp">Back</a></button>
    </div>
</form>

</body>
</html>
