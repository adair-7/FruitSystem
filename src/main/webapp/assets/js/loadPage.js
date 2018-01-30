/**
 * Created by admin on 2018/1/28.
 */
$(function () {
    $("#addProduct").click(function () {
        $("#content").load("../Page/addProduct");
    })

    $("#productSearch").click(function () {
        $("#content").load("../Page/productSearch");
    })

})