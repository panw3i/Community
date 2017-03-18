package com.xylife.community.bean;

import java.util.List;

public class ListResponse<T>{

    public int total;
    public int code;
    public String msg;
    public List<T> data;

}
