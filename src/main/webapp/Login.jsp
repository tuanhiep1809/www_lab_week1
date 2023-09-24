<%--
  Created by IntelliJ IDEA.
  User: LaptopAnhHiep
  Date: 9/19/2023
  Time: 12:27 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>Login</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
    <link rel="stylesheet" type="text/css" href="css/style.css">

    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js"
            integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM"
            crossorigin="anonymous"></script>
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.css"
          integrity="sha512-5A8nwdMOWrSz20fDsjczgUidUBR8liPYU+WymTZP1lmY9G6Oc7HlZv156XqnsgNUzTyMefFTcsFH/tnJE/+xBg=="
          crossorigin="anonymous" referrerpolicy="no-referrer"/>

</head>
<body>
<nav class="navbar navbar-expand-lg navbar-light bg-dark">
    <div class="container-fluid">
        <a class="navbar-brand" href="#">
            <img src="images/logo.jpg" height="50px">
        </a>

        <div class="collapse navbar-collapse" id="navbarSupportedContent">
        </div>
    </div>
</nav>
<nav class="container mt-5 row justify-content-center col-md-6 card">
    <div class="card-body">
        <form action="dashboard" method="post">
            <%-- Kiểm tra xem có thông báo lỗi không và hiển thị nếu có --%>
            <c:if test="${not empty error}">
                <div class="alert alert-danger" role="alert">
                        ${error}
                </div>
            </c:if>







            <div class="mb-3">
                <label for="account_id" class="form-label"  >Account ID</label>
                <input type="text" class="form-control" id="account_id" name="account_id" required>
            </div>
            <div class="mb-3">
                <label for="password" class="form-label">Password</label>
                <input type="password" class="form-control" id="password" name="password" required>
            </div>
            <div class="text-center">
                <button type="submit" name="action"     value="login"  class="btn btn-primary" >Login</button>
            </div>
        </form>
    </div>
</nav>
</body>
</html>
