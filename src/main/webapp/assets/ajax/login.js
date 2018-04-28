/**
 * Created by admin on 2018/1/22.
 */
// JavaScript Document
//前端表单数据验证
$(function(){
    var txt_user=$("#userName")
    var txt_pwd=$("#passWord")
    var btn_login=$("#btn_login");
    var tip_user=$("#tip_user");
    var tip_pwd=$("#tip_pwd");
    var group_user=$("#group_user");
    var group_pwd=$("#group_pwd");

    btn_login.click(function () {
        var name=txt_user.val();
        var pwd=txt_pwd.val();
        if (txt_user.val()==""){

            group_user.addClass('has-error');
            tip_user.text('账号不能为空').css('color','#900');
        }else  if (txt_pwd.val()==""){

            group_pwd.addClass('has-error');
            tip_pwd.text('密码不能为空').css('color','#900');
        }else{
            $.ajax({
                type:"post",
                url:"../Admin/loginCheck",
                data:{
                    "name":name,
                    "pwd":pwd
                },
                datatype:"json",
                success:function (data) {
                    if (data.code==2){
                        location.href="../Admin/goIndex";
                    }else if (data.code==0){
                        group_user.addClass('has-error');
                        tip_user.text('账号不存在').css('color','#900');
                    }else if (data.code==1){
                        group_user.addClass('has-error');
                        tip_pwd.text('密码错误').css('color','#900');
                    }
                },error:function () {
                    group_user.addClass('has-error');
                    tip_user.text('登录失败').css('color','#900');
                }
            })
        }

    })
})