<%--<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>--%>
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
    <title>dashboard</title>
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
        <form method="post" action="ControlServlet">
            <a class="navbar-brand" href="#">
                <img src="images/logo.jpg" height="50px">
            </a>

            <div class="collapse navbar-collapse" id="navbarSupportedContent">

                <ul class="navbar-nav ml-auto"> <!-- Sử dụng lớp ml-auto để nút "Login" nằm bên phải -->
                    <li class="nav-item">
                        <a class="nav-link active" aria-current="page" href="index.jsp"
                           style="color: white; font-size: 17px;">Logout</a>

                    </li>
                    <li class="nav-item">
                        <!-- Các phần tử khác nếu có -->
                    </li>
                </ul>


            </div>
        </form>
    </div>
</nav>
<h3 style="text-align: center; color: blue;">Xin chào ${kiemTraAdmin} ${id}</h3>

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


        <%
            String kiemTraAdmin = request.getAttribute("kiemTraAdmin").toString();
            int i = 1;
            if (kiemTraAdmin.equals("admin")) {
                List<Account> a = (List<Account>) request.getAttribute("list");
        %>
        <%--add --%>
        <nav class="container mt-2 row justify-content-center col-md-4 card">
            <div class="card-body">
                <form action="dashboard" method="post">
                    <div class="mb-1">
                        <label for="account_idAdd" class="form-label">Account ID</label>
                        <input type="text" class="form-control" id="account_idAdd" name="account_idAdd" required>
                    </div>
                    <div class="mb-1">
                        <label for="FullnameAdd" class="form-label">Fullname</label>
                        <input type="text" class="form-control" id="FullnameAdd" name="FullnameAdd" required>
                    </div>
                    <div class="mb-1">
                        <label for="PasswordAdd" class="form-label">Password</label>
                        <input type="password" class="form-control" id="PasswordAdd" name="PasswordAdd" required>
                    </div>
                    <div class="mb-1">
                        <label for="EmailAdd" class="form-label">Email</label>
                        <input type="email" class="form-control" id="EmailAdd" name="EmailAdd" required>
                    </div>
                    <div class="mb-1">
                        <label for="PhoneAdd" class="form-label">Phone</label>
                        <input type="number" class="form-control" id="PhoneAdd" name="PhoneAdd" required>
                    </div>
                    <div class="mb-1">
                        <label for="StatusAdd" class="form-label">Status (0,1,-1)</label>
                        <input type="number" class="form-control" id="StatusAdd" name="StatusAdd" required>
                    </div>
                    <div class="text-center">
                        <button type="submit" name="action" value="add" class="btn btn-primary">Add</button>
                    </div>
                </form>
            </div>
        </nav>
        <%
            for (Account acc : a) {

        %>
        <tbody>
        <tr bgcolor="#bffef4">
            <td scope="col"><%= i++%>
            </td>
            <td id="IDCanUpdate" scope="col"><%= acc.getAccount_id()%>
            <td/>
            <td scope="col"><%= acc.getFull_name()%>
            <td/>
            <td scope="col"><%= acc.getPassword()%>
            <td/>
            <td scope="col"><%= acc.getEmail()%>
            <td/>
            <td scope="col"><%= acc.getPhone()%>
            <td/>
            <td scope="col"><%= acc.getStatus() %>
            <td/>
            <td scope="col">
                <form method="post" action="dashboard">
                    <input type="hidden" name="id" value="<%= acc.getAccount_id() %>">
                    <button name="action" value="Delete" type="submit" class="btn btn-primary"><i class="fa fa-trash"
                                                                                                  aria-hidden="true"></i>
                    </button>
                    <button onclick="copyData()"  type="button"  class="btn btn-primary" id="show-formUpdate"><i
                            class="fa fa-edit" aria-hidden="true"></i>
                    </button>
                </form>
            </td>

        </tr>
        <% }
        }
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

<form id="info-formUpdate" class="card-body container mt-2 row justify-content-center col-md-4 card"
      style="display: none; justify-content: center" action="dashboard" method="post">

    <div class="mb-1">
        <label for="account_idUpdate" class="form-label">Account ID</label>
        <input   type="text" class="form-control" id="account_idUpdate" name="account_idUpdate" readonly>
    </div>
    <div class="mb-1">
        <label for="FullnameUpdate" class="form-label">Fullname</label>
        <input type="text" class="form-control" id="FullnameUpdate" name="FullnameUpdate" required>
    </div>
    <div class="mb-1">
        <label for="PasswordUpdate" class="form-label">Password</label>
        <input type="password" class="form-control" id="PasswordUpdate" name="PasswordUpdate" required>
    </div>
    <div class="mb-1">
        <label for="EmailUpdate" class="form-label">Email</label>
        <input type="email" class="form-control" id="EmailUpdate" name="EmailUpdate" required>
    </div>
    <div class="mb-1">
        <label for="PhoneUpdate" class="form-label">Phone</label>
        <input type="number" class="form-control" id="PhoneUpdate" name="PhoneUpdate" required>
    </div>
    <div class="mb-1">
        <label for="StatusUpdate" class="form-label">Status (0,1,-1)</label>
        <input type="number" class="form-control" id="StatusUpdate" name="StatusUpdate" required>
    </div>
    <div class="text-center">
        <button type="submit" name="action" value="Update" class="btn btn-primary">Update</button>
    </div>

</form>

<script>

    // Lấy tham chiếu đến nút và form
    const showFormButton = document.getElementById('show-formUpdate');
    const infoForm = document.getElementById('info-formUpdate');
    var cellData = document.getElementById("IDCanUpdate").textContent;
    // Đặt sự kiện click cho nút "Add"
    showFormButton.addEventListener('click', () => {
        // Hiển thị form khi nút "Add" được bấm
        infoForm.style.display = 'block';
        document.getElementById("account_idUpdate").value = cellData;
        // Gán giá trị cho input ẩn


    });
</script>


</body>
</html>
