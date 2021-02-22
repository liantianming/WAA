<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%
    String path = request.getContextPath();
%>
<!DOCTYPE HTML>
<head>
    <meta charset="utf-8">
    <title>单词</title>
    <meta name="renderer" content="webkit">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
    <link rel="stylesheet" href="<%=path%>/layui-v2.5.6/layui/css/layui.css" media="all">
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
    <audio id="music" src="music/yinanping.flac" loop autoplay></audio>
    <div class="layui-row">
        <div class="layui-col-xs12 layui-col-sm12 layui-col-md12">
            <button class="layui-btn" onclick="audi()">播放</button>

            <button class="layui-btn" onclick="audi()">折叠</button>
            <select >
                <option value="0">英</option>
                <option value="1">美</option>
            </select>
        </div>
        <div class="layui-col-xs6 layui-col-sm3 layui-col-md3">
            <input type="text" name="word" lay-verify="title" autocomplete="off" placeholder="请输入单词"
                   class="layui-input">
        </div>
        <div class="layui-col-xs6 layui-col-sm9 layui-col-md9">
            <button type="button" onclick="getData()" class="layui-btn">确定</button>


        </div>
    </div>

    <div class="layui-collapse" id="row">

    </div>
</div>


<div style="display: none">
    <div class="audiopalyer"></div>
    <input name="bkId" value="${bkId}">
    <input name="unitName" value="${unitName}">
</div>

<script type="text/javascript" src="<%=path%>/easyui/jquery.min.js"></script>
<script type="text/javascript" src="<%=path%>/commen/js/base.js"></script>
<script src="<%=path%>/layui-v2.5.6/layui/layui.js" charset="utf-8"></script>
<script>
    var row = $("#row");

    var words = new Array();
    $(function () {
        getData();
    });

    function audi() {
        for (var i = 0;i < words.length; i++){
            setTimeout(function(){

            },(i + 1) * 3000);

            audi1(words[i]);
        }
    }

    function kk(i) {

    }


    function audi1(wd) {
        var src = "http://dict.youdao.com/dictvoice?audio=" + wd + "&type=1";
        $(".audiopalyer").html("");
        var aud = $('<audio id="player"  src="' + src + '" autoplay hidden></audio>');
        $(".audiopalyer").html(aud);
        document.getElementById('player').play();
    }

    function audi2(wd) {
        var src = "http://dict.youdao.com/dictvoice?audio=" + wd + "&type=2";
        $(".audiopalyer").html("");
        var aud = $('<audio id="player"  src="' + src + '" autoplay hidden></audio>');
        $(".audiopalyer").html(aud);
        document.getElementById('player').play();
    }

    function initData(rList) {
        row.html("");
        var list = rList[0];
        for (var i = 0; i < list.length; i++) {
            var item = $('<div class="layui-colla-item"></div>');

            words[i] = list[i].vcVocabulary;
            var title = $('<h2 class="layui-colla-title">' + list[i].vcVocabulary + '</h2>');
            var content = $('<div class="layui-colla-content layui-show"></div>');

            var h2 = $('<h2></h2>');
            var baav = $('<div class="baav"></div>');
            var pronounce_uk = $('<span class="pronounce">英</span>');
            var phonetic_uk = $('<span class="phonetic">' + list[i].vcPhoneticUk + '</span>');
            var fayin_uk = $('<span class="sp dictvoice" title="真人发音" onclick="audi1(\'' + list[i].vcVocabulary + '\')"></span>');

            var pronounce_us = $('<span class="pronounce">美</span>');
            var phonetic_us = $('<span class="phonetic">' + list[i].vcPhoneticUs + '</span>');
            var fayin_us = $('<span class="sp dictvoice" title="真人发音" onclick="audi2(\'' + list[i].vcVocabulary + '\')"></span>');

            var div1 = $('<div class="nv"></div>');
            var ul1 = $('<ul></ul>');

            var children = list[i].children;
            var v;
            var expre;
            for (var j = 0; j < children.length; j++) {
                v = children[j].v;
                expre = children[j].expre;
                var li1 = $('<li>' + v + ' [语] ' + expre + '</li>');
                li1.appendTo(ul1);
            }

            item.appendTo(row);
            title.appendTo(item);
            content.appendTo(item);
            h2.appendTo(content);
            baav.appendTo(h2);
            pronounce_uk.appendTo(baav);
            phonetic_uk.appendTo(pronounce_uk);
            fayin_uk.appendTo(pronounce_uk);

            pronounce_us.appendTo(baav);
            phonetic_us.appendTo(pronounce_us);
            fayin_us.appendTo(pronounce_us);

            div1.appendTo(content);
            ul1.appendTo(div1);
        }

        layui.use('element', function(){
            var element = layui.element;
        });
    }

    function doWordDetail(bvTag) {
        var bkId = $('input[name="bkId"]').val();
        window.location.href = "./wordList.do?bkId=" + bkId + "&bvTag=" + bvTag;
    }

    function getData() {
        var bkId = $('input[name="bkId"]').val();
        var unitName = $('input[name="unitName"]').val();
        var word = $('input[name="word"]').val();
        var data = {bkId: bkId, unitName: unitName, word: word};
        $.ajax({
            url: "./wordList.do",
            type: 'POST',
            data: data,
            success: function (result) {
                if (result.code == '0') {
                    var rList = result.data;
                    initData(rList);
                } else {
                    alert(result.msg);
                }
            },
            error: function () {
                alert("失败了。");
            }
        });
    }
</script>
</body>
</html>