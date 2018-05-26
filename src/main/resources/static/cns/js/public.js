$(function() {
	$('nav#mmenu').mmenu({
		extensions	: [ 'effect-slide-menu', 'pageshadow' ],
		counters	: false,
		navbar 		: {
			title		: '菜单',
		},
		navbars		: [
			 {
				position	: 'top',
				content		: [
					'prev',
					'title',
					'close'
				]
			}, {
				position	: 'bottom',
				content		: [
					''
				]
			} 
		]
	});
});



$(function(){
	$(".nav li:last").css({"background":"none","width":"95px","text-align":"right"})
	$(".scope ul li:last").css({"margin-right":"0"})
})

$(".friendlink").click(function(){
	$(".flinkdown").toggle(200);
})



$(".honor ul li:nth-child(4n)").css({"margin-right":"0"});

$(".procon li:nth-child(4n)").css({"margin-right":"0"});


$(document).ready(function() {
		
			
		if($("#menu > div").length > 4){
			$('#menu').slick({
		    	slidesToShow:4,
		    	infinite:false,
		    	
		    });
	
			if($("#menu .cur").length>0){
				$("#menu").slick("slickGoTo",$("#menu .cur").parent().data("slick-index")-3);
			}
		}
		
		else {
			$('#menu').slick({
				slidesToShow:4,
				infinite:false,
				responsive: [
					    {
					        breakpoint: 480,
					        settings: {
					            slidesToShow: 3,
					        }
					    }
					    
                ]
			});	
			
		}
		
		
	});
$(function(){
		if($("#menu2 > div").length > 8){
			$('#menu2').slick({
		    	slidesToShow:8,
		    	infinite:false,
		    	
		    	
		    });
	
			if($("#menu2 .cur2").length>0){
				$("#menu2").slick("slickGoTo",$("#menu2 .cur2").parent().data("slick-index")-7);
			}
		}
		
		else {
			$('#menu2').slick({
				slidesToShow:8,
				infinite:false,
				responsive: [
					    {
					        breakpoint: 992,
					        settings: {
					            slidesToShow: 3,
					        }
					    },
					    {
					        breakpoint: 480,
					        settings: {
					            slidesToShow: 2,
					        }
					    }
                ]
			});	
			
		}
	})




$(function(){
	$(".phonecase").slick({
		dots:true,
		arrows:false,
		autoplay:true,
	})
})

$(function(){
	$(".nav li").hover(function(){
		$(this).find(".two").slideDown(200);
	},function(){
		$(this).find(".two").stop(true).slideUp(200);
	})
})



$(function(){
	$(".nav li ul li").hover(function(){
		$(this).find("ul").slideDown(200);
	},function(){
		$(this).find("ul").stop(true).slideUp(100);
	})
})

/*
     * $.confirm({
     *   content:      {string}  弹框内容，可为纯文本或html片段 （必须）
     *   width:        {number}  弹框宽度
     *   title:        {string}  弹框标题
     *   btnText       {string}  确认按钮文本
     *   btnCelText    {string}  取消按钮文本
     *   containerCls: {string}  自定义弹框容器的 className
     * })
     */
$.confirm = function(option) {
    option || (option = {});

    var setting = {
        title: option.title || '确认',
        width: option.width || 400,
        // dragdrop: false,
        containerCls: option.containerCls,
        btnText: option.btnText || '确认',
        btnCelText:option.btnCelText || '取消',
        onSure: option.onSure || noop,
        onCancel: option.onCancel || noop,
        onClose: option.onClose || noop
    }

    var cont = option.content || '';
    if (typeof option == 'string') {
        var msg = '<p class="c-content">' + option + '</p>';
    }

    var buttons = '<div class="thick-btn btn-w">' +
        '<a href="javascript:;" class="btn-a btn-red">' + setting.btnText + '</a>' +
        '<a href="javascript:;" class="btn-a btn-cancel">' + setting.btnCelText + '</a>' +
        '</div>';
    setting.source = cont + buttons;

    // 确定/取消按钮
    var $dialog = $.dialog(setting)
    var close = $dialog.data('close')
    $dialog.find('.btn-red').click(function() {
        if (setting.onSure()!=false) {
            close();
        }
    });

    $dialog.find('.btn-cancel').click(function() {
        setting.onCancel();
        close();
    });

    $dialog.find('.thickclose').click(function() {
        setting.onClose();
        close();
    });

    return $dialog;
};








