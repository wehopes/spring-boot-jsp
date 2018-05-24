<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>上传文件</title>
</head>
<body>
    <form method="post" enctype="multipart/form-data" action="/upload">
        <p>
            文件:<input type="file" name="file"/>
        </p>
        <p>
            文件:<input type="submit" value="上传"/>
        </p>
    </form>
</body>
</html>
