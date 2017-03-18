package com.xylife.community.bean;


public class Response<T> {

    public boolean isSuccess() {
        return code == 200;
    }


    public int total;
    public int code;
    public String msg;
    public T data;
}
