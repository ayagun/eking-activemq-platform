$(function () {
    $("#myManu").load('../index');
    $('#table').bootstrapTable({
        url: 'ajaxList',
        striped: true,                      //是否显示行间隔色
        cache: false,                       //是否使用缓存，默认为true，所以一般情况下需要设置一下这个属性（*）
        pagination: true,                   //是否显示分页（*）
        pageList: [10, 25, 50, 100],        //可供选择的每页的行数（*）
        search: true,                      //是否显示表格搜索
        strictSearch: true,
        showColumns: true,                  //是否显示所有的列（选择显示的列）
        showRefresh: true,                  //是否显示刷新按钮
        columns: [{
            field: 'messageid',
            title: '消息ID'
        }, {
            field: 'destination',
            title: '目的地'
        }, {
            field: 'consumer',
            title: '消费者'
        },{
            field: 'message',
            title: '内容'
        },{
            field: 'createperson',
            title: '生产者'
        },{
            field: 'createtime',
            title: '创建时间',
            sortable : true,
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
            '<button id="detail" type="button" class="btn btn-default">查看</button> &nbsp;&nbsp;',
            '<button id="reSend" type="button" class="btn btn-default">重发</button>'
        ].join("")
    }
});

window.operateEvents = {
    "click #detail": function (e, value, row, index) {
        $("#messageid").val(row.messageid);
        $("#destination").val(row.destination);
        $("#consumer").val(row.consumer);
        $("#createperson").val(row.createperson);
        $("#message").val(row.message);
        var createTime= changeDateFormat(row.createtime);
        $("#createtime").val(createTime);
        $("#detailModal").modal('show');
    },
    "click #reSend": function (e, value, row, index) {
        alert("delete");
    }
}