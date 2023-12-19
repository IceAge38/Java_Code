<%--
  Created by IntelliJ IDEA.
  User: thann
  Date: 11/19/2023
  Time: 9:44 PM
  To change this template use File | Settings | File Templates.
--%>
// 64130500038 Thannicha
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Insert</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
</head>
<body>

<div class="container">
    <div class="row bg-primary m-3"><h2>Update office data by office code ::</h2></div>
    <div class="row">
        <c:forEach items="${offices}" var="office">
            <div class="col-2 border border-secondary p-2 m-2 ${office.officeCode == selectedOffice.officeCode ? 'bg-warning' : ''}">
                <div>
                    Code : <a href="UpdateOfficeServlet?officeCode=${office.officeCode}">${office.officeCode}</a><br>
                    City: ${office.city}<br>
                    Country: ${office.country}<br>
                    Phone Number : <br>${office.phoneNumber}
                </div>
            </div>
        </c:forEach>
    </div>
<form action="UpdateOfficeServlet" method="post">
    <div class=" m-3 p-2">
        1. officeCode :<br><input class="col-3 border border-secondary p-2 m-2" type="text" name="officeCode" value="${selectedOffice.officeCode}"><br>
        2. city :<br><input class="col-3 border border-secondary p-2 m-2" type="text" name="city" value="${selectedOffice.city}"><br>
        3. address 1 :<br><input class="col-3 border border-secondary p-2 m-2" type="text" name="addressLine1" value="${selectedOffice.addressLine1}"><br>
        4. address 2 :<br><input class="col-3 border border-secondary p-2 m-2" type="text" name="addressLine2" value="${selectedOffice.addressLine2}"><br>
        5. state :<br><input class="col-3 border border-secondary p-2 m-2" type="text" name="state" value="${selectedOffice.state}"><br>
        6. country :<br><input class="col-3 border border-secondary p-2 m-2" type="text" name="country" value="${selectedOffice.country}"><br>
        7. postal code :<br><input class="col-3 border border-secondary p-2 m-2" type="text" name="postalCode" value="${selectedOffice.postalCode}"><br>
        8. phone number :<br><input class="col-3 border border-secondary p-2 m-2" type="text" name="phoneNumber" value="${selectedOffice.phoneNumber}"><br>
        9. territory :<br><input class="col-3 border border-secondary p-2 m-2" type="text" name="territory" value="${selectedOffice.territory}"><br>
        <input class="m-3" type="submit" value="Submit">
        <button><a href="index.jsp">Back</a></button>
    </div>
</form>
</div>
</body>
</html>
