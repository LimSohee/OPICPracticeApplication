package com.sh.opicpracticeapplication.practice;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;

import com.sh.opicpracticeapplication.R;
import com.sh.opicpracticeapplication.description.DescriptionActivity;
import com.sh.opicpracticeapplication.util.ScriptData;
import com.sh.opicpracticeapplication.util.CommonData;

import java.util.ArrayList;

public class PracticeActivity extends AppCompatActivity implements QuestionControlView.QuestionControlListener {

    Context mContext;

    LinearLayout mEmptyScriptLayout;
    Button mGoDescriptionButton;

    LinearLayout mPracticeLayout;
    QuestionTableView mQuestionTableView;
    QuestionControlView mQuestionControlView;
    ScriptView mScriptView;
    Button mShowScriptButton;

    private int mCurQuestionNum;
    ArrayList<ScriptData> mScriptList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_practice);
        mContext = this;

        mScriptList = CommonData.getInstance().getScriptList();

        mPracticeLayout = (LinearLayout) findViewById(R.id.practice_layout);
        mEmptyScriptLayout = (LinearLayout) findViewById(R.id.empty_script_layout);
        if(mScriptList.size() > 0) {
            //스크립트가 있을 경우
            mCurQuestionNum = 0;

            mQuestionTableView = (QuestionTableView) findViewById(R.id.question_table_view);
            mQuestionTableView.setTotalQuestionCount(mScriptList.size());
            mQuestionTableView.startTotalTimer();

            mQuestionControlView = (QuestionControlView) findViewById(R.id.question_control_view);
            mQuestionControlView.setMode(QuestionControlView.MODE_PRACTICE, mScriptList);
            mQuestionControlView.setQuestionControlListener(this);

            mScriptView = (ScriptView) findViewById(R.id.script_view);
            mScriptView.setScriptList(mScriptList);

            mShowScriptButton = (Button) findViewById(R.id.show_script_btn);
        }
        else {
            //스크립트가 없을 경우
            mPracticeLayout.setVisibility(View.GONE);
            mEmptyScriptLayout.setVisibility(View.VISIBLE);

            mGoDescriptionButton = (Button) findViewById(R.id.go_description_btn);
            mGoDescriptionButton.setOnClickListener(GoDescriptionButtonClickListener);
        }
    }

    @Override
    protected void onDestroy() {
        if(mQuestionControlView != null)
            mQuestionControlView.endQuestionSpeak();

        if(mQuestionTableView != null)
            mQuestionTableView.stopTotalTimer();

        super.onDestroy();
    }

    //Next 버튼 Click 시
    @Override
    public void onClickNextButton() {
        //다음 스크립트로 이동
        mCurQuestionNum++;
        mQuestionTableView.setCurQuestion(mCurQuestionNum);
        mScriptView.setCurQuestion(mCurQuestionNum);
    }

    //Show Script 버튼 Click 시
    public void onClickShowScripttButton(View v) {
        if(mScriptView.getVisibility() == View.VISIBLE) {
            mScriptView.setVisibility(View.INVISIBLE); //스크립트 숨기기
            mShowScriptButton.setText(R.string.show_script);
        }
        else {
            mScriptView.setVisibility(View.VISIBLE); //스크립트 보이기
            mShowScriptButton.setText(R.string.hide_script);
        }
    }

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
}
