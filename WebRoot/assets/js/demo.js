$(function() {
	$('#search_button').button({
		icons: {
			primary: 'ui-icon-search',
		},
	});

	/*初始化对话框*/
	$('#reg').dialog({
		title: '知乎注册',
		buttons: {
			'提交': function() {
				alert('提交');
			},
			'关闭': function() {
				$(this).dialog('close');
			}
		},
		autoOpen: false,//不让html中显示
		modal: true,//后台不可操作
		resizable: false,//不可改变大小
		width: 350,
		height: 340,
		closeText: '关闭',
		show: 'slide',
		hide: 'slide',
	}); 
	/*显示对话框*/
	$('#reg_a').click(function() {
		$('#reg').dialog('open');
	});
	
//	$('#reg input[type=radio]').button();
	
	$('#reg').buttonset();
	
	/*生日部件*/
	$('#date').datepicker({
		changeMonth: true,//好选取month
		changeYear: true,//好选取year
		showButtonPanel: true,
		closeText: '关闭',
		currentText: '今天',
		
		maxDate: 0,		//可用于火车票购买日历控件
//		minDate: -8000,
//		hideIfNoPrevNext: true,
		yearRange: '1950:2020',
	}); 
	
	/*设置tooltip的属性*/
	$('#reg input[title]').tooltip({
//		disabled: true,
//		content: '改变title',
//		tooltipClass: 'a',//显示文字的css样式
		position: {
			my: 'left+5 center',
			at: 'right center'
		}
	});
	
	/*邮箱自动补全*/
	$('#email').autocomplete({
		delay: 0,/*加快反应速度*/
		autoFocus: true,
		source: function(request, response) {
			//获取用户输入的内容
//			alert(request.term);
//			response(['aa','aaaa','aaaaaa','bb']);//展示补全结果
			
			var hosts=['126.com', '163.com', 'qq.com', 'gmail.com', 'sina.com.cn', 'hotmail.com'],
				term = request.term,/*获取用户输入的内容*/
				name = term,/*邮箱的用户名*/
				host = '',/*邮箱的域名*/
				ix = term.indexOf('@'),/*@的位置*/
				result = [];/*最终呈现的邮箱列表*/
			
			result.push(term);
			
			/*当有@的时候，重新分配用户名和域名*/
			if(ix > -1) {
				name = term.slice(0, ix); /*从0开始筛选到ix*/
				host = term.slice(ix + 1);/*选取ix以后的数据*/
			}	
			
			if(name) {
				/*如果用户已经输入@好后面的域名，那么就找到相关的域名提示，比如bnbbs@1,就提示bnbbs@126.com
				 * 如果用户还没有输入@和后面的域名，那么就把所有的域名都提示出来
				 * */
				var findedHosts = (host ? findedHosts = $.grep(hosts, function(value, index) {
					return value.indexOf(host) > -1;
				}) : hosts),
					findedResults = $.map(findedHosts, function(value, index) {
						return name+'@'+value;
				});
				result = result.concat(findedResults);
			}
			
			response(result);
		},
	});
});


