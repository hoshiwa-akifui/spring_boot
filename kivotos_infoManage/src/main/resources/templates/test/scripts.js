document.getElementById('openFormBtn').addEventListener('click', function() {
    var formWindow = window.open('form.html', '_blank', 'width=600,height=400');
    // 设置新窗口的大小和位置等属性
    formWindow.focus(); // 让新窗口获得焦点
});

function closeWindow() {
    window.close(); // 关闭当前窗口（表单页面）
}
