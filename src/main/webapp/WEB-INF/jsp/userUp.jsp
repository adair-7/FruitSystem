<%--
  Created by IntelliJ IDEA.
  User: admin
  Date: 2018/3/8
  Time: 22:03
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <!-- start: Meta -->
    <meta charset="utf-8">
    <title>fruitSystem</title>

    <!-- start: CSS -->
</head>
<body>
<!-- start: Content -->
<ul class="breadcrumb">
    <li>
        <i class="icon-home"></i>
        <a href="../Admin/goIndex">主页</a>
        <i class="icon-angle-right"></i>
    </li>
    <li><a>用户信息</a></li>
</ul>

<div>
    <form enctype="multipart/form-data">
        用户姓名：<input type="text" disabled="disabled" id="userName" value="${user.userName}" style="width: 300px;"><br>
        用户电话：<input type="text" disabled="disabled"  id="phone" value="${user.phone} " style="width: 300px;"/><br>
        用户邮箱：<input type="text" disabled="disabled" id="mail" value="${user.mail} " style="width: 300px;"/><br>
        用户地址：<input type="text" disabled="disabled"  id="address" value="${user.address} " style="width: 300px;"/><br>
        用户 QQ ：<input type="text" disabled="disabled"  id="qq" value="${user.qq} " style="width: 300px;"/><br>
        <button type="button" id="submit" class="btn btn-primary" style="margin-top: 50px;">返回</button>
    </form>

</div>

<!--/.fluid-container-->
<!-- start: JavaScript-->
<script src="../assets/ajax/ajaxfileupload.js"></script>
<script src="../assets/ajax/userUp.js"></script>
<!-- end: JavaScript-->

</body>
</html>
