<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>${title}</title>
<meta name="keywords" content="在线支付案例，支付宝支付Demo，微信支付Demo">
<link rel="stylesheet" href="/static/layui/css/layui.css">
<meta name="description" content="一个Java实现的支付宝微信在线支付在线案例，Java知识分享网出品，作者 Java1234_小锋老师。">
<meta name="renderer" content="webkit">
<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
<meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
<meta name="apple-mobile-web-app-status-bar-style" content="black"> 
<meta name="apple-mobile-web-app-capable" content="yes">
<meta name="format-detection" content="telephone=no">
</head>
<body>
<div class="layui-container">
	
	<#include "/common/head.ftl">
	
	<div class="layui-row">
	    <div class="layui-col-md12">
	        <fieldset class="layui-elem-field layui-field-title" style="margin-top: 20px;">
			  <legend>订单列表</legend>
			</fieldset>
	    </div> 
	</div>
	
	<div class="layui-row">
	    <div class="layui-col-md12">
	        <table class="layui-hide" id="orderListTable"></table>
	    </div> 
	</div>
	
</div>
<script src="/static/layui/layui.js"></script>

<script>
layui.use('table', function(){
  var table = layui.table;
  
  table.render({
    elem: '#orderListTable'
    ,url:'/order/orderList'
    ,cols: [[
       {field:'nickName', width:100, title: '昵称'}
      ,{field:'qq', width:120, title: 'QQ'}
      ,{field:'buyTime', width:180, title: '支付时间', sort: true,align:'center'}
      ,{field:'way', width:100, title: '支付方式',align:'center'}
      ,{field:'body',width:200, title: '订单详情'}
      ,{field:'message', title: '留言', minWidth: 150}
    ]]
    ,page: true
  });
});
</script>

</body>
</html>