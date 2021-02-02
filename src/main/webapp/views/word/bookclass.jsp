<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <title>书籍分类</title>
    <meta name="renderer" content="webkit">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
    <link rel="stylesheet" href="../../layui-v2.5.6/layui/css/layui.css"  media="all">
    <!-- 注意：如果你直接复制所有代码到本地，上述css路径需要改成你本地的 -->

    <style type="text/css">
        .my-img{
            width: 80px;
            background: url("../../commen/images/new-sprite.png");
            text-align: center;
        }
        .my-row{
            background-color: #f2f2f2;
            margin-top: 4px;
        }
        .my-acol{
            margin-left: 20px;
            color: #01AAED ;
        }

    </style>
</head>
<body>

<div class="layui-container">

    <!--查询功能-->
    <div class="layui-row">
        <div class="layui-col-xs3 layui-col-sm3 layui-col-md3" >
            <input type="text" name="bookclass" lay-verify="title" autocomplete="off" placeholder="请输入标题" class="layui-input">
        </div>
        <div class="layui-col-xs9 layui-col-sm9 layui-col-md9">
            <button type="button" class="layui-btn">确定</button>
        </div>
    </div>

    <!--列表-->
    <div class="layui-row" id="row">
        <!--<div class="layui-row my-row">
            <img class="my-img" src="../../commen/images/new-sprite.png">
            <div class="layui-inline my-text" >
                <a href="#" class="my-acol">中学</a>
            </div>
        </div>-->
    </div>
</div>

<script type="text/javascript" src="../../easyui/jquery.min.js"></script>
<script type="text/javascript" src="../../commen/js/base.js"></script>
<script src="../../layui-v2.5.6/layui/layui.js" charset="utf-8"></script>
<!-- 注意：如果你直接复制所有代码到本地，上述js路径需要改成你本地的 -->
<script>
    var row = $("#row");
    var my_row;
    var my_img;
    var my_text;
    var my_acol;

    $(function () {
        getData();
    });

    function initData(rList) {
        row.html("");
        for (var i = 0;i<rList.length;i++){
            my_row = $('<div class="layui-row my-row"></div>');
            my_img = $('<img class="my-img" src="../../commen/images/new-sprite.png">');
            my_text = $('<div class="layui-inline my-text" ></div>');
            my_acol = $('<div class="my-acol" onclick="doBook(\''+rList[i].schoolClassify+'\')">'+rList[i].schoolZh+'</div>');
            my_row.appendTo(row);
            my_img.appendTo(my_row);
            my_text.appendTo(my_row);
            my_acol.appendTo(my_text);
        }
    }

    function doBook(classify) {
        window.location.href="./bookList.do?classify="+classify;
    }

    function getData(){
        var bookclass =$('input[name="bookclass"]').val();
        var data = {bookclass:bookclass};
        $.ajax({
            url: pathName+"/schoolList.do",
            type : 'POST',
            data: data,
            success: function(result) {
                if(result.code == '0'){
                    var rList = result.data;
                    initData(rList);
                }else {
                    alert(result.msg);
                }
            },
            error: function() {
                alert("失败了。");
            }
        });
    }
</script>

</body>
</html>