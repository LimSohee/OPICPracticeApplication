package com.sh.opicpracticeapplication.script;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.sh.opicpracticeapplication.R;
import com.sh.opicpracticeapplication.util.ScriptData;
import com.sh.opicpracticeapplication.description.DescriptionActivity;
import com.sh.opicpracticeapplication.util.CommonData;

import java.util.ArrayList;

public class ScriptActivity extends AppCompatActivity {

    Context mContext;

    LinearLayout mEmptyScriptLayout;
    Button mGoDescriptionButton;

    LinearLayout mScriptLayout;
    TextView mCountTextView;
    Button mPreButton;
    Button mNextButton;
    ViewPager mScriptViewPager;
    ScriptViewPagerAdapter mScriptPagerAdapter;
    ArrayList<ScriptData> mScriptList;

    int mRealCurPosition = 0;
    int mScriptCount = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_script);
        mContext = this;

        Intent intent = getIntent();
        mScriptList =  CommonData.getInstance().getScriptList();
        mScriptCount = mScriptList.size();

        mScriptLayout = (LinearLayout) findViewById(R.id.script_layout);
        mEmptyScriptLayout = (LinearLayout) findViewById(R.id.empty_script_layout);
        if(mScriptList.size() > 0) {
            //스크립트가 있을 경우
            mScriptLayout.setVisibility(View.VISIBLE);
            mEmptyScriptLayout.setVisibility(View.GONE);

            mScriptViewPager = (ViewPager) findViewById(R.id.script_viewpager);
            mScriptPagerAdapter = new ScriptViewPagerAdapter(mContext, mScriptList);
            mScriptViewPager.setAdapter(mScriptPagerAdapter);
            mScriptViewPager.setOffscreenPageLimit(2);
            mScriptViewPager.addOnPageChangeListener(pageChangeListener);

            mCountTextView = (TextView) findViewById(R.id.count_textview);
            mRealCurPosition = mScriptCount;
            mScriptViewPager.setCurrentItem(mRealCurPosition, false);
            UpdatePositionInfo();

            mPreButton = (Button) findViewById(R.id.pre_btn);
            mPreButton.setOnClickListener(preButtonClickListener);

            mNextButton = (Button) findViewById(R.id.next_btn);
            mNextButton.setOnClickListener(nextButtonClickListener);
        }
        else {
            //스크립트가 없을 경우
            mScriptLayout.setVisibility(View.GONE);
            mEmptyScriptLayout.setVisibility(View.VISIBLE);

            mGoDescriptionButton = (Button) findViewById(R.id.go_description_btn);
            mGoDescriptionButton.setOnClickListener(GoDescriptionButtonClickListener);
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if(mScriptPagerAdapter != null)
            mScriptPagerAdapter.endQuestionOrAnswerSpeak();
    }

    //이전 버튼 Click 시
    View.OnClickListener preButtonClickListener = new View.OnClickListener(){
        @Override
        public void onClick(View v) {
            //이전 페이지로 이동
            mRealCurPosition--;
            if(mRealCurPosition < mScriptCount) { //1번째 아이템에서 마지막 아이템으로 이동하면
                mRealCurPosition = mRealCurPosition + mScriptCount;
                mScriptViewPager.setCurrentItem(mRealCurPosition, false);
            }
            else {
                mScriptViewPager.setCurrentItem(mRealCurPosition);
            }

            UpdatePositionInfo();
        }
    };

    //다음 버튼 Click 시
    View.OnClickListener nextButtonClickListener = new View.OnClickListener(){
        @Override
        public void onClick(View v) {
            //다음 페이지로 이동
            mRealCurPosition++;
            if(mRealCurPosition >= mScriptCount * 2) { //마지막 아이템에서 1번째 아이템으로 이동하면
                mRealCurPosition = mRealCurPosition - mScriptCount;
                mScriptViewPager.setCurrentItem(mRealCurPosition, false);
            }
            else {
                mScriptViewPager.setCurrentItem(mRealCurPosition);
            }

            UpdatePositionInfo();
        }
    };

    //페이지 Scroll 시
    ViewPager.OnPageChangeListener pageChangeListener = new ViewPager.OnPageChangeListener() {
        @Override
        public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

        }

        @Override
        public void onPageSelected(int position) {
            //스크롤해서 이동한 페이지로
            mRealCurPosition = position;
            if(mRealCurPosition < mScriptCount) { //1번째 아이템에서 마지막 아이템으로 이동하면
                mRealCurPosition = mRealCurPosition + mScriptCount;
                mScriptViewPager.setCurrentItem(mRealCurPosition, false);
            }
            else if(mRealCurPosition >= mScriptCount * 2) { //마지막 아이템에서 1번째 아이템으로 이동하면
                mRealCurPosition = mRealCurPosition - mScriptCount;
                mScriptViewPager.setCurrentItem(mRealCurPosition, false);
            }

            UpdatePositionInfo();
        }

        @Override
        public void onPageScrollStateChanged(int state) {
        }
    };

    //사용법 화면 이동 버튼 Click 시
    View.OnClickListener GoDescriptionButtonClickListener = new View.OnClickListener(){
        @Override
        public void onClick(View v) {
            //사용법 화면으로 이동
            Intent intent = new Intent(mContext, DescriptionActivity.class);
            intent.setFlags(Intent.FLAG_ACTIVITY_NO_HISTORY );
            startActivity(intent);
        }
    };

    //페이지 이동 및 위치 정보 디스플레이 업데이트하는 함수
    private void UpdatePositionInfo() {
        int mCurPosition = mRealCurPosition % mScriptCount;
        String positionInfo = (mCurPosition + 1) + " / " + mScriptCount;
        mCountTextView.setText(positionInfo);
    }
}
