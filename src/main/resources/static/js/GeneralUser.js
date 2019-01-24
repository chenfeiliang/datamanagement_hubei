
var recordList;

$(function() {
    getRecord();
	showLeftTable();
	showRrightTable(0);
});

function getRecord() {
	$.ajax({
		url: "http://localhost:8080/test?cp=1",
		type: "GET",
		dataType: "json",
		async: false,
		contentType: "application/x-www-form-urlencoded; charset=UTF-8", //防止乱码
		success: function(data) {
			recordList =  data.extend.result.list;
		},
		error: function() {
			alert("fail");
		}
	});
}

function getRecordByIndex(index) {
	return recordList[index];
}

function showLeftTable() {
	$("#tbody1").empty();
	$.each(recordList, function(index, item) {
		var tr1 = "<tr class = 'tr recordTr' onclick=showRrightTable("+index+")>" +
			"<td>" + item.machineNo + "</td>" +
			"<td>" + item.pileNo + "</td>" +
			"<td>" + item.firstWeight + "</td>" +
			"<td>" + item.secondWeight + "</td>" +
			"<td>" + item.firstDepth + "</td>" +
			"<td>" + item.secondDepth + "</td>" +
			"<td>" + item.sumDepth + "</td>" +
			"<td>" + item.str_beginTime + "</td>" +
			"<td>" + item.str_endTime + "</td>" +
			"</tr>";
		$("#tbody1").append(tr1);
	});
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
	$("#TL").append((record.firstWeight+record.secondWeight));
	$("#TH").append(record.sumDepth);
	$("#S1").append(record.firstDepth);
	$("#S2").append(record.secondDepth);
	$("#W1").append(record.firstWeight);
	$("#W2").append(record.secondWeight);
	
	
	
	var weightRecord = record.weightRecord.toString();
	
	var str = weightRecord.split("#");
	
	$("#weight_record").empty();
	
	/*最后一个为空,不需要*/
	for(var i = 0 ; i<str.length-1;i++){
		
		var M = (i+1>9?"0"+(i+1):"00"+(i+1)) + "#";
		
		var tr1 = "<tr class = 'tr recordTr' onclick=showRrightTable("+index+")>" +
			"<td>" + record.pileNo + "</td>" +
			"<td>" + M+ "</td>" +
			"<td>" + str[i]+ "</td>" +
			"</tr>";
		
		$("#weight_record").append(tr1);
	}
	
}
