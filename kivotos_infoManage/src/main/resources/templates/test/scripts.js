document.getElementById('openFormBtn').addEventListener('click', function() {
    document.getElementById('formModal').style.display = 'block';
});

document.getElementsByClassName('closeBtn')[0].addEventListener('click', function() {
    document.getElementById('formModal').style.display = 'none';
});

window.addEventListener('click', function(event) {
    if (event.target == document.getElementById('formModal')) {
        document.getElementById('formModal').style.display = 'none';
    }
});

document.getElementById('dataForm').addEventListener('submit', function(event) {
    event.preventDefault();
    // 在这里处理表单数据
    alert('表单已提交！');
    document.getElementById('formModal').style.display = 'none';
});
