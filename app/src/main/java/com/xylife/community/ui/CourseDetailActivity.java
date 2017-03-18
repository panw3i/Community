package com.xylife.community.ui;

import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.android.framewok.util.AppToast;
import com.bumptech.glide.Glide;
import com.xylife.community.R;
import com.xylife.community.adapter.MyFragmentPagerAdapter;
import com.xylife.community.api.APIWrapper;
import com.xylife.community.api.util.RxHelper;
import com.xylife.community.api.util.RxSubscriber;
import com.xylife.community.base.BaseActivity;
import com.xylife.community.bean.CourseEntity;
import com.xylife.community.bean.Response;
import com.xylife.community.fragment.AttendNotesFragment;
import com.xylife.community.fragment.PartyDetailFragment;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import butterknife.BindArray;
import butterknife.BindView;

public class CourseDetailActivity extends BaseActivity implements TabLayout.OnTabSelectedListener,
                                                                        ViewPager.OnPageChangeListener{

    @BindView(R.id.cover_image)
    ImageView coverImage;
    @BindView(R.id.course_name)
    TextView courseNameText;
    @BindView(R.id.teacher)
    TextView teacherText;
    @BindView(R.id.publish_time)
    TextView publishTimeText;

    @BindArray(R.array.tab_bar_course_detail)
    CharSequence[] mLabels;

    @BindView(R.id.tab_layout)
    TabLayout tabs;
    @BindView(R.id.viewpager)
    ViewPager viewPager;

    private ArrayList<Fragment> mFragments = new ArrayList<>();

    @Override
    protected int getLayoutId() {
        return R.layout.activity_course_detail;
    }

    @Override
    public void initView() {
        mTitleText.setText(R.string.title_course_detail);

        tabs.addOnTabSelectedListener(this);
        for (int i = 0; i < mLabels.length; i ++) tabs.addTab(tabs.newTab().setText(mLabels[i]));

        mFragments.add(new PartyDetailFragment());
        mFragments.add(new AttendNotesFragment());
        //mFragments.add(new CommentFragment());

        viewPager.setAdapter(new MyFragmentPagerAdapter(getSupportFragmentManager(), mFragments, mLabels));
        viewPager.addOnPageChangeListener(this);
    }

    @Override
    public void initData() {
        getCourseDetails();

    }

    private void fillData(CourseEntity entity) {
        courseNameText.setText(entity.name);

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss'Z'");
        SimpleDateFormat sdf2 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

        try {
            Date date = sdf.parse(entity.pub_date);
            publishTimeText.setText("发布时间：" + sdf2.format(date));
        } catch (Exception e) {
            e.printStackTrace();
        }

        teacherText.setText("主讲：" + entity.teacher.name);

        Glide.with(mContext)
                .load(entity.image)
                .fitCenter()
                .centerCrop()
                .into(coverImage);
    }

    @Override
    public void onTabSelected(TabLayout.Tab tab) {
        viewPager.setCurrentItem(tab.getPosition());

        Toast.makeText(this, tab.getText(), Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onTabUnselected(TabLayout.Tab tab) {

    }

    @Override
    public void onTabReselected(TabLayout.Tab tab) {

    }

    @Override
    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

    }

    @Override
    public void onPageSelected(int position) {
        tabs.setScrollPosition(position, 0, true);
    }

    @Override
    public void onPageScrollStateChanged(int state) {

    }

    private void getCourseDetails() {
        String courseId = getIntent().getStringExtra("course_id");
        APIWrapper.getInstance().getCourseDetails(courseId)
                .compose(new RxHelper<Response<CourseEntity>>("正在获取数据，请稍候").io_main(CourseDetailActivity.this))
                .subscribe(new RxSubscriber<Response<CourseEntity>>() {
                    @Override
                    public void _onNext(Response<CourseEntity> response) {
                        if(response.isSuccess()){
                            CourseEntity entity = response.data;
                            fillData(entity);
                        }else {
                            AppToast.showShortText(CourseDetailActivity.this,response.msg);
                        }
                    }

                    @Override
                    public void _onError(String msg) {
                        AppToast.showShortText(CourseDetailActivity.this,"获取数据失败");
                        gotoActivity(MainActivity.class);
                    }
                });
    }
}
