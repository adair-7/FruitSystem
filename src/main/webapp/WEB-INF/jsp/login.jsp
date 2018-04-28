<%--
  Created by IntelliJ IDEA.
  User: admin
  Date: 2018/1/21
  Time: 17:06
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="zh-CN">
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>FruitSystem</title>

    <!-- Bootstrap -->
    <link href="../assets/css/bootstrap.min1.css" rel="stylesheet">
    <link href="../assets/css/login.css" rel="stylesheet">
    <link href="../assets/css/yahoo.css" rel="stylesheet">
    <script src="../assets/js/jquery-2.1.1.min.js"></script>
    <script src="../assets/ajax/login.js"></script>

</head>
<body>
<div id="container"><!--id container-top -->
    <div class="container">
        <div class="row">
            <div class="col-md-3 col-md-offset-3 col-sm-12 logo_img">

            </div>
            <div class="col-md-3 col-sm-12 login_form">
                <form>
                    <fieldset>
                        <legend>用户登录</legend>
                        <div class="form-group" id="group_user">
                            <input type="text" class="form-control" placeholder="账号" id="userName">		<!--form-control类样式的宽度为100%-->
                            <p id="tip_user"></p>
                        </div>
                        <div class="form-group" id="group_pwd">
                            <input type="password" class="form-control" placeholder="密码" id="passWord">
                            <p id="tip_pwd"></p>
                        </div>
                        <div class="checkbox">
                            <label><input type="checkbox">记住密码</label>
                            <a href="" class="pull-right"  data-toggle='tooltip' data-original-title='找回密码' data-placement='left'>忘记密码？</a>
                        </div>
                        <button type="button" class="btn btn-info btn-block" id="btn_login">登&nbsp;录</button>
                    </fieldset>
                </form>
            </div>
        </div>
    </div>
</div>
<script src="../assets/js/bootstrap.min.js"></script>
<script type="text/javascript">
    $('[data-toggle=tooltip]').tooltip();
</script>
</body>
</html>
