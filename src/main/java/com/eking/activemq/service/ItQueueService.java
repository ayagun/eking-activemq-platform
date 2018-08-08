package com.eking.activemq.service;

import com.eking.activemq.dao.ItQueueMapper;
import com.eking.activemq.dto.Pager;
import com.eking.activemq.entity.ItQueue;
import com.eking.activemq.entity.ItUser;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ItQueueService {

    @Autowired
    private ItQueueMapper itQueueMapper;

    public Pager<ItQueue> queryAjaxPage(ItQueue queue, Pager pager){
        PageHelper.startPage(pager.getPageNum(), pager.getPageSize());
        return new Pager<ItQueue>(itQueueMapper.selectByQueue(queue));
    }

    public List<ItQueue> queryAjaxList(ItQueue queue){
        return itQueueMapper.selectAll();
    }

    public ItQueue queryByid(int id){
        return itQueueMapper.selectByPrimaryKey(id);
    }


    public ItQueue queryByName(String queueName) {
        return itQueueMapper.selectByName(queueName);
    }

    public int addQueue(ItQueue queue) {
        return itQueueMapper.insert(queue);
    }

    public int deleteQueue(int queueId) {
        return itQueueMapper.deleteByPrimaryKey(queueId);
    }

    public List<ItQueue> queryByUserId(int userId) {
        return itQueueMapper.selectByUserId(userId);
    }
}
