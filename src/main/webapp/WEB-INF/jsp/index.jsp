<%--
  Created by IntelliJ IDEA.
  User: admin
  Date: 2018/1/22
  Time: 16:14
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
<!-- start: Header -->
<div class="navbar">
    <div class="navbar-inner">
        <div class="container-fluid">
            <a class="btn btn-navbar" data-toggle="collapse" data-target=".top-nav.nav-collapse,.sidebar-nav.nav-collapse">
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
            </a>
            <a class="brand" href="../Admin/goIndex"><span>订购管理系统</span></a>

            <!-- start: Header Menu -->
            <div class="nav-no-collapse header-nav">
                <ul class="nav pull-right">

                    <!-- start: User Dropdown -->
                    <li class="dropdown">
                        <a class="btn dropdown-toggle" data-toggle="dropdown" href="#">
                            <i class="halflings-icon white user"></i><c:out value="${admin.adminName}"/>
                            <span class="caret"></span>
                        </a>
                        <ul class="dropdown-menu">
                            <li class="dropdown-menu-title">
                                <span>账户设置</span>
                            </li>
                            <li><a href="#"><i class="halflings-icon user"></i>账户信息</a></li>
                            <li><a href="../Admin/goOut"><i class="halflings-icon off"></i> 退出</a></li>
                        </ul>
                    </li>
                    <!-- end: User Dropdown -->
                </ul>
            </div>
            <!-- end: Header Menu -->

        </div>
    </div>
</div>
<!-- start: Header -->

<div class="container-fluid-full">
    <div class="row-fluid">

        <!-- start: Main Menu -->
        <div id="sidebar-left" class="span2">
            <div class="nav-collapse sidebar-nav">
                <ul class="nav nav-tabs nav-stacked main-menu">
                    <li id="index"><a href="../Admin/goIndex"><i class="icon-bar-chart"></i><span class="hidden-tablet"> 主页</span></a></li>
                    <li>
                        <a class="dropmenu" href="#"><i class="icon-folder-close-alt"></i><span class="hidden-tablet"> 产品管理</span></a>
                        <ul>
                            <li ><a id="productSearch" href="#" class="submenu"><i class="icon-file-alt"></i><span class="hidden-tablet"> 产品查询</span></a></li>
                            <li><a id="addProduct" href="#" class="submenu"><i class="icon-file-alt"></i><span class="hidden-tablet">产品新增</span></a></li>
                        </ul>
                    </li>
                    <li><a id="user" href="#"><i class="icon-tasks"></i><span class="hidden-tablet"> 用户管理</span></a></li>
                    <li><a id="wallet" href="#"><i class="icon-eye-open"></i><span class="hidden-tablet"> 钱包管理</span></a></li>
                    <li><a id="order" href="#"><i class="icon-dashboard"></i><span class="hidden-tablet"> 订单管理</span></a></li>
                </ul>
            </div>
        </div>
        <!-- end: Main Menu -->

        <!-- start: Content -->
        <div id="content" class="span10">

            <ul class="breadcrumb">
                <li>
                    <i class="icon-home"></i>
                    <a href="../Admin/goIndex">主页</a>
                    <i class="icon-angle-right"></i>
                </li>
                <li><a>介绍</a></li>
            </ul>
            <div class="row-fluid">

                <a class="quick-button metro yellow span2">
                    <i class="icon-group"></i>
                    <p>用户</p>
                    <span class="badge">237</span>
                </a>
                <a class="quick-button metro red span2">
                    <i class="icon-comments-alt"></i>
                    <p>评论</p>
                    <span class="badge">46</span>
                </a>
                <a class="quick-button metro blue span2">
                    <i class="icon-shopping-cart"></i>
                    <p>订单</p>
                    <span class="badge">13</span>
                </a>
                <a class="quick-button metro green span2">
                    <i class="icon-barcode"></i>
                    <p>产品</p>
                </a>
                <a class="quick-button metro pink span2">
                    <i class="icon-envelope"></i>
                    <p>信息</p>
                    <span class="badge">88</span>
                </a>
                <a class="quick-button metro black span2">
                    <i class="icon-calendar"></i>
                    <p>日历</p>
                </a>

                <div class="clearfix"></div>

            </div><!--/row-->
        </div><!--/.fluid-container-->

        <!-- end: Content -->
    </div><!--/#content.span10-->
</div><!--/fluid-row-->


<div class="clearfix"></div>

<footer>

    <p>
        <span style="text-align:left;float:left">2013 <a>JANUX Responsive Dashboard</a></span>

    </p>

</footer>

<!-- start: JavaScript-->

<script src="../assets/js/jquery-1.9.1.min.js"></script>
<script src="../assets/js/loadPage.js"></script>
<script src="../assets/js/jquery-migrate-1.0.0.min.js"></script>

<script src="../assets/js/jquery-ui-1.10.0.custom.min.js"></script>

<script src="../assets/js/jquery.ui.touch-punch.js"></script>

<script src="../assets/js/modernizr.js"></script>

<script src="../assets/js/bootstrap.min.js"></script>

<script src="../assets/js/jquery.cookie.js"></script>

<script src='../assets/js/fullcalendar.min.js'></script>

<script src='../assets/js/jquery.dataTables.min.js'></script>


<script src="../assets/js/jquery.chosen.min.js"></script>

<script src="../assets/js/jquery.uniform.min.js"></script>

<script src="../assets/js/jquery.cleditor.min.js"></script>

<script src="../assets/js/jquery.noty.js"></script>

<script src="../assets/js/jquery.elfinder.min.js"></script>

<script src="../assets/js/jquery.raty.min.js"></script>


<script src="../assets/js/jquery.uploadify-3.1.min.js"></script>

<script src="../assets/js/jquery.gritter.min.js"></script>

<script src="../assets/js/jquery.imagesloaded.js"></script>

<script src="../assets/js/jquery.masonry.min.js"></script>

<script src="../assets/js/jquery.knob.modified.js"></script>

<script src="../assets/js/jquery.sparkline.min.js"></script>

<script src="../assets/js/counter.js"></script>

<script src="../assets/js/retina.js"></script>

<script src="../assets/js/custom.js"></script>


<!-- end: JavaScript-->

</body>
</html>

