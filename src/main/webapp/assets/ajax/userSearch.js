/**
 * Created by admin on 2018/3/8.
 */
$(function () {
    var pageIndex=1;
    var pageSize=5;
    var totalPages;
    var btn_search=$("#user_search");
    
    //初始化
    loadData(1,"");
    
    //搜索
    btn_search.click(function () {
        var name=$("#user_name").val();
        loadData(1,name);
    })

    //加载数据
    function loadData(pageIndex,name) {
        $.ajax({
            url:"../Admin/quaryUser",
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
                        tbody+="<td>"+data.data[i].userName+"</td>";
                        tbody+="<td>"+data.data[i].phone+"</td>";
                        tbody+="<td>"+data.data[i].mail+"</td>";
                        tbody+="<td>"+data.data[i].address+"</td>";
                        tbody+="<td>"+data.data[i].qq+"</td>";
                        tbody+="<td><button type=\"button\" class=\"btn btn-info user_up\" id=\""+data.data[i].userId+"\" >查看</button></td>";
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
                    $(".user_up").click(function(){
                        $("#content").load("../Admin/"+$(this).attr("id")+"/userUp");
                    })
                }
            },
            error:function () {
                alert("网络错误");
            }
        })
    }
})