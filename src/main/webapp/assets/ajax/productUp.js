/**
 * Created by admin on 2018/3/6.
 */
$(function () {
    var txt_file=$("#file");
    var img=$("#img");
    //图片预览
    txt_file.change(function () {
        var objUrl=getObjectURL(this.files[0]);
        if (objUrl){
            img.attr("src",objUrl);
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


})