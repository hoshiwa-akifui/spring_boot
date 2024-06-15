<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>用户数据</title>
    <style>
        /* 窗口的基本样式 */
        #addWindow {
            display: none; /* 默认隐藏 */
            position: fixed; /* 固定定位 */
            z-index: 1; /* 位于最前 */
            left: 0;
            top: 0;
            width: 100%;
            height: 100%;
            overflow: auto;
            background-color: rgba(0,0,0,0.4); /* 半透明背景 */
        }

        #addWindowContent {
            background-color: #fefefe;
            margin: 15% auto; /* 中心显示 */
            padding: 20px;
            border: 1px solid #888;
            width: 50%;
        }

        .close {
            color: #aaa;
            float: right;
            font-size: 28px;
            font-weight: bold;
        }

        .close:hover,
        .close:focus {
            color: black;
            text-decoration: none;
            cursor: pointer;
        }
    </style>
</head>
<body>
<button id="add">增加</button><input type="hidden" id="msg" value="${msg}"/>
<!-- 点击增加才显示的窗口-->
<div id="addWindow">
    <div id="addWindowContent">
        <span class="close">&times;</span>
        <form action="" method="post" id="form">
            <table>
                <tr>
                    <th><p id="tInfo"></p></th>
                </tr>
                <input type="hidden" id="user_id" name="user_id"/>
                <tr>
                    <th>用户姓名：<input type="text" id="user_name" name="user_name" placeholder="请输入用户姓名"/></th>
                </tr>
                <tr>
                    <th>用户年龄：<input type="text" id="user_age" name="user_age" placeholder="请输入用户年龄"/></th>
                </tr>
                <tr>
                    <th><input type="submit" id="sub"/></th>
                </tr>
            </table>
        </form>
    </div>
</div>
<button id="dtn" onclick="del();">批量删除</button>
<table>
    <tr>
        <th><input type="checkbox" name="check" onclick="checkAll();"/>全选/非全选</th>
        <th>user_id</th>
        <th>user_name</th>
        <th>user_age</th>
    </tr>
    <#list users as user>
        <tr ondblclick="update(${user.user_id}, '${user.user_name}', '${user.user_age}');">
            <td><input type="checkbox" name="check" onclick="checkOne();" value="${user.user_id}"/></td>
            <td>${user.user_id}</td>
            <td>${user.user_name}</td>
            <td>${user.user_age}</td>
        </tr>
    </#list>
</table>

<script>
    // 获取按钮、模态框和关闭按钮
    var btn = document.getElementById("add");
    var modal = document.getElementById("addWindow");
    var span = document.getElementsByClassName("close")[0];

    // 点击按钮打开模态框
    btn.onclick = function() {
        modal.style.display = "block";

        document.getElementById("tInfo").innerText = "增加一个user的信息";
        document.getElementById("form").action = "addUser";
        document.getElementById("user_id").value = "";
        document.getElementById("user_name").value = "";
        document.getElementById("user_age").value = "";
        document.getElementById("sub").value = "新增";
    }

    // 点击关闭按钮关闭模态框
    span.onclick = function() {
        modal.style.display = "none";
    }

    // 点击模态框外区域关闭模态框
    window.onclick = function(event) {
        if (event.target == modal) {
            modal.style.display = "none";
        }
    }

    // 收到后端的新增是否成功
    window.onload = function (){
        if(document.getElementById("msg").value!=""){
            alert(document.getElementById("msg").value);
        }
    }

    function update(id, name, age){
        modal.style.display = "block";

        document.getElementById("tInfo").innerText = "修改所选中user的信息";
        document.getElementById("form").action = "updateUser";
        document.getElementById("user_id").value = id;
        document.getElementById("user_name").value = name;
        document.getElementById("user_age").value = age;
        document.getElementById("sub").value = "修改";
    }

    function checkAll(){
        var box = document.getElementsByName("check");

        if(box[0].checked){
            for (var i = 0; i < box.length; i++) {
                box[i].checked=true;
            }
        }else{
            for (var i = 0; i < box.length; i++) {
                box[i].checked=false;
            }
        }
    }

    function checkOne(){
        var box = document.getElementsByName("check");

        var result =true;
        for (var i = 1; i < box.length; i++) {
            if(box[i].checked==false){
                result=false;
                break;
            }
        }
        if (result) {
            box[0].checked=true;
        }else {
            box[0].checked=false;
        }

    }

    function del(){
        var box = document.getElementsByName("check");
        var ids="";

        for (var i = 1; i < box.length; i++) {
            if(box[i].checked){
                ids+=box[i].value+",";
            }
        }

        <!-- 去掉ids中最后一个逗号-->
        ids = ids.slice(0, -1);

        if(confirm("您确定要删除id为："+ids+"的数据吗？")){
            location.href = "deleteUser?ids="+ids;
        }else{
            alert("您取消了删除");
        }
    }
</script>
</body>
</html>