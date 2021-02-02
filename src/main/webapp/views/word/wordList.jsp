<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE HTML>
<head>
    <meta charset="utf-8">
    <title>单词</title>
    <meta name="renderer" content="webkit">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
    <link rel="stylesheet" href="../../layui-v2.5.6/layui/css/layui.css"  media="all">
    <style type="text/css">
        .my-img{
            width: 80px;
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
    <div class="layui-row">
        <div class="layui-col-xs3 layui-col-sm3 layui-col-md3" >
            <input type="text" name="book" lay-verify="title" autocomplete="off" placeholder="请输入标题" class="layui-input">
        </div>
        <div class="layui-col-xs9 layui-col-sm9 layui-col-md9">
            <button type="button" class="layui-btn">确定</button>
        </div>
    </div>

    <div class="layui-collapse" id="row">
        <div class="layui-colla-item">
            <h2 class="layui-colla-title">杜甫</h2>
            <div class="layui-colla-content layui-show">
                <h2>
                    <div class="baav">
                        <span class="pronounce">英
                            <span class="phonetic">[wɜːd]</span>
                            <a href="#" title="真人发音" class="sp dictvoice" onclick="audi1('word')"></a>
                        </span>
                        <span class="pronounce">美
                            <span class="phonetic">[wɜːrd]</span>
                            <a href="#" title="真人发音" class="sp dictvoice" onclick="audi2('word')"></a>
                        </span>
                    </div>
                </h2>
                <div>
                    <ul>
                        <li>n. [语] 单词；话语；消息；诺言；命令</li>
                        <li>vt. 用言辞表达</li>
                        <li>n. (Word)人名；(英)沃德</li>
                    </ul>
                    <p>[复数 words 过去式 worded 过去分词 worded 现在分词 wording 第三人称单数 words ] </p>
                </div>
            </div>
        </div>
    </div>
</div>

<div style="display: none">
    <input name="bkId" value="${bkId}">
    <input name="unitName" value="${unitName}">
</div>

<script type="text/javascript" src="../../easyui/jquery.min.js"></script>
<script type="text/javascript" src="../../commen/js/base.js"></script>
<script src="../../layui-v2.5.6/layui/layui.js" charset="utf-8"></script>
<!-- 注意：如果你直接复制所有代码到本地，上述js路径需要改成你本地的 -->
<script>
    var row = $("#row");

    $(function () {
        getData();


    });
    function initData(rList) {
        //row.html("");
        var list = rList[0];
        for (var i = 0;i<list.length;i++){
            var item = $('<div class="layui-colla-item"></div>');

            var title = $('<h2 class="layui-colla-title">'+list[i].vcVocabulary+'</h2>');
            var content = $('<div class="layui-colla-content layui-show"></div>');

            var h2 = $('<h2></h2>');
            var baav = $('<div class="baav"></div>');
            var pronounce_uk = $('<span class="pronounce">英</span>');
            var phonetic_uk = $('<span class="phonetic">'+list[i].vcPhoneticUk+'</span>');
            var fayin_uk = $('<a href="#" title="真人发音">发音</a>');

            var pronounce_us = $('<span class="pronounce">英</span>');
            var phonetic_us = $('<span class="phonetic">'+list[i].vcPhoneticUs+'</span>');
            var fayin_us = $('<a href="#" title="真人发音">发音</a>');

            var div1 = $('<div></div>');
            var ul1 = $('<ul></ul>');

            var children = list[i].children;
            var v;
            var expre;
            for (var j = 0;j < children.length;j++){
                v = children[j].v;
                expre = children[j].expre;
                var li1 = $('<li>'+v+' [语] '+expre+'</li>');
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
            var element = layui.element();
        });
    }

    function doWordDetail(bvTag) {
        var bkId = $('input[name="bkId"]').val();
        window.location.href="./wordList.do?bkId="+bkId+"&bvTag="+bvTag;
    }

    function getData(){
        var bkId =$('input[name="bkId"]').val();
        var unitName =$('input[name="unitName"]').val();
        var data = {bkId:bkId,unitName:unitName};
        $.ajax({
            url: pathName+"/wordList.do",
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