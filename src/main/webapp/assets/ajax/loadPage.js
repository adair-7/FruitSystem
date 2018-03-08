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

    $("#user").click(function () {
        $("#content").load("../Page/userSearch");
    })

    $("#order").click(function () {
        $("#content").load("../Page/orderSearch");
    })
    $("#wallet").click(function () {
        $("#content").load("../Page/walletSearch");
    })
})