<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Title</title>
</head>
<body>
<form action="updateUser" method="post">
    <table border="1" width="600" cellpadding="2" cellspacing="2" align="center">
        <input type="hidden" name="userId" value="${map.userId}">
        <tr>
            <td>userName:<input type="text" id="userName" name="userName" value="${map.userName}"></td>
        </tr>
        <tr>
            <td>userAge:<input type="text" id="userAge" name="userAge" value="${map.userAge}"></td>
        </tr>
        <tr>
            <td colspan="2"><input type="submit" value="修改"></td>
        </tr>
    </table>
</form>
</body>
</html>