var words = new Array();

$(function () {
    getData();
});

function initData(rList) {
    var row = $("#row");
    var path = $("#path");
    var my_row;
    var my_img;
    var my_text;
    var my_acol;
    row.html("");
    var j = 1;
    for (var i = 0; i < rList.length; i++) {
        var my_src = path+"/commen/images/"+j+".png";
        my_row = $('<div class="layui-row my-row"></div>');
        my_img = $('<img class="my-img" style="height: 60px;width: 50px" src="'+my_src+'">');
        my_text = $('<div class="layui-inline my-text" ></div>');
        my_acol = $('<div class="my-acol" onclick="doBook(\'' + rList[i].schoolClassify + '\')">' + rList[i].schoolZh + '</div>');
        my_row.appendTo(row);
        my_img.appendTo(my_row);
        my_text.appendTo(my_row);
        my_acol.appendTo(my_text);
        j++;
    }
}
function doBook(classify) {
    window.location.href = "./bookList.do?classify=" + classify;
}

function getSentence() {
    var wordId = $('#wordId').val();
    var data = {wordId: wordId};
    $.ajax({
        url: "./getSentence.do",
        type: 'POST',
        data: data,
        success: function (result) {
            if (result.code == '0') {
                var rList = result.data;
                sentenceInitData(rList);
                layui.use('element', function(){
                    var element = layui.element;
                });
                layui.element.init()
            } else {
                alert(result.msg);
            }
        },
        error: function () {
            alert("失败了。");
        }
    });
}

function getWord() {
    var word = $('input[name="bookclass"]').val();
    var data = {word: word};
    $.ajax({
        url: "./getWord.do",
        type: 'POST',
        data: data,
        success: function (result) {
            if (result.code == '0') {
                var rList = result.data;
                wordInitData(rList);
                getSentence();
            } else {
                alert(result.msg);
            }
        },
        error: function () {
            alert("失败了。");
        }
    });
}

function getData() {
    var data = {};
    $.ajax({
        url: "./schoolList.do",
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

function wordInitData(rList) {
    var row = $("#row");
    row.html("");
    var list = rList[0];
    for (var i = 0; i < list.length; i++) {
        var item = $('<div class="layui-colla-item"></div>');
        var vcId = list[i].vcId;
        $('#wordId').val(vcId);
        words[i] = list[i].vcVocabulary;
        var title = $('<h2 class="layui-colla-title">' + list[i].vcVocabulary + '</h2>');
        var content = $('<div class="layui-colla-content layui-show"></div>');
        var sectenceDiv = $('<div id=\"id'+vcId+'\" class="nv"></div>');

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

        $('<div style="margin: 10px;font-size: 24px;">实用场景例句</div>').appendTo(content);
        sectenceDiv.appendTo(content);
    }
}
function sentenceInitData(list) {

    if(list.length > 0){
        var j = 1;
        for (var i = 0; i < list.length; i++) {
            var sectenceDiv = $('#id'+list[i].sWordId+'');

            var div1 = $('<div class="nv" style="margin-top: 10px;"></div>');
            var ul = $('<ul></ul>');
            var li1 = $('<li style="margin-bottom: 8px;">'+j+".&nbsp;&nbsp;"+list[i].sSentence+'</li>');
            var li3 = $('<li>'+list[i].sSentenceCn+'</li>');
            var li4 = $('<li style="color: #9F9F9F;">'+list[i].sSentenceFrom+'</li>');
            div1.appendTo(sectenceDiv);
            ul.appendTo(div1);
            li1.appendTo(ul);
            li3.appendTo(ul);
            li4.appendTo(ul);
            j++;
        }
    }
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