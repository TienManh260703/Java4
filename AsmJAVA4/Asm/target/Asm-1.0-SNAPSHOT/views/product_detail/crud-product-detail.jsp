<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: manhnt
  Date: 4/3/2024
  Time: 4:49 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
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
                        Dropdown
                    </a>
                    <ul class="dropdown-menu">
                        <li><a class="dropdown-item" href="#">Action</a></li>
                        <li><a class="dropdown-item" href="#">Another action</a></li>
                        <li>
                            <hr class="dropdown-divider">
                        </li>
                        <li><a class="dropdown-item" href="#">Something else here</a></li>
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
<%--End NAV--%>
<div class="container">

    <form action="/product-detail/update?id=${pd.id}" method="post">
        <div class="row">
            <div class="col-md-3">
                <div class="form-group">
                    <label>Tên sản phẩm</label>
                    <select class="form-control" name="productId">
                        <c:forEach var="p" items="${productList}">
                            <option value="${p.id}"  ${p.id == pd.productId ? "selected" : ""} ${btn == 1 ? "disabled" : ""} >${p.name}</option>
                        </c:forEach>

                    </select>
                </div>
            </div>
            <div class="col-md-3">
                <div class="form-group">
                    <label>Màu sắc</label>
                    <select class="form-control" name="colorId">
                        <c:forEach var="color" items="${colorList}">
                            <option value="${color.id}"  ${color.id == pd.colorId ? "selected" : ""} ${btn == 1 ? "disabled" : ""}>${color.name}</option>
                        </c:forEach>
                    </select>
                </div>
            </div>
            <div class="col-md-3">
                <div class="form-group">
                    <label>Dòng sản phẩm</label>
                    <select class="form-control" name="productLineId">
                        <c:forEach var="pl" items="${productLineList}">
                            <option value="${pl.id}" ${pl.id == pd.productLineId ? "selected" : ""} ${btn == 1 ? "disabled" : ""} >${pl.name}</option>
                        </c:forEach>

                    </select>
                </div>
            </div>
            <div class="col-md-3">
                <div class="form-group">
                    <label>Nhà sản xuất</label>
                    <select class="form-control" name="producerId">
                        <c:forEach var="pdc" items="${producerList}">
                            <option value="${pdc.id}"  ${pdc.id == pd.producerId ? "selected" : ""} ${btn == 1 ? "disabled" : ""}>${pdc.name}</option>
                        </c:forEach>
                    </select>
                </div>
            </div>
        </div>
        <div class="row">
            <div class="col-md-3">
                <div class="form-group">
                    <label>Giá nhập</label>
                    <input  class="form-control" type="text" name="importPrice" value="${pd.importPrice}"  ${btn == 1 ? "readonly" : ""}/>
                </div>
            </div>
            <div class="col-md-3">
                <div class="form-group">
                    <label>Giá bán</label>
                    <input class="form-control" type="text" name="price" value="${pd.price}"  ${btn == 1 ? "readonly" : ""} />
                </div>
            </div>
            <div class="col-md-3">
                <div class="form-group">
                    <label>Số lượng</label>
                    <input class="form-control" type="text" name="quantity" value="${pd.quantity}"  ${btn == 1 ? "readonly" : ""}/>
                </div>
            </div>
            <div class="col-md-3">
                <div class="form-group">
                    <label>Năm bảo hành</label>
                    <input class="form-control" type="text" name="warrantyYear" value="${pd.warrantyYear}"  ${btn == 1 ? "readonly" : ""}/>
                </div>
            </div>
        </div>
        <div class="row">
            <div class="col-md-12">
                <div class="form-group">
                    <label>Mô tả</label>
                    <textarea class="form-control" type="text" name="describe"  ${btn == 1 ? "readonly" : ""}>
                        ${pd.describe}
                    </textarea>
                </div>
            </div>
        </div>
        <c:choose>
            <c:when test="${btn eq 0}">
                <button class="btn btn-warning mt-3 mb-3" type="submit">Câp nhập</button>
            </c:when>
            <c:otherwise>
                <a href="/product-detail/list" class="btn btn-primary mt-3 mb-3" style="direction: none">
                   Quay lai
                </a>
            </c:otherwise>
        </c:choose>

    </form>
</div>
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
</body>
</html>
