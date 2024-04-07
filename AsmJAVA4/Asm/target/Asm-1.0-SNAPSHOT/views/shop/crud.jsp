<%--
  Created by IntelliJ IDEA.
  User: manhnt
  Date: 4/4/2024
  Time: 9:02 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Shop9</title>
    <link
            href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css"
            rel="stylesheet"
            integrity="sha384-T3c6CoIi6uLrA9TneNEoa7RxnatzjcDSCmG1MXxSR1GAsXEV/Dwwykc2MPK8M2HN"
            crossorigin="anonymous"
    />
</head>
<body>
<div class="container">
    <form action="/shop/update?id=${s.id}" method="post">
        <div class="row">
            <div class="col-md-4">
                <div class="mb-3">
                    <label for="code" class="form-label">Mã</label>
                    <input type="text" class="form-control" id="code" name="code" value="${s.code  }">
                </div>
            </div>
            <div class="col-md-4">
                <div class="mb-3">
                    <label for="name" class="form-label">Tên</label>
                    <input type="text" class="form-control" id="name" name="name" value="${s.name  }">
                </div>
            </div>
            <div class="col-md-4">
                <div class="mb-3">
                    <label for="address" class="form-label">Địa chỉ</label>
                    <input type="text" class="form-control" id="address" name="address" value="${s.address  }">
                </div>
            </div>
        </div>
        <div class="row">
            <div class="col-md-6">
                <div class="mb-3">
                    <label for="city" class="form-label">Thành phố</label>
                    <input type="text" class="form-control" id="city" name="city" value="${s.city  }">
                </div>
            </div>
            <div class="col-md-6">
                <div class="mb-3">
                    <label for="country" class="form-label">Quốc gia</label>
                    <input type="text" class="form-control" id="country" name="country" value="${s.country  }">
                </div>
            </div>
        </div>
        <button type="submit" class="btn btn-primary">Submit</button>
    </form>
</div>
</body>
</html>
