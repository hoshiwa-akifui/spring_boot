<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>おかえり先生</title>
    <link rel="stylesheet" href="static/css/login.css">
</head>
<body>
<div class="background"></div>
<div class="login-container">
    <h2>おかえり先生</h2>
    <form action="login" method="post">
        <label for="username">Username</label>
        <input type="text" id="username" name="username" placeholder="请输入账号" value="akifui123" required>
        <label for="password">Password</label>
        <input type="password" id="password" name="password" placeholder="请输入密码" value="123456" required>
        <button type="submit">Login</button>
    </form>
</div>
</body>
</html>
