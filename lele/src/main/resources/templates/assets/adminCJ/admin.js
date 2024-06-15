// 获取按钮、模态框和关闭按钮
var btn = document.getElementById("add");
var modal = document.getElementById("addWindow");
var span = document.getElementsByClassName("close")[0];

// 点击按钮打开模态框
btn.onclick = function() {
    modal.style.display = "block";

    document.getElementById("tInfo").innerText = "增加一个admin的信息";
    document.getElementById("form").action = "addAdmin";
    document.getElementById("admin_id").value = "";
    document.getElementById("admin_account").value = "";
    document.getElementById("admin_password").value = "";
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

function update(id, account, pwd){
    modal.style.display = "block";

    document.getElementById("tInfo").innerText = "修改所选中admin的信息";
    document.getElementById("form").action = "updateAdmin";
    document.getElementById("admin_id").value = id;
    document.getElementById("admin_account").value = account;
    document.getElementById("admin_password").value = pwd;
    document.getElementById("sub").value = "修改";
}

function checkAll(){
    var box = document.getElementsByName("check");

    if(box[0].checked){
        for (var i = 0; i < box.length; i++) {
            box[i].checked=true;
            document.getElementById("dtn").className = "btn btn-danger";
        }
    }else{
        for (var i = 0; i < box.length; i++) {
            box[i].checked=false;
            document.getElementById("dtn").className = "btn btn-danger disabled";
        }
    }
}