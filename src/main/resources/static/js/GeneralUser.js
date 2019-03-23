var recordList;
var pageInfo;

$(function() {
	initBarDiagram();
	initBarDiagramTwo()
	showRecord(1);


});


function showRecord(cp) {
	getRecordByCriteria(cp);
	showLeftTable();
	showRrightTable(0);
}

/*function getRecord(cp) {
	$.ajax({
		url: AJAXURL + "/getRecordWithPage",
		type: "GET",
		dataType: "json",
		data: {
			"cp": cp
		},
		async: false,
		contentType: "application/x-www-form-urlencoded; charset=UTF-8", //防止乱码
		success: function(data) {
			recordList = data.extend.result.list;
			pageInfo = data.extend.result;
		},
		error: function() {
			//alert("fail");
		}
	});
}*/

function getRecordByCriteria(cp) {
	var pileNo = $("#pileNo").val();
	var machineNo = $("#machineNo").val();
	var beginTime = $("#beginTime").val();
	var endTime = $("#endTime").val();
	var team = $("#team").val();

	$.ajax({
		url: AJAXURL + "/getRecordWithPageByCriteria",
		type: "GET",
		dataType: "json",
		data: {
			"cp": cp,
			"machine_no": machineNo,
			"pile_no": pileNo,
			"beginTime": beginTime,
			"endTime": endTime,
			"team": team
		},
		async: false,
		contentType: "application/x-www-form-urlencoded; charset=UTF-8", //防止乱码
		success: function(data) {
			recordList = data.extend.result.list;
			pageInfo = data.extend.result;
		},
		error: function(obj) {	
			alert("fair");
		}
	});
}

function getRecordByIndex(index) {
	return recordList[index];
}

function gotoPage() {
	var cp = $("#gotoInput").val();
	if(cp==""||cp==null){
		cp = 1;
	}
	showRecord(cp);
}

function showPageDiv() {

	$("#pageInfoDiv").empty();

	var pageDiv = "<p>共有<i id = 'bian'>" + pageInfo.total + "</i>条记录，分<i>" + pageInfo.pages + "</i>页,当前页为第<i>" + pageInfo.pageNum + "</i>页</p>" +
		"<button class='bt1' onclick=showRecord(" + 1 + ")>首页</button> " +
		"<button class='bt2' onclick=showRecord(" + (pageInfo.pageNum - 1 < 1 ? 1 : pageInfo.pageNum - 1) + ")>上一页</button>" +
		"<input class='page-in' type='text' placeholder='页码' id='gotoInput'>" +
		"<button class='bt3' onclick=gotoPage()>跳转</button>" +
		"<button class='bt4' onclick=showRecord(" + (pageInfo.pageNum + 1 > pageInfo.pages ? pageInfo.pages : pageInfo.pageNum + 1) + ")>下一页</button>" +
		"<button class='bt5' onclick=showRecord(" + pageInfo.pages + ")>尾页</button>" +
		"<button class='bt6' onclick=showRecord("+1+")>刷新数据</button>"+
		"<span id='localtime'></span>"	
		;

	$("#pageInfoDiv").append(pageDiv);
}

function showLeftTable() {

	$("#tbody1").empty();
	$.each(recordList, function(index, item) {
		var tr1 = "<tr class='tr recordTr'  onclick=showRrightTable(" + index + ")>" +
			"<td class='recordTd'>" + item.machineNo + "</td>" +
			"<td class='recordTd'>" + item.pileNo + "</td>" +
            "<td class='recordTd'>" + item.firstDepth + "</td>" +
			"<td class='recordTd'>" + item.firstWeight + "</td>" +
			"<td class='recordTd'>" + item.secondDepth + "</td>" +
			"<td class='recordTd'>" + item.secondWeight + "</td>" +
			"<td class='recordTd'>" + item.sumDepth + "</td>" +
			"<td class='recordTd'>" + item.str_beginTime + "</td>" +
			"<td class='recordTd'>" + item.str_endTime + "</td>" +
			"</tr>";
		$("#tbody1").append(tr1);
	});

	showPageDiv();
}

function printPDF(){
	//alert("ok")
    var iframe=document.getElementById("print-iframe");
    if(!iframe){  
            var el1 = document.getElementById("prinDiv1");
            var el2 = document.getElementById("prinDiv2");
            iframe = document.createElement('IFRAME');
            var doc = null;
            iframe.setAttribute("id", "print-iframe");
            iframe.setAttribute('style', 'position:absolute;width:0px;height:0px;left:-500px;top:-500px;');
           
            document.body.appendChild(iframe);
            doc = iframe.contentWindow.document;
                       
                       
            //这里可以自定义样式
           //  doc.write("<link rel='stylesheet' type='text/css' href='css/print.css'>");
			  
            doc.write("<div id = 'prinDIV1'>" + el1.innerHTML + '</div>');
            doc.write("<div id = 'prinDIV2'>" + el2.innerHTML + '</div>');
      
      		var spans = doc.getElementsByTagName("span");
      		
            var prinDIV1 = doc.getElementById("prinDIV1");
            var prinDIV2 = doc.getElementById("prinDIV2");
            
            prinDIV1.style.width="30%";
            prinDIV2.style.width="30%";
            
            prinDIV1.style.lineHeight="5px";
            prinDIV1.style.fontFamily="宋体";
            
            prinDIV2.style.lineHeight="5px";
            prinDIV2.style.fontFamily="宋体";
            
            var title = doc.getElementById("Ptitle");
            title.style.width="70%";
            title.style.fontSize="20px";
            title.style.fontWeight="300";
            
            var ptds = doc.getElementsByClassName("pileNoTd");
    	
            for(var i = 0 ; i < ptds.length; i++ ){
            	ptds[i].style.textAlign="left";
            	ptds[i].style.paddingRight="20px";
            }

            var mtds = doc.getElementsByClassName("MTd");
            for(var i = 0 ; i < mtds.length; i++ ){
            	mtds[i].style.textAlign="center";
            	mtds[i].style.paddingRight="20px";
            }
            
            var kgmtds = doc.getElementsByClassName("KGMTd");
            for(var i = 0 ; i < kgmtds.length; i++ ){
            	kgmtds[i].style.textAlign="right";
            	kgmtds[i].style.paddingRight="20px";
            }
            doc.close();
          
            iframe.contentWindow.focus();   
        

            
           // alert(iframe.contentWindow.document.getElementById("prinDIV1").style.fontSize);
         //   alert(iframe.contentWindow.document.getElementsByTagName('html')[0].innerHTML);
    }
 
    iframe.contentWindow.print();
    if (navigator.userAgent.indexOf("MSIE") > 0){
        document.body.removeChild(iframe);
    }
}

function showRrightTable(index) {

	var record = getRecordByIndex(index);
	
	$("#exportTicketExcelBT").attr("onclick","exportTicketExcelById("+record.recordNo+")");
	$("#printTicketPDFBT").attr("onclick","printPDF()");
	$("#BH").html("");
	$("#Z").html("");
	$("#beginTimeRright").html("");
	$("#endTimeRright").html("");
	$("#NO_up").html("");
	$("#TL").html("");
	$("#TH").html("");
	$("#S1").html("");
	$("#S2").html("");
	$("#W1").html("");
	$("#W2").html("");

	$("#BH").append(record.machineNo);
	$("#Z").append(15);
	$("#beginTimeRright").append(record.str_beginTime);
	$("#endTimeRright").append(record.str_endTime);
	$("#NO_up").append(record.pileNo);
	
	$("#TL").append(saveIntForN(record.secondWeight,4)+"Kg");
	$("#TH").append(formatDepth(record.sumDepth.toString())+"M");

	$("#S1").append(formatDepth(record.firstDepth.toString()));
	$("#S2").append(formatDepth(record.secondDepth.toString()));
	$("#W1").append(saveIntForN(record.firstWeight,4));
	$("#W2").append(saveIntForN(record.secondWeight,4));

	var weightRecord = record.weightRecord.toString();

	var str = weightRecord.split("#");

	$("#weight_record").empty();

	var xValue = [];

	for(var i = 0; i < str.length - 1; i++) {
		xValue.push((i) + "米");
	}

	showBarDiagram(xValue, str);

	/*最后一个为空,不需要*/
	for(var i = 0; i < str.length - 1; i++) {

		var M = (i  >= 10 ?  i : "0" + (i)) + ".0";

		var tr1 = "<tr class = 'tr'>" +
			"<td class='pileNoTd'>" + record.pileNo + "#</td>" +
			"<td class='MTd'>" + M + "</td>" +
			"<td class='KGMTd'>" + str[i] + "</td>" +
			"</tr>";

		$("#weight_record").append(tr1);

	}
	
		if((record.sumDepth%1)!=0){
		    var M2 = record.sumDepth.toFixed(1);
		    M2 = (M2  >= 10 ?  M2 : "0" + (M2));
			var tr2 = "<tr class = 'tr'>" +
			"<td class='pileNoTd'>" + record.pileNo + "#</td>" +
			"<td class='MTd'>" + M2 + "</td>" +
			"<td class='KGMTd'>" + "000" + "</td>" +
			"</tr>";
			$("#weight_record").append(tr2);
	}
		
		
		
		

}

function saveIntForN(target,n)
{
	target = target.toString();
	var tempN = target.length;
	if(tempN>=n){
		return target;
	}else{
		for(var i = 0 ;i<n-tempN;i++){
			target = "0" + target;
		}
		return target;
	}
}

function formatDepth(depth){
	if(depth==0){
		return "00.0";
	}
	var str = depth.split('.');
	var result = saveIntForN(str[0],2)+"."+str[1];	
	return result;
}

function showBarDiagram(xValue, seriesData) {
	// 基于准备好的dom，初始化echarts实例
	var myChart = echarts.init(document.getElementById('main'));

	// 指定图表的配置项和数据
	option = {
		xAxis: [{
			data: xValue
				/*
				function (){
						var list = [];
						for(var i = 0;i<10;i++){
							list.push('0' +  '.' + i + '米');
						}
						return list;
				}()
				*/
		}],
		series: [{
			//初始数据
			data: seriesData
		}]
	};

	myChart.setOption(option);
}

function exportThisPage() {
	if(confirm("确定导出本页数据？")) {

		var cp = pageInfo.pageNum;
		var pileNo = $("#pileNo").val();
		var machineNo = $("#machineNo").val();
		var beginTime = $("#beginTime").val();
		var endTime = $("#endTime").val();
		var team = $("#team").val();

		window.location.href = AJAXURL + "/downloadExcelThisPageRecordByCriteria?" +
			"cp=" + cp +
			"&pileNo=" + pileNo +
			"&machineNo=" + machineNo +
			"&beginTime=" + beginTime +
			"&endTime=" + endTime +
			"&team=" + team;

	}
}

function exportTicketExcelById(id) {
	if(confirm("确定导出票据？")) {
		window.location.href = AJAXURL + "/downloadTicketExcelById?" +"id=" + id
	}
}

function exportTicketPDFById(id) {
		$.ajax({
		url: AJAXURL + "/downloadTicketPDFById",
		type: "GET",
		data: {
			"id": id
		},
		contentType: "application/x-www-form-urlencoded; charset=UTF-8", //防止乱码
		success: function() {
			alert("打印成功");
		},
		error: function() {
			alert("fail");
		}
	});
/*	if(confirm("确定打印票据？")) {
		window.location.href = AJAXURL + "/downloadTicketPDFById?" +"id=" + id
	}*/
}



function exportAll() {
	if(confirm("确定导出所有数据？")) {
		
		var pileNo = $("#pileNo").val();
		var machineNo = $("#machineNo").val();
		var beginTime = $("#beginTime").val();
		var endTime = $("#endTime").val();
		var team = $("#team").val();

		window.location.href = AJAXURL + "/downloadExcelAllRecordByCriteria?" +
			"&pileNo=" + pileNo +
			"&machineNo=" + machineNo +
			"&beginTime=" + beginTime +
			"&endTime=" + endTime +
			"&team=" + team;

	}
}

function initBarDiagram() {
	// 基于准备好的dom，初始化echarts实例
	var myChart = echarts.init(document.getElementById('main'));

	var ecConfig = echarts.config;

	// 指定图表的配置项和数据
	option = {
		title: {
			//主标题文本，'\n'指定换行
			text: '每米下料详情',
			textStyle: {
				color: '#fff'
			},
			//水平安放位置，默认为左侧，可选为：'center' | 'left' | 'right' | {number}（x坐标，单位px）
			x: 'center',
			//垂直安放位置，默认为全图顶端，可选为：'top' | 'bottom' | 'center' | {number}（y坐标，单位px）
			y: 'top'
		},
		backgroundColor: 'transparent',
		tooltip: {
			trigger: 'item',
			axisPointer: { // 坐标轴指示器，坐标轴触发有效
				type: 'shadow' // 默认为直线，可选为：'line' | 'shadow'
			},
			padding: 10,
			formatter: function(params) {
				return params.name + '</br>' + '水泥用量：' + params.value + '千克' + '</br>'
			}
		},
		//				    legend: {
		//						    //显示策略，可选为：true（显示） | false（隐藏），默认值为true
		//						    show: true,
		//						    //水平安放位置，默认为全图居中，可选为：'center' | 'left' | 'right' | {number}（x坐标，单位px）
		//						    x: 'center',
		//						    //垂直安放位置，默认为全图顶端，可选为：'top' | 'bottom' | 'center' | {number}（y坐标，单位px）
		//						    y: 'top',
		//						},
		//工具箱，每个图表最多仅有一个工具箱
		toolbox: {
			right: 5,
			top: 5,
			//显示策略，可选为：true（显示） | false（隐藏），默认值为false
			show: true,
			//启用功能，目前支持feature，工具箱自定义功能回调处理
			feature: {
				//辅助线标志
				mark: {
					show: true
				},
				//dataZoom，框选区域缩放，自动与存在的dataZoom控件同步，分别是启用，缩放后退
				dataZoom: {
					show: true,
					//		        iconStyle: {
					//		            		borderColor: 'green'
					//		            },
					title: {
						dataZoom: '区域缩放',
						dataZoomReset: '区域缩放后退'
					}
				},
				//数据视图，打开数据视图，可设置更多属性,readOnly 默认数据视图为只读(即值为true)，可指定readOnly为false打开编辑功能
				dataView: {
					show: true,
					readOnly: true
				},
				//magicType，动态类型切换，支持直角系下的折线图、柱状图、堆积、平铺转换
				magicType: {
					show: true,
					type: ['line', 'bar']
				},
				//restore，还原，复位原始图表
				restore: {
					show: true
				},
				//saveAsImage，保存图片（IE8-不支持）,图片类型默认为'png'
				saveAsImage: {
					show: true
				}
			}
		},
		calculable: true,
		xAxis: [{
			type: 'category',
			axisLine: {
				show: true,
				lineStyle: {
					color: '#DDDDDD',
					width: 0
				}
			},
			splitLine: {
				show: false
			},
			axisTick: {
				show: true
			},
			axisLabel: {
				show: true,
				textStyle: {
					color: '#999'
				}
			},
			//初始数据
			data: []
		}],
		yAxis: [{
			type: 'value',
			name: '下料重量（kg/m）',
			nameTextStyle: {
				color: 'rgb(0, 252, 255)'
			},
			axisLabel: {
				formatter: '{value} kg',
				textStyle: {
					color: 'orange'
				}
			},
			axisLine: {
				show: true,
				lineStyle: {
					color: '#DDDDDD',
					width: 1
				}
			},
			splitLine: {
				show: false
			}
		}],
		grid: {
			left: '3%',
			right: '5%',
			top: '20%',
			bottom: '1%',
			containLabel: true
		},
		series: [{
			//      				name: '指标',
			type: 'bar',
			// barWidth: 20,
			itemStyle: {
				normal: {
					label: {
				                show: true,
				                textStyle: {
				                    fontWeight: 'bolder',
				                    fontSize: '12',
				                    fontFamily: '微软雅黑',
				                    shadowColor: 'transparent',
				                    color: '#18F9F3'
				                },
				                position: 'top'
				            },
					barBorderRadius: 5,
					color: function(params) {
						var colorList = [ //柱子颜色
							'#C1232B', '#B5C334', '#FCCE10', '#E87C25', '#27727B',
							'#FE8463', '#9BCA63', '#FAD860', '#F3A43B', '#60C0DD',
							'#D7504B', '#C6E579', '#F4E001'
						];
						return colorList[params.dataIndex]
					}
				},
				emphasis: {
					barBorderRadius: 5
				}
			},
			//系列中的数据标注内容
			markPoint: {
				data: [{
					type: 'max',
					name: '最大值'
				}, {
					type: 'min',
					name: '最小值'
				}, {
					type: 'value', 
					name: '数值'
				}],
				symbolOffset: [0,'-30%']
			},
			//系列中的数据标线内容
			markLine: {
				data: [{
					type: 'average',
					name: '平均值'
				}]
			},
			//初始数据
			data: []
		}]
	};

	myChart.setOption(option);

	//单击某个柱子时获取数值
	myChart.on('click', function(params) {
		//alert(params.value); 
		var sum = params.value;
		var TransferData = [0,0,0,0,0,0,0,0,0,0];
		var average = 0;
		var rem = 0;
		var i = 0;
		var j = 0;
		var p = 0;
		var q = 0;
		var temp = 0;
		
		//增值映射表，用于校正和值与数据和的差值
		var index = 
		[
			[0,0,0,0,0,0,0,0,0,0],
			[0,0,0,0,0,0,1,0,0,0],
			[0,0,0,1,0,0,0,1,0,0],
			[0,1,0,0,0,1,0,0,0,1],
			[0,1,0,0,0,1,0,1,0,1],
			[1,0,1,0,0,1,1,0,1,0],
			[1,1,0,1,0,1,0,1,0,1],
			[0,1,1,1,0,1,0,1,1,1],
			[1,1,1,1,1,0,1,0,1,1],
			[1,1,1,1,1,1,1,1,0,1]
		];
		//平均数
		average = sum/10 - (sum/10)%(1);
		//余数
		rem = sum - average*10;
		//数据增减处理
		TransferData[0] = average + (average*1)/6;
		TransferData[1] = average + (average*2)/7;
		TransferData[2] = average + (average*3)/8;
		TransferData[3] = average + (average*4)/9;
		TransferData[4] = average + (average*5)/10;
		TransferData[5] = average - (average*4)/9;
		TransferData[6] = average - (average*3)/8;
		TransferData[7] = average - (average*2)/7;
		TransferData[8] = average - (average*1)/6;
		//TransferData取整
		for(i=0; i<9; i++)
		{
			TransferData[i] = TransferData[i] - TransferData[i]%1;
		}
		//校正数据和
		TransferData[9] = average*10 - TransferData[0] - TransferData[1] - TransferData[2] - TransferData[3] - 
						  TransferData[4] - TransferData[5] - TransferData[6] - TransferData[7] - TransferData[8];
		//增值校正
		for(i=0; i<10; i++)
		{
			TransferData[i] += index[rem][i];
		}
		//alert("average=" + average + "," + "rem=" + rem);
		//根据余数选择排序
		for(j=rem+3; j>0; j--)
		{
			p=(rem+5)%10;
			q=(rem+8)%10;
			temp=TransferData[p];
			TransferData[p]=TransferData[q];
			TransferData[q]=temp;
			rem +=2;
		}
		/*
		alert("TransferData-array" + "=" + TransferData[0] + "," + TransferData[1] + "," + TransferData[2] + "," + 
				TransferData[3] + "," + TransferData[4] + "," + TransferData[5] + "," + TransferData[6] + "," + 
				TransferData[7] + "," + TransferData[8] + "," + TransferData[9]);*/
				
		//处理好TransferData，设置右边条形图的数值
	    showBarDiagramTwo(TransferData);
	});

}

function initBarDiagramTwo(){
	        // 基于准备好的dom，初始化echarts实例
        var myChart = echarts.init(document.getElementById('main-two'));
		
        // 指定图表的配置项和数据
		option = {
			title: {
	        	//主标题文本，'\n'指定换行
	            text: '每0.1米下料详情',
	            textStyle:{
	            	color: '#fff'
	            },
	            //水平安放位置，默认为左侧，可选为：'center' | 'left' | 'right' | {number}（x坐标，单位px）
				x: 'center',
				//垂直安放位置，默认为全图顶端，可选为：'top' | 'bottom' | 'center' | {number}（y坐标，单位px）
				y: 'top'
			},
			backgroundColor:'transparent',
			tooltip: {
				trigger: 'item',
				axisPointer: { // 坐标轴指示器，坐标轴触发有效
					type: 'shadow' // 默认为直线，可选为：'line' | 'shadow'
				},
				padding: 10,
				formatter: function(params) {
					return params.name + '</br>' + '水泥用量：' + params.value + '千克' + '</br>'
				}
			},
//				    legend: {
//						    //显示策略，可选为：true（显示） | false（隐藏），默认值为true
//						    show: true,
//						    //水平安放位置，默认为全图居中，可选为：'center' | 'left' | 'right' | {number}（x坐标，单位px）
//						    x: 'center',
//						    //垂直安放位置，默认为全图顶端，可选为：'top' | 'bottom' | 'center' | {number}（y坐标，单位px）
//						    y: 'top',
//						},
						//工具箱，每个图表最多仅有一个工具箱
			toolbox: {
				right: 5,
				top: 5,
				//显示策略，可选为：true（显示） | false（隐藏），默认值为false
				show: true,
				//启用功能，目前支持feature，工具箱自定义功能回调处理
				feature: {
					//辅助线标志
					mark: {show: true},
					//dataZoom，框选区域缩放，自动与存在的dataZoom控件同步，分别是启用，缩放后退
					dataZoom: {
						show: true,
					//		        iconStyle: {
					//		            		borderColor: 'green'
					//		            },
						title: {
							dataZoom: '区域缩放',
							dataZoomReset: '区域缩放后退'
						}
					},
					//数据视图，打开数据视图，可设置更多属性,readOnly 默认数据视图为只读(即值为true)，可指定readOnly为false打开编辑功能
					dataView: {show: true, readOnly: true},
					//magicType，动态类型切换，支持直角系下的折线图、柱状图、堆积、平铺转换
					magicType: {show: true, type: ['line', 'bar']},
					//restore，还原，复位原始图表
					restore: {show: true},
					//saveAsImage，保存图片（IE8-不支持）,图片类型默认为'png'
					saveAsImage: {show: true}
				}
			},
			calculable : true,
			xAxis : [
				{
					type : 'category',
					axisLine:{
						show:true,
						lineStyle:{
							color:'#DDDDDD',
							width:0
						}
					},
					splitLine:{
						show:false
					},
					axisTick:{
						show:true
					},
					axisLabel:{
						show:true,
						textStyle:{
							color:'#999'
							}
					},
				  data: function (){
							var list = [];
							for(var i = 0;i<10;i++){
								list.push('0' +  '.' + i + '米');
								//list.push(i +  '-' + (i+1) + 'dm');
							}
							return list;
						}()
				}
			],
			yAxis : [
				{
					type : 'value',
					name : '下料重量（kg/0.1m）',
					nameTextStyle: {
						color: 'rgb(0, 252, 255)'
					},
					axisLabel : {
						formatter: '{value} kg',
						textStyle: {
							color: 'orange'
						}
					},
					axisLine:{
						show:true,
						lineStyle:{
							color:'#DDDDDD',
							width:1
						}
					},
					splitLine:{
						show:false
					}
				}
			],
//				    grid: {
//				        x: 45,
//				        x2: 15,
//				        y: 25,
//				        y2: 15,
//				        backgroundColor:'#fff',
//				        borderWidth: 0
//				    },
			grid: {
			  left: '4%',
			  right: '5%',
			  top:'20%',
			  bottom: '1%',
			  containLabel: true
			},
			series: [{
				//name: '指标',
				type: 'bar',
				// barWidth: 20,
				itemStyle:{
					normal:{
						label: {
				                show: true,
				                textStyle: {
				                    fontWeight: 'bolder',
				                    fontSize: '12',
				                    fontFamily: '微软雅黑',
				                    shadowColor: 'transparent',
				                    color: '#18F9F3'
				                },
				                position: 'top'
				            },
						barBorderRadius: 5,
						color: function(params) {
							var colorList = [     //柱子颜色
								'#C1232B','#B5C334','#FCCE10','#E87C25','#27727B',
								'#FE8463','#9BCA63','#FAD860','#F3A43B','#60C0DD',
								'#D7504B','#C6E579','#F4E001'
							];
							return colorList[params.dataIndex]
						}
					},
					emphasis:{
						barBorderRadius: 5
					}
				},
				//系列中的数据标注内容
				markPoint: {
					data: [
						{type: 'max', name: '最大值'},
						{type: 'min', name: '最小值'},
						{type: 'value', name: '数值'}
					],
					symbolOffset: [0,'-30%']
				},
				//系列中的数据标线内容
				markLine: {
					data: [
						{type: 'average', name: '平均值'}
					]
				},
				//初始数据
				data:[
					{value: 0},
					{value: 0},
					{value: 0},
					{value: 0},
					{value: 0},
					{value: 0},
					{value: 0},
					{value: 0},
					{value: 0},
					{value: 0},
					{value: 0}
				]
			}]
		};
		
        // 使用刚指定的配置项和数据显示图表。
        myChart.setOption(option);	
		
        //echart自适应
        var worldMapContainer = document.getElementById('main-two');
		//用于使chart自适应高度和宽度,通过窗体高宽计算容器高宽
		var resizeWorldMapContainer = function () {
			var owidth=window.innerWidth*0.8;
			worldMapContainer.style.width = window.innerWidth-owidth+'px';
		};
		//设置容器高宽
		resizeWorldMapContainer();

		//浏览器大小改变时重置大小
		window.addEventListener("resize",function(){
			//重置容器高宽
			resizeWorldMapContainer();
			dayGaugeMyChart.resize();
		});
}

function showBarDiagramTwo(seriesData) {
	// 基于准备好的dom，初始化echarts实例
	var myChart = echarts.init(document.getElementById('main-two'));

	// 指定图表的配置项和数据
	option = {
		series: [{
			//初始数据
			data: seriesData
		}]
	};

	myChart.setOption(option);
}



