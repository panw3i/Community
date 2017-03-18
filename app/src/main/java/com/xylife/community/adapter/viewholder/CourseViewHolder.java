package com.xylife.community.adapter.viewholder;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.xylife.community.R;

import butterknife.BindView;
import butterknife.ButterKnife;

public class CourseViewHolder extends RecyclerView.ViewHolder{
    @BindView(R.id.cover_image) public ImageView coverImage;
    @BindView(R.id.course_name) public TextView courseNameText;
    @BindView(R.id.teacher) public TextView teacherText;
    @BindView(R.id.more_btn) public Button moreBtn;


    public CourseViewHolder(View itemView) {
        super(itemView);
        ButterKnife.bind(this,itemView);
    }
}
