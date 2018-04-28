<%--
  Created by IntelliJ IDEA.
  User: admin
  Date: 2018/3/11
  Time: 14:32
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
    <li><a>库存信息</a></li>
</ul>

<div>
    <form enctype="multipart/form-data">
        水果 ID ：<input type="text" disabled="disabled" id="fruitId" value="${stock.fruitId}" style="width: 300px;"><br>
        水果名称：<input type="text" disabled="disabled"  id="fruitName" value="${stock.fruitName} " style="width: 300px;"/><br>
        库存上限：<input type="text" id="stockTop" value="${stock.stockTop} " style="width: 300px;"/><br>
        库存余量：<input type="text" id="stockAccount" value="${stock.stockAccount} " style="width: 300px;"/><br>
        <button type="button" id="submit" class="btn btn-primary" style="margin-top: 50px;">确认修改</button>
    </form>

</div>

<!--/.fluid-container-->
<!-- start: JavaScript-->
<script src="../assets/ajax/ajaxfileupload.js"></script>
<script src="../assets/ajax/stockUp.js"></script>
<!-- end: JavaScript-->

</body>
</html>
