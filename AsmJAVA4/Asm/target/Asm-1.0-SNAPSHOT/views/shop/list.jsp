<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: manhnt
  Date: 4/4/2024
  Time: 9:24 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Danh sach Shop</title>
    <link
            href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css"
            rel="stylesheet"
            integrity="sha384-T3c6CoIi6uLrA9TneNEoa7RxnatzjcDSCmG1MXxSR1GAsXEV/Dwwykc2MPK8M2HN"
            crossorigin="anonymous"
    />
</head>
<body>

<div class="container">
    <h1>Danh sach cua hang</h1>
    <form action="/shop/add" method="post">
        <div class="row">
            <div class="col-md-4">
                <div class="mb-3">
                    <label for="code" class="form-label">Mã</label>
                    <input type="text" class="form-control" id="code" name="code">
                </div>
            </div>
            <div class="col-md-4">
                <div class="mb-3">
                    <label for="name" class="form-label">Tên</label>
                    <input type="text" class="form-control" id="name" name="name">
                </div>
            </div>
            <div class="col-md-4">
                <div class="mb-3">
                    <label for="address" class="form-label">Địa chỉ</label>
                    <input type="text" class="form-control" id="address" name="address">
                </div>
            </div>
        </div>
        <div class="row">
            <div class="col-md-6">
                <div class="mb-3">
                    <label for="city" class="form-label">Thành phố</label>
                    <input type="text" class="form-control" id="city" name="city">
                </div>
            </div>
            <div class="col-md-6">
                <div class="mb-3">
                    <label for="country" class="form-label">Quốc gia</label>
                    <input type="text" class="form-control" id="country" name="country">
                </div>
            </div>
        </div>
        <button type="submit" class="btn btn-primary">Add</button>
    </form>
    <table class="table ">
        <thead>
        <tr>
            <th scope="col">STT</th>
            <th scope="col">Mã</th>
            <th scope="col">Tên</th>
            <th scope="col">Địa chỉ</th>
            <th scope="col">Thành phố</th>
            <th scope="col">Quốc gia</th>
            <th scope="col">Thao tac</th>

        </tr>
        </thead>
        <tbody>
        <c:forEach var="s" items="${shopList}" varStatus="i">
            <tr>
                <td>${i.index + 1}</td>
                <td>${s.code}</td>
                <td>${s.name}</td>
                <td>${s.address}</td>
                <td>${s.city}</td>
                <td>${s.country}</td>
                <td>
                    <a href="/shop/view-update?id=${s.id}" class="btn btn-warning">Update</a>
                    <a href="/shop/delete?id=${s.id}" class="btn btn-danger">Delete</a>

                </td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
</div>

</body>
</html>
