<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: manhnt
  Date: 4/4/2024
  Time: 6:18 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Trang Màu  sắc</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
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
    <form action="/color/update?id=${c.id}" method="post" class="mb-3">
        <div class="row">
            <div class="col-md-12">
                <div class="form-group">
                    <label>Mã Màu</label>
                    <input class="form-control" type="text" name="code"  ${btn == 0 ? "readonly" : ""}
                           value="${c.code}">
                </div>
            </div>
        </div>
        <div class="row">
            <div class="col-md-12">
                <div class="form-group">
                    <label>Tên Màu</label>
                    <input class="form-control" type="text" name="name" ${btn == 0 ? "readonly" : ""} value="${c.name}">
                </div>
            </div>
        </div>

        <c:choose>
            <c:when test="${btn eq 0}">
                <a href="/color/list" class="btn btn-primary mt-3 mb-3" style="direction: none">
                    Quay lai
                </a>
            </c:when>
            <c:otherwise>
                <button class="btn btn-warning">Update</button>
            </c:otherwise>
        </c:choose>
    </form>
</div>
</body>
</html>
