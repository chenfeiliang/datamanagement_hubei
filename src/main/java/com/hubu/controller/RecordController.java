package com.hubu.controller;

import com.github.pagehelper.PageInfo;

import com.hubu.mapper.RecordMapper;
import com.hubu.pojo.Msg;
import com.hubu.pojo.Record;
import com.hubu.service.RecorderService;
import com.hubu.utils.PojoHelper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.Map;

/*
 * Author:   chenfeiliang
 * Description: RecordController
 */
@Controller
public class RecordController
{
    @Autowired
    private RecorderService recorderService;

    @Autowired
    private RecordMapper recordMapper;

    private Logger logger = LoggerFactory.getLogger(this.getClass());  //日志类

    /**
     * 功能描述:
     * 把票据导出成excel
     *
     * @param:   [response, request, id]
     * @return : void
     * @author : chenfeiliang
     */
    @RequestMapping(value = "/downloadTicketExcelById")
    @ResponseBody
    public Msg  downloadTicketById(HttpServletResponse response,HttpServletRequest request,@RequestParam(value = "id") Integer id)
    {
        try{
            return new Msg().add(Msg.RESULT,recorderService.exportTicketById(response,id));
        }catch (Exception e){
            logger.error(e.getMessage());
            return new Msg().fail();
        }
    }

    /*
     * 功能描述:
     * 导出经过筛选的所有数据
     *
     * @param:   [response, request, machine_no, pile_no, beginTime, endTime, team]
     * @return : void
     * @author : chenfeiliang
     */
    @RequestMapping("/downloadExcelAllRecordByCriteria")
    @ResponseBody
    public Msg  downloadExcelAllRecord(       HttpServletResponse response,HttpServletRequest request,
                                              @RequestParam(value = "machine_no",required=false)String machine_no,
                                              @RequestParam(value = "pile_no",required=false)String pile_no,
                                              @RequestParam(value = "beginTime",required=false)String beginTime,
                                              @RequestParam(value = "endTime",required=false)String endTime,
                                              @RequestParam(value = "team",required=false)String team
    )
    {
        try {
            return new Msg().add(Msg.RESULT,recorderService.exportAllRecordByCriteria(response,machine_no,pile_no,beginTime,endTime,team));
        }
        catch (Exception e){
            logger.error(e.getMessage());
            return new Msg().fail();
        }
    }
 
    /*
     * 功能描述:
     * 导出经过筛选的当前页数据
     *
     * @param:   [response, request, currentPage, machine_no, pile_no, beginTime, endTime, team]
     * @return : void
     * @author : chenfeiliang
     */
    @RequestMapping("/downloadExcelThisPageRecordByCriteria")
    @ResponseBody
    public Msg  downloadExcelThisPageRecordByCriteria(
                                               HttpServletResponse response,HttpServletRequest request,
                                               @RequestParam(value = "cp",required=true) int currentPage,
                                               @RequestParam(value = "machine_no",required=false)String machine_no,
                                               @RequestParam(value = "pile_no",required=false)String pile_no,
                                               @RequestParam(value = "beginTime",required=false)String beginTime,
                                               @RequestParam(value = "endTime",required=false)String endTime,
                                               @RequestParam(value = "team",required=false)String team
    )
    {
        try {
            return new Msg().success().add(Msg.RESULT,recorderService.exportThisPageRecordByCriteria(response,currentPage,machine_no,pile_no,beginTime,endTime,team));
        }
        catch (Exception e){
            logger.error(e.getMessage());
            return new Msg().fail();
        }
    }

    /*
     * 功能描述:
     * 获取经过筛选的分页数据
     *
     * @param:   [currentPage, machine_no, pile_no, beginTime, endTime, team]
     * @return : com.hubu.pojo.Msg
     * @author : chenfeiliang
     */
    @RequestMapping("/getRecordWithPageByCriteria")
    @ResponseBody
    public Msg  getRecordWithPageByCriteria(  @RequestParam(value = "cp",required=true) int currentPage,
                                              @RequestParam(value = "machine_no",required=false)String machine_no,
                                              @RequestParam(value = "pile_no",required=false)String pile_no,
                                              @RequestParam(value = "beginTime",required=false)String beginTime,
                                              @RequestParam(value = "endTime",required=false)String endTime,
                                              @RequestParam(value = "team",required=false)String team
    ){
        try {
            PageInfo<Record> records = recorderService.findRecordWithPageByCriteria(currentPage,machine_no,pile_no,beginTime,endTime,team);
         //   throw new NullPointerException();
            return new Msg().success().add(Msg.RESULT,records);
        }
        catch (Exception e){
            logger.error(e.toString());
            return new Msg().fail();
        }
    }

    /*
     * 功能描述:
     * 获取项目某个团队的完成任务情况
     *
     * @param:   [projectNo, teamNo]
     * @return : java.util.List<com.hubu.pojo.ProjectTeamFinishedCompletion>
     * @author : chenfeiliang
     */
   @RequestMapping("/getProjectTeamFinishedCompletion")
   @ResponseBody
    public Msg  hello(@RequestParam(value = "pno") Integer projectNo,
                                                      @RequestParam(value = "tno") Integer teamNo){
       try {
           Map<String,Object> map = new HashMap<>();
           map.put("projectNo",projectNo);
           map.put("teamNo",teamNo);
           return  new Msg().success().add(Msg.RESULT,PojoHelper.setProjectTeamFinishedCompletionDateString(recordMapper.analyzeProjectTeamFinishedCompletion(map)));
       }
       catch (Exception e){
           logger.error(e.getMessage());
           return new Msg().fail();
       }



    }

    /*
     * 功能描述:
     * 获取项目整体完成任务情况
     *
     * @param:   [projectNo]
     * @return : java.util.List<com.hubu.pojo.ProjectFinishedCompletion>
     * @author : chenfeiliang
     */
    @RequestMapping("/getProjectFinishedCompletion")
    @ResponseBody
    public Msg  hi(@RequestParam(value = "pno") Integer projectNo){
        try {
            return new Msg().success().add(Msg.RESULT,PojoHelper.setProjectFinishedCompletionDateString(recordMapper.analyzeProjectFinishedCompletion(projectNo)));
        }
        catch (Exception e){
            logger.error(e.getMessage());
            return new Msg().fail();
        }
    }
}
