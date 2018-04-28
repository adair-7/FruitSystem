<%--
  Created by IntelliJ IDEA.
  User: admin
  Date: 2018/3/6
  Time: 20:41
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
    <li><a>产品信息</a></li>
</ul>

<div>
    <form enctype="multipart/form-data">
        水果名称：<input type="text" disabled="disabled" id="fruitName" value="${fruit.fruitName}" style="width: 300px;"><br>
        水果单价：<input type="text" id="unitPrice" value="${fruit.unitPrice} " style="width: 300px;"/><br>
        相关简介：<textarea id="introduction" rows="10" style="width: 300px;">${fruit.introduction}</textarea><br>
        图片预览：<img src="/${fruit.iconUrl}" style="width: 200px;height: auto;" id="img">
        <label for="file"class="btn btn-default">修改图片</label>
        <input type="file" id="file"  name="file" style="display: none;" /><br>
        <button type="button" id="submit" class="btn btn-primary" style="margin-top: 50px;">确认修改</button>
    </form>

</div>

<!--/.fluid-container-->
<!-- start: JavaScript-->
<script src="../assets/ajax/ajaxfileupload.js"></script>
<script src="../assets/ajax/productUp.js"></script>
<!-- end: JavaScript-->

</body>
</html>
