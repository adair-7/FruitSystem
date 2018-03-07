/**
 * Created by admin on 2018/1/31.
 */
$(function () {
    var pageIndex=1;
    var pageSize=5;
    var totalPages;
    var btn_search=$("#fruit_search");

    //初始化表格第一页数据
    loadData(1,name);

    //搜索
    btn_search.click(function () {
        var name=$("#fruit_name").val();
        loadData(1,name);
    })


    //ajax加载数据
    function loadData(pageIndex,name) {
        $.ajax({
            url:"../Admin/quaryFruit",
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
                        tbody+="<td>"+data.data[i].fruitName+"</td>";
                        tbody+="<td>"+data.data[i].unitPrice+"</td>";
                        tbody+="<td>"+data.data[i].introduction+"</td>";
                        tbody+="<td><button type=\"button\" class=\"btn btn-danger product_up\" id=\""+data.data[i].fruitId+"\" >修改</button></td>";
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

                    //点击修改
                    $(".product_up").click(function(){
                        $("#content").load("../Admin/"+$(this).attr("id")+"/productUp");
                    })
                }
            },
            error:function () {
                alert("网络错误");
            }
        })
    };

})

