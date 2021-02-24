<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%
    String path = request.getContextPath();
%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <title>书籍分类</title>
    <meta name="renderer" content="webkit">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
    <script type="text/javascript" charset="utf-8" src="<%=path%>/easyui/jquery.min.js"></script>
    <script type="text/javascript" charset="utf-8" src="<%=path%>/commen/js/base.js"></script>
    <script type="text/javascript" charset="utf-8" src="<%=path%>/layui-v2.5.6/layui/layui.js"></script>
    <link rel="stylesheet" media="all" href="<%=path%>/layui-v2.5.6/layui/css/layui.css">
    <script type="text/javascript" charset="utf-8" src="<%=path%>/views/word/bookclass.js"></script>
    <style type="text/css">

        .my-row{
            background-color: #f2f2f2;
            margin-top: 4px;
        }
        .my-acol{
            margin-left: 20px;
            color: #01AAED ;
        }
        .layui-container{
            margin-top: 10px;
        }

        .sp {
            background: url("<%=path%>/commen/images/new-sprite.png") no-repeat;
            vertical-align: middle;
            overflow: hidden;
            display: inline-block
        }
        .dictvoice {
            vertical-align: middle;
            margin: 10px;
            width: 15px;
            height: 21px;
            background-position: -47px -36px
        }
        .dictvoice:hover {
            background-position: -32px -36px
        }
        .nv{
            margin: 10px;
        }
    </style>
</head>
<body>

<div class="layui-container">
    <!--查询功能-->
    <div class="layui-row">
        <div class="layui-col-xs6 layui-col-sm3 layui-col-md3">
            <input type="text" name="bookclass" lay-verify="title" autocomplete="off" placeholder="请输入单词"
                   class="layui-input">
        </div>
        <div class="layui-col-xs3 layui-col-sm9 layui-col-md9">
            <button type="button" onclick="getWord()" class="layui-btn">确定</button>
        </div>
    </div>
    <div class="layui-row layui-collapse" id="row"></div>
    <div style="display: none;">
        <input id="wordId" name="wordId">
        <div class="audiopalyer"></div>
        <input name="path" id="path" value="<%=path%>"></input>
    </div>

</div>

</body>
</html>
