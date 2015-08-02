$(function() {
	$('#search_button').button({
		icons: {
			primary: 'ui-icon-search',
		},
	});
	
	
	
	
	
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
	
	$('#reg_a').click(function() {
		$('#reg').dialog('open');
	});
	
//	$('#reg input[type=radio]').button();
	
	$('#reg').buttonset();
	
	//生日部件
	$('#date').datepicker(); 
	
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
	var host=['aa', 'aaaa', 'aaaaaa', 'bb'];
	$('#email').autocomplete({
		source: host,
		autoFocus: true,
	});
});


