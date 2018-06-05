package com.navigationview.base.bean;

/**
 * @Auth Mr.lc(兰超)
 * @Date 2018/6/5
 * @Time 17:06
 */
public class BaseBean<T> {
    public String msg;
    public  String status;

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public T getResult() {
        return result;
    }

    public void setResult(T result) {
        this.result = result;
    }

    public  T result;
}
