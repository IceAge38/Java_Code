<%--
  Created by IntelliJ IDEA.
  User: User
  Date: 15/11/2566
  Time: 14:23
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Office Delete</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
    <style>
        .success-message {
            color: #155724;
            background-color: #d4edda;
            border-color: #c3e6cb;
            padding: 10px;
            border-radius: 5px;
            margin-top: 10px;
        }
    </style>
</head>
<body>
<div class="container mt-5">
    <h1>The Office Code ${param.officeCode}, confirm for Delete!!!  </h1>

    <form action="officeDelete" method="get">
        <input type="hidden" name="officeCode" value="${param.officeCode}">
        <span style="display: inline-block;margin-right: 2%;margin-top: 1%">
            <button type="submit" class="btn btn-success">Delete</button>

            </span>
        <span style="display: inline-block;">
             <a href="office-list" class="btn btn-danger">Back</a>
            </span>
    </form>
    <%-- แสดงข้อความสีเขียวเมื่อลบสำเร็จ --%>
    <c:if test="${isDeleteSuccess}">
        <div class="alert alert-success mt-3" role="alert">
            Delete is success!
        </div>
    </c:if>
</div>
</body>
</html>
