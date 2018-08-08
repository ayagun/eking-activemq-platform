package com.eking.activemq.service;

import com.eking.activemq.dao.ItUserMapper;
import com.eking.activemq.dao.MessageLogMapper;
import com.eking.activemq.dto.Pager;
import com.eking.activemq.entity.ItUser;
import com.eking.activemq.entity.MessageLog;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MessageLogService {

    @Autowired
    private MessageLogMapper messageLogMapper;

    public Pager<MessageLog> queryAjaxPage(MessageLog message, Pager pager){
        PageHelper.startPage(pager.getPageNum(), pager.getPageSize());
        return new Pager<MessageLog>(messageLogMapper.selectByMessage(message));
    }

    public List<MessageLog> queryAjaxList(ItUser user){
        return messageLogMapper.selectAll();
    }

    public MessageLog queryByid(int id){
        return messageLogMapper.selectByPrimaryKey(id);
    }


}
