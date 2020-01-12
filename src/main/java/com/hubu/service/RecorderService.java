package com.hubu.service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.google.common.collect.Lists;

import com.hubu.mapper.RecordMapper;
import com.hubu.pojo.Record;
import com.hubu.pojo.RecordExample;
import com.hubu.utils.DateUtil;
import com.hubu.utils.PojoHelper;
import com.hubu.utils.RecordUtil;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

/**
 * 功能描述:  处理关于记录的业务逻辑
 *
 *  Author:   chenfeiliang
 */
@Service
public class RecorderService {
    @Autowired
    RecordMapper recordMapper;

    @Value("${front.pagesize}") //分页的页大小
    int PAGESIZE;


    /*
     * 功能描述:
     * 把票据导出成excel
     *
     * @param:   [response, id]
     * @return : boolean
     * @author : chenfeiliang
     */
    public boolean exportTicketById(HttpServletResponse response,Integer id) throws IOException {

        //根据id查找查找数据
        Record record = recordMapper.selectByPrimaryKey(id);

        //把Record里的Date类型日期 如 beginTime，赋值到String 类型 的str_beginTime 方便前台显示   （日期格式化）
        List<Record>list = PojoHelper.setRecordDateString(Lists.newArrayList(record));

        //生成Excel
        TicketExcelExport export = new TicketExcelExport();
        HSSFWorkbook wb = export.generateExcel();

        //生成sheet
        wb = export.generateSheet(wb, "票据", list);

        //导出
        export.export(wb, response);

        //成功则返回true，异常则throws IOException （在方法名处）,在controller层捕捉
        return true;
    }

    /*
     * 功能描述:
     *导出经过筛选的所有数据
     *
     * @param:   [response, machine_no, pile_no, beginTime, endTime, team]
     * @return : boolean
     * @author : chenfeiliang
     */
    public boolean exportAllRecordByCriteria(
            HttpServletResponse response,
            String machine_no,
            String pile_no,
            String beginTime,
            String endTime,
            String team) throws IOException {

             //多条件查找查找数据
            RecordExample recordExample = getRecordByCriteria(machine_no,pile_no,beginTime,endTime);

            List<Record> list = recordMapper.selectByExampleWithBLOBs(recordExample);

            //把Record里的Date类型日期 如 beginTime，赋值到String 类型 的str_beginTime 方便前台显示
            list = PojoHelper.setRecordDateString(list);

            //设置表头数据
            String[] fields = {"序号","机台编号","桩基号","第一次下料重量","第二次下料重量"
                    ,"第一次下料深度","第二次下料深度","总深度","每米下料,#分隔"
                    ,"数据入库时的时间","开始时间","结束时间","源数据"
            };

            //生成Excel
            RecordExcelExport export = new RecordExcelExport();
            HSSFWorkbook wb = export.generateExcel();

             //生成sheet
            wb = export.generateSheet(wb, "打桩记录表", fields, list);

            //导出
            export.export(wb, response);

            //成功则返回true，异常则throws IOException （在方法名处）,在controller层捕捉
            return true;

    }

    /*
     * 功能描述:
     * 导出经过筛选的当前页数据
     *
     * @param:   [response, currentPage, machine_no, pile_no, beginTime, endTime, team]
     * @return : boolean
     * @author : chenfeiliang
     */
    public boolean exportThisPageRecordByCriteria(
            HttpServletResponse response,
            int currentPage,
            String machine_no,
            String pile_no,
            String beginTime,
            String endTime,
            String team) throws IOException {

            //多条件查找查找数据
            RecordExample recordExample = getRecordByCriteria(machine_no,pile_no,beginTime,endTime);

            //分页
            PageHelper.startPage(currentPage,PAGESIZE);
            List<Record> list = recordMapper.selectByExampleWithBLOBs(recordExample);

            //把Record里的Date类型日期 如 beginTime，赋值到String 类型 的str_beginTime 方便前台显示
            list = PojoHelper.setRecordDateString(list);


            //把Record里的Date类型日期 如 beginTime，赋值到String 类型 的str_beginTime 方便前台显示
            list = PojoHelper.setRecordDateString(list);

            //设置表头数据
            String[] fields = {"序号","机台编号","桩基号","第一次下料重量","第二次下料重量"
                    ,"第一次下料深度","第二次下料深度","总深度","每米下料,#分隔"
                    ,"数据入库时的时间","开始时间","结束时间","源数据"
            };

            //生成Excel
            RecordExcelExport export = new RecordExcelExport();
            HSSFWorkbook wb = export.generateExcel();

            //生成sheet
            wb = export.generateSheet(wb, "打桩记录表", fields, list);

            //导出
            export.export(wb, response);

            //成功则返回true，异常则throws IOException （在方法名处）,在controller层捕捉
            return true;

    }

    /*
     * 功能描述:
     *    通过id查找记录
     *
     * @param:   [id]
     * @return : com.hubu.pojo.Record
     * @author : chenfeiliang
     */
    public Record findRecordById(int id){
        Record record = recordMapper.selectByPrimaryKey(id);
        List<Record> records = PojoHelper.setRecordDateString(Arrays.asList(record));
        return records.get(0);
    }

    /*
     * 功能描述:
     * 多条件查询打桩记录数据
     *
     * @param:   [currentPage, machine_no, pile_no, beginTime, endTime, team]
     * @return : com.github.pagehelper.PageInfo<com.hubu.pojo.Record>
     * @author : chenfeiliang
     */
    public PageInfo<Record> findRecordWithPageByCriteria(
                                                        int currentPage,
                                                        String machine_no,
                                                        String pile_no,
                                                        String beginTime,
                                                        String endTime,
                                                        String team)
    {
        //多条件查找查找数据
        RecordExample recordExample = getRecordByCriteria(machine_no,pile_no,beginTime,endTime);

        //分页
        PageHelper.startPage(currentPage,PAGESIZE);
        List<Record> records = recordMapper.selectByExampleWithBLOBs(recordExample);

        //把Record里的Date类型日期 如 beginTime，赋值到String 类型 的str_beginTime 方便前台显示
        records = PojoHelper.setRecordDateString(records);

        //分页包装
        PageInfo<Record> pageInfo = new PageInfo<>(records);

        return pageInfo;
    }
    /*
     * 功能描述:
     * 查看前台要求包含哪些查询条件，设置查询条件。
     *
     * @param:   [machine_no, pile_no, beginTime, endTime]
     * @return : com.hubu.pojo.RecordExample
     * @author : chenfeiliang
     */
    public RecordExample getRecordByCriteria(String machine_no ,String pile_no,String beginTime,String endTime){

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

        if(beginTime!=null){
            if(!(beginTime.trim()).equals("")){
                Date beginTimeDate =  DateUtil.StringToDate2(beginTime);
                criteria.andBeginTimeGreaterThanOrEqualTo(beginTimeDate);
            }
        }

        if(endTime!=null){
            if(!(endTime.trim()).equals("")){
                Date endTimeDate =  DateUtil.StringToDate2(endTime);
                criteria.andEndTimeLessThanOrEqualTo(endTimeDate);
            }
        }

        return  recordExample;
    }
}
