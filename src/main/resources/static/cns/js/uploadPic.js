function uploadPic() {
    var flag = check();

    if(flag){
        var url = "/access/addPic";

        var param = {
            placeId : $('#placeId').val(),
            url : $('#headImg').attr('src'),
            picName : $('#picName').val(),
            placeName : $('#placeName').val(),
            remark : $('#remark').val()
        }
        
        callServiceJson("POST",url,param,function (res) {
            if(res.state == 0000){
                alert("提交成功，请您耐心等待审核！");
            }else{
                alert(res.data);
            }
        })
    }
}

function check() {
    var picName = $('#picName').val();

    var remark = $('#remark').val();

    var imgurl = $('#head-upload').attr("src");

    if(picName == "" || picName == null){
        alert("图片名称不能为空！");
        return false;
    }

    if(remark == "" || remark == null){
        alert("图片介绍不能为空！");
        return false;
    }

    if(imgurl == "" || imgurl == null){
        alert("请您上传图片！");
        return false;
    }
}