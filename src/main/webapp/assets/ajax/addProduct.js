/**
 * Created by admin on 2018/1/28.
 */
$(function () {
    var txt_name=$("#fruitName");
    var txt_price=$("#unitPrice");
    var txt_intro=$("#introduction");
    var txt_file=$("#file");
    var btn_sub=$("#submit");
    var txt_info=$("#info-panel");
    var img=$("#img");

    //图片预览
    txt_file.change(function () {
        var objUrl=getObjectURL(this.files[0]);
        if (objUrl){
            $("#img").attr("src",objUrl);
        }
    })
    //建立一個可存取到该file的url
    function getObjectURL(file) {
        var url = null ;
        if (window.createObjectURL!=undefined) { // basic
            url = window.createObjectURL(file) ;
        } else if (window.URL!=undefined) { // mozilla(firefox)
            url = window.URL.createObjectURL(file) ;
        } else if (window.webkitURL!=undefined) { // webkit or chrome
            url = window.webkitURL.createObjectURL(file) ;
        }
        return url ;
    }

    //提交
    btn_sub.click(function () {
        var name=txt_name.val();
        var price=txt_price.val();
        var introduction=txt_intro.val();

        $.ajaxFileUpload({
            url:"../Admin/addProduct",
            type:"post",
            data:{
                "fruitName":name,
                "unitPrice":price,
                "introduction":introduction,
            },
            secureuri:false,
            fileElementId:"file",
            datatype:"json",
            success:function (data) {
                if(data.code==1){
                    alert("添加成功");
                }else if (data.code==2){
                    alert("该品种已存在");
                }else {
                    alert("添加失败");
                }
            },
            error:function () {
                alert("网络错误");
            }
        })

    })
})
