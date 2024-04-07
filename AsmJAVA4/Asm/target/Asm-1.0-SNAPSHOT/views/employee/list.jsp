<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: manhnt
  Date: 4/4/2024
  Time: 8:51 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/css/bootstrap.min.css" rel="stylesheet">
    <script
            src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.11.8/dist/umd/popper.min.js"
            integrity="sha384-I7E8VVD/ismYTF4hNIPjVp/Zjvgyol6VFvRkX/vR+Vc4jQkC+hVqc2pM8ODewa9r"
            crossorigin="anonymous"
    ></script>

    <script
            src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.min.js"
            integrity="sha384-BBtl+eGJRgqQAUMxJ7pMwbEyER4l1g+O15P+16Ep7Q9Q+zqX6gSbd85u4mG4QzX+"
            crossorigin="anonymous"
    ></script>
</head>
<body>
<nav class="navbar navbar-expand-lg bg-body-tertiary mb-3">
    <div class="container-fluid">
        <a class="navbar-brand" href="#">Navbar</a>
        <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarSupportedContent"
                aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
            <span class="navbar-toggler-icon"></span>
        </button>
        <div class="collapse navbar-collapse" id="navbarSupportedContent">
            <ul class="navbar-nav me-auto mb-2 mb-lg-0">
                <li class="nav-item">
                    <a class="nav-link active" aria-current="page" href="#">Home</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="#">Link</a>
                </li>
                <li class="nav-item dropdown">
                    <a class="nav-link dropdown-toggle" href="#" role="button" data-bs-toggle="dropdown"
                       aria-expanded="false">
                        Danh sách ...
                    </a>
                    <ul class="dropdown-menu">
                        <li><a class="dropdown-item" href="/product-detail/list">Chi tiết sản phẩm</a></li>
                        <li><a class="dropdown-item" href="/product/list">Sản phẩm</a></li>
                        <li><a class="dropdown-item" href="/product-line/list">Dòng sản phảm</a></li>
                        <li><a class="dropdown-item" href="/color/list">Màu sắc</a></li>
                        <li><a class="dropdown-item" href="/producer/list">Nhà sản xuất</a></li>
                        <li>
                            <hr class="dropdown-divider">
                        </li>
                        <li><a class="dropdown-item" href="/employee/list">Nhân viên</a></li>
                        <li><a class="dropdown-item" href="/position/list">Chức vụ</a></li>
                        <li>
                            <hr class="dropdown-divider">
                        </li>
                        <li><a class="dropdown-item" href="/customer/list">Khách hàng</a></li>
                        <li>
                            <hr class="dropdown-divider">
                        </li>
                        <li><a class="dropdown-item" href="/shop/list">Cua hang</a></li>

                    </ul>
                </li>
                <li class="nav-item">
                    <a class="nav-link disabled" aria-disabled="true">Disabled</a>
                </li>
            </ul>
            <form class="d-flex" role="search">
                <input class="form-control me-2" type="search" placeholder="Search" aria-label="Search">
                <button class="btn btn-outline-success" type="submit">Search</button>
            </form>
        </div>
    </div>
</nav>
<div class="container">
    <h2>Danh sách nhân viên</h2>
    <a href="/employee/view-add" class="btn btn-success">+ Add</a>
    <table class="table">
        <thead>
        <tr>
            <th scope="col">STT</th>
            <th scope="col">Code</th>
            <th scope="col">Tên</th>
            <th scope="col">Tên đệm</th>
            <th scope="col">Họ</th>
            <th scope="col">Giới tính</th>
            <th scope="col">Ngày sinh</th>
            <th scope="col">Địa chỉ</th>
            <th scope="col">Số điện thoại</th>
            <th scope="col">Mật khẩu</th>
            <th scope="col">Cửa hàng</th>
            <th scope="col">Chức vụ</th>
            <th scope="col">Thao tác</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach varStatus="i" var="e" items="${employeeList}">
            <tr>
                <td>
                        ${i.index +1}
                </td>
                <td>${e.code}</td>
                <td>${e.firstName}</td>
                <td>${e.middleName}</td>
                <td>${e.lastName}</td>
                <td>${e.gender}</td>
                <td>${e.dateStr}</td>
                <td>${e.address}</td>
                <td>${e.phoneNumber}</td>
                <td>${e.password}</td>
                <td>${e.shopName}</td>
                <td>${e.positionName}</td>
                <td>
                    <a href="/employee/delete?id=${e.id}" class="btn btn-danger">Delete</a>
                    <a href="/employee/view-update?id=${e.id}" class="btn btn-warning">Update</a>
                    <a href="/employee/detail?id=${e.id}" class="btn btn-info">Detail</a></td>
            </tr>
        </c:forEach>

        </tbody>
    </table>
</div>
</body>
</html>
