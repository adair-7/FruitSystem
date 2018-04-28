/**
 * Created by admin on 2018/3/6.
 */
$(function () {
    var txt_name=$("#fruitName");
    var txt_price=$("#unitPrice");
    var txt_introduction=$("#introduction");
    var txt_file=$("#file");
    var img=$("#img");
    var btn_sub=$("#submit");


    //图片预览
    txt_file.live("change",function () {
        var objUrl=getObjectURL(this.files[0]);
        if (objUrl){
            img.attr("src",objUrl);
        }
        txt_file.replaceWith(txt_file.clone(true));
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
        name=txt_name.val();
        unitPrice=txt_price.val();
        introduction=txt_introduction.val();
        $.ajaxFileUpload({
            url:"../Admin/productUp",
            type:"post",
            data:{
                "fruitName":name,
                "introduction":introduction,
                "unitPrice":unitPrice
            },
            secureuri:false,
            fileElementId:"file",
            datatype:"json",
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