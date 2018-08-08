package com.eking.activemq.controller;

import com.eking.activemq.dto.ActiveMQResult;
import com.eking.activemq.dto.Pager;
import com.eking.activemq.entity.ItConnection;
import com.eking.activemq.entity.ItUser;
import com.eking.activemq.entity.MessageLog;
import com.eking.activemq.service.ConnectionService;
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
@RequestMapping("/connection")
public class ConnectionController {

    Logger logger = Logger.getLogger(this.getClass());

    @Autowired
    private ConnectionService connectionService;

    @GetMapping("/list")
    public String list(ModelMap map){
        map.addAttribute("message","hello world");
        return "connection/list";
    }

    @GetMapping("/ajaxPage")
    @ResponseBody
    public ActiveMQResult<Pager> ajaxPage(ItConnection connection, Integer page, Integer pageSize){
        try{
            Pager pager = new Pager();
            pager.setPageNum(1);
            pager.setPageSize(2);
            pager = connectionService.queryAjaxPage(connection, pager);
            return ActiveMQResult.ok(pager);
        }catch (Exception e){
            logger.error(e.getMessage());
            return ActiveMQResult.errorException(e.getMessage());
        }

    }

    @GetMapping("/ajaxList")
    @ResponseBody
    public ActiveMQResult<List<ItConnection>> ajaxList(ItConnection connection){
        try{
            List<ItConnection> list = connectionService.queryAjaxList(connection);
            return ActiveMQResult.ok(list);
        }catch (Exception e){
            logger.error(e.getMessage());
            return ActiveMQResult.errorException(e.getMessage());
        }

    }

    @GetMapping("/{connectionId}/detail")
    @ResponseBody
    public ActiveMQResult<ItConnection> detail(@PathVariable("connectionId") int connectionId){
        try {
            ItConnection connection = connectionService.queryByid(connectionId);
            return ActiveMQResult.ok(connection);
        }catch (Exception e){
            logger.error(e.getMessage());
            return ActiveMQResult.errorException(e.getMessage());
        }
    }
}
