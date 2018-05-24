var currentPage = 1;
var pageSize = 3;

$(function(){
    init();
});

function init() {
    $("#content").empty();
    var type = $("#type").val();
    var isSchool = $("#isSchool").val();
    var url = "/spot/getPlaceCount";
    var param = {"type":type,"isSchool":isSchool};
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
                    var url = "/spot/getPlaceCount";
                    var param = {"type":type,"isSchool":isSchool};
                    callService("POST",url,param,function (data) {
                        if(data.state == 0000){
                            api.totalData = data.data;
                            $("#totalCount").val(data.data);
                        }else{
                            alert("获取分页列表失败！");
                        }
                    });
                    var param2 = {"pageNum":api.getCurrent(),"pageSize":pageSize,"type":type,"isSchool":isSchool};
                    callService("POST","/spot/getPlaceListByType",param2,function (data) {
                        if(data.state == 0000){
                            var htm = "";
                            var jsonData = data.data;
                            $.each(jsonData,function (i,value){
                                var html = "<li class='animated fadeInRight'>" +
                                    "<div class='pic'><a href='/spot/detail?id="+ value.id +"'><img class='vcenter' src='"+ value.img +"' alt='' /></a></div>" +
                                    "<a href='/spot/detail?id="+ value.id +"' class='protit'>" +
                                    "<span>"+ value.placeNameCh +"</span>" +
                                    "</a>" +
                                    "</li>";
                                htm += html;
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
    var param2 = {"pageNum":1,"pageSize":pageSize,"type":type,"isSchool":isSchool};
    callService("POST","/spot/getPlaceListByType",param2,function (data) {
        if(data.state == 0000){
            var htm = "";
            var jsonData = data.data;
            $.each(jsonData,function (i,value){
                var html = "<li class='animated fadeInRight'>" +
                    "<div class='pic'><a href='/spot/detail?id="+ value.id +"'><img class='vcenter' src='"+ value.img +"' alt='' /></a></div>" +
                    "<a href='/spot/detail?id="+ value.id +"' class='protit'>" +
                    "<span>"+ value.placeNameCh +"</span>" +
                    "</a>" +
                    "</li>";
                htm += html;
            });
            $("#content").append(htm);
        }else{
            alert("获取分页列表失败！");
        }
    });
}

function inSchool() {
    var type = $("#type").val();
    location.href="/spot/inSchool?type="+type;
}

function notInSchool() {
    var type = $("#type").val();
    location.href="/spot/notInSchool?type="+type;
}

function typeChang(obj) {
    var type = $(obj).attr("code");
    $('.twofenlei a').attr("class","");
    $(obj).attr("class","active");
    $("#type").val(type);
    init();
}