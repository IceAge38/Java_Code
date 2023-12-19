<%--
  Created by IntelliJ IDEA.
  User: thann
  Date: 11/20/2023
  Time: 9:04 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
  <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">

</head>
<body>
// 64130500038 Thannicha
<form action="FindServlet" method="post">
  <div class=" m-3 p-2">
    Search by City & Country : <br><input class="col-3 border border-secondary p-2 m-2" type="text" name="cityOrCountry" required><br>
    <span class="m-2" style="color: red">example : USA</span><br>
    <input class="m-3" type="submit" value="Search">
    <button><a href="index.jsp">Back</a></button>
    <table>
      <thead class= "m-3">
      <tr>
        <th >officeCode</th>
        <th >addressLine1</th>
        <th >addressLine2</th>
        <th >city</th>
        <th>state</th>
        <th>country</th>
        <th>postalCode</th>
        <th>phoneNumber</th>
        <th>territory</th>
      </tr>
      </thead>


<%--     <p>${FindByCityCountry}</p>--%>
      <c:forEach var="office" items="${requestScope.FindByCityCountry}" >
        <tr>
          <td>${office.officeCode}</td>
          <td>${office.addressLine1}</td>
          <td>${office.addressLine2}</td>
          <td>${office.city}</td>
          <td>${office.state}</td>
          <td>${office.country}</td>
          <td>${office.postalCode}</td>
          <td>${office.phoneNumber}</td>
          <td>${office.territory}</td>

        </tr>
      </c:forEach>
    </table>

  </div>
</form>
</body>
</html>
