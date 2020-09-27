package com.sh.opicpracticeapplication.practice;


import android.content.Context;
import android.text.method.ScrollingMovementMethod;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;

import com.sh.opicpracticeapplication.R;
import com.sh.opicpracticeapplication.util.ScriptData;

import java.util.ArrayList;

public class ScriptView extends FrameLayout {

    Context mContext;

    private TextView mQuestionTextView;
    private TextView mAnswerTextView;

    ArrayList<ScriptData> mScriptList;

    public ScriptView(Context context, AttributeSet attrs) {
        super(context, attrs);
        mContext = context;

        String infService = Context.LAYOUT_INFLATER_SERVICE;
        LayoutInflater li = (LayoutInflater) getContext().getSystemService(infService);
        View v = li.inflate(R.layout.view_script, this, false);
        addView(v);

        mQuestionTextView = (TextView) findViewById(R.id.textview_question_practice);
        mAnswerTextView = (TextView) findViewById(R.id.textview_answer_practice);
        mAnswerTextView.setMovementMethod(new ScrollingMovementMethod());
    }

    //스크립트 리스트를 변경하는 함수
    public void setScriptList(ArrayList<ScriptData> scriptList) {
        mScriptList = scriptList;

        if((mScriptList != null) && (mScriptList.size() > 0)) {
            //첫번째 스크립트로 변경
            ScriptData item = (ScriptData) mScriptList.get(0);
            mQuestionTextView.setText(item.getQuestion());
            mAnswerTextView.setText(item.getAnswer());
        }
    }

    //curQuestionNum번째 스크립트로 변경하는 함수
    public void setCurQuestion(int curQuestionNum) {
        if((mScriptList == null) || (mScriptList.size() <= curQuestionNum))
            return;

        ScriptData item = (ScriptData) mScriptList.get(curQuestionNum);
        mQuestionTextView.setText(item.getQuestion());
        mAnswerTextView.setText(item.getAnswer());
    }
}
