<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>我是freemarker页面</title>
    <script>
        //验证账号是否OK
        function checkUserName() {
            var username = document.getElementById("username").value.trim();//取到username输入框的值 trim去空格
            if (username == '') {
                document.getElementById("username1").innerHTML = '账号不允许为空';
                document.getElementById("username1").style.color = 'red';
                return false;
            } else {
                document.getElementById("username1").innerHTML = '账号OK';
                document.getElementById("username1").style.color = 'green';
                return true;
            }
        }

        //验证密码是否OK
        function checkPassword() {
            var password = document.getElementById("password").value.trim();//取到username输入框的值 trim去空格
            if (password == '') {
                document.getElementById("password1").innerHTML = '密码不允许为空';
                document.getElementById("password1").style.color = 'red';
                return false;
            } else if (password.length != 6) {
                document.getElementById("password1").innerHTML = '密码长度不是6位';
                document.getElementById("password1").style.color = 'red';
                return false;
            } else {
                document.getElementById("password1").innerHTML = '密码OK';
                document.getElementById("password1").style.color = 'green';
                return true;
            }
        }

        function check() {
            if (checkUserName() & checkPassword()) {
                return true;
            } else {
                return false;
            }
        }
    </script>
</head>
<body>
<marquee align="left">大家好，这是我的登录页面</marquee>
<!--action的路径可以是一个页面也可以是一个controller/servlet-->
<!--method get/post
1:get方法传值的数据量没有post多
2:如果我的表单元素中含有二进制文件，只允许用post方式提交，但是后面的enctype需要指定multipart/form-data
3：get方式提交的话地址栏会显示地址，so不安全，post则不会
4:get方式提交中文乱码问题和post的解决方式是不一样
onsubmit  表示返回的是一个boolean值,true会执行Action的跳转 false则不会，所以onsubmit通常会
//和onblur等事件进行联用，而且还会有正则表达式进行联用，通常用于做数据的验证
-->
<form action="reg" method="post" onsubmit="return check();">
    <table border="1" width="600" cellpadding="2" cellspacing="2" align="center">
        <tr>
            <td>username:<input type="text" id="username" name="username" onblur="checkUserName();" value="admin"></td>
            <td id="username1">请输入用户名</td>
        </tr>
        <tr>
            <td>password:<input type="password" id="password" name="password" onblur="checkPassword();" value="111111">
            </td>
            <td id="password1">请输入6位数密码</td>
        </tr>
        <tr>
            <td colspan="2"><input type="submit" value="注册"></td>
        </tr>
    </table>
</form>
</body>
</html>