package com.xylife.community.api;


import com.android.framewok.util.Util;
import com.xylife.community.api.util.RetrofitUtil;
import com.xylife.community.bean.Course;
import com.xylife.community.bean.CourseEntity;
import com.xylife.community.bean.ListResponse;
import com.xylife.community.bean.Response;
import com.xylife.community.exception.ApiException;

import rx.Observable;
import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Func1;
import rx.schedulers.Schedulers;

import static com.xylife.community.utils.Constant.PAGE_SIZE;

public class APIWrapper extends RetrofitUtil{

    private static APIWrapper mAPIWrapper;

    public APIWrapper(){
    }

    public static APIWrapper getInstance(){
        if(mAPIWrapper == null) {
            mAPIWrapper = new APIWrapper();
        }
        return mAPIWrapper;
    }


    public Observable<Response> login(String name, String password) {
        Observable<Response> observable = getAPIService().login(name, Util.getMD5Text(password),4);
        return observable;
    }

    public Observable<ListResponse<Course>> getCourseList(int page) {
        Observable<ListResponse<Course>> observable = getAPIService().getCourseList(page,PAGE_SIZE);
        return observable;
    }

    public Observable<Response<CourseEntity>> getCourseDetails(String courseId) {
        Observable<Response<CourseEntity>> observable = getAPIService().getCourseDetails(courseId);
        return observable;
    }

    public  <T> void toSubscribe(Observable<T> o, Subscriber<T> s){
        o.subscribeOn(Schedulers.io())
                .unsubscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(s);
    }

    /**
     * 用来统一处理Http的resultCode,并将HttpResult的Data部分剥离出来返回给subscriber
     *
     * @param <T>   Subscriber真正需要的数据类型，也就是Data部分的数据类型
     */
    private class ResponseFunc<T> implements Func1<Response<T>, T> {

        @Override
        public T call(Response<T> response) {
            if (response.total == 0) {
                throw new ApiException(100);
            }
            return response.data;
        }
    }
}
