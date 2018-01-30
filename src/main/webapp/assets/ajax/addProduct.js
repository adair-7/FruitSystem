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
                    txt_info.val("添加成功").css("color:#09f");
                }
            }
        })

    })
})
