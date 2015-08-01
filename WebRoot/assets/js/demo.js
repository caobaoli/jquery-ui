$(function() {
	$('#search_button').button();
	
	
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
		closeText: '关闭',
//		height: 500,
//		width: 500,
//		minWidth: 300,
//		minHeight: 300,
//		maxWidth: 700,
//		maxHeight: 600
//		show: true,
//		hide: true,
		show: 'slide',
		hide: 'slide',
	}); 
	
	$('#reg_a').click(function() {
		$('#reg').dialog('open');
	});
});


