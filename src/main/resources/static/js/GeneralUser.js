var recordList;
var pageInfo;

$(function() {
	showRecord(1);
});

function showRecord(cp) {
	getRecordByCriteria(cp);
	showLeftTable();
	showRrightTable(0);
}

function getRecord(cp) {
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
			alert("fail");
		}
	});
}

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
		error: function() {
			alert("fail");
		}
	});
}

function getRecordByIndex(index) {
	return recordList[index];
}

function gotoPage() {
	var cp = $("#gotoInput").val();
	showRecord(cp);
}

function showPageDiv() {

	$("#pageInfoDiv").empty();

	var pageDiv = "<p>共<i id = 'bian'>" + pageInfo.total + "</i>页记录，当前页共有<i>" + pageInfo.size + "</i>条</p>" +
		"<button class='bt1' onclick=showRecord(" + 1 + ")>首页</button> " +
		"<button class='bt2' onclick=showRecord(" + (pageInfo.pageNum - 1 < 1 ? 1 : pageInfo.pageNum - 1) + ")>上一页</button>" +
		"<input class='page-in' type='text' placeholder='页码' id='gotoInput'>" +
		"<button class='bt3' onclick=gotoPage()>跳转</button>" +
		"<button class='bt4' onclick=showRecord(" + (pageInfo.pageNum + 1 > pageInfo.pages ? pageInfo.pages : pageInfo.pageNum + 1) + ")>下一页</button>" +
		"<button class='bt5' onclick=showRecord(" + pageInfo.pages + ")>尾页</button>" +
		"<span id='localtime'></span>";

	$("#pageInfoDiv").append(pageDiv);
}

function showLeftTable() {
	$("#tbody1").empty();
	$.each(recordList, function(index, item) {
		var tr1 = "<tr class='tr recordTr'  onclick=showRrightTable(" + index + ")>" +
			"<td class='recordTd'>" + item.machineNo + "</td>" +
			"<td class='recordTd'>" + item.pileNo + "</td>" +
			"<td class='recordTd'>" + item.firstWeight + "</td>" +
			"<td class='recordTd'>" + item.secondWeight + "</td>" +
			"<td class='recordTd'>" + item.firstDepth + "</td>" +
			"<td class='recordTd'>" + item.secondDepth + "</td>" +
			"<td class='recordTd'>" + item.sumDepth + "</td>" +
			"<td class='recordTd'>" + item.str_beginTime + "</td>" +
			"<td class='recordTd'>" + item.str_endTime + "</td>" +
			"</tr>";
		$("#tbody1").append(tr1);
	});

	showPageDiv();
}

function showRrightTable(index) {
	var record = getRecordByIndex(index);
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
	$("#TL").append((record.firstWeight + record.secondWeight));
	$("#TH").append(record.sumDepth);
	$("#S1").append(record.firstDepth);
	$("#S2").append(record.secondDepth);
	$("#W1").append(record.firstWeight);
	$("#W2").append(record.secondWeight);

	var weightRecord = record.weightRecord.toString();

	var str = weightRecord.split("#");

	$("#weight_record").empty();

	/*最后一个为空,不需要*/
	for(var i = 0; i < str.length - 1; i++) {

		var M = (i + 1 > 9 ? "0" + (i + 1) : "00" + (i + 1)) + "#";

		var tr1 = "<tr class = 'tr' onclick=showRrightTable(" + index + ")>" +
			"<td>" + record.pileNo + "#</td>" +
			"<td>" + M + "</td>" +
			"<td>" + str[i] + "</td>" +
			"</tr>";

		$("#weight_record").append(tr1);
	}
}

function exportThisPage() {
	if(confirm("确定导出所有数据？")) {
		
		var cp = pageInfo.pageNum;
		var pileNo = $("#pileNo").val();
		var machineNo = $("#machineNo").val();
		var beginTime = $("#beginTime").val();
		var endTime = $("#endTime").val();
		var team = $("#team").val();
		
		 window.location.href=AJAXURL + "/downloadExcelThisPageRecordByCriteria?"+
		                      "cp="+cp+
		                      "&pileNo="+pileNo+
		                      "&machineNo="+machineNo+
		                      "&beginTime="+beginTime+
		                      "&endTime="+endTime+
		                      "&team="+team;
		
	}
}

function exportAll() {
	if(confirm("确定导出所有数据？")) {
	    window.location.href=AJAXURL + "/downloadExcelAllRecordByCriteria";
	}
}