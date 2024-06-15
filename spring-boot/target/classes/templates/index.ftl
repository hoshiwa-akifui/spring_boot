<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Title</title>
    <style>
        .clickCS {
            background-color: gray;
            font-size: 40px;
        }
    </style>
    <script>
        function addClass(id) {
            // console.log('addClass');
            //  document.getElementById("tr"+id).style.backgroundColor='gray';
            //  document.getElementById("tr"+id).style.fontSize='40px';
            document.getElementById("tr" + id).className = 'clickCS';
        }

        function removeClass(id) {
            // document.getElementById("tr"+id).style.backgroundColor='';
            // document.getElementById("tr"+id).style.fontSize='';
            document.getElementById("tr" + id).className = '';
        }

        function updateUser(id, name, age) {
            location.href = 'updateUser?userId=' + id + "&userName=" + name + "&userAge=" + age;
        }

        function deleteUser(id){
            if(confirm('你确定要删除id为'+id+'的数据吗？')){
                location.href = 'deleteUser?userId=' + id;
            }else{
                alter('你取消了删除操作')
            }
        }
    </script>
</head>
<body>
<table border="1" width="800" cellpadding="2" cellspacing="1" align="center">
    <tr>
        <td>id</td>
        <td>name</td>
        <td>age</td>
        <td>control</td>
    </tr>
    <#list list as user>
        <tr onmouseover="addClass(${user.userId});" onmouseout="removeClass(${user.userId});" id="tr${user.userId}">
            <td>${user.userId}</td>
            <td>${user.userName}</td>
            <td>${user.userAge}</td>
            <td><input type="button" value="edit"
                       onclick="updateUser(${user.userId},'${user.userName}',${user.userAge});">&nbsp;<input
                        type="button" value="delete" onclick="deleteUser(${user.userId});"></td>
        </tr>
    </#list>
    <tr>
        <td colspan="2"><input type="button" value="add" onclick="javascript:location.href='addUser'"></td>
        <td colspan="2">${msg}</td>
    </tr>
</table>
</body>
</html>