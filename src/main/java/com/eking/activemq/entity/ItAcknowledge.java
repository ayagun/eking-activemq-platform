package com.eking.activemq.entity;

import java.util.Date;

public class ItAcknowledge {
    private Integer id;

    private String messageid;

    private String username;

    private String queuename;

    private Integer count;

    private Date acktime;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getMessageid() {
        return messageid;
    }

    public void setMessageid(String messageid) {
        this.messageid = messageid;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getQueuename() {
        return queuename;
    }

    public void setQueuename(String queuename) {
        this.queuename = queuename;
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    public Date getAcktime() {
        return acktime;
    }

    public void setAcktime(Date acktime) {
        this.acktime = acktime;
    }
}