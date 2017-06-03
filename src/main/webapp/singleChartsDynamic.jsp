<!DOCTYPE html>
<html lang="en">
	<!-- 面积图  多序列  动态获取数据 从数据库获取-->
	<head>
		<meta charset="utf-8">
		<title>ECharts</title>
		<!--Step:1 Import a module loader, such as esl.js or require.js-->
		<!--Step:1 引入一个模块加载器，如esl.js或者require.js-->
		<script src="./js/esl.js"></script>
		<script src="./js/jquery-1[1].2.6.pack.js"></script>
	</head>
<%
String datefromto = request.getParameter("datefromto");
if(datefromto==null)
	datefromto = "20140701~20140704";
String starttime = datefromto.split("~")[0].replaceAll("-","")+"0000";
String endtime = datefromto.split("~")[1].replaceAll("-","")+"0000";
System.out.println(starttime);
System.out.println(endtime);
 %>
	<body>
		<!--Step:2 Prepare a dom for ECharts which (must) has size (width & hight)-->
		<!--Step:2 为ECharts准备一个具备大小（宽高）的Dom-->
		<div id="main"
			style="height:500px;width:90%;border: 1px solid #ccc; padding: 10px;"></div>

		<script type="text/javascript">
    // Step:3 conifg ECharts's path, link to echarts.js from current page.
    // Step:3 为模块加载器配置echarts的路径，从当前页面链接到echarts.js，定义所需图表路径
    require.config({
        paths:{ 
            echarts:'./js/echarts',
            'echarts/chart/bar' : './js/echarts-map',
            'echarts/chart/line': './js/echarts-map'
        }
    });
    
    // Step:4 require echarts and use it in the callback.
    // Step:4 动态加载echarts然后在回调函数中开始使用，注意保持按需加载结构定义图表路径
    // 定义数组
    var label = new Array();
    var value = new Array();
    var value2 = new Array();
    require(
        [
            'echarts',
            'echarts/chart/bar',
            'echarts/chart/line'
        ],
        function (ec) {//回调函数
            //--- 折柱 ---
            var myChart = ec.init(document.getElementById('main'));
            //后台获取数据
            $.ajax({
	        	url:"action.jsp?starttime=<%=starttime%>&endtime=<%=endtime%>",
	        	dataType:"json",
	        	success:function(data){
		        	$.each(data,function(i,p){
		        	    label[i]=p['label'];
		        	    value[i]=p['value'];
		        	    value2[i]=p['value2']
		        	});
		        	//alert('循环后'+label);
		            myChart.setOption({//图形
		                tooltip : {
		                    trigger: 'axis'
		                },
		                legend: {
		                    data:['测试指标1','测试指标2']
		                },
		                toolbox: {
		                    show : true,
		                    feature : {
		                        mark : {show: true},
		                        dataView : {show: true, readOnly: false},
		                        magicType : {show: true, type: ['line', 'bar']},
		                        restore : {show: true},
		                        saveAsImage : {show: true}
		                    }
		                },
		                calculable : true,
		                animation : false,
		                xAxis : [
		                    {
		                        type : 'category',
		                        data : testX(label)
		                    }
		                ],
		                yAxis : [
		                    {
		                        type : 'value',
		                        splitArea : {show : true}
		                    }
		                ],
		                series : [
		                    {
		                        name:'测试指标1',
		                        type:'line',
		                        smooth:true,
		                        itemStyle: {normal: {areaStyle: {type: 'default'}}},
		                        data:testY(),
		                        symbol:'none'
		                    },
		                    {
		                        name:'测试指标2',
		                        type:'line',
		                        smooth:true,
		                        itemStyle: {normal: {areaStyle: {type: 'default'}}},
		                        data:testY2(),
		                        symbol:'none'
		                    }
		                ]
		            },true);//图形展示
					window.onresize = myChart.resize;
	        	}//ajax执行后台
        	}); 
        }
    );
    
    function testX(){
    	return label;
    }
    
    function testY(){
    	//alert(value);
    	return value;
    }
    
    function testY2(){
    	return value2;
    }
    </script>
	</body>
</html>