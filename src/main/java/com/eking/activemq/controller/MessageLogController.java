package com.eking.activemq.controller;

import com.eking.activemq.dto.ActiveMQResult;
import com.eking.activemq.dto.Pager;
import com.eking.activemq.entity.ItUser;
import com.eking.activemq.entity.MessageLog;
import com.eking.activemq.service.ItUserService;
import com.eking.activemq.service.MessageLogService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping("/message")
public class MessageLogController {

    Logger logger = Logger.getLogger(this.getClass());

    @Autowired
    private MessageLogService messageLogService;

    @GetMapping("/list")
    public String list(ModelMap map){
        map.addAttribute("message","hello world");
        return "message/list";
    }

    @GetMapping("/ajaxPage")
    @ResponseBody
    public ActiveMQResult<Pager> ajaxPage(MessageLog message, Integer page, Integer pageSize){
        try{
            Pager pager = new Pager();
            pager.setPageNum(1);
            pager.setPageSize(2);
            pager = messageLogService.queryAjaxPage(message, pager);
            return ActiveMQResult.ok(pager);
        }catch (Exception e){
            logger.error(e.getMessage());
            return ActiveMQResult.errorException(e.getMessage());
        }

    }

    @GetMapping("/ajaxList")
    @ResponseBody
    public ActiveMQResult<List<ItUser>> ajaxList(ItUser user){
        try{
            List<MessageLog> list = messageLogService.queryAjaxList(user);
            return ActiveMQResult.ok(list);
        }catch (Exception e){
            logger.error(e.getMessage());
            return ActiveMQResult.errorException(e.getMessage());
        }

    }

    @GetMapping("/{messageId}/detail")
    @ResponseBody
    public ActiveMQResult<MessageLog> detail(@PathVariable("messageId") int messageId){
        try {
            MessageLog messageLog = messageLogService.queryByid(messageId);
            return ActiveMQResult.ok(messageLog);
        }catch (Exception e){
            logger.error(e.getMessage());
            return ActiveMQResult.errorException(e.getMessage());
        }
    }
}
