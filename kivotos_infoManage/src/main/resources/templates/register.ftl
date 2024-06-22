<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>注册页面</title>
    <link rel="stylesheet" href="static/css/register.css">
</head>
<body>
<div class="background"></div>
<div class="login-container">
    <h2>注册账号</h2>
    <form action="register" method="post" enctype="multipart/form-data">

        <label for="avatar">头像:</label>
        <input type="file" id="avatar" name="avatar" required>
        <label for="username">Username</label>
        <input value="test" type="text" id="username" name="username" placeholder="请输入账号" required>
        <label for="password">Password</label>
        <input value="test" type="password" id="password" name="password" placeholder="请输入密码" required>
        <label for="name">姓名:</label>
        <input value="test" type="text" id="name" name="name" required>
        <label for="phone">手机号:</label>
        <input value="test" type="text" id="phone" name="phone" required>

        <div class="button-container">
            <button type="submit">Register</button>
            <button type="button" onclick="window.history.back();">Cancel</button>
        </div>
    </form>
</div>
</body>
</html>
