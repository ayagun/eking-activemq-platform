package com.eking.activemq.dao;

import com.eking.activemq.entity.MessageLog;
import java.util.List;

public interface MessageLogMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(MessageLog record);

    MessageLog selectByPrimaryKey(Integer id);

    List<MessageLog> selectByMessage(MessageLog messageLog);

    List<MessageLog> selectAll();

    int updateByPrimaryKey(MessageLog record);
}