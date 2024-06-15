<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>我是上传页面</title>
</head>
<body>
<marquee align="left">大家好，这是我的上传页面</marquee>
<form action="upload" method="post" enctype="multipart/form-data">
    <table border="1" width="600" cellpadding="2" cellspacing="2" align="center">
        <tr>
            <td>昵称:<input type="text" name="name"></td>
        </tr>
        <tr>
            <td>头像1:<input type="file" name="attr"></td>
            <td>头像2:<input type="file" name="attr"></td>
            <td>头像3:<input type="file" name="attr"></td>
        </tr>
        <tr>
            <td><input type="submit" value="注册"></td>
        </tr>
    </table>
</form>
</body>
</html>