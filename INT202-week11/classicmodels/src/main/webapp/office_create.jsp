<%--
  Created by IntelliJ IDEA.
  User: User
  Date: 15/11/2566
  Time: 23:54
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Office Create</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
</head>
<body>
<div class="container mt-5">
    <h2>Create Office</h2>
    <form action="officeCreate" method="post">
        <!-- แบบฟอร์มสำหรับการสร้าง Office -->
        <div class="mb-3">
            <label for="officeCode" class="form-label"><span style="color: red;">*</span>Office Code:</label>
            <input type="text" class="form-control" id="officeCode" name="officeCode" required>
        </div>
        <div class="mb-3">
            <label for="addressLine1" class="form-label"><span style="color: red;">*</span>Address Line 1:</label>
            <input type="text" class="form-control" id="addressLine1" name="addressLine1" required>
        </div>
        <div class="mb-3">
            <label for="addressLine1" class="form-label">Address Line 2:</label>
            <input type="text" class="form-control" id="addressLine2" name="addressLine2" >
        </div>
        <div class="mb-3">
            <label for="city" class="form-label"><span style="color: red;">*</span>City:</label>
            <input type="text" class="form-control" id="city" name="city" required>
        </div>
        <div class="mb-3">
            <label for="state" class="form-label">State:</label>
            <input type="text" class="form-control" id="state" name="state" >
        </div>
        <div class="mb-3">
            <label for="country" class="form-label"><span style="color: red;">*</span>Country:</label>
            <input type="text" class="form-control" id="country" name="country" required>
        </div>
        <div class="mb-3">
            <label for="postalCode" class="form-label"><span style="color: red;">*</span>Postal Code:</label>
            <input type="text" class="form-control" id="postalCode" name="postalCode" required>
        </div>
        <div class="mb-3">
            <label for="phoneNumber" class="form-label"><span style="color: red;">*</span>Phone Number:</label>
            <input type="text" class="form-control" id="phoneNumber" name="phoneNumber" required>
        </div>
        <div class="mb-3">
            <label for="territory" class="form-label"><span style="color: red;">*</span>Territory:</label>
            <input type="text" class="form-control" id="territory" name="territory" required>
        </div>
        <span style="display: inline-block;margin-right: 2%">
            <button type="submit" class="btn btn-primary">Create</button>
        </span>
        <span style="display: inline-block;">
            <a href="office-list" class="btn btn-danger">Back</a>
        </span>
    </form>

</div>
</body>
</html>
