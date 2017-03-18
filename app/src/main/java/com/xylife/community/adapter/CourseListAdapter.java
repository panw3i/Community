package com.xylife.community.adapter;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.android.framewok.base.ListBaseAdapter;
import com.bumptech.glide.Glide;
import com.xylife.community.R;
import com.xylife.community.adapter.viewholder.CourseViewHolder;
import com.xylife.community.bean.Course;
import com.xylife.community.ui.CourseDetailActivity;

public class CourseListAdapter extends ListBaseAdapter<Course> {

    private Context mContext;

    public CourseListAdapter() {
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        mContext = parent.getContext();
        View view = LayoutInflater.from(mContext).inflate(R.layout.layout_list_item_course, parent, false);
        return new CourseViewHolder(view);
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, final int position) {
        final CourseViewHolder viewHolder = (CourseViewHolder) holder;
        final Course course = this.mDataList.get(position);

        viewHolder.courseNameText.setText(course.name);
        viewHolder.teacherText.setText("讲师：" + course.teacher.name);

        Glide.with(mContext)
                .load(course.image)
                .fitCenter()
                .centerCrop()
                .into(viewHolder.coverImage);

        viewHolder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(mContext, CourseDetailActivity.class);
                intent.putExtra("course_id",course.id+"");
                mContext.startActivity(intent);
            }
        });

    }

}
