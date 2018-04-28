<%--
  Created by IntelliJ IDEA.
  User: admin
  Date: 2018/3/10
  Time: 22:32
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
    <link id="bootstrap-style" href="../assets/css/bootstrap.min.css" rel="stylesheet">
    <link href="../assets/css/bootstrap-responsive.min.css" rel="stylesheet">
    <link id="base-style" href="../assets/css/style.css" rel="stylesheet">
    <link id="base-style-responsive" href="../assets/css/style-responsive.css" rel="stylesheet">

</head>
<body>
<!-- start: Content -->
<ul class="breadcrumb">
    <li>
        <i class="icon-home"></i>
        <a href="../Admin/goIndex">主页</a>
        <i class="icon-angle-right"></i>
    </li>
    <li><a>库存管理</a></li>
</ul>

<div>
    <form>
        <div class="input-group">
            <input type="text" class="form-control" id="stock_name" placeholder="水果名称"/>
            <a href="#" class="btn btn-primary" id="stock_search">搜索</a>
        </div>

        <table class="table table-hover">
            <thead>
            <tr>
                <th>水果ID</th>
                <th>水果名称</th>
                <th>库存上限</th>
                <th>库存量</th>
            </tr>
            </thead>
            <tbody id="tableBody">

            </tbody>
        </table>
        <ul class="pager" id="pageNum">
        </ul>

    </form>

</div>


<!--/.fluid-container-->
<!-- start: JavaScript-->
<script src="../assets/ajax/stockSearch.js"></script>
<!-- end: JavaScript-->

</body>
</html>
