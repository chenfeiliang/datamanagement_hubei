package com.hubu.controller;

import com.alibaba.fastjson.JSONArray;
import com.github.pagehelper.PageInfo;
import com.hubu.dao.RecordMapper;
import com.hubu.pojo.Msg;
import com.hubu.pojo.ProjectFinishedCompletion;
import com.hubu.pojo.ProjectTeamFinishedCompletion;
import com.hubu.pojo.Record;
import com.hubu.service.RecorderService;
import com.hubu.utils.DateUtil;
import com.hubu.utils.JsonListUtil;
import com.hubu.utils.PojoHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Required;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.tags.Param;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class RecordController
{
    @Autowired
    private RecorderService recorderService;

    @Autowired
    private RecordMapper recordMapper;


    @RequestMapping(value = "/downloadExcelAllRecord",method = RequestMethod.POST)
    @ResponseBody
    public void  downloadExcelAllRecord(HttpServletResponse response,HttpServletRequest request,@RequestParam(value = "dataJson") String dataJson)
    {
         System.out.println(dataJson);
/*        recorderService.exportAllRecord(response,dataJson);*/
    }


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



  @RequestMapping("/analyzeProjectTeamFinishedCompletion")
  @ResponseBody
    public List<ProjectTeamFinishedCompletion>  hello(@RequestParam(value = "pno") Integer projectNo,
                                                      @RequestParam(value = "tno") Integer teamNo){
        Map<String,Object> map = new HashMap<>();
        map.put("projectNo",projectNo);
        map.put("teamNo",teamNo);
        return PojoHelper.setProjectTeamFinishedCompletionDateString(recordMapper.analyzeProjectTeamFinishedCompletion(map));
    }

    @RequestMapping("/analyzeProjectFinishedCompletion")
    @ResponseBody
    public List<ProjectFinishedCompletion>  hi(@RequestParam(value = "pno") Integer projectNo){
        return PojoHelper.setProjectFinishedCompletionDateString(recordMapper.analyzeProjectFinishedCompletion(projectNo));
    }

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
