$(function () {
    $("#myManu").load('../index');
    $('#table').bootstrapTable({
        url: 'ajaxList',
        striped: true,                      //是否显示行间隔色
        cache: false,                       //是否使用缓存，默认为true，所以一般情况下需要设置一下这个属性（*）
        pagination: true,                   //是否显示分页（*）
        pageList: [1, 2, 5, 10],        //可供选择的每页的行数（*）
        search: true,                      //是否显示表格搜索
        strictSearch: true,
        showColumns: true,                  //是否显示所有的列（选择显示的列）
        showRefresh: true,                  //是否显示刷新按钮
        columns: [{
            field: 'userId',
            title: '客户端ID'
        }, {
            field: 'userName',
            title: '名称'
        }, {
            field: 'address',
            title: '地址'
        },{
            field: 'email',
            title: '邮件'
        },{
            field: 'phone',
            title: '电话'
        },{
            field: 'createTime',
            title: '创建时间',
            //获取日期列的值进行转换
            formatter: function (value, row, index) {
                return changeDateFormat(value)
            }
        },{
            field: 'operation',
            title: '操作',
            align: 'center',
            events: operateEvents,
            formatter: operateFormatter,
        } ],
    });

    //操作栏的格式化
    function operateFormatter(value, row, index) {
        return[
            '<button id="setQueue" type="button" class="btn btn-default">设置权限</button> &nbsp;&nbsp;',
            '<button id="delete" type="button" class="btn btn-default">删除</button>'
        ].join("")
    }
});

window.operateEvents = {
    "click #setQueue": function (e, value, row, index) {
        $("#queueList").empty();
        $.ajax({
            url:"../itQueue/queryQueueByUserId",
            data:{userId:row.userId},
            success: function(data) {
                if (data.success) {
                    $("#queueList").val(row.userId);
                    var list = data.data;
                    for(var i=0;i<list.length;i++) {
                        if(list[i].userId==row.userId){
                            $("#queueList").append("<li class='input-group'>" +
                                "<span class='input-group-addon'>" +
                                "<input type='checkbox' name='queuecheckbox' checked='checked' value='"+list[i].queueId+"'></span>" +
                                "<div class='form-control'>" +
                                "<label id='queueName' style='float:left'>"+list[i].queueName+"</label>" +
                                "<label id='queueDescribe'>"+list[i].queueDescribe+"</label>" +
                                "<label id='createTime' style='float:right'>"+changeDateFormat(list[i].createTime)+"</label>" +
                                "</div></li>");
                        }else{
                            $("#queueList").append("<li class='input-group'>" +
                                "<span class='input-group-addon'>" +
                                "<input type='checkbox' name='queuecheckbox' value='"+list[i].queueId+"'></span>" +
                                "<div class='form-control'>" +
                                "<label id='queueName' style='float:left'>"+list[i].queueName+"</label>" +
                                "<label id='queueDescribe'>"+list[i].queueDescribe+"</label>" +
                                "<label id='createTime' style='float:right'>"+changeDateFormat(list[i].createTime)+"</label>" +
                                "</div></li>");
                        }

                    }
                    $("#setModal").modal('show');
                } else {
                    alert(data.msg);
                }
            }
        });
    },
    "click #delete": function (e, value, row, index) {
       $.ajax({
           url:"delete",
           data:{userId:row.userId},
           success: function(data){
               if(data.success){
                   alert(data.msg);
                   window.location.href="list";
               }else{
                   alert(data.msg);
               }
           }
       })
    }
}

function add() {
    var userName = $.trim($("#userName").val());
    var passwd = $("#passwd").val();
    var address = $("#address").val();
    var email = $("#email").val();
    var phone = $("#phone").val();
    if(userName.length==0){
        alert("用户名不能为空！")
    }
    if(email.length!=0){
        reg=/^([a-zA-Z0-9_-])+@([a-zA-Z0-9_-])+(.[a-zA-Z0-9_-])+/ ;
        if(!reg.test(email)){
            alert("邮箱格式不正确!");
        }
    }
    if(phone.length!=0){
        reg = /^1[34578]\d{9}$/;
        if(!reg.test(phone)){
            alert("手机格式不正确!");
        }
    }
    $.ajax({
        type:"post",
        url:"add",
        data:{userName:userName, passwd:passwd, address:address, email:email, phone:phone},
        success: function(data){
            if(data.success){
                alert(data.msg);
                window.location.href="list";
            }else{
                alert(data.msg);
            }
        }
    })
}

function  set() {
    var userId = $("#queueList").val();
    var obj = $("[name='queuecheckbox']");
    var check_val = [];
    for(var k in obj){
        if(obj[k].checked)
            check_val.push(obj[k].value);
    }
    var allReceiver=check_val.toString();//获取所有选中的value值
    $.ajax({
        type:"post",
        url:"setQueue",
        data:{userId:userId, queueIds:allReceiver},
        success: function(data){
            if(data.success){
                alert(data.msg);
                window.location.href="list";
            }else{
                alert(data.msg);
            }
        }

    })

}
