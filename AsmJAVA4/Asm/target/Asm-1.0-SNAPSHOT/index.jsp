<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>JSP - Hello World</title>
</head>
<body>
<h1><%= "Hello World!" %>
</h1>
<br/>
<a href="hello-servlet">Hello Servlet</a>
</body>
    <form action="/LoginServlet">
        u : <input name="code"> <br>
        p : <input name="password"> <br>
        <button> sub</button>
    </form>
</html>