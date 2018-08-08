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
            field: 'id',
            title: '连接ID'
        }, {
            field: 'connectionIp',
            title: '连接IP'
        }, {
            field: 'userName',
            title: '连接者'
        },{
            field: 'connectionStatus',
            title: '状态'
        },{
            field: 'createTime',
            title: '创建时间',
            //获取日期列的值进行转换
            formatter: function (value, row, index) {
                return changeDateFormat(value)
            }
        },{
            field: 'updateTime',
            title: '更新时间',
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
            '<button id="detail" type="button" class="btn btn-default">查看</button>'
        ].join("")
    }
});

window.operateEvents = {
    "click #detail": function (e, value, row, index) {
        $("#id").val(row.id);
        $("#connectionIp").val(row.connectionIp);
        $("#userName").val(row.userName);
        $("#connectionStatus").val(row.connectionStatus);
        var createTime= changeDateFormat(row.createTime);
        var updateTime= changeDateFormat(row.updateTime);
        $("#createTime").val(createTime);
        $("#updateTime").val(updateTime);
        $("#detailModal").modal('show');
    }
}