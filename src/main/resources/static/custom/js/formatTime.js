
//获取当前日期
function getFormat(){
    format = "";
    var nTime = new Date();
    format += nTime.getFullYear()+"-";
    format += (nTime.getMonth()+1)<10?"0"+(nTime.getMonth()+1):(nTime.getMonth()+1);
    format += "-";
    format += nTime.getDate()<10?"0"+(nTime.getDate()):(nTime.getDate());
    format += "T";
    format += nTime.getHours()<10?"0"+(nTime.getHours()):(nTime.getHours());
    format += ":";
    format += nTime.getMinutes()<10?"0"+(nTime.getMinutes()):(nTime.getMinutes());
    format += ":00";
    return format;
}

//将字符串转换为日期
function timeCompare(beginTime,endTime)
{
    console.log(beginTime+"||"+endTime);
    var result = true;
    //js判断日期
    if(beginTime>endTime){
        result =  false;
    }
    console.log(result);
    return result;
}

//开始日期
$('#sendTime').val(getFormat());

//结束日期
$('#endTime').val(getFormat());
function checkExpirationDate() {
    var startDate = $('#sendTime').val();
    var expirationDate = $('#endTime').val();
    if (!timeCompare(startDate,expirationDate)) {
        $('#expirationDateModal').modal('show');
        $('#endTime').val(getFormat());
    }

}