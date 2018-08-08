package com.eking.activemq.dao;

import com.eking.activemq.entity.ItQueue;
import com.eking.activemq.entity.ItUser;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface ItUserMapper {
    int deleteByPrimaryKey(Integer userId);

    int insert(ItUser record);

    ItUser selectByPrimaryKey(Integer userId);

    List<ItUser> selectAll();

    List<ItUser> selectByUser(ItUser user);

    int updateByPrimaryKey(ItUser record);

    ItUser selectByName(String userName);

    int deleteUserQueueByUserId(int userId);

    int addUserQueueByUserIdAndQueueId(@Param("userId") int userId, @Param("queueId") int queueId);
}