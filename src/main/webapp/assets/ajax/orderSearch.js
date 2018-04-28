/**
 * Created by admin on 2018/3/8.
 */

$(function () {
    var pageIndex=1;
    var pageSize=8;
    var totalPages;
    var btn_search=$("#user_search");

    //初始化表格第一页数据
    loadData(1,"");

    //搜索
    btn_search.click(function () {
        var name=$("#user_name").val();
        loadData(1,name);
    })


//ajax加载数据
function loadData(pageIndex,name) {
    $.ajax({
        url:"../Admin/quaryOrder",
        type:"post",
        datatype:"json",
        data:{
            "pageIndex":pageIndex,
            "pageSize":pageSize,
            "name":name,
        },
        success:function (data) {
            if (data.flag){
                totalPages=data.page.totalPages;
                $("table tbody").html("");
                $("#pageNum").html("");
                var tbody="";
                var pageBtn="";
                //动态加载表格
                for (var i=0;i<(data.page.endRow-data.page.beginRow);i++){
                    tbody+="<tr>";
                    tbody+="<td>"+data.data[i].orderId+"</td>";
                    tbody+="<td>"+data.data[i].fruitName+"</td>";
                    tbody+="<td>"+data.data[i].userName+"</td>";
                    tbody+="<td>"+data.data[i].fruitNum+"</td>";
                    tbody+="<td>"+data.data[i].orderPrice+"</td>";
                    var date = new Date(data.data[i].orderDate);
                    Y = date.getFullYear() + '-';
                    M = (date.getMonth()+1 < 10 ? '0'+(date.getMonth()+1) : date.getMonth()+1) + '-';
                    D = date.getDate() + ' ';
                    h = date.getHours() + ':';
                    m = date.getMinutes() + ':';
                    s = date.getSeconds();
                    tbody+="<td>"+Y+M+D+h+m+s+"</td>";
                    tbody+="<td><button type=\"button\" class=\"btn btn-danger order_del\" style='margin-left: 10px' id=\""+data.data[i].orderId+"\" >删除</button></td>";
                    tbody+="</tr>";
                }

                //动态加载页码
                pageBtn+="<li><a href='#' id='pre'>上一页</a></li>";
                for (var i=1;i<=totalPages;i++){
                    pageBtn+="<li ><a href='#'>"+i+"</a></li>";
                }
                pageBtn+="<li><a href='#' id='next'>下一页</a></li>";
                $("table tbody").append(tbody);
                $("#pageNum").append(pageBtn);

                //加载上一页
                $("#pre").click(function () {
                    if (pageIndex>1){
                        pageIndex-=1;
                        loadData(pageIndex,name);
                    }else {
                        return false;
                    }
                });
                //加载下一页
                $("#next").click(function () {
                    if (pageIndex<totalPages){
                        pageIndex+=1;
                        loadData(pageIndex,name);
                    }else {
                        return false;
                    }
                });

                //删除
                $(".order_del").click(function () {
                    var btn=$(this);
                    if (confirm("确认删除此订单？")){
                        $.ajax({
                            url:"../Admin/orderDel",
                            type:"post",
                            datatype:"json",
                            data:{
                                "orderId":btn.attr("id"),
                            },
                            success:function (data) {
                                if (data.flag){
                                    btn.parent().parent().remove();
                                    alert("删除成功");
                                }else {
                                    alert("删除失败");
                                }
                            },
                            error:function () {
                                alert("网络错误");
                            }
                        })
                    }
                });

            }
        },
        error:function () {
            alert("网络错误");
        }
    })
}

})