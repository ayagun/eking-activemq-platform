package com.eking.activemq.dao;

import com.eking.activemq.entity.ItAcknowledge;
import java.util.List;

public interface ItAcknowledgeMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(ItAcknowledge record);

    ItAcknowledge selectByPrimaryKey(Integer id);

    List<ItAcknowledge> selectAll();

    int updateByPrimaryKey(ItAcknowledge record);
}