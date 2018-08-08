package com.eking.activemq.entity;

import java.util.Date;

public class ItQueue {
    private Integer queueId;

    private String queueName;

    private String permissionType;

    private String queueDescribe;

    private Date createTime;

    private String createPerson;

    private int userId;

    public Integer getQueueId() {
        return queueId;
    }

    public void setQueueId(Integer queueId) {
        this.queueId = queueId;
    }

    public String getQueueName() {
        return queueName;
    }

    public void setQueueName(String queueName) {
        this.queueName = queueName;
    }

    public String getPermissionType() {
        return permissionType;
    }

    public void setPermissionType(String permissionType) {
        this.permissionType = permissionType;
    }

    public String getQueueDescribe() {
        return queueDescribe;
    }

    public void setQueueDescribe(String queueDescribe) {
        this.queueDescribe = queueDescribe;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public String getCreatePerson() {
        return createPerson;
    }

    public void setCreatePerson(String createPerson) {
        this.createPerson = createPerson;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }
}