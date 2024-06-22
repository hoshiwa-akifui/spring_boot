document.addEventListener('DOMContentLoaded', (event) => {
    const rowsPerPage = 6; // 每页显示的行数
    const tableBody = document.querySelector('#data-table tbody');
    const prevBtn = document.getElementById('prevBtn');
    const nextBtn = document.getElementById('nextBtn');
    const pageIndicator = document.getElementById('pageIndicator');

    const indexBtn = document.getElementById("indexBtn");
    const endBtn = document.getElementById("endBtn");

    // 假设这是你的表格数据
    var tableData = [
        // 使用ajax加入数据
    ];

    // 每隔1秒钟更新表格数据，实时查看数据
    //setInterval(getTableData, 1000);

    function getTableData(currentPage){
        $.ajax({
            url:"queryStudents",
            type:"post",
            dataType:"json",
            data:{},
            success:function(data){
                tableData=[]; // 更新数据的时候，将原来的数据清空
                data.forEach(function (item, index){
                    tableData.push([item.id, item.name, item.sex, item.school, item.school_id, item.status]);
                })
                totalPages = Math.ceil(tableData.length / rowsPerPage);
                displayTablePage(currentPage);
            }
        })
    }

    let currentPage = 0;
    // const totalPages = Math.ceil(tableData.length / rowsPerPage);
    var totalPages;

    function displayTablePage(page) {
        tableBody.innerHTML = '';
        const start = page * rowsPerPage;
        const end = start + rowsPerPage;
        const rows = tableData.slice(start, end);

        rows.forEach(rowData => {
            const row = document.createElement('tr');
            row.ondblclick = ()=> update(rowData);

            // 在每一个tr里面的第一个td前面追加一个复选框
            const checkboxCell = document.createElement('td');
            const checkbox = document.createElement('input');
            checkbox.type = 'checkbox';
            checkbox.name = 'check';
            checkbox.onclick = checkOne;
            checkbox.value = rowData[0];
            checkboxCell.appendChild(checkbox);
            row.appendChild(checkboxCell);

            rowData.forEach(function (cellData, index){
                const cell = document.createElement('td');
                if(index!=rowData.length-2){
                    if(index==rowData.length-1&&cellData==1){
                        cell.textContent = "正常使用";
                    }else if(index==rowData.length-1&&cellData==0){
                        cell.textContent = "禁用";
                    }else{
                        cell.textContent = cellData;
                    }
                    row.appendChild(cell);
                }
            });
            tableBody.appendChild(row);
        });

        pageIndicator.textContent = `第 ${page + 1} 页 / 共 ${totalPages} 页`;
    }

    function updateButtons() {
        // prevBtn.disabled = currentPage === 0;
        // nextBtn.disabled = currentPage === totalPages - 1;
        if(currentPage === 0){  // 如果当前页是第一页
            prevBtn.classList.add("disabled-button"); // 设上一页不可编辑
            indexBtn.classList.add("disabled-button"); // 设首页不可编辑
        }else{
            prevBtn.classList.remove("disabled-button");
            indexBtn.classList.remove("disabled-button");
        }
        if(currentPage === totalPages - 1){ // 如果当前页是最后一页
            nextBtn.classList.add("disabled-button"); // 设下一页不可编辑
            endBtn.classList.add("disabled-button"); // 设末页不可编辑
        }else{
            nextBtn.classList.remove("disabled-button");
            endBtn.classList.remove("disabled-button");
        }

        // 每次有页面的更换关闭全选按钮的勾勾，并且删除按钮关灯
        document.getElementsByName("check")[0].checked=false;
        document.getElementById("dtn").className = "delete-button disabled-button";
    }

    prevBtn.addEventListener('click', () => {
        if (currentPage > 0) {
            currentPage--;
            getTableData(currentPage);
            updateButtons();
        }
    });

    nextBtn.addEventListener('click', () => {
        if (currentPage < totalPages - 1) {
            currentPage++;
            getTableData(currentPage);
            updateButtons();
        }
    });

    indexBtn.addEventListener("click", ()=>{
        if (currentPage > 0) {
            currentPage=0;
            getTableData(currentPage);
            updateButtons();
        }
    });
    endBtn.addEventListener("click", ()=>{
        if (currentPage < totalPages - 1) {
            currentPage=totalPages - 1;
            getTableData(currentPage);
            updateButtons();
        }
    });

    // 初始化
    getTableData(currentPage);
    // displayTablePage(currentPage);
    updateButtons();
});

function checkAll(){
    var box = document.getElementsByName("check");

    if(box[0].checked){
        for (var i = 0; i < box.length; i++) {
            box[i].checked=true;
            document.getElementById("dtn").className = "delete-button";
        }
    }else{
        for (var i = 0; i < box.length; i++) {
            box[i].checked=false;
            document.getElementById("dtn").className = "delete-button disabled-button";
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

    var result1 =false;
    for (var i = 1; i < box.length; i++) {
        if(box[i].checked==true){
            result1=true;
            break;
        }
    }
    if (result1) {
        document.getElementById("dtn").className = "delete-button";
    }else {
        document.getElementById("dtn").className = "delete-button disabled-button";
    }

}
