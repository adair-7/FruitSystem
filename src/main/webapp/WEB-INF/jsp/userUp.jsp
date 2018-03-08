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
    <li><a>产品更新</a></li>
</ul>

<div>
    <form enctype="multipart/form-data">
        水果名称：<label id="fruitName">${fruit.fruitName}</label> <br>
        水果单价：<input type="text" id="unitPrice" value="${fruit.unitPrice} "/><br>
        相关简介：<textarea id="introduction" rows="10">${fruit.introduction}</textarea><br>
        图片：<img src="${fruit.iconUrl}" style="width: 200px;height: auto;" id="img"><br>
        <input type="file" id="file"  name="file" /><br>
        <button type="button" id="submit" class="btn btn-primary">确认修改</button>
    </form>

</div>

<!--/.fluid-container-->
<!-- start: JavaScript-->
<script src="../assets/ajax/ajaxfileupload.js"></script>
<script src="../assets/ajax/userUp.js"></script>
<!-- end: JavaScript-->

</body>
</html>
