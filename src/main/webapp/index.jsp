<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>上传文件</title>
    <!--<script src="./layui-v2.5.6/layui/layui.js"></script>-->
    <!--<script type="text/javascript"  src="https://cdn.staticfile.org/jquery/1.9.1/jquery.min.js"></script>-->

    <!--<link rel="stylesheet" href="./layui-v2.5.6/layui/css/layui.css" media="all">-->

    <!--<link href="./css/base.css" rel="stylesheet" type="text/css">-->


    <script type="text/javascript" src="easyui/jquery.min.js"></script>
    <script type="text/javascript" src="easyui/jquery.easyui.min.js"></script>
    <script type="text/javascript" src="easyui/locale/easyui-lang-zh_CN.js" ></script>
    <script type="text/javascript" src="commen/js/base.js" ></script>
    <script type="text/javascript" src="index.js"></script>
    <link rel="stylesheet" type="text/css" href="easyui/themes/default/easyui.css" />
    <link rel="stylesheet" type="text/css" href="easyui/themes/icon.css" />
    <style type="text/css">
        .red{
            color:  #fa2f6a;
        }
        .collect{
            width: 20px;
        }
    </style>

    <script type="text/javascript">
        $(function () {

            $('#fenci').accordion('add', {
                title: '新标题',
                content: '<div >今天天气真好</div>',
                selected: false
            });
        })
    </script>

</head>
<body>
<!-- 搜索框开始 -->
<div style="position:relative;zoom:1;">


    <div id="scontainer">

        <table id="tableDate"></table>

        <div id="tb" style="padding:5px;">
            <div style="margin-bottom:5px;">
                <a href="#" class="easyui-linkbutton" iconCls="icon-add" plain="true" onclick="openAdd()">添加</a>
               <!-- <a href="#" class="easyui-linkbutton" iconCls="icon-edit" plain="true">修改</a>
                <a href="#" class="easyui-linkbutton" iconCls="icon-remove" plain="true">删除</a>-->
            </div>
            <div style="padding:0 0 0 7px;color:#333;">
                查询帐号：<input type="text" class="textbox" name="user" style="width:110px">
                创建时间从：<input type="text" name="date_from" class="easyui-datebox" style="width:110px">
                到：<input type="text" name="date_to" class="easyui-datebox" style="width:110px">
                <a href="#" class="easyui-linkbutton" iconCls="icon-search" onclick="obj.search();">查询</a>
            </div>
        </div>


        <a id="layui" >layui</a>
    </div>
</div>


<!-- Begin of easyui-dialog -->
<div id="add-dialog" class="easyui-dialog" data-options="closed:true,iconCls:'icon-save'" style="width:420px; padding:10px;">

    <div id="container">
        <div> 分辨率
            <select name="ratio" id="ratio" class="easyui-combobox">
                <option value="">默认大小</option>
                <option value="1920*1080">1920*1080</option>
                <option value="1280*720">1280*720</option>
                <option value="1024*576">1024*576</option>
                <option value="768*432">768*432</option>
                <option value="640*360">640*360</option>
                <option value="424*240">424*240</option>
            </select>
        </div>
        <div class="red">请选择 avi，mp4，wmv，3gp，asx，asf，mpg，mov，flv文件格式</div>
        <input  type="file" id="fileInput">


        <form  class="form-horizontal" content="multipart/form-data">
            <input class="easyui-linkbutton" value="上传" onclick="importInfo()" type="button">
        </form>

    </div>
    <div class="time" style="display: none;">
        <img style="margin-left: 125px;position: absolute;margin-top: -145px;width: 200px;width: 200px;" src="./commen/images/timg.gif"/>
    </div>
</div>
</body>
</html>
