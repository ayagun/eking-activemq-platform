$(function () {
    $("#myManu").load('../index');
    $('#table').bootstrapTable({
        url: 'ajaxList',
        striped: true,                      //是否显示行间隔色
        cache: false,                       //是否使用缓存，默认为true，所以一般情况下需要设置一下这个属性（*）
        pagination: true,                   //是否显示分页（*）
        pageList: [5, 10, 20, 50],        //可供选择的每页的行数（*）
        search: true,                      //是否显示表格搜索
        strictSearch: true,
        showColumns: true,                  //是否显示所有的列（选择显示的列）
        showRefresh: true,                  //是否显示刷新按钮
        columns: [{
            field: 'queueId',
            title: '队列ID'
        }, {
            field: 'queueName',
            title: '名称'
        }, {
            field: 'permissionType',
            title: '权限类型'
        },{
            field: 'queueDescribe',
            title: '描述'
        },{
            field: 'createPerson',
            title: '创建人'
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
            '<button id="edit" type="button" class="btn btn-default">修改</button> &nbsp;&nbsp;',
            '<button id="delete" type="button" class="btn btn-default">删除</button>'
        ].join("")
    }
});

window.operateEvents = {
    "click #edit": function (e, value, row, index) {
        alert(row.queueId);
    },
    "click #delete": function (e, value, row, index) {
        $.ajax({
            url:"delete",
            data:{queueId:row.queueId},
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
    var queueName = $.trim($("#queueName").val());
    var permissionType = $("#permissionType").val();
    var queueDescribe = $("#queueDescribe").val();
    var createPerson = $("#createPerson").val();
    if(queueName.length==0){
        alert("名称不能为空！")
    }
    $.ajax({
        type:"post",
        url:"add",
        data:{queueName:queueName, permissionType:permissionType, queueDescribe:queueDescribe, createPerson:createPerson},
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