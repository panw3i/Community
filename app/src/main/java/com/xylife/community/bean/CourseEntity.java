package com.xylife.community.bean;

import com.android.framewok.bean.Entity;

/**
 * 课程详情
 */
public class CourseEntity extends Entity {
    public String course_ref;
    public String name;
    public String sub_name;
    public String description;
    public String image;
    public String pub_date;
    public int star;
    public Teacher teacher;
}
