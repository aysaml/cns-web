function addPlace() {
    var flag = check();

    if(flag == true){
        var url = "/access/addPlace";

        var para = {
            placeNameCh : $('#placeNameCh').val(),

            placeNameEn : $('#placeNameEn').val(),

            alias : $('#alias').val(),

            type : $('#type option:selected').val(),

            isSchool : $("[name='isSchool']:checked").val(),

            descr : $('#descr').val(),

            img : $('#headImg').attr('src')
        }
        
        callServiceJson("POST",url,JSON.stringify(para),function (res) {
            if(res.state == 0000){
                alert(res.data);
                location.href = "/access/addPage";
            }else{
                alert(res.data);
            }

        })
    }
}

function check() {
    var placeNameCh = $('#placeNameCh').val();

    var placeNameEn = $('#placeNameEn').val();

    var alias = $('#alias').val();

    var type = $('#type option:selected').val();

    var isSchool = $("[name='isSchool']:checked").val();

    var descr = $('#descr').val();

    var img = $('#headImg').attr('src');

    if(placeNameCh == "" || placeNameCh == null){
        alert("中文名称不能为空！");
        return false;
    }

    if(placeNameEn == "" || placeNameEn == null){
        alert("英文名称不能为空！");
        return false;
    }

    if(img == "" || img == null){
        alert("请您上传一张地点图片！");
        return false;
    }

    if(alias == "" || alias == null){
        alert("地点全名不能为空！");
        return false;
    }

    if(type == "" || type == null){
        alert("请选择地点类型！");
        return false;
    }

    if(isSchool == "" || isSchool == null){
        alert("请选择地点分类！");
        return false;
    }

    if(descr == "" || descr == null){
        alert("地点描述不能为空！");
        return false;
    }
    return true;
}