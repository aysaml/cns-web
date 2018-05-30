

(function ($) {
    var headUploader;
    headUploader = WebUploader.create({
        swf: 'static/webuploader/Uploader.swf',
        server: '/upload',
        pick: '#head-upload',
        fileNumLimit: 1,
        fileSizeLimit: 10 * 1024 * 1024,    // 10 M
        fileSingleSizeLimit:10* 1024 *1024,
        auto: true,
        duplicate:true,
        accept: {
            title: 'Images',
            extensions: 'jpg,png,jpeg,gif,bmp',
            mimeTypes: 'image/*'
        }

    });

    $('#head-upload').click(function () {
        headUploader.reset();
    });

    headUploader.on('beforeFileQueued', function (file) {
        var uploadType = $(file.source._refer).attr("uploadType"); //上传按钮(更新图片/更新文件)imageFile:图片  otherFile:其他
        var fileTypeImg = file.type.indexOf("image/");//文件类型:-1 : 非图片  其他 : 图片
        if(uploadType == "imageFile" && fileTypeImg == -1){
            alert("请上传图片文件！");
            return false;
        }
    });

//
    headUploader.on('fileQueued', function (file) {
    });
    headUploader.on('uploadProgress', function (file, percentage) {

    });
// 文件上传成功，给item添加成功class, 用样式标记上传成功。
    headUploader.on('uploadSuccess', function (file) {

    });
// 文件上传失败，显示上传出错。
    headUploader.on('error', function (type) {
        if (type == "Q_TYPE_DENIED") {
            alert("请上传JPG、PNG、GIF、BMP格式文件");
        } else if (type == "Q_EXCEED_SIZE_LIMIT") {
            alert("图片大小不能超过10M哦！");
        }else {
            alert("上传出错！请检查后重新上传!");
        }
    });

    headUploader.on('uploadAccept', function (object, ret) {
                    $("#headImg").attr("src",ret.data);
    });

// 完成上传完了，成功或者失败，先删除进度条。
    headUploader.on('uploadComplete', function (file) {

    });


})(jQuery);




