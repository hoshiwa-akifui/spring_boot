// 获取添加按钮
const addButton = document.querySelector('.add-button');
// 获取弹出窗口元素
const popupForm = document.getElementById('popup-form');

// 点击添加按钮时显示弹出窗口
addButton.addEventListener('click', function () {
    getSchoolNames(function() {
        document.getElementById("formTitle").innerText = "添加学生信息";
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
        document.getElementById("formAction").action = "";
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
