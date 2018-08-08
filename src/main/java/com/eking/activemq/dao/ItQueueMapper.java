package com.eking.activemq.dao;

import com.eking.activemq.entity.ItQueue;
import java.util.List;

public interface ItQueueMapper {
    int deleteByPrimaryKey(Integer queueId);

    int insert(ItQueue record);

    ItQueue selectByPrimaryKey(Integer queueId);

    List<ItQueue> selectAll();

    List<ItQueue> selectByQueue(ItQueue queue);

    int updateByPrimaryKey(ItQueue record);

    ItQueue selectByName(String queueName);

    List<ItQueue> selectByUserId(int userId);
}