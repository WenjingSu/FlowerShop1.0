<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>统计表</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	
<script type="text/javascript" src="/FlowerShop1.0/backmanger/js/jquery.js"></script>
<script type="text/javascript" src="/FlowerShop1.0/backmanger/js/highcharts.js"></script>
<script type="text/javascript" src="/FlowerShop1.0/backmanger/js/exporting.js"></script>

<script type="text/javascript">
	 $(function () {
	 var Jan=${a[0]};
    var Feb=${a[1]};
    var Mar=${a[2]};
    var Apr=${a[3]};
    var May=${a[4]};
    var June=${a[5]};
    var July=${a[6]};
    var Aug=${a[7]};
    var Sep=${a[8]};
    var Oct=${a[9]};
    var Nov=${a[10]};
    var Dec=${a[11]};                                                               
    $('#container1').highcharts({                                          
        chart: {                                                          
        },                                                                
        title: {                                                          
            text: '2018年月销量统计'                                     
        },  
		//x轴
        xAxis: {                                                          
            categories: ['1', '2', '3', '4', '5','6','7', '8', '9', '10', '11','12']
        },                                                                
        tooltip: {                                                        
            formatter: function() {                                       
                var s;                                                    
                if (this.point.name) { // the pie chart                   
                    s = ''+                                               
                        this.point.name +': '+ this.y +' fruits';         
                } else {                                                  
                    s = ''+                                               
                        this.x  +': '+ this.y;                            
                }                                                         
                return s;                                                 
            }                                                             
        },                                                                
        labels: {                                                         
            items: [{                                                     
                html: '月销件数',                          
                style: {                                                  
                    left: '40px',                                         
                    top: '8px', 
                                                            
                    color: 'black' 
                                                          
                }                                                         
            }]                                                            
        },                                                                
        series: [{                                                        
            type: 'column',                                               
            name: '商品销量（件）',                                                 
            data: [Jan,Feb,Mar,Apr,May,June,July,Aug,Sep,Oct,Nov,Dec]                                         
        } , {                                                              
            type: 'spline',                                               
            name: '商品销量（件）',                                              
            data: [Jan,Feb,Mar,Apr,May,June,July,Aug,Sep,Oct,Nov,Dec],                               
            marker: {                                                     
            	lineWidth: 2,                                               
            	lineColor: Highcharts.getOptions().colors[3],               
            	fillColor: 'white'                                          
            }                                                             
        }                                                          
        ]                                                                
    }); 
    
    
    
    var n1 =${salesRank[0].total_num};
    //alert(n1);
    var n2=${salesRank[1].total_num};
    var n3=${salesRank[2].total_num};
    var n4=${salesRank[3].total_num};
    var n5=${salesRank[4].total_num};
    
     // var name1=${g_name};
     // alert(name1);
     /* var name2=${salesRank[1].g_name};
    var name3=${salesRank[2].g_name};
    var name4=${salesRank[3].g_name};
    var name5=${salesRank[4].g_name};   */ 
     
    var name1=$("#g_name1").val();
    var name2=$("#g_name2").val();
    var name3=$("#g_name3").val();
    var name4=$("#g_name4").val();
    var name5=$("#g_name5").val();
    $('#container2').highcharts({                                          
        chart: {                                                          
        },                                                                
        title: {                                                          
            text: '热销商品排行榜'                                     
        },  
		//x轴
        xAxis: {                                                          
            categories: ['', '', '', 'Bananas', '']
        },                                                                
        tooltip: {                                                        
            formatter: function() {                                       
                var s;                                                    
                if (this.point.name) { // the pie chart                   
                    s = ''+                                               
                        this.point.name +': '+ this.y +' fruits';         
                } else {                                                  
                    s = ''+                                               
                        this.x  +': '+ this.y;                            
                }                                                         
                return s;                                                 
            }                                                             
        },                                                                
        labels: {                                                         
            items: [{                                                     
                                         
                style: {                                                  
                    left: '40px',                                         
                    top: '8px',                                           
                    color: 'black'                                        
                }                                                         
            }]                                                            
        },                                                                
        series: [ {                                                        
            type: 'column',                                               
            name: name1,                                                 
            data: []                                         
        }, {                                                              
            type: 'column',                                               
            name: name2,                                                 
            data: []                                         
        }, {                                                              
            type: 'column',                                               
            name: name3,                                                  
            data: []                                         
        },{                                                              
            type: 'column',                                               
            name: name4,                                                  
            data: []                                         
        },{                                                              
            type: 'column',                                               
            name: name5,                                                  
            data: []                                         
        }, {                                                              
            type: 'pie',                                                  
            name: 'Total consumption',                                    
            data: [{                                                      
                name: name1,                                             
                y: n1,                                                    
                color: Highcharts.getOptions().colors[0] // Jane's color  
            }, {                                                          
                name: name2,                                             
                y: n2,                                                    
                color: Highcharts.getOptions().colors[1] // John's color  
            }, {                                                          
                name: name3,                                              
                y: n3,                                                    
                color: Highcharts.getOptions().colors[2] // Joe's color   
            },{                                                          
                name: name4,                                              
                y: n4,                                                    
                color: Highcharts.getOptions().colors[3] // Joe's color   
            },{                                                          
                name: name5,                                              
                y: n5,                                                    
                color: Highcharts.getOptions().colors[4] // Joe's color   
            }],                                                           
            center: [360, 180],                                            
            size: 350,                                                    
            showInLegend: false,                                          
            dataLabels: {                                                 
                enabled: false                                            
            }                                                             
        }]                                                                
    });               
    
   
   
     var price1=${priceRank[0].total_price};
     var price2=${priceRank[1].total_price};
     var price3=${priceRank[2].total_price};
     var price4=${priceRank[3].total_price};
     var price5=${priceRank[4].total_price};
     var price6=${priceRank[5].total_price};
     var price7=${priceRank[6].total_price};
     var price8=${priceRank[7].total_price};
     var p_g_name1=$("#p_g_name1").val();
     var p_g_name2=$("#p_g_name2").val();
     var p_g_name3=$("#p_g_name3").val();
     var p_g_name4=$("#p_g_name4").val();
     var p_g_name5=$("#p_g_name5").val();
     var p_g_name6=$("#p_g_name6").val();
     var p_g_name7=$("#p_g_name7").val();
     var p_g_name8=$("#p_g_name8").val();
     
     $('#container3').highcharts({                                          
        chart: {                                                          
        },                                                                
        title: {                                                          
            text: '商品销售金额排行榜'                                     
        },  
		//x轴
        xAxis: {                                                          
            categories: ['']
        },                                                                
        tooltip: {                                                        
            formatter: function() {                                       
                var s;                                                    
                if (this.point.name) { // the pie chart                   
                    s = ''+                                               
                        this.point.name +': '+ this.y +' fruits';         
                } else {                                                  
                    s = ''+                                               
                        this.x  +': '+ this.y;                            
                }                                                         
                return s;                                                 
            }                                                             
        },                                                                
        labels: {                                                         
            items: [{                                                     
                html: '',                          
                style: {                                                  
                    left: '40px',                                         
                    top: '8px',                                           
                    color: 'black'                                        
                }                                                         
            }]                                                            
        },                                                                
        series: [{                                                        
            type: 'column',                                               
            name: p_g_name1,                                                 
            data: [price1]                                         
        }, {                                                              
            type: 'column',                                               
            name: p_g_name2,                                                 
            data: [price2]                                         
        }, {                                                              
            type: 'column',                                               
            name: p_g_name3,                                                  
            data: [price3]                                         
        },{                                                        
            type: 'column',                                               
            name: p_g_name4,                                                 
            data: [price4]                                         
        }, {                                                        
            type: 'column',                                               
            name: p_g_name5,                                                 
            data: [price5]                                         
        }, {                                                        
            type: 'column',                                               
            name: p_g_name6,                                                 
            data: [price6]                                         
        }, {                                                        
            type: 'column',                                               
            name: p_g_name7,                                                 
            data: [price7]                                         
        }, {                                                        
            type: 'column',                                               
            name: p_g_name8,                                                 
            data: [price8]                                         
        }]                                                                
    });             
                                                                      
});                                                                       				         				
</script>

  </head>
 
 
  <body>
<input type="hidden" id="g_name1" value="${salesRank[0].g_name}">
<input type="hidden" id="g_name2" value="${salesRank[1].g_name}">
<input type="hidden" id="g_name3" value="${salesRank[2].g_name}">
<input type="hidden" id="g_name4" value="${salesRank[3].g_name}">
<input type="hidden" id="g_name5" value="${salesRank[4].g_name}">

<input type="hidden" id="p_g_name1" value="${priceRank[0].g_name}">
<input type="hidden" id="p_g_name2" value="${priceRank[1].g_name}">
<input type="hidden" id="p_g_name3" value="${priceRank[2].g_name}">
<input type="hidden" id="p_g_name4" value="${priceRank[3].g_name}">
<input type="hidden" id="p_g_name5" value="${priceRank[4].g_name}">
<input type="hidden" id="p_g_name6" value="${priceRank[5].g_name}">
<input type="hidden" id="p_g_name7" value="${priceRank[6].g_name}">
<input type="hidden" id="p_g_name8" value="${priceRank[7].g_name}">


<div id="container1" style="width:850px;height:500px;margin:0 auto"></div>
<br><br><br>
<div id="container2" style="width:850px;height:500px;margin:0 auto"></div>
<br><br><br>
<div id="container3" style="width:850px;height:500px;margin:0 auto"></div>
  </body>
</html>
