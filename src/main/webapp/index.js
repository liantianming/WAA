var filenames =new Array()
filenames[0]="asx";
filenames[1]="asf";
filenames[2]="mpg";
filenames[3]="wmv";
filenames[4]="3gp";
filenames[5]="mp4";
filenames[6]="mov";
filenames[7]="avi";
filenames[8]="flv";

$(function () {
	obj = {
		search : function () {

			$('#tableDate').datagrid('load', {
                fileName : $.trim($('input[name="user"]').val()),
                dateFrom : $('input[name="date_from"]').val(),
                dateTo : $('input[name="date_to"]').val(),
			});
		},
	};
    getDate();


    $('#layui').attr('href',pathName+"/media/layui.do");
});



function openAdd() {
    $('#add-dialog').dialog({
        closed: false,
        modal:true,
        title: "上传文件",
        buttons: [ {
            text: '取消',
            iconCls: 'icon-cancel',
            handler: function () {
                $('#add-dialog').dialog('close');
            }
        }],
        onBeforeOpen:function(){
            //$("#add-form input").val('');
        }
    });
}

function add() {

}

function getDate() {
    $('#tableDate').datagrid({
        width : 600,
        url: pathName+"/media/list.do",
        title : '视频列表',
        iconCls : 'icon-search',
        striped : true,
        nowrap : true,
        rownumbers : true,
        singleSelect : true,
        fitColumns : true,
        columns : [[
            {
                field : 'vOrigName',
                title : '文件名',
                sortable : true,
                width : 100,

            },
            {
                field : 'vSuffix',
                title : '后缀名',
                sortable : true,
                width : 100,
            },
            {
                field : 'vCreateDate',
                title : '上传时间',
                sortable : true,
                width : 100,
                formatter:function (value,row,index) {
                    return jsonTimeStamp(value);
                }
            }
        ]],
        toolbar : '#tb',
        pagination : true,
        pageSize : 10,
        pageList : [10, 20, 30],
        pageNumber : 1,
        //data:rresult.data,
        // sortName : 'date',
        // sortOrder : 'DESC',
    });
}

function checkFile(filename) {
    if(filename == ""){
        alert("请选择文件。")
        return false;
    }
    var index = filename.lastIndexOf(".");
    var suffix = filename.substr(index+1);
    var index = filenames.indexOf(suffix);
    if(index == -1){
        alert("请选择视频文件。")
        return false;
    }
    return true;
}

function importInfo(){

    var formData = new FormData();
    var filename = $("#fileInput").val();
    var ratio = $('#ratio').combobox('getValue');
    // var ratio = $('input[name="ratio"]').selected;
    var isVideo = checkFile(filename);
    if(!isVideo){
        return;
    }
    formData.append("video",$("#fileInput")[0].files[0]);
    formData.append("ratio",ratio);

    $.ajax({
        url: pathName+"/media/video.do",
        type : 'POST',
        data: formData,
        processData : false,
        contentType : false,

        beforeSend: function(){
            addLoding();
        },
        complete: function(){

        },
        success: function(result) {
            removeLoding();
            if(result.code == '0'){
                alert("上传完成");
            }else {
                alert(result.msg);
            }
        },
        error: function() {
            removeLoding();
            alert("失败了。");
        }
    });
}
function addLoding() {
    $(".time").show();
}
function removeLoding() {
    $(".time").hide();
}

	









