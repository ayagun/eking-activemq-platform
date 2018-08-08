package com.eking.activemq.service;

import com.eking.activemq.dao.ItUserMapper;
import com.eking.activemq.dto.Pager;
import com.eking.activemq.entity.ItUser;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ItUserService {

    @Autowired
    private ItUserMapper itUserMapper;

    public Pager<ItUser> queryAjaxPage(ItUser user, Pager pager){
        PageHelper.startPage(pager.getPageNum(), pager.getPageSize());
        return new Pager<ItUser>(itUserMapper.selectByUser(user));
}

    public List<ItUser> queryAjaxList(ItUser user){
        return itUserMapper.selectAll();
    }

    public ItUser queryByid(int id){
        return itUserMapper.selectByPrimaryKey(id);
    }

    public int addUser(ItUser user){
        return itUserMapper.insert(user);
    }

    public ItUser queryByName(String userName) {
        return itUserMapper.selectByName(userName);
    }

    public int deleteUser(int userId) {
        return itUserMapper.deleteByPrimaryKey(userId);
    }

    public void deleteUserQueueByUserId(int userId) {
        itUserMapper.deleteUserQueueByUserId(userId);
    }

    public void addUserQueueByUserIdAndQueueIds(int userId, int[] queueIds) {
        for (int i=0;i<queueIds.length;i++){
            int queueId = queueIds[i];
            itUserMapper.addUserQueueByUserIdAndQueueId(userId, queueId);
        }
    }
}
