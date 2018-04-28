/**
 * Created by admin on 2018/3/11.
 */
$(function () {
    var btn_submit=$("#submit");
    btn_submit.click(function () {
        var top=$("#stockTop").val();
        var account=$("#stockAccount").val();
        var id=$("#fruitId").val();
        $.ajax({
            url:"../Admin/stockUp",
            type:"post",
            datatype:"json",
            data:{
                "fruitId":id,
                "stockTop":top,
                "stockAccount":account,
            },
            success:function (data) {
                if (data.flag){
                    alert("修改成功");
                }else {
                    alert("修改失败");
                }
            },
            error:function () {
                alert("网络错误");
            }
        })
    })
})