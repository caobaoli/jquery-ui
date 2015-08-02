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
				$(this).submit();
			},
			'关闭': function() {
				$(this).dialog('close');
			}
		},
		autoOpen: false,//不让html中显示
		modal: true,//后台不可操作
		resizable: false,//不可改变大小
		width: 320,
		height: 340,
		closeText: '关闭',
		show: 'slide',
		hide: 'slide',
	}); 
	
	/*显示对话框*/
	$('#reg_a').click(function() {
		$('#reg').dialog('open');
	});
	
	
	$('#reg').buttonset().validate({
		submitHandler: function(form) {
			alert('验证完成，准备提交！');
		},
		
		/**
		 * 调整errors出现时的高度
		 * @param errorMap
		 * @param errorList
		 */
		showErrors: function(errorMap, errorList) {
			var errors = this.numberOfInvalids();
			if(errors>0) {
				$('#reg').dialog('option', 'height', errors * 20 + 340);
			} else {
				$('#reg').dialog('option', 'height', 340);
			}
			this.defaultShowErrors();
		},
		
		/**
		 * 文本框在出错时的状态
		 * @param element
		 * @param errorClass
		 */
		highlight: function(element, errorClass) {
			$(element).css('border', '1px solid #630');
		},
		
		/**
		 * 文本框在输入正确时状态
		 * @param element
		 * @param errorClass
		 */
		unhighlight: function(element, errorClass) {
			$(element).css('border', '1px solid #ccc');
			$(element).parent().find('span').html('&nbsp;').addClass('success');
		},
		
		errorLabelContainer: 'ol.reg_error',
		wrapper: 'li',
		
		rules: {
			user: {
				required: true,
				minlength: 2,
			},
			pass: {
				required: true,
				minlength: 6,
			},
			email: {
				required: true,
				email: true,
			},
			date: {
				date: true,
			}
		},
		messages: {
			user: {
				required: '账号不得为空',
				minlength: jQuery.format('账号不得小于{0}位'),
			},
			pass: {
				required: '密码不得为空',
				minlength: jQuery.format('密码不得小于{0}位'),
			},
			email: {
				required: '邮箱不得为空',
				minlength: '请输入正确的邮箱地址',
			},
		}
	});
	
	/*生日部件*/
	$('#date').datepicker({
		changeMonth: true,//好选取month
		changeYear: true,//好选取year
		showButtonPanel: true,
		closeText: '关闭',
		currentText: '今天',
		
		maxDate: 0,		//可用于火车票购买日历控件
		yearRange: '1950:2020',
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


