package com.hubu.controller;

import com.github.pagehelper.PageInfo;
import com.hubu.dao.RecordMapper;
import com.hubu.pojo.Msg;
import com.hubu.pojo.Record;
import com.hubu.service.RecorderService;
import com.hubu.utils.DateUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Required;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.tags.Param;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@Controller
public class RecordController
{
    @Autowired
    private RecorderService recorderService;

    @RequestMapping("/downloadExcelAllRecordByCriteria")
    @ResponseBody
    public void  downloadExcelAllRecord(       HttpServletResponse response,HttpServletRequest request,
                                              @RequestParam(value = "machine_no",required=false)String machine_no,
                                              @RequestParam(value = "pile_no",required=false)String pile_no,
                                              @RequestParam(value = "beginTime",required=false)String beginTime,
                                              @RequestParam(value = "endTime",required=false)String endTime,
                                              @RequestParam(value = "team",required=false)String team
    )
    {
        recorderService.exportAllRecordByCriteria(response,machine_no,pile_no,beginTime,endTime,team);
    }

    @RequestMapping("/downloadExcelThisPageRecordByCriteria")
    @ResponseBody
    public void  downloadExcelThisPageRecordByCriteria(
                                               HttpServletResponse response,HttpServletRequest request,
                                               @RequestParam(value = "cp",required=true) int currentPage,
                                               @RequestParam(value = "machine_no",required=false)String machine_no,
                                               @RequestParam(value = "pile_no",required=false)String pile_no,
                                               @RequestParam(value = "beginTime",required=false)String beginTime,
                                               @RequestParam(value = "endTime",required=false)String endTime,
                                               @RequestParam(value = "team",required=false)String team
    )
    {
        recorderService.exportThisPageRecordByCriteria(response,currentPage,machine_no,pile_no,beginTime,endTime,team);
    }

    @RequestMapping("/getRecordWithPageByCriteria")
    @ResponseBody
    public Msg  getRecordWithPageByCriteria(  @RequestParam(value = "cp",required=true) int currentPage,
                                              @RequestParam(value = "machine_no",required=false)String machine_no,
                                              @RequestParam(value = "pile_no",required=false)String pile_no,
                                              @RequestParam(value = "beginTime",required=false)String beginTime,
                                              @RequestParam(value = "endTime",required=false)String endTime,
                                              @RequestParam(value = "team",required=false)String team
    ){
        PageInfo<Record> records = recorderService.findRecordWithPageByCriteria(currentPage,machine_no,pile_no,beginTime,endTime,team);
        return new Msg().success().add("result",records);
    }



/*   @RequestMapping("hello")
    public String  hello(){
        return "hello";
    }*/

/*    @RequestMapping("/getRecordWithPage")
    @ResponseBody
    public Msg  getRecordWithPage(  @RequestParam(value = "cp") int currentPage ){
        PageInfo<Record> records = recorderService.findRecordWithPage(currentPage);
        return new Msg().success().add("result",records);
    }*/

/*    @RequestMapping("/downloadExcelAllRecord")
    @ResponseBody
    public void downloadExcelAllRecord(HttpServletResponse response, HttpServletRequest request) throws IOException {
        recorderService.export(response);
    }*/
}
