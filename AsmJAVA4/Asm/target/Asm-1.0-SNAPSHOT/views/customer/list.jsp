<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: manhnt
  Date: 4/4/2024
  Time: 9:51 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Khanh hang</title>
    <link
            href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css"
            rel="stylesheet"
            integrity="sha384-T3c6CoIi6uLrA9TneNEoa7RxnatzjcDSCmG1MXxSR1GAsXEV/Dwwykc2MPK8M2HN"
            crossorigin="anonymous"
    />
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
    <form action="/customer/add" method="post">
        <!-- Hàng 1 -->
        <div class="row">
            <div class="col-md-2">
                <div class="mb-3">
                    <label for="code" class="form-label">Mã</label>
                    <input type="text" class="form-control" id="code" name="code">
                </div>
            </div>
            <div class="col-md-2">
                <div class="mb-3">
                    <label for="firstName" class="form-label">Tên</label>
                    <input type="text" class="form-control" id="firstName" name="firstName">
                </div>
            </div>
            <div class="col-md-2">
                <div class="mb-3">
                    <label for="middleName" class="form-label">Tên đệm</label>
                    <input type="text" class="form-control" id="middleName" name="middleName">
                </div>
            </div>
            <div class="col-md-2">
                <div class="mb-3">
                    <label for="lastName" class="form-label">Họ</label>
                    <input type="text" class="form-control" id="lastName" name="lastName">
                </div>
            </div>
            <div class="col-md-2">
                <div class="mb-3">
                    <label for="dateStr" class="form-label">Ngày sinh</label>
                    <input type="text" class="form-control" id="dateStr" name="dateStr">
                </div>
            </div>
        </div>
        <!-- Hàng 2 -->
        <div class="row">
            <div class="col-md-3">
                <div class="mb-3">
                    <label for="phoneNumber" class="form-label">Số điện thoại</label>
                    <input type="text" class="form-control" id="phoneNumber" name="phoneNumber">
                </div>
            </div>
            <div class="col-md-3">
                <div class="mb-3">
                    <label for="address" class="form-label">Địa chỉ</label>
                    <input type="text" class="form-control" id="address" name="address">
                </div>
            </div>
            <div class="col-md-3">
                <div class="mb-3">
                    <label for="city" class="form-label">Thành phố</label>
                    <input type="text" class="form-control" id="city" name="city">
                </div>
            </div>
            <div class="col-md-3">
                <div class="mb-3">
                    <label for="country" class="form-label">Quốc gia</label>
                    <input type="text" class="form-control" id="country" name="country">
                </div>
            </div>
        </div>
        <button type="submit" class="btn btn-primary">Submit</button>
    </form>

    <table class="table">
        <thead>
        <tr>
            <th scope="col">STT</th>
            <th scope="col">Mã</th>
            <th scope="col">Tên</th>
            <th scope="col">Tên đệm</th>
            <th scope="col">Họ</th>
            <th scope="col">Ngày sinh</th>
            <th scope="col">Số điện thoại</th>
            <th scope="col">Địa chỉ</th>
            <th scope="col">Thành phố</th>
            <th scope="col">Quốc gia</th>
            <th scope="col">Hành động</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach var="c" items="${customerList}" varStatus="i">
            <tr>
                <td>${i.index + 1}</td>
                <td>${c.code}</td>
                <td>${c.firstName}</td>
                <td>${c.middleName}</td>
                <td>${c.lastName}</td>
                <td>${c.dateStr}</td>
                <td>${c.phoneNumber}</td>
                <td>${c.address}</td>
                <td>${c.city}</td>
                <td>${c.country}</td>
                <td>
                    <a href="/customer/view-update?id=${c.id}" class="btn btn-warning">Update</a>
                    <a href="/customer/delete?id=${c.id}" class="btn btn-danger">Delete</a>
                </td>
            </tr>

        </c:forEach>

        </tbody>
    </table>
</div>


</body>
</html>
