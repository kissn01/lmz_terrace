//循环获取固定数组指定长度元素
function sliceArr(arrName, n) {
    var arr = [];
    for(var i = 0; i < Math.ceil(n / arrName.length); i++) {
        arr = arr.concat(arrName);
    }
    return arr.slice(0, n);
}


//初始化日期
var nowDate = new Date();
//获取昨天
nowDate.setTime(nowDate.getTime()-24*60*60*1000);
//月份和日期若为小于10的数要做处理
var nowMonth = nowDate.getMonth() + 1;
var nowDay = nowDate.getDate();
if ((nowDate.getMonth() + 1) < 10) {
    nowMonth = "0" + nowMonth;
}
if (nowDate.getDate() < 10) {
    nowDay = '0' + nowDay;
}
var today = nowDate.getFullYear() + "-" + nowMonth + "-" + nowDay;
//开始日期
$('#startDate').val(today);
function checkStartDate() {
    var startDate = $('#startDate').val();
    var expirationDate = $('#expirationDate').val();
    if (startDate < '2020-01-01') {
        $('#startDateModal').modal('show');
        $('#startDate').val(today);
    }
    if (startDate > expirationDate) {
        $('#expirationDateModal').modal('show');
        $('#startDate').val(today);
    }
    if (expirationDate > today) {
        $('#noDateModal').modal('show');
        $('#startDate').val(today);
    }
}

//结束日期
$('#expirationDate').val(today);
function checkExpirationDate() {
    var startDate = $('#startDate').val();
    var expirationDate = $('#expirationDate').val();
    if (startDate > expirationDate) {
        $('#expirationDateModal').modal('show');
        $('#expirationDate').val(today);
    }
    if (expirationDate > today) {
        $('#noDateModal').modal('show');
        $('#expirationDate').val(today);
    }
}

//指定日期
$('#searchDate').val(today);
function checkSearchDate() {
    var searchDate = $('#searchDate').val();
    if (searchDate < '2020-01-01') {
        $('#startDateModal').modal('show');
        $('#searchDate').val(today);
    }
    if (searchDate > today) {
        $('#noDateModal').modal('show');
        $('#searchDate').val(today);
    }
}