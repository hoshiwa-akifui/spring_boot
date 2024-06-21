<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>学生信息</title>
    <link rel="stylesheet" href="static/css/studentInfo.css">
    <link rel="stylesheet" href="static/css/infoTable.css">
</head>
<body>
<div class="background">
    <input type="hidden" id="msg" value="${msg}"/> <!-- 接收后端发来的成功失败信息-->
    <div id="table-container">
        <button class="add-button">+</button> <!-- 添加按钮 -->
        <button id="dtn" class="delete-button disabled-button">-</button> <!-- 删除按钮 -->
        <table id="data-table">
            <thead>
            <tr>
                <th><input type="checkbox" name="check" onclick="checkAll();"/>全选/非全选</th>
                <th>学生id</th>
                <th>学生姓名</th>
                <th>学生性别</th>
                <th>所属学校</th>
                <th>状态</th>
            </tr>
            </thead>
            <tbody>
            <!-- 这里填充表格数据 -->
            </tbody>
        </table>
    </div>
    <div class="pagination">
        <button id="indexBtn" class="disabled-button">首页</button>
        <button id="prevBtn" class="disabled-button">&laquo; 上一页</button>
        <span id="pageIndicator"></span>
        <button id="nextBtn">下一页 &raquo;</button>
        <button id="endBtn">末页</button>
    </div>
</div>

<#--添加、修改学生信息所用的表格-->
<div id="popup-form" class="popup-form">
    <form id="formAction" action="" method="post">
        <h1 id="formTitle" style="text-align: center; color: #007bff"><!-- 这是是提示标题--></h1>
        <!-- 表单内容 -->
        <label for="id">学生id:</label>
        <input type="text" id="id" name="id" value="default" readonly><br><br>

        <label for="name">学生姓名:</label>
        <input type="text" id="name" name="name"><br><br>

        <label for="sex">学生性别:</label>
        <select id="sex" name="sex">
            <option value="男">男</option>
            <option value="女">女</option>
        </select><br><br>

        <label for="school">所属学校:</label>
        <select id="school" name="school">
            <!-- 使用ajax查询学校数据，然后依次加入学校name-->
        </select><br><br>

        <label for="status">状态:</label>
        <select id="status" name="status">
            <option value="1">正常使用</option>
            <option value="0">禁用</option>
        </select>
        <!-- 其他表单字段 -->
        <div class="button-container">
            <button type="submit">提交</button>
            <button type="button" onclick="closePopup()">取消</button>
        </div>
    </form>
</div>

<script src="https://ajax.aspnetcdn.com/ajax/jQuery/jquery-3.7.1.min.js"></script>
<script src="static/js/studentInfo.js"></script>
<script src="static/js/operateInfo.js"></script>
</body>
</html>
