package com.eking.activemq.dao;

import com.eking.activemq.entity.ItUser;
import com.github.pagehelper.PageHelper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;

import java.util.List;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class ItUserMapperTest {

    @Resource
    private ItUserMapper itUserMapper;
    @Test
    public void deleteByPrimaryKey() {

    }

    @Test
    public void insert() {
    }

    @Test
    public void selectByPrimaryKey() {
    }

    @Test
    public void selectAll() {
        PageHelper.startPage(2, 2);
        List<ItUser> userList = itUserMapper.selectAll();
        for(int i=0;i<userList.size();i++){
            System.out.println("userName is "+ userList.get(i).getUserName());
        }

    }

    @Test
    public void updateByPrimaryKey() {
    }
}