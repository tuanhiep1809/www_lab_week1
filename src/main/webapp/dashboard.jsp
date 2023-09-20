<%@ page import="vn.edu.iuh.fit.week01_lab_nguyentuanhiep_20111311.entities.Account" %>
<%@ page import="java.util.List" %><%--
  Created by IntelliJ IDEA.
  User: LaptopAnhHiep
  Date: 9/20/2023
  Time: 8:05 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>dashboard_Admin</title>
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
            <img src="images/logo.jpg" height="50px">
        </a>

        <div class="collapse navbar-collapse" id="navbarSupportedContent">
            <form method="post" action="ControlServlet">
                <ul class="navbar-nav ml-auto"> <!-- Sử dụng lớp ml-auto để nút "Login" nằm bên phải -->
                    <li class="nav-item">
                        <a class="nav-link active" aria-current="page" href="index.jsp"
                           style="color: white; font-size: 17px;">Logout</a>

                    </li>
                    <li class="nav-item">
                        <!-- Các phần tử khác nếu có -->
                    </li>
                </ul>
            </form>

        </div>
    </div>
</nav>
<h3 style="text-align: center; color: blue;">Bạn đăng đăng nhập với quyền ${kiemTraAdmin}</h3>

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
            <th scope="col">Action |</th>
        </tr>
        </thead>
        <div class="red"></div>

        <tbody>
        <%
            String kiemTraAdmin = request.getAttribute("kiemTraAdmin").toString();
            int i = 1;
            if (kiemTraAdmin.equals("admin")) {
                List<Account> a = (List<Account>) request.getAttribute("list");

             for (Account acc : a) {

        %>

        <tr bgcolor="#bffef4">
            <td scope="col"><%= i
                    ++ %>
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
            <td scope="col">
                <button name="action" value="Delete" type="button" class="btn btn-primary" data-bs-toggle="modal"
                        data-bs-target="#exampleModal"><i class="fa fa-trash" aria-hidden="true"></i>
                </button>
                <button name="action" value="Update" type="button" class="btn btn-primary" data-bs-toggle="modal"
                        data-bs-target="#exampleModal"><i class="fa fa-edit" aria-hidden="true"></i>
                </button>
            </td>

        </tr>
        <% }}
             if (kiemTraAdmin.equals("user")) {
                Account accc = (Account) request.getAttribute("AccountUser");
        %>
        <tr bgcolor="#bffef4">
            <td scope="col"><%= i++ %>
            </td>
            <td scope="col"><%= accc.getAccount_id() %>
            <td/>
            <td scope="col"><%= accc.getFull_name() %>
            <td/>
            <td scope="col"><%= accc.getPassword() %>
            <td/>
            <td scope="col"><%= accc.getEmail() %>
            <td/>
            <td scope="col"><%= accc.getPhone() %>
            <td/>
            <td scope="col"><%= accc.getStatus() %>
            <td/>
            <td scope="col">

            </td>
        </tr>
        <% } %>

        </tbody>
    </table>
</div>


</body>
</html>
