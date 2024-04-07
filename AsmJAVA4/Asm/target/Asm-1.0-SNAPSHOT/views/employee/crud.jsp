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
    <h2>Thông tin nhân viên ${action}</h2>
    <form action="${action}" method="post" >
        <div class="row">
            <div class="col-md-2">
                <div class="mb-3">
                    <label for="code" class="form-label">Code</label>
                    <input type="text" class="form-control" id="code" name="code" value="${e.code}">
                </div>
            </div>
            <div class="col-md-2">
                <div class="mb-3">
                    <label for="firstName" class="form-label">Tên</label>
                    <input type="text" class="form-control" id="firstName" name="firstName" value="${e.firstName}">
                </div>
            </div>
            <div class="col-md-2">
                <div class="mb-3">
                    <label for="middleName" class="form-label">Tên đệm</label>
                    <input type="text" class="form-control" id="middleName" name="middleName" value="${e.middleName}">
                </div>
            </div>
            <div class="col-md-2">
                <div class="mb-3">
                    <label for="lastName" class="form-label">Họ</label>
                    <input type="text" class="form-control" id="lastName" name="lastName" value="${e.lastName}">
                </div>
            </div>
            <div class="col-md-2">
                <div class="mb-3">
                    <label class="form-label">Giới tính</label><br>
                    <div class="form-check form-check-inline">
                        <input class="form-check-input" type="radio" name="gender" id="male" value="Male" ${e.gender eq "Male" ? "checked"  : ""} >
                        <label class="form-check-label" for="male">Nam</label>
                    </div>
                    <div class="form-check form-check-inline">
                        <input class="form-check-input" type="radio" name="gender" id="female" value="female" ${e.gender eq "female" ? "checked"  : ""}>
                        <label class="form-check-label" for="female">Nữ</label>
                    </div>
                </div>
            </div>
        </div>
        <div class="row">
            <div class="col-md-2">
                <div class="mb-3">
                    <label for="dateOfBirth" class="form-label">Ngày sinh</label>
                    <input type="text" class="form-control" id="dateOfBirth" name="dateStr"placeholder="MM-dd-yyyy" value="${e.dateStr}">
                </div>
            </div>
            <div class="col-md-2">
                <div class="mb-3">
                    <label for="address" class="form-label">Địa chỉ</label>
                    <input type="text" class="form-control" id="address" name="address" value="${e.address}">
                </div>
            </div>
            <div class="col-md-2">
                <div class="mb-3">
                    <label for="phoneNumber" class="form-label">Số điện thoại</label>
                    <input type="text" class="form-control" id="phoneNumber" name="phoneNumber" value="${e.phoneNumber}">
                </div>
            </div>
            <div class="col-md-2">
                <div class="mb-3">
                    <label for="password" class="form-label">Mật khẩu</label>
                    <input type="password" class="form-control" id="password" name="password" value="${e.password}">
                </div>
            </div>
            <div class="col-md-2">
                <div class="mb-3">
                    <label for="shop" class="form-label">Cửa hàng</label>
                    <select class="form-select" id="shop" name="shopId">
                       <c:forEach var="s" items="${shopList}">
                           <option value="${s.id}"  ${s.id == e.shopId ? "selected" : ""}>${s.name}</option>
                       </c:forEach>
                    </select>
                </div>
            </div>
        </div>
        <div class="row">
            <div class="col-md-2">
                <div class="mb-3">
                    <label for="position" class="form-label">Chức vụ</label>
                    <select class="form-select" id="position" name="positionId">
                        <c:forEach var="p" items="${positionList}">
                            <option value="${p.id}" ${p.id == e.positionId ? "selected" : ""}>${p.name}</option>
                        </c:forEach>
                    </select>
                </div>
            </div>
        </div>
        <button type="submit" class="btn btn-primary">Submit</button>
    </form>
</div>

</script>
</body>
</html>
