<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: manhnt
  Date: 4/5/2024
  Time: 12:42 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Bán hàng</title>
    <style>
        /* CSS cho bảng giỏ hàng */
        #cartTable {
            position: absolute;
            top: 50%; /* Đặt vị trí theo chiều dọc ở giữa */
            left: 50%; /* Đặt vị trí theo chiều ngang ở giữa */
            transform: translate(-50%, -50%); /* Di chuyển bảng giỏ hàng về giữa màn hình */
            z-index: 999; /* Đảm bảo bảng giỏ hàng hiển thị trên các phần tử khác */
            background-color: white; /* Màu nền của bảng */
            padding: 20px;
            border: 1px solid #ccc;
            border-radius: 5px;
            display: none; /* Ẩn bảng giỏ hàng ban đầu */
        }

        /* CSS cho nút tắt bảng giỏ hàng */
        #closeCartButton {
            position: absolute;
            top: 10px; /* Khoảng cách từ top */
            right: 10px; /* Khoảng cách từ right */
            cursor: pointer;
        }
    </style>
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
    <link href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css" rel="stylesheet">
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
    <!-- Nút "Xem giỏ hàng" -->
    <button id="viewCartButton" class="btn btn-primary mt-3 mb-3">Xem giỏ hàng</button>

    <!-- Bảng hiển thị giỏ hàng -->
    <div id="cartTable">
        <!-- Nút tắt bảng giỏ hàng -->
        <div id="closeCartButton">&times;</div>
        <h2>Danh sách sản phẩm</h2>
        <table class="table">
            <thead>
            <tr>
                <th>STT</th>
                <th>Sản phẩm</th>
                <th>Giá</th>
                <th>Số lượng mua</th>
                <th>Thành tiển</th>
                <th> Thao tác</th>
            </tr>
            </thead>
            <tbody id="cartItems">

            <c:forEach varStatus="i" var="prod" items="${producerDetailList}"><h1>${prod.id}</h1>
               <tr>
                   <form action="/order/add?idPd=${prod.id}" method="post"> <!-- Bắt đầu form cho mỗi hàng -->
                       <td>${i.index + 1}</td>
                       <td>${prod.productName} - ${prod.colorName} - ${prod.productLineName}<br>${prod.quantity}</td>

                       <td>${prod.price}</td>
                       <td><input type="number" name="quantityPurchased" class="quantityInput"></td>
                       <td class="totalQuantity">0</td> <!-- Số lượng mua nhân giá sẽ được hiển thị ở đây -->
                       <td><button type="submit">Chọn</button></td> <!-- Sử dụng button thay vì thẻ a để submit form -->
                   </form> <!-- Kết thúc form cho mỗi hàng -->
               </tr>
            </c:forEach>
            </tbody>
        </table>
    </div>

    <!-- Bảng danh sách mặt hàng để mua -->
    <h2>Danh sách mặt hàng</h2>
    <table class="table">
        <thead>
        <tr>
            <th>Sản phẩm</th>
            <th>Giá</th>
            <th>Thêm vào giỏ hàng</th>
        </tr>
        </thead>
        <tbody id="productItems">
        <!-- Dữ liệu sản phẩm sẽ được thêm ở đây -->
        </tbody>
    </table>
</div>

<script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.9.3/dist/umd/popper.min.js"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
<script>
    // Sự kiện click cho nút "Xem giỏ hàng"
    document.getElementById("viewCartButton").addEventListener("click", function() {
        var cartTable = document.getElementById("cartTable");
        // Hiển thị hoặc ẩn bảng giỏ hàng khi nhấn vào nút "Xem giỏ hàng"
        cartTable.style.display = cartTable.style.display === "none" ? "block" : "none";
    });

    // Sự kiện click cho nút tắt bảng giỏ hàng
    document.getElementById("closeCartButton").addEventListener("click", function() {
        var cartTable = document.getElementById("cartTable");
        // Ẩn bảng giỏ hàng khi nhấn vào nút tắt
        cartTable.style.display = "none";
    });
</script>

<script>
    // Lặp qua tất cả các input số lượng mua
    document.querySelectorAll('.quantityInput').forEach(function(input) {
        // Thêm sự kiện 'change' cho mỗi input
        input.addEventListener('change', function() {
            // Lấy giá trị số lượng mua
            var quantityPurchased = parseInt(input.value);
            // Lấy giá trị giá sản phẩm từ cột trước đó
            var price = parseFloat(input.parentElement.previousElementSibling.textContent);
            // Tính tổng số lượng mua nhân giá và hiển thị trong cột 'Số lượng mua nhân giá'
            input.parentElement.nextElementSibling.textContent = quantityPurchased * price;
        });
    });
</script>
</body>
</html>
