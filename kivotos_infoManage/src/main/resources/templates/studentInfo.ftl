<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>学生信息</title>
    <link rel="stylesheet" href="static/css/studentInfo.css">
</head>
<body>
<div class="background">
    <div id="table-container">
        <table id="data-table">
            <thead>
            <tr>
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
<script src="https://ajax.aspnetcdn.com/ajax/jQuery/jquery-3.7.1.min.js"></script>
<script src="static/js/studentInfo.js"></script>
</body>
</html>
