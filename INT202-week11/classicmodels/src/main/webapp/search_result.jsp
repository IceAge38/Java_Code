<%--
  Created by IntelliJ IDEA.
  User: User
  Date: 15/11/2566
  Time: 21:13
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
  <title>Search Result</title>
  <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
</head>
<body>
    <div class="container mt-5">
        <h2>Search Result</h2>
        <div class="row">
          <c:forEach var="office" items="${offices}">
            <div class="col-2 border border-secondary p-2 m-2">
              <div>
                <a href="office-list?officeCode=${office.officeCode}"> ${office.city}</a>, ${office.country}
              </div>
              <div> ${office.phoneNumber}</div>
            </div>
          </c:forEach>
        </div>
        <span style="display: inline-block;margin-top: 3%">
                <a href="office-list" class="btn btn-danger">Back</a>
            </span>
    </div>
</body>
</html>
