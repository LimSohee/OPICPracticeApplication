package com.sh.opicpracticeapplication.exam;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;

import com.sh.opicpracticeapplication.R;
import com.sh.opicpracticeapplication.description.DescriptionActivity;
import com.sh.opicpracticeapplication.practice.QuestionControlView;
import com.sh.opicpracticeapplication.practice.QuestionTableView;
import com.sh.opicpracticeapplication.util.CommonData;
import com.sh.opicpracticeapplication.util.ExamData;
import com.sh.opicpracticeapplication.util.ScriptData;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ExamActivity extends AppCompatActivity implements QuestionControlView.QuestionControlListener {

    Context mContext;

    LinearLayout mEmptyExamLayout;
    Button mGoDescriptionButton;

    LinearLayout mExamLayout;
    QuestionTableView mQuestionTableView;
    QuestionControlView mQuestionControlView;

    private int mCurQuestionNum;
    ArrayList<ExamData> mExamList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_exam);
        mContext = this;

        makeExamQuestion();

        mExamLayout = (LinearLayout) findViewById(R.id.exam_layout);
        mEmptyExamLayout = (LinearLayout) findViewById(R.id.empty_exam_layout);
        if(mExamList.size() > 0) {
            //시험문제가 있을 경우
            mCurQuestionNum = 0;

            mQuestionTableView = (QuestionTableView) findViewById(R.id.question_table_view);
            mQuestionTableView.setTotalQuestionCount(mExamList.size());
            mQuestionTableView.startTotalTimer();

            mQuestionControlView = (QuestionControlView) findViewById(R.id.question_control_view);
            mQuestionControlView.setMode(QuestionControlView.MODE_EXAM, mExamList);
            mQuestionControlView.setQuestionControlListener(this);
        }
        else {
            //스크립트가 없을 경우
            mExamLayout.setVisibility(View.GONE);
            mEmptyExamLayout.setVisibility(View.VISIBLE);

            mGoDescriptionButton = (Button) findViewById(R.id.go_description_btn);
            mGoDescriptionButton.setOnClickListener(GoDescriptionButtonClickListener);
        }
    }

    private void makeExamQuestion() {
        mExamList = new ArrayList<ExamData>();
        for(EXAM_QUESTION_BANK question : EXAM_QUESTION_BANK.values()) {
            if(question.getQuestion().isEmpty() == false) {
                ExamData data = new ExamData(question.getSubject(), question.getType(), question.getQuestion());
                mExamList.add(data);
                Collections.shuffle(mExamList);
            }
        }

        CommonData.getInstance().setExamList(mExamList);
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
        //다음 시험문제로 이동
        mCurQuestionNum++;
        mQuestionTableView.setCurQuestion(mCurQuestionNum);
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
