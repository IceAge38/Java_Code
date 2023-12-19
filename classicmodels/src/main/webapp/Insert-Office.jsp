<%--
  Created by IntelliJ IDEA.
  User: thann
  Date: 11/19/2023
  Time: 2:59 PM
  To change this template use File | Settings | File Templates.
--%>
// 64130500038 Thannicha
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <title>Insert</title>
  <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
</head>
<body>
    <div class="row bg-light m-3">
      <b>Insert office ::</b>
    </div>
    <form action="InsertOfficeServlet" method="post">
    <div class=" m-3 p-2">
        1. city :<br><input class="col-3 border border-secondary p-2 m-2" type="text" name="city" ><br>
        2. address 1 :<br><input class="col-3 border border-secondary p-2 m-2" type="text" name="addressLine1" ><br>
        3. address 2 :<br><input class="col-3 border border-secondary p-2 m-2" type="text" name="addressLine2" ><br>
        4. state :<br><input class="col-3 border border-secondary p-2 m-2" type="text" name="state" ><br>
        5. country :<br><input class="col-3 border border-secondary p-2 m-2" type="text" name="country" ><br>
        6. postal code :<br><input class="col-3 border border-secondary p-2 m-2" type="text" name="postalCode" ><br>
        7. phone number :<br><input class="col-3 border border-secondary p-2 m-2" type="text" name="phoneNumber" ><br>
        8. territory :<br><input class="col-3 border border-secondary p-2 m-2" type="text" name="territory" ><br>
        <p style="color:blue">${Mess}</p>
        <input class="m-3" type="submit" value="Submit">
        <button><a href="index.jsp">Back</a></button>
    </div>

    </form>


</body>
</html>
