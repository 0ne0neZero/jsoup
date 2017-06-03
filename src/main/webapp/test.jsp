<%@ page language="java" contentType="text/html; charset=UTF-8"  
    pageEncoding="UTF-8"%>  
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">  
<html>  
<head>  
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">  
    <title>ECharts</title>  
    <script type="text/javascript" src="./js/echarts.js"></script>  
    <script type="text/javascript" src="./js/jquery-1.2.6.min.js"></script>  
    <script type="text/javascript">  
        // 配置路径  
        require.config({  
            paths: {  
                echarts: './js/echarts'  
            }  
        });  
          
        // 按需加载  
        require(  
            [  
                'echarts',   
                'echarts/chart/bar',  
                'echarts/chart/line'  
            ],  
            function (ec) {  
                var chart = document.getElementById('chart');  
                var echart = ec.init(chart);  
                  
                echart.showLoading({  
                    text: '正在努力加载中...'  
                });  
                  
                var categories = [];  
                var values = [];  
                  
                // 同步执行  
                $.ajaxSettings.async = false;  
                  
                // 加载数据  
                $.getJSON('${ctx}/dataAccessServlet', function (json) {  
                    categories = json.categories;  
                    values = json.values;  
                });  
                  
                var option = {  
                    tooltip: {  
                        show: true  
                    },  
                    legend: {  
                        data: ['销量']  
                    },  
                    xAxis: [  
                        {  
                            type: 'category',  
                            data: categories  
                        }  
                    ],  
                    yAxis: [  
                        {  
                            type: 'value'  
                        }  
                    ],  
                    series: [  
                        {  
                            'name': '销量',  
                            'type': 'bar',  
                            'data': values  
                        }  
                    ]  
                };  
                  
                echart.setOption(option);  
                echart.hideLoading();  
            }  
        );  
    </script>  
</head>  
<body>  
    <div id="chart" style="width: 580px;height: 420px;margin: 0 auto;border: 1px solid gray;"></div>  
</body>  
</html> 