package com.hubu.service;
import java.io.ByteArrayOutputStream;
import java.io.OutputStream;
import java.net.URLEncoder;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import com.hubu.pojo.Record;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.HorizontalAlignment;


/**
 * 创建excel表格并返回给前台
 * @author Administrator
 *
 */
public class ExcelExport {

    // 第一步，创建一个webbook，对应一个Excel文件
    public HSSFWorkbook generateExcel() {
        return new HSSFWorkbook();
    }
    public HSSFWorkbook generateSheet(HSSFWorkbook wb, String sheetName, String[] fields, List<Record> list) {

        // 第二步，在webbook中添加一个sheet,对应Excel文件中的sheet
        HSSFSheet sheet = wb.createSheet(sheetName);
        // 第三步，在sheet中添加表头第0行,注意老版本poi对Excel的行数列数有限制short
        HSSFRow row = sheet.createRow(0);
        // 第四步，创建单元格，并设置值表头 设置表头居中
        HSSFCellStyle style = wb.createCellStyle();

        style.setAlignment(HorizontalAlignment.CENTER); // 创建一个居中格式

        //设置表头字段名
        HSSFCell cell;
        int m=0;
        for(String fieldName:fields){
            cell = row.createCell(m);
            cell.setCellValue(fieldName);
            cell.setCellStyle(style);

            m++;
        }

        for (int i = 0; i < list.size(); i++)
        {
            row = sheet.createRow(i + 1);
            Record data = list.get(i);
            System.out.println(data.toString());
            // 第五步，创建单元格，并设置值
            row.createCell(0).setCellValue(i+1);
            row.createCell(1).setCellValue(data.getMachineNo());
            row.createCell(2).setCellValue(data.getPileNo());
            row.createCell(3).setCellValue(data.getFirstWeight());
            row.createCell(4).setCellValue(data.getSecondWeight());
            row.createCell(5).setCellValue(data.getFirstDepth());
            row.createCell(6).setCellValue(data.getSecondDepth());
            row.createCell(7).setCellValue(data.getSumDepth());
            row.createCell(8).setCellValue(data.getWeightRecord());
            row.createCell(9).setCellValue(data.getStr_gatherTime());
            row.createCell(10).setCellValue(data.getStr_beginTime());
            row.createCell(11).setCellValue(data.getStr_endTime());
        }

        return wb;
    }

    public void export(HSSFWorkbook wb, HttpServletResponse response){
        // 第六步，实现文件下载保存
        try
        {

            response.setHeader("content-disposition", "attachment;filename="
                    + URLEncoder.encode("打桩记录", "utf-8") + ".xls");


            OutputStream out = response.getOutputStream();
            ByteArrayOutputStream baos = new ByteArrayOutputStream();
            wb.write( baos);
            byte[] xlsBytes = baos .toByteArray();
            out.write( xlsBytes);
            out.close();

        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }
}
