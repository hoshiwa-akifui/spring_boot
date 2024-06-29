// 获取添加按钮
const addButton = document.querySelector('.add-button');
// 获取弹出窗口元素
const popupForm = document.getElementById('popup-form');

// 点击添加按钮时显示弹出窗口
addButton.addEventListener('click', function () {
    getSchoolNames(function() {
        document.getElementById("formTitle").innerText = "添加学生信息";
        document.getElementById("formTitle").style.color = "#4CAF50";
        document.getElementById("formAction").querySelectorAll("label").forEach(ft=>{
            ft.style.color = "#4CAF50";
        });
        document.querySelector(".button-container").querySelectorAll("button").forEach(bcb=>{
            bcb.style.backgroundColor = "#28a745";
            bcb.addEventListener("mouseover",()=>{
                bcb.style.backgroundColor = "#218838";
            });
            bcb.addEventListener("mouseout",()=>{
                bcb.style.backgroundColor = "#28a745";
            });
        });
        document.getElementById("formAction").action = "insertStudent";
        popupForm.style.display = 'block';
    });
});

// 点击空白处关闭弹窗
document.addEventListener('click', function (event) {
    // 如果点击的目标不是弹窗本身和添加按钮，则关闭弹窗
    if (!popupForm.contains(event.target) && event.target !== addButton) {
        popupForm.style.display = 'none';
    }
});

// 点击取消按钮或者提交后关闭弹出窗口
function closePopup() {
    popupForm.style.display = 'none';
}

// 获取的学校name
var schoolNames = [
    // 使用ajax加入数据
];
function getSchoolNames(callback) {
    $.ajax({
        url: "querySchoolNames",
        type: "post",
        dataType: "json",
        data: {},
        success: function (data) {
            schoolNames=[];
            data.forEach(function (item, index) {
                schoolNames.push([item.id, item.name]);
            });
            setSchoolOption();
            if(callback) callback();
        }
    })
}

// 给select逐个添加学校name
const schoolOption = document.querySelector("#school");
function setSchoolOption(){
    schoolOption.innerHTML = "";
    schoolNames.forEach(sn=>{
        const option = document.createElement("option");
        option.value = sn[0]+","+sn[1]; // 用来标记学校id和name
        option.textContent = sn[1];
        schoolOption.appendChild(option);
    });
}

function update(rowData){
    getSchoolNames(function() {
        document.getElementById("formTitle").innerText = "修改学生信息";
        document.getElementById("formTitle").style.color = "#007bff";
        document.getElementById("formAction").querySelectorAll("label").forEach(ft=>{
            ft.style.color = "#007bff";
        });
        document.querySelector(".button-container").querySelectorAll("button").forEach(bcb=>{
            bcb.style.backgroundColor = "#007bff";
            bcb.addEventListener("mouseover",()=>{
                bcb.style.backgroundColor = "#0056b3";
            });
            bcb.addEventListener("mouseout",()=>{
                bcb.style.backgroundColor = "#007bff";
            });
        });
        document.getElementById("formAction").action = "updateStudent";
        document.getElementById("id").value = rowData[0];
        document.getElementById("name").value = rowData[1];
        document.getElementById("sex").value = rowData[2];
        document.getElementById("school").value = rowData[4]+","+rowData[3];
        document.getElementById("status").value = rowData[5];
        popupForm.style.display = 'block';
    });
}

// 收到后端发来的信息，是否执行成功
window.onload = function (){
    if(document.getElementById("msg").value!=""){
        alert(document.getElementById("msg").value);
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

    if(confirm("您确定要删除id为："+ids+" 的数据吗？")){
        location.href = "deleteStudents?ids="+ids;
    }else{
        alert("您取消了删除");
    }
}
