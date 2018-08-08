package com.eking.activemq.dto;

/**
* @Author： 王运振 【yunzh.wang@haihangyun.com】
* @Description： 所有ajax请求的返回类型封装json结果
* @Date：Created in 2018/7/25 11:36
* @Modified By：
*/

public class ActiveMQResult<T> {

    private static final long serialVersionUID = 1L;

    private boolean success;
    private T data;
    private String msg;

    public ActiveMQResult(T data) {
        this.success = true;
        this.data = data;
        this.msg = "操作成功";
    }

    public ActiveMQResult(String msg) {
        this.success = false;
        this.data = null;
        this.msg = msg;
    }

    public static ActiveMQResult errorMsg(String msg) {
        return new ActiveMQResult(msg);
    }

    public static ActiveMQResult errorException(String msg) {
        return new ActiveMQResult(msg);
    }

    public static ActiveMQResult ok(Object data) {
        return new ActiveMQResult(data);
    }

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}
