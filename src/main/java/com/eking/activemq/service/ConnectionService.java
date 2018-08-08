package com.eking.activemq.service;

import com.eking.activemq.dao.ItConnectionMapper;
import com.eking.activemq.dao.MessageLogMapper;
import com.eking.activemq.dto.Pager;
import com.eking.activemq.entity.ItConnection;
import com.eking.activemq.entity.ItUser;
import com.eking.activemq.entity.MessageLog;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ConnectionService {

    @Autowired
    private ItConnectionMapper connectionMapper;

    public Pager<ItConnection> queryAjaxPage(ItConnection connection, Pager pager){
        PageHelper.startPage(pager.getPageNum(), pager.getPageSize());
        return new Pager<ItConnection>(connectionMapper.selectByConnection(connection));
    }

    public List<ItConnection> queryAjaxList(ItConnection connection){
        return connectionMapper.selectAll();
    }

    public ItConnection queryByid(int id){
        return connectionMapper.selectByPrimaryKey(id);
    }


}
