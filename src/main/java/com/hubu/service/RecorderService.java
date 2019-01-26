package com.hubu.service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.hubu.dao.RecordMapper;
import com.hubu.pojo.Record;
import com.hubu.pojo.RecordExample;
import com.hubu.utils.JsonListUtil;
import com.hubu.utils.PojoHelper;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletResponse;
import java.util.List;

@Service
public class RecorderService {
    @Autowired
    RecordMapper recordMapper;

    @Value("${front.pagesize}")
    int PAGESIZE;

/*    public PageInfo<Record> findRecordWithPage(int currentPage){

        //分页
        PageHelper.startPage(currentPage,PAGESIZE);
        List<Record> records = recordMapper.selectByExampleWithBLOBs(null);

        //把Record里的Date类型日期 如 beginTime，赋值到String 类型 的str_beginTime 方便前台显示
        records = PojoHelper.setRecordDateString(records);

        PageInfo<Record> pageInfo = new PageInfo<>(records);

        return pageInfo;
    }*/

/*    public boolean export(HttpServletResponse response){
        try {
            //分页
     *//*       PageHelper.startPage(1,PAGESIZE);*//*
            List<Record> list = recordMapper.selectByExampleWithBLOBs(null);

            //把Record里的Date类型日期 如 beginTime，赋值到String 类型 的str_beginTime 方便前台显示
            list = PojoHelper.setRecordDateString(list);

            String[] fields = {"序号","机台编号","桩基号","第一次下料重量","第二次下料重量"
                    ,"第一次下料深度","第二次下料深度","总深度","每米下料,#分隔"
                    ,"数据入库时的时间","开始时间","结束时间"
            };
            ExcelExport export = new ExcelExport();
            HSSFWorkbook wb = export.generateExcel();
            wb = export.generateSheet(wb, "打桩记录表", fields, list);

            export.export(wb, response);
            return true;
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
            return false;
        }
    }*/

    public boolean exportAllRecord(HttpServletResponse response,String dataJson){
        List<Record> records = JsonListUtil.jsonToList(dataJson,Record.class);
        records.get(0).toString();
        return true;
    }

    public boolean exportAllRecordByCriteria(
            HttpServletResponse response,
            String machine_no,
            String pile_no,
            String beginTime,
            String endTime,
            String team)
    {
        try {

            RecordExample recordExample = getRecordByCriteria(machine_no,pile_no);

            List<Record> list = recordMapper.selectByExampleWithBLOBs(recordExample);

            //把Record里的Date类型日期 如 beginTime，赋值到String 类型 的str_beginTime 方便前台显示
            list = PojoHelper.setRecordDateString(list);


            //把Record里的Date类型日期 如 beginTime，赋值到String 类型 的str_beginTime 方便前台显示
            list = PojoHelper.setRecordDateString(list);

            String[] fields = {"序号","机台编号","桩基号","第一次下料重量","第二次下料重量"
                    ,"第一次下料深度","第二次下料深度","总深度","每米下料,#分隔"
                    ,"数据入库时的时间","开始时间","结束时间","源数据"
            };
            ExcelExport export = new ExcelExport();
            HSSFWorkbook wb = export.generateExcel();
            wb = export.generateSheet(wb, "打桩记录表", fields, list);

            export.export(wb, response);
            return true;
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
            return false;
        }
    }

    public boolean exportThisPageRecordByCriteria(
            HttpServletResponse response,
            int currentPage,
            String machine_no,
            String pile_no,
            String beginTime,
            String endTime,
            String team)
    {
        try {

            RecordExample recordExample = getRecordByCriteria(machine_no,pile_no);

            //分页
            PageHelper.startPage(currentPage,PAGESIZE);
            List<Record> list = recordMapper.selectByExampleWithBLOBs(recordExample);

            //把Record里的Date类型日期 如 beginTime，赋值到String 类型 的str_beginTime 方便前台显示
            list = PojoHelper.setRecordDateString(list);


            //把Record里的Date类型日期 如 beginTime，赋值到String 类型 的str_beginTime 方便前台显示
            list = PojoHelper.setRecordDateString(list);

            String[] fields = {"序号","机台编号","桩基号","第一次下料重量","第二次下料重量"
                    ,"第一次下料深度","第二次下料深度","总深度","每米下料,#分隔"
                    ,"数据入库时的时间","开始时间","结束时间"
            };
            ExcelExport export = new ExcelExport();
            HSSFWorkbook wb = export.generateExcel();
            wb = export.generateSheet(wb, "打桩记录表", fields, list);

            export.export(wb, response);
            return true;
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
            return false;
        }
    }


    public PageInfo<Record> findRecordWithPageByCriteria(
                                                        int currentPage,
                                                        String machine_no,
                                                        String pile_no,
                                                        String beginTime,
                                                        String endTime,
                                                        String team)
    {
        RecordExample recordExample = getRecordByCriteria(machine_no,pile_no);

        //分页
        PageHelper.startPage(currentPage,PAGESIZE);
        List<Record> records = recordMapper.selectByExampleWithBLOBs(recordExample);

        //把Record里的Date类型日期 如 beginTime，赋值到String 类型 的str_beginTime 方便前台显示
        records = PojoHelper.setRecordDateString(records);

        PageInfo<Record> pageInfo = new PageInfo<>(records);

        return pageInfo;
    }

    public RecordExample getRecordByCriteria(String machine_no ,String pile_no){
        RecordExample recordExample = new RecordExample();

        RecordExample.Criteria criteria = recordExample.createCriteria();


        if(machine_no!=null){
            if(!(machine_no.trim()).equals("")){
                criteria.andMachineNoEqualTo(machine_no);
            }
        }

        if(pile_no!=null){
            if(!(pile_no.trim()).equals("")){
                criteria.andPileNoEqualTo(pile_no);
            }
        }

        return  recordExample;
    }
}
