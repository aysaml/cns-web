var canGetCookie = 0;//是否支持存储Cookie 0 不支持 1 支持

var CodeVal = 0;
Code();
function Code() {
    if(canGetCookie == 1){
        createCode("AdminCode");
        var AdminCode = getCookieValue("AdminCode");
        showCheck(AdminCode);
    }else{
        showCheck(createCode(""));
    }
}
function showCheck(a) {
    CodeVal = a;
    var c = document.getElementById("myCanvas");
    var ctx = c.getContext("2d");
    ctx.clearRect(0, 0, 1000, 1000);
    ctx.font = "80px 'Hiragino Sans GB'";
    ctx.fillStyle = "#E8DFE8";
    ctx.fillText(a, 0, 100);
}
$(document).keypress(function (e) {
    // 回车键事件
    if (e.which == 13) {
        $('input[type="button"]').click();
    }
});
//粒子背景特效
$('body').particleground({
    dotColor: '#E8DFE8',
    lineColor: '#133b88'
});
$('input[name="pwd"]').focus(function () {
    $(this).attr('type', 'password');
});
$('input[type="text"]').focus(function () {
    $(this).prev().animate({ 'opacity': '1' }, 200);
});
$('input[type="text"],input[type="password"]').blur(function () {
    $(this).prev().animate({ 'opacity': '.5' }, 200);
});
$('input[name="login"],input[name="pwd"]').keyup(function () {
    var Len = $(this).val().length;
    if (!$(this).val() == '' && Len >= 5) {
        $(this).next().animate({
            'opacity': '1',
            'right': '30'
        }, 200);
    } else {
        $(this).next().animate({
            'opacity': '0',
            'right': '20'
        }, 200);
    }
});
var open = 0;
layui.use('layer', function () {
    var msgalert = '注册时请牢记您的账号密码哦!';
    var index = layer.alert(msgalert, { icon: 6, time: 4000, offset: 't', closeBtn: 0, title: '友情提示', btn: [], anim: 2, shade: 0 });
    layer.style(index, {
        color: '#777'
    });
    //非空验证
    $('input[type="button"]').click(function () {
        var login = $('input[name="login"]').val();
        var pwd = $('input[name="pwd"]').val();
        var code = $('input[name="code"]').val();
        if (login == '') {
            ErroAlert('请输入您的账号！');
            return;
        } else if (pwd == '') {
            ErroAlert('请输入密码！');
            return;
        } else if (code.toUpperCase() != CodeVal.toUpperCase()) {
            ErroAlert('验证码错误！');
            return;
        } else {
            //认证中..
            fullscreen();
            $('.login').addClass('test'); //倾斜特效
            setTimeout(function () {
                $('.login').addClass('testtwo'); //平移特效
            }, 300);
            setTimeout(function () {
                $('.authent').show().animate({ right: -320 }, {
                    easing: 'easeOutQuint',
                    duration: 600,
                    queue: false
                });
                $('.authent').animate({ opacity: 1 }, {
                    duration: 200,
                    queue: false
                }).addClass('visible');
            }, 500);

            var url = "/doRegister";
            var json = JSON.stringify({"username":login,"password":pwd});
            callServiceJson('POST',url,json,function (data) {
                setTimeout(function () {
                    $('.authent').show().animate({ right: 90 }, {
                        easing: 'easeOutQuint',
                        duration: 600,
                        queue: false
                    });
                    $('.authent').animate({ opacity: 0 }, {
                        duration: 200,
                        queue: false
                    }).addClass('visible');
                    $('.login').removeClass('testtwo'); //平移特效
                }, 2000);
                setTimeout(function () {
                    $('.authent').hide();
                    $('.login').removeClass('test');
                    if (data.state == 0000) {
                        //注册成功
                        $('.login div').fadeOut(100);
                        $('.success').fadeIn(1000);
                        $('.success').html(data.data+"<br/>3秒钟后为您跳转到登录页面...");
                        //跳转操作
                        setTimeout( "location.href = '/home'",3000);
                    } else {
                        var message = data.data;
                        var index = layer.alert(message, { icon: 6, time: 4000, offset: 't', closeBtn: 0, title: '提示', btn: [], anim: 2, shade: 0 });
                        layer.style(index, {
                            color: '#777'
                        });
                    }
                }, 2400);
            },function (data) {
            })
          /*  AjaxPost(url, json,
                function () {

                },
                function (data) {
                    //ajax返回
                    //认证完成
                    setTimeout(function () {
                        $('.authent').show().animate({ right: 90 }, {
                            easing: 'easeOutQuint',
                            duration: 600,
                            queue: false
                        });
                        $('.authent').animate({ opacity: 0 }, {
                            duration: 200,
                            queue: false
                        }).addClass('visible');
                        $('.login').removeClass('testtwo'); //平移特效
                    }, 2000);
                    setTimeout(function () {
                        $('.authent').hide();
                        $('.login').removeClass('test');
                        if (data.state == 0000) {
                            //注册成功
                            $('.login div').fadeOut(100);
                            $('.success').fadeIn(1000);
                            $('.success').html(data.data);
                            //跳转操作
                            location.href = '/home';
                        } else {
                            var message = data.data;
                            var index = layer.alert(message, { icon: 6, time: 4000, offset: 't', closeBtn: 0, title: '提示', btn: [], anim: 2, shade: 0 });
                            layer.style(index, {
                                color: '#777'
                            });
                        }
                    }, 2400);
                })*/
        }
    })
})
var fullscreen = function () {
    elem = document.body;
    if (elem.webkitRequestFullScreen) {
        elem.webkitRequestFullScreen();
    } else if (elem.mozRequestFullScreen) {
        elem.mozRequestFullScreen();
    } else if (elem.requestFullScreen) {
        elem.requestFullscreen();
    } else {
        //浏览器不支持全屏API或已被禁用
    }
}