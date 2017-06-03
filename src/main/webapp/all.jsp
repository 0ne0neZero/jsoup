<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<link rel="shortcut icon" href="./asset/ico/favicon.png">
<script src="./js/esl.js"></script>
<title>中国人口流动大潮</title>
<style type="text/css">
* {
    font-family: "Microsoft YaHei" !important;
}
h1 {
    font-family: "Microsoft YaHei";
    font-weight: bold;
    color: #FFF;
    background-color: #000;
    border: 5px none #000;
    background-image: url(./asset/img/tweed.png);
    background-repeat: repeat;
    padding-right: 15px;
    padding-bottom: 15px;
    padding-left: 15px;
    padding-top: 15px;
}

p {
    padding: 0 15px;
}
    
.select_box {
    border-top-width: 1px;
    border-top-style: dashed;
    border-top-color: #699;
    padding-top: 15px;
    padding-bottom: 15px;
    padding-right: 15px;
    padding-left: 15px;
}
body {
    background-image: url(./asset/img/ticks.png);
    background-repeat: repeat;
    margin-left: 0px;
    margin-top: 0px;
    margin-right: 0px;
    margin-bottom: 0px;
}

#main{
    background-image: url(./asset/img/groovepaper.png);
    background-repeat: repeat;    
    }

.footer {
    height: 100px;
    background-image: url(./asset/img/tweed.png);
    background-repeat: repeat;
    font-family: "Microsoft YaHei";
    font-size: 14px;
    color: #CCC;
    text-align: center;
    padding-top: 1px;
}
.footer a:hover {
    color:#62C462
}
</style>
</head>

<body>
<h1>百合网注册分布图（单位：万人）</h1>
<p></p>
<p></p>
<div class="select_box"><form id="form1" name="form1" method="post" action="">
  <label for="year">请选择年份</label>
  <select name="year" id="year">
    <option>1987</option>
    <option>1988</option>
    <option>1989</option>
    <option>1990</option>
    <option>1991</option>
    <option>1992</option>
    <option>1993</option>
    <option>1994</option>
    <option>1995</option>
    <option>1996</option>
    <option>1997</option>
    <option>1998</option>
    <option>1999</option>
    <option>2000</option>
    <option>2001</option>
    <option>2002</option>
    <option>2003</option>
    <option>2004</option>
    <option>2005</option>
    <option>2006</option>
    <option>2007</option>
    <option>2008</option>
    <option>2009</option>
    <option>2010</option>
    <option selected="selected">2011</option>
  </select>
</form></div>

<div id="main" style="height:500px;border:1px solid #ccc;padding:20px;"></div>
    <script src="js/data-people.js"></script>
    <script type="text/javascript">
    var fileLocation = './js/echarts-map';
    require.config({
        paths:{ 
            echarts:fileLocation,
            'echarts/chart/bar' : fileLocation,
            'echarts/chart/line': fileLocation,
            'echarts/chart/line': fileLocation,
            'echarts/chart/bar': fileLocation,
            'echarts/chart/scatter': fileLocation,
            'echarts/chart/k': fileLocation,
            'echarts/chart/pie': fileLocation,
            'echarts/chart/radar': fileLocation,
            'echarts/chart/map': fileLocation,
            'echarts/chart/chord': fileLocation,
            'echarts/chart/force': fileLocation
        }
    });
    var myChart;
    var colorList;
    require(
        [
            'echarts',
            'echarts/chart/bar',
            'echarts/chart/line',
            'echarts/chart/map'
        ],
        function(ec) {
            colorList = require('zrender/tool/color').getGradientColors(
                ['red','yellow','lightskyblue'], 10
            );
            //console.log(colorList)
            myChart = ec.init(document.getElementById('main'));
            //myChart.setOption(option);
            yearSelector.onchange();
            window.onresize = myChart.resize;
            var ecConfig = require('echarts/config');
            myChart.on(ecConfig.EVENT.MAP_SELECTED, mapSelected);
        }
    );
    
    var selected;
    function mapSelected(param){
        selected = param.selected;
        var mapSeries = option.series[0];
        var data = [];
        var legendData = [];
        var legendData = [];
        var name;
        option.series = option.series.slice(0,1);
        for (var p = 0, len = mapSeries.data.length; p < len; p++) {
            name = mapSeries.data[p].name;
            mapSeries.data[p].selected = selected[name];
            if (selected[name]) {
                //option.yAxis[0].name = name + ' 人口流动情况';
                var tarIdx;
                for (var i = 0, l = pList.length; i < l; i++) {
                    if (pList[i] == name) {
                        tarIdx = i;
                        break;
                    }
                }
                for (var i = 1987; i <= 2011; i++) {
                    data.push(dataPeople[i][tarIdx]);
                }
                option.series.push({
                    name : name,
                    type:'line',
                    tooltip: {
                        trigger: 'axis'
                    },
                    data: data
                });
                legendData.push(name);
                data = [];
            }
        }
        //option.series[1].data = data;
        option.legend.data = legendData;
        myChart.setOption(option, true);
    }
    
    var yearSelector = document.getElementById('year');
    yearSelector.onchange = function(e){
        var curYear = yearSelector.selectedOptions[0].innerHTML;
        option.title.text = '中国人口流动图示 (' + curYear + ')';
        var max = dataPeople[curYear + 'max'];
        var min = dataPeople[curYear + 'min'];
        var gap = (max - min) / 5;
        /*
        var legendData = [
            Math.round(min + 4 * gap) + '以上',
            Math.round(min + 3 * gap) + ' ~' + Math.round(min + 4 * gap),
            Math.round(min + 2 * gap) + ' ~' + Math.round(min + 3 * gap),
            Math.round(min + gap) + ' ~' + Math.round(min + 2 * gap),
            Math.round(min + gap) + '以下',
        ];
        option.legend.data = legendData;
        */
        option.dataRange.max = max;
        option.dataRange.min = min;
        if (min >= 0) {
            //双正
            option.dataRange.color = [colorList[0], colorList[10]];
            /*
            option.color = require('zrender/tool/color').getStepColors(
                colorList[0], colorList[10], 5
            )
            */
            //option.color = [colorList[0], colorList[2], colorList[4], colorList[7], colorList[10]];
        }
        else if (max >= 0 && min <= 0) {
            //正负
            var first = Math.round(10 - max / (max - min) * 10);
            var end = Math.round(min / (min - max) * 10 + 10);
            option.dataRange.color = [
                colorList[first], 
                colorList[Math.round((end - first) / 2 + first)],
                colorList[end]
            ];
            //console.log(first,end);
            /*
            option.color = [
                colorList[first], colorList[first + 2], 
                option.dataRange.color[1], 
                colorList[end - 2], colorList[end]
            ];
            */
        }
        else {
            //双负
            option.dataRange.color = [colorList[11], colorList[20]];
            /*
            option.color = require('zrender/tool/color').getStepColors(
                colorList[11], colorList[20], 5
            )
            */
            //option.color = [colorList[11], colorList[13], colorList[15], colorList[17], colorList[20]];
        }
        //console.log(option.color,option.dataRange.color)
        
        option.series[0].data = dataPeople[curYear];
        /*
        for (var i = 0; i <= 4; i++) {
            option.series[i + 1].name = legendData[i];
        }
        */
        if (selected) {
            mapSelected({selected:selected});
        }
        else{
            myChart.setOption(option, true);
        }
    }
    </script>
</body>
</html>
