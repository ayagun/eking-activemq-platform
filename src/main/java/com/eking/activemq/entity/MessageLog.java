package com.eking.activemq.entity;

import java.util.Date;

public class MessageLog {
    private Integer id;

    private String messageid;

    private String destination;

    private String consumer;

    private String message;

    private String createperson;

    private Date createtime;

    private Date jmstime;

    private Date sendtime;

    private Double jmssend;

    private Double jmsnow;

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

    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public String getConsumer() {
        return consumer;
    }

    public void setConsumer(String consumer) {
        this.consumer = consumer;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getCreateperson() {
        return createperson;
    }

    public void setCreateperson(String createperson) {
        this.createperson = createperson;
    }

    public Date getCreatetime() {
        return createtime;
    }

    public void setCreatetime(Date createtime) {
        this.createtime = createtime;
    }

    public Date getJmstime() {
        return jmstime;
    }

    public void setJmstime(Date jmstime) {
        this.jmstime = jmstime;
    }

    public Date getSendtime() {
        return sendtime;
    }

    public void setSendtime(Date sendtime) {
        this.sendtime = sendtime;
    }

    public Double getJmssend() {
        return jmssend;
    }

    public void setJmssend(Double jmssend) {
        this.jmssend = jmssend;
    }

    public Double getJmsnow() {
        return jmsnow;
    }

    public void setJmsnow(Double jmsnow) {
        this.jmsnow = jmsnow;
    }
}