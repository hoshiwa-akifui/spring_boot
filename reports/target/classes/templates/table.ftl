<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>用户数据</title>
</head>
<body>
<table>
    <tr>
        <th>user_id</th>
        <th>user_name</th>
        <th>user_age</th>
    </tr>
    <#list users as user>
        <tr>
            <td>${user.user_id}</td>
            <td>${user.user_name}</td>
            <td>${user.user_age}</td>
        </tr>
    </#list>
</table>
</body>
</html>