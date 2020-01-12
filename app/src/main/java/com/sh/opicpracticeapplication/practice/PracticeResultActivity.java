package com.sh.opicpracticeapplication.practice;

import android.content.Context;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.Environment;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.method.ScrollingMovementMethod;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.sh.opicpracticeapplication.R;
import com.sh.opicpracticeapplication.util.ScriptData;
import com.sh.opicpracticeapplication.util.CommonData;

import java.util.ArrayList;

public class PracticeResultActivity extends AppCompatActivity implements ResultRecyclerViewAdapter.PracticeResultClickListener{

    Context mContext;

    private RecyclerView mPracticeResultRecyclerView;
    private ResultRecyclerViewAdapter mPracticeResultAdapter;
    private RecyclerView.LayoutManager mLayoutManager;

    private LinearLayout mScriptViewLayout;
    private ImageView mScriptCloseButton;
    private TextView mQuestionTextView;
    private TextView mAnswerTextView;

    ArrayList<ScriptData> mScriptList;

    MediaPlayer mMediaPlayer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_practice_result);
        mContext = this;

        Intent intent = getIntent();
        mScriptList = CommonData.getInstance().getScriptList();

        mPracticeResultRecyclerView = (RecyclerView) findViewById(R.id.practice_result_recyclerview);
        mLayoutManager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
        mPracticeResultRecyclerView.setLayoutManager(mLayoutManager);
        mPracticeResultAdapter = new ResultRecyclerViewAdapter(mContext, mScriptList, this);
        mPracticeResultRecyclerView.setAdapter(mPracticeResultAdapter);
        mPracticeResultRecyclerView.setItemAnimator(new DefaultItemAnimator());

        mScriptViewLayout = (LinearLayout) findViewById(R.id.script_view_layout);
        mScriptCloseButton = (ImageView) findViewById(R.id.script_close_button);
        mScriptCloseButton.setOnClickListener(ScriptCloseButtonClickListener);
        mQuestionTextView = (TextView) findViewById(R.id.textview_question_practice_result);
        mAnswerTextView = (TextView) findViewById(R.id.textview_answer_practice_result);
        mAnswerTextView.setMovementMethod(new ScrollingMovementMethod());
    }

    @Override
    protected void onDestroy() {
        endSoundPlay();
        super.onDestroy();
    }

    //스크립트 보기 버튼 Click 시
    @Override
    public void onScriptViewButtonClick(int position) {
        if((mScriptList == null) || (mScriptList.size() <= position))
            return;

        ScriptData item = (ScriptData) mScriptList.get(position);

        //스크립트 보이기
        mScriptViewLayout.setVisibility(View.VISIBLE);
        mQuestionTextView.setText(item.getQuestion());
        mAnswerTextView.setText(item.getAnwser());
    }

    //재생 버튼 Click 시
    @Override
    public void onSoundButtonClick(int position) {
        if((mScriptList == null) || (mScriptList.size() <= position))
            return;

        ScriptData item = (ScriptData) mScriptList.get(position);

        //녹음 파일 재생
        String fileName = item.getFileName();
        String filePath = Environment.getExternalStorageDirectory() + "/OpicPracticeApplication/Record/" + fileName + ".mp3";
        startSoundPlay(filePath);

        //스크립트 디스플레이하고 있는 상태이면, 스크립트 변경
        if(mScriptViewLayout.getVisibility() == View.VISIBLE) {
            onScriptViewButtonClick(position);
        }
    }

    //스크립트 닫기 버튼 Click 시
    View.OnClickListener ScriptCloseButtonClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            //스크립트 숨기기
            mScriptViewLayout.setVisibility(View.GONE);
        }
    };

    //녹음 파일 재생하는 함수
    public void startSoundPlay(String filePath) {
        try {
            if(mMediaPlayer == null)
                mMediaPlayer = new MediaPlayer();
            else {
                mMediaPlayer.stop();
                mMediaPlayer.reset();
            }

            mMediaPlayer.setDataSource(filePath);
            mMediaPlayer.prepare();
            mMediaPlayer.start();
        } catch (Exception e) {
            Toast.makeText(mContext, "녹음 파일 재생 실패!", Toast.LENGTH_SHORT).show();
        }
    }

    //MediaPlayer 리소스 해제하는 함수
    public void endSoundPlay() {
        if (mMediaPlayer != null) {
            mMediaPlayer.stop();
            mMediaPlayer.reset();
            mMediaPlayer.release();
            mMediaPlayer = null;
        }
    }
}
