package com.hubu.service;

import com.hubu.pojo.Record;
import javafx.scene.control.Cell;
import org.apache.poi.hssf.usermodel.*;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.Font;
import org.apache.poi.ss.usermodel.HorizontalAlignment;
import org.apache.poi.ss.util.CellRangeAddress;
import org.apache.poi.ss.util.CellUtil;
import org.apache.poi.xssf.usermodel.XSSFFont;

import javax.servlet.http.HttpServletResponse;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


/**
 * 功能描述:  创建票据表格
 *
 *  Author:   chenfeiliang
 */
public class TicketExcelExport {

    // 第一步，创建一个webbook，对应一个Excel文件
    public HSSFWorkbook generateExcel() {
        return new HSSFWorkbook();
    }
    public HSSFWorkbook generateSheet(HSSFWorkbook wb, String sheetName, List<Record> list) {

        //获取数据
        Record record = list.get(0);

        // 第二步，在webbook中添加一个sheet,对应Excel文件中的sheet
        HSSFSheet sheet = wb.createSheet(sheetName);

        //第三步，设置列宽
        sheet.setColumnWidth(0,2000);

        // 第四步，在sheet中添加表头第0行,注意老版本poi对Excel的行数列数有限制short
        HSSFRow row = sheet.createRow(0);

        //第五步创建字体
        HSSFFont font = (HSSFFont) wb.createFont();
        font.setFontHeightInPoints((short) 16);
        font.setFontName("宋体");

        HSSFFont font2 = (HSSFFont) wb.createFont();
        font2.setFontHeightInPoints((short) 12);
        font2.setFontName("宋体");

        // 第六步，创建样式
        HSSFCellStyle style = wb.createCellStyle();
        style.setAlignment(HorizontalAlignment.LEFT );
        style.setFont(font);

        //声明 列
        HSSFCell cell;

        //设置第0行属性
        cell = row.createCell(0); //生成第0列
        cell.setCellStyle(style);
        cell.setCellValue("WHSKP:2019-1");

        //设置从1行开始每一行属性
        row = sheet.createRow(1);
        cell =  row.createCell(0);
        cell.setCellValue("BH: " + record.getMachineNo() +"    Z:15" );

        //设置从1行开始每一行字体
        cell.getCellStyle().setFont(font2);

        row = sheet.createRow(2);
        cell =  row.createCell(0);

        cell.setCellValue(record.getStr_beginTime());


        row = sheet.createRow(3);
        cell =  row.createCell(0);
        cell.setCellValue(record.getStr_endTime());


        row = sheet.createRow(4);
        cell =  row.createCell(0);
        cell.setCellValue("NO:" + record.getPileNo()+"#");


        row = sheet.createRow(5);
        cell =  row.createCell(0);
        cell.setCellValue("TL:" + (record.getFirstWeight()+record.getSecondWeight()) +"Kg" );

        row = sheet.createRow(6);
        cell =  row.createCell(0);
        cell.setCellValue("TH:" + record.getSumDepth() +"M" );

        row = sheet.createRow(7);
        cell =  row.createCell(0);
        cell.setCellValue("S1:" + "00.0M-"+record.getFirstDepth() +"M" );

        row = sheet.createRow(8);
        cell =  row.createCell(0);
        cell.setCellValue( record.getFirstWeight() +"Kg" );

        row = sheet.createRow(9);
        cell =  row.createCell(0);
        cell.setCellValue("S2:" +"00.0M-"+ record.getSecondDepth() +"M" );

        row = sheet.createRow(10);
        cell =  row.createCell(0);
        cell.setCellValue( record.getSecondWeight()  +"Kg" );

        row = sheet.createRow(11);
        cell =  row.createCell(0);   //设置第11行第0列属性
        cell.setCellValue("NO:");

        cell =  row.createCell(1);   //设置第11行第1列属性
        cell.setCellValue("m");

        cell =  row.createCell(2);    //设置第11行第2列属性
        cell.setCellValue("kg/m");

        //填充每一米下料量
        String weightRecord = record.getWeightRecord();

        String str[] = weightRecord.split("#"); //分隔由#分隔的字段，获取每一米下料量

        //从第12列开始填充
        for (int i = 0 ;i<str.length;i++){
            String M = (i>=10?i+"":"0"+i)+".0";

            row = sheet.createRow(i+12);
            cell =  row.createCell(0);
            cell.setCellValue(record.getPileNo()+"#   ");

            cell =  row.createCell(1);
            cell.setCellValue(M);

            cell =  row.createCell(2);
            cell.setCellValue(str[i]);
        }


        //如果非整数，再加一行
        if((record.getSumDepth()%1)!=0){

            String M  = (record.getSumDepth()  >= 10 ?  String.valueOf(record.getSumDepth()) : "0" + (String.valueOf(record.getSumDepth())));

            row = sheet.createRow(str.length+12);

            cell =  row.createCell(0);
            cell.setCellValue(record.getPileNo()+"#   ");

            cell =  row.createCell(1);
            cell.setCellValue(M);

            cell =  row.createCell(2);
            cell.setCellValue("000");
        }



        //合并 第 i 行 的 0到2列
        CellRangeAddress  region[] = new CellRangeAddress[11];

        for (int i = 0 ;i<11;i++){
            region[i] = new CellRangeAddress(i, (short)i, 0, (short)2);
            sheet.addMergedRegion(region[i]);
        }
        return wb;
    }

    public void export(HSSFWorkbook wb, HttpServletResponse response) throws IOException {

        // 第六步，实现文件下载保存

        String title = "票据"+System.currentTimeMillis();

        response.setHeader("content-disposition", "attachment;filename="
                + URLEncoder.encode(title, "utf-8") + ".xls");
        OutputStream out = response.getOutputStream();
        ByteArrayOutputStream baos = new ByteArrayOutputStream();

        //把表格转成流写进baos并转成字节数组
        wb.write( baos);
        byte[] xlsBytes = baos .toByteArray();

        //response输出xlsBytes
        out.write( xlsBytes);
        out.close();
    }
}
