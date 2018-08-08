package com.eking.activemq.controller;

import com.eking.activemq.dto.ActiveMQResult;
import com.eking.activemq.dto.Pager;
import com.eking.activemq.entity.ItQueue;
import com.eking.activemq.entity.ItUser;
import com.eking.activemq.service.ItQueueService;
import com.eking.activemq.service.ItUserService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@Controller
@RequestMapping("/itQueue")
public class ItQueueController {

    Logger logger = Logger.getLogger(this.getClass());

    @Autowired
    private ItQueueService itQueueService;

    @GetMapping("/list")
    public String index(ModelMap map){
        map.addAttribute("message","hello world");
        return "queue/list";
    }

    @GetMapping("/ajaxPage")
    @ResponseBody
    public ActiveMQResult<Pager> ajaxPage(ItQueue queue, Integer page, Integer pageSize){
        try{
            Pager pager = new Pager();
            pager.setPageNum(1);
            pager.setPageSize(2);
            pager = itQueueService.queryAjaxPage(queue, pager);
            return ActiveMQResult.ok(pager);
        }catch (Exception e){
            logger.error(e.getMessage());
            return ActiveMQResult.errorException(e.getMessage());
        }

    }

    @GetMapping("/ajaxList")
    @ResponseBody
    public ActiveMQResult<List<ItQueue>> ajaxList(ItQueue queque){
        try{
            List<ItQueue> list = itQueueService.queryAjaxList(queque);
            return ActiveMQResult.ok(list);
        }catch (Exception e){
            logger.error(e.getMessage());
            return ActiveMQResult.errorException(e.getMessage());
        }

    }

    @GetMapping("/{itUserId}/detail")
    @ResponseBody
    public ActiveMQResult<ItQueue> detail(@PathVariable("itUserId") int itUserId){
        try {
            ItQueue queque = itQueueService.queryByid(itUserId);
            return ActiveMQResult.ok(queque);
        }catch (Exception e){
            logger.error(e.getMessage());
            return ActiveMQResult.errorException(e.getMessage());
        }
    }

    @PostMapping("/add")
    @ResponseBody
    public  ActiveMQResult add(ItQueue queue){
        if(itQueueService.queryByName(queue.getQueueName())!=null){
            return ActiveMQResult.errorMsg("目的地已经存在！");
        }
        queue.setCreateTime(new Date());
        if(itQueueService.addQueue(queue)>0){
            return ActiveMQResult.ok(null);
        }else{
            return ActiveMQResult.errorMsg("新增目的地错误！");
        }
    }

    @RequestMapping("/delete")
    @ResponseBody
    public ActiveMQResult delete(int queueId){
        if(itQueueService.deleteQueue(queueId)>0){
            return ActiveMQResult.ok(null);
        }else{
            return ActiveMQResult.errorMsg("删除权限错误！");
        }
    }

    @RequestMapping("queryQueueByUserId")
    @ResponseBody
    public ActiveMQResult<ItQueue> queryQueueByUserId(int userId){
        List<ItQueue> queueList = itQueueService.queryByUserId(userId);
        if(queueList != null){
            return ActiveMQResult.ok(queueList);
        }else{
            return ActiveMQResult.errorMsg("通过userId获取queue列表报错！");
        }
    }
}
