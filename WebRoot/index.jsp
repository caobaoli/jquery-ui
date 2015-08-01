<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>jquery-ajax</title>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	
	<link rel="stylesheet" type="text/css" href="<%=path%>/assets/css/style.css">
	<script type="text/javascript" src="<%=path%>/assets/js/jquery-1.11.3.js"></script>
	<script type="text/javascript" src="<%=path%>/assets/js/jquery.nav.js"></script>
	<script type="text/javascript" src="<%=path%>/assets/js/demo.js"></script>
  </head>
  
  <body>
  	<ul class="list">
  		<li>列表1
  			<ul class="nav">
  				<li>列表1-1</li>
  				<li>列表1-2</li>
  				<li>列表1-3</li>
  			</ul>
  		</li>
  		<li>列表2
  			<ul class="nav">
  				<li>列表2-1</li>
  				<li>列表2-2</li>
  				<li>列表2-3</li>
  			</ul>
  		</li>
  		<li>列表3
  			<ul class="nav">
  				<li>列表3-1</li>
  				<li>列表3-2</li>
  				<li>列表3-3</li>
  			</ul>
  		</li>
  		<li>列表4
  			<ul class="nav">
  				<li>列表4-1</li>
  				<li>列表4-2</li>
  				<li>列表4-3</li>
  			</ul>
  		</li>
  		<li>列表5
  			<ul class="nav">
  				<li>列表5-1</li>
  				<li>列表5-2</li>
  				<li>列表5-3</li>
  			</ul>
  		</li>
  		<li>列表6
  			<ul class="nav">
  				<li>列表6-1</li>
  				<li>列表6-2</li>
  				<li>列表6-3</li>
  			</ul>
  		</li>
  		<li>列表7
  			<ul class="nav">
  				<li>列表7-1</li>
  				<li>列表7-2</li>
  				<li>列表7-3</li>
  			</ul>
  		</li>
  	</ul>	
  </body>
</html>
