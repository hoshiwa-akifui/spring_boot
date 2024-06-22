<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>おかえり先生</title>
    <link rel="stylesheet" href="static/css/login.css">
    <script>
        window.onload = function (){
            if(document.getElementById("msg").value!=""){
                alert(document.getElementById("msg").value);
            }
        }
    </script>
</head>
<body>
<div class="background"></div>
<div class="login-container">
    <input type="hidden" id="msg" value="${msg}"/> <!-- 接收过滤器发来的通知-->
    <h2>おかえり先生</h2>
    <form action="login" method="post">
        <label for="username">Username</label>
        <input type="text" id="username" name="username" placeholder="请输入账号" value="akifui123" required>
        <label for="password">Password</label>
        <input type="password" id="password" name="password" placeholder="请输入密码" value="123456" required>
        <div class="button-container">
            <button type="submit">Login</button>
            <button type="button" onclick="window.location.href='register';">Register</button>
        </div>
    </form>
</div>
</body>
</html>
