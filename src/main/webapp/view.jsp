<%--<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>--%>
<%@ page import="vn.edu.iuh.fit.week01_lab_nguyentuanhiep_20111311.entities.Account" %>
<%@ page import="vn.edu.iuh.fit.week01_lab_nguyentuanhiep_20111311.repositories.AccountRepositories" %>
<%@ page import="java.util.List" %>
<%@ page import="java.io.PrintWriter" %><%--
  Created by IntelliJ IDEA.
  User: LaptopAnhHiep
  Date: 9/16/2023
  Time: 12:45 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>Bootstrap 5</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
    <link rel="stylesheet" type="text/css" href="css/style.css">

    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js"
            integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM"
            crossorigin="anonymous"></script>
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.css"
          integrity="sha512-5A8nwdMOWrSz20fDsjczgUidUBR8liPYU+WymTZP1lmY9G6Oc7HlZv156XqnsgNUzTyMefFTcsFH/tnJE/+xBg=="
          crossorigin="anonymous" referrerpolicy="no-referrer"/>
    <%--    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>--%>
</head>

<body>
<nav class="navbar navbar-expand-lg navbar-light bg-dark">
    <div class="container-fluid">
        <a class="navbar-brand" href="#">
            <img src="images/logo1.png" height="50px">
        </a>
        <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarSupportedContent"
                aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
            <span class="navbar-toggler-icon"></span>
        </button>
        <div class="collapse navbar-collapse" id="navbarSupportedContent">
            <ul class="navbar-nav me-auto mb-2 mb-lg-0">
                <li class="nav-item">
                    <a class="nav-link active" aria-current="page"
                       style="color: white; font-size: 17px;">Add Account</a>
                </li>

                <li class="nav-item">
                    <a class="nav-link active" aria-current="page" href="view" style="color: white; font-size: 17px;">View
                        Account</a>
                </li>
            </ul>

        </div>
    </div>
</nav>


<h4>Account</h4>
<div class="container">

    <table class="table">
        <thead style="color: white;">
        <tr bgcolor="#120671">
            <th scope="col">No |</th>
            <th scope="col">Account ID|</th>
            <th scope="col">Full Name |</th>
            <th scope="col">Password |</th>
            <th scope="col">Email |</th>
            <th scope="col">Phone |</th>
            <th scope="col">Status |</th>
        </tr>
        </thead>
                <div class="red"></div>

        <tbody>
        <%
            List<Account> a = (List<Account>) request.getAttribute("list");
            int i=1;
            for (Account acc : a){

        %>
        <c: forEach var="acc" items="${list}">
        <tr bgcolor="#bffef4">
            <td scope="col"><c: ${i} </c:>
            </td>
            <td scope="col"><%= acc.getAccount_id() %>
            <td/>
            <td scope="col"><%= acc.getFull_name() %>
            <td/>
            <td scope="col"><%= acc.getPassword() %>
            <td/>
            <td scope="col"><%= acc.getEmail() %>
            <td/>
            <td scope="col"><%= acc.getPhone() %>
            <td/>
            <td scope="col"><%= acc.getStatus() %>
            <td/>

        </tr>
        <% } %>
        </tbody>
    </table>

</div>


</body>
</html>
