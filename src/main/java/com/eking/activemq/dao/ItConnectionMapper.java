package com.eking.activemq.dao;

import com.eking.activemq.entity.ItConnection;
import java.util.List;

public interface ItConnectionMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(ItConnection record);

    ItConnection selectByPrimaryKey(Integer id);

    List<ItConnection> selectByConnection(ItConnection user);

    List<ItConnection> selectAll();

    int updateByPrimaryKey(ItConnection record);
}