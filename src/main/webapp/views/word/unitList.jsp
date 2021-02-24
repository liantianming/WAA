<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%
    String path = request.getContextPath();
%>
<!DOCTYPE HTML>
<head>
    <meta charset="utf-8">
    <title>单元名</title>
    <meta name="renderer" content="webkit">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
    <link rel="stylesheet" href="<%=path%>/layui-v2.5.6/layui/css/layui.css"  media="all">
    <link href="<%=path%>/commen/css/base.css" rel="stylesheet" type="text/css">
    <style type="text/css">
        .my-img{
            width: 80px;
            background: url("<%=path%>/commen/images/new-sprite.png");
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
        .layui-container{
            margin-top: 10px;
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
    <div class="layui-row">
        <div class="layui-col-xs6 layui-col-sm3 layui-col-md3" >
            <input type="text" name="unitName" lay-verify="title" autocomplete="off" placeholder="请输入单元" class="layui-input">
        </div>
        <div class="layui-col-xs3 layui-col-sm9 layui-col-md9">
            <button type="button" onclick="getData()" class="layui-btn">确定</button>
        </div>
    </div>
    <div class="layui-row" id="row"></div>
</div>

<div style="display: none">
    <input name="bkId" value="${bkId}">
</div>

<script type="text/javascript" src="<%=path%>/easyui/jquery.min.js"></script>
<script type="text/javascript" src="<%=path%>/commen/js/base.js"></script>
<script src="<%=path%>/layui-v2.5.6/layui/layui.js" charset="utf-8"></script>
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
            my_text = $('<div class="layui-inline my-text" ></div>');
            my_acol = $('<div class="my-acol" style="line-height: 30px;" onclick="doWord(\''+rList[i].bvTagOrder+'\')">'+rList[i].bvTag+'</div>');
            my_row.appendTo(row);
            my_text.appendTo(my_row);
            my_acol.appendTo(my_text);
        }
    }

    function doWord(bvTagOrder) {
        var bkId = $('input[name="bkId"]').val();
        window.location.href="./wordList.do?bkId="+bkId+"&bvTagOrder="+bvTagOrder;
    }

    function getData(){
        var bookclass =$('input[name="bookclass"]').val();
        var bkId =$('input[name="bkId"]').val();
        var unitName =$('input[name="unitName"]').val();
        var data = {bookclass:bookclass,bkId:bkId,unitName:unitName};
        $.ajax({
            url: "./unitList.do",
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