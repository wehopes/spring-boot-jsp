<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>多文件上传</title>
</head>
<body>
    <form method="post" enctype="multipart/form-data" action="/upload">
        <p>
            文件1:<input type="file" name="file"/>
            文件2:<input type="file" name="file"/>
            文件3:<input type="file" name="file"/>
        </p>
        <p>
            文件:<input type="submit" value="上传"/>
        </p>
    </form>
</body>
</html>
