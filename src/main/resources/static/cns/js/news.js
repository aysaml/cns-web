var currentPage = 1;
var pageSize = 10;

$(function(){
    init();
});

function init() {
    $("#content").empty();
    var type = $("#type").val();
    var url = "/news/getNewsCount";
    var param = {"type":type};
    callService("POST",url,param,function (data) {
        if(data.state == 0000){
            $("#totalCount").val(data.data);
            $('.page').pagination({
                totalData:$("#totalCount").val(),
                showData : pageSize,
                current : currentPage,
                jump: true,
                coping: true,
                mode: 'fixed',
                homePage: '首页',
                endPage: '末页',
                prevContent: '上页',
                nextContent: '下页',
                callback: function (api) {
                    $("#content").empty();
                    var type = $("#type").val();
                    var isSchool = $("#isSchool").val();
                    var url = "/news/getNewsCount";
                    var param = {"type":type};
                    callService("POST",url,param,function (data) {
                        if(data.state == 0000){
                            api.totalData = data.data;
                            $("#totalCount").val(data.data);
                        }else{
                            alert("获取分页列表失败！");
                        }
                    });
                    var param2 = {"pageNum":api.getCurrent(),"pageSize":pageSize,"type":type};
                    callService("POST","/news/getNewsList",param2,function (data) {
                        if(data.state == 0000){
                            var htm = "";
                            var jsonData = data.data;
                            $.each(jsonData,function (i,value){
                                var html = "<li>" +
                                    "<div class='pic pull-left'><a href='/news/detail?id="+ value.id + "'><img class='vcenter' src='"+ value.imgUrl +"' alt='' /></a></div>" +
                                    "<div class='ntxt pull-left'>\n" +
                                    "<a href='/news/detail?id="+  value.id +"'>"+ value.title +"</a>" +
                                    "<p>"+ value.content +"</p>" +
                                    "</div>" +
                                    "<div class='date pull-right'>" +
                                    "<span>"+ value.createTime +"</span>" +
                                    "<a href='/news/detail?id=" + value.id + "'></a>" +
                                    "</div>" +
                                    "</li>";
                                htm = htm + html;
                            });
                            $("#content").append(htm);
                        }else{
                            alert("获取分页列表失败！");
                        }
                    });
                }
            });
        }else{
            alert("获取分页列表失败！");
        }
    });
    var param2 = {"pageNum":1,"pageSize":pageSize,"type":type};
    callService("POST","/news/getNewsList",param2,function (data) {
        if(data.state == 0000){
            var htm = "";
            var jsonData = data.data;
            $.each(jsonData,function (i,value){
                var html = "<li>" +
                    "<div class='pic pull-left'><a href='/news/detail?id="+ value.id + "'><img class='vcenter' src='"+ value.imgUrl +"' alt='' /></a></div>" +
                    "<div class='ntxt pull-left'>\n" +
                    "<a href='/news/detail?id="+  value.id +"'>"+ value.title +"</a>" +
                    "<p>"+ value.content +"</p>" +
                    "</div>" +
                    "<div class='date pull-right'>" +
                    "<span>"+ value.createTime +"</span>" +
                    "<a href='/news/detail?id=" + value.id + "'></a>" +
                    "</div>" +
                    "</li>";
                htm = htm + html;
            });
            $("#content").append(htm);
        }else{
            alert("获取分页列表失败！");
        }
    });
}
