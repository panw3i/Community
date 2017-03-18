package com.xylife.community.api;

import com.xylife.community.bean.Course;
import com.xylife.community.bean.CourseEntity;
import com.xylife.community.bean.ListResponse;
import com.xylife.community.bean.Response;

import retrofit2.http.GET;
import retrofit2.http.Query;
import rx.Observable;

/**
 * Retrofit 2.0中我们还可以在@Url里面定义完整的URL：这种情况下Base URL会被忽略。
 */
public interface APIService {

    @GET("http://www.baidu.com/")
    Observable<Response> login(@Query("phone") String name,
                                   @Query("password") String password,
                                   @Query("userType") int userType);

    @GET("/v2/course/list")
    Observable<ListResponse<Course>> getCourseList(@Query("page") int page,@Query("pagesize") int pagesize);

    @GET("/v2/course/detail")
    Observable<Response<CourseEntity>> getCourseDetails(@Query("course_id") String courseId);
}
