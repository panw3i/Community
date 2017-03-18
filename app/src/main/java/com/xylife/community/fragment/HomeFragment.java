package com.xylife.community.fragment;

import android.support.v7.widget.LinearLayoutManager;
import android.view.View;

import com.android.framewok.base.ListBaseAdapter;
import com.github.jdsjlzx.ItemDecoration.DividerDecoration;
import com.xylife.community.R;
import com.xylife.community.adapter.CourseListAdapter;
import com.xylife.community.api.APIWrapper;
import com.xylife.community.base.BaseListFragment;
import com.xylife.community.bean.Course;
import com.xylife.community.bean.ListResponse;

import rx.Observable;


public class HomeFragment extends BaseListFragment<Course> {

    @Override
    public void initView(View view) {
        super.initView(view);

        DividerDecoration divider = new DividerDecoration.Builder(getActivity())
                .setHeight(R.dimen.default_divider_height)
                .setColorResource(R.color.divider_color)
                .build();

        mRecyclerView.addItemDecoration(divider);

    }

    @Override
    protected ListBaseAdapter<Course> getListAdapter() {
        return new CourseListAdapter();
    }


    @Override
    protected void onRefresh() {

    }

    @Override
    public void initData() {
        super.initData();

    }

    @Override
    protected Observable<ListResponse<Course>> sendRequestData() {
        return APIWrapper.getInstance().getCourseList(mCurrentPage);
    }

    @Override
    protected void initLayoutManager() {
        mRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
    }


}
