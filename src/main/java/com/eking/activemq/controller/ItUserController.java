package com.eking.activemq.controller;

import com.eking.activemq.dto.ActiveMQResult;
import com.eking.activemq.dto.Pager;
import com.eking.activemq.entity.ItUser;
import com.eking.activemq.service.ItUserService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@Controller
@RequestMapping("/itUser")
public class ItUserController {

    Logger logger = Logger.getLogger(this.getClass());

    @Autowired
    private ItUserService itUserService;

    @GetMapping("/list")
    public String index(ModelMap map){
        map.addAttribute("message","hello world");
        return "user/list";
    }

    @GetMapping("/ajaxPage")
    @ResponseBody
    public ActiveMQResult<Pager> ajaxPage(ItUser user, Integer page, Integer pageSize){
        try{
            Pager pager = new Pager();
            pager.setPageNum(1);
            pager.setPageSize(2);
            pager = itUserService.queryAjaxPage(user, pager);
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
            List<ItUser> list = itUserService.queryAjaxList(user);
            return ActiveMQResult.ok(list);
        }catch (Exception e){
            logger.error(e.getMessage());
            return ActiveMQResult.errorException(e.getMessage());
        }

    }

    @GetMapping("/{itUserId}/detail")
    @ResponseBody
    public ActiveMQResult<ItUser> detail(@PathVariable("itUserId") int itUserId){
        try {
            ItUser itUser = itUserService.queryByid(itUserId);
            return ActiveMQResult.ok(itUser);
        }catch (Exception e){
            logger.error(e.getMessage());
            return ActiveMQResult.errorException(e.getMessage());
        }
    }

    @PostMapping("/add")
    @ResponseBody
    public  ActiveMQResult add(ItUser user){
        if(itUserService.queryByName(user.getUserName())!=null){
            return ActiveMQResult.errorMsg("用户已经存在！");
        }
        user.setCreateTime(new Date());
        if(itUserService.addUser(user)>0){
            return ActiveMQResult.ok(null);
        }else{
            return ActiveMQResult.errorMsg("新增用户错误！");
        }
    }

    @RequestMapping("/delete")
    @ResponseBody
    public ActiveMQResult delete(int userId){
        if(itUserService.deleteUser(userId)>0){
            return ActiveMQResult.ok(null);
        }else{
            return ActiveMQResult.errorMsg("删除用户错误！");
        }
    }

    @RequestMapping("setQueue")
    @ResponseBody
    @Transactional
    public ActiveMQResult setQueue(int userId, int[] queueIds){
        try{
            //1.通过userId删除所有关联的queue
            itUserService.deleteUserQueueByUserId(userId);
            //2.将所有的queueIds关联到userId下
            if(queueIds.length>0){
                itUserService.addUserQueueByUserIdAndQueueIds(userId, queueIds);
            }
            return ActiveMQResult.ok(null);
        }catch (Exception e){
            return ActiveMQResult.errorMsg(e.getMessage());
        }
    }
}
