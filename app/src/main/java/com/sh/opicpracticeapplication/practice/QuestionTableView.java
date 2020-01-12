package com.sh.opicpracticeapplication.practice;


import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;

import com.sh.opicpracticeapplication.R;
import com.sh.opicpracticeapplication.util.ScriptData;

import java.util.ArrayList;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

public class QuestionTableView extends FrameLayout {

    Context mContext;

    private GridLayoutManager mGridLayoutManager;
    private RecyclerView mQuestionTableRecyclerView;
    private TableRecyclerViewAdapter mQuestionTableAdapter;
    List mQuestionTableItemList;

    final TextView mCurTimeTextView;

    private int mCurQuestionNum;
    private int mTotalQuestionCount;

    private Timer timer;
    private TimerTask totalTimerTask;

    public QuestionTableView(Context context, AttributeSet attrs) {
        super(context, attrs);
        mContext = context;

        String infService = Context.LAYOUT_INFLATER_SERVICE;
        LayoutInflater li = (LayoutInflater) getContext().getSystemService(infService);
        View v = li.inflate(R.layout.view_question_table, this, false);
        addView(v);

        mCurQuestionNum = 0;
        mTotalQuestionCount = 0;

        mQuestionTableRecyclerView = (RecyclerView) findViewById(R.id.question_table_recyclerview);
        mGridLayoutManager = new GridLayoutManager(mContext, 4);
        mQuestionTableRecyclerView.setLayoutManager(mGridLayoutManager);
        mQuestionTableItemList = new ArrayList<>();
        mQuestionTableAdapter = new TableRecyclerViewAdapter(mContext, mQuestionTableItemList);
        mQuestionTableRecyclerView.setAdapter(mQuestionTableAdapter);
        mQuestionTableRecyclerView.setItemAnimator(new DefaultItemAnimator());

        mCurTimeTextView = (TextView) findViewById(R.id.textview_current_time);
        mCurTimeTextView.setText("00:00");

        timer = new Timer(true);
    }

    //스크립트 리스트를 변경하는 함수
    public void setTotalQuestionCount(int totalQuestionCount) {
        mTotalQuestionCount = totalQuestionCount;

        //첫번째 질문 번호로 표시
        mQuestionTableItemList.clear();
        for(int i=0; i<mTotalQuestionCount; i++) {
            int nQuestionNum = i+1;
            if(i == 0)
                mQuestionTableItemList.add(new TableRecyclerViewItem(nQuestionNum, true));
            else
                mQuestionTableItemList.add(new TableRecyclerViewItem(nQuestionNum, false));
        }
        mQuestionTableAdapter.notifyDataSetChanged();
    }

    //curQuestionNum번째 질문 번호로 표시 변경하는 함수
    public void setCurQuestion(int curQuestionNum) {
        TableRecyclerViewItem preItem = (TableRecyclerViewItem) mQuestionTableItemList.get(mCurQuestionNum);
        preItem.setCurQuestion(false);

        TableRecyclerViewItem nextItem = (TableRecyclerViewItem) mQuestionTableItemList.get(curQuestionNum);
        nextItem.setCurQuestion(true);

        mQuestionTableAdapter.notifyDataSetChanged();

        mCurQuestionNum = curQuestionNum;
    }

    //타이머 작동하는 함수
    public void startTotalTimer() {
        final long startTime = System.currentTimeMillis();
        totalTimerTask = new TimerTask() {
            @Override
            public void run() {
                ((Activity)mContext).runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        long currentTime = System.currentTimeMillis();
                        long gapTime = (currentTime - startTime) / 1000;
                        long min = gapTime / 60;
                        long sec = gapTime % 60;
                        String strTime = String.format("%02d:%02d", min, sec);
                        mCurTimeTextView.setText(strTime);

                        if(gapTime >= 40*60) {
                            timer.cancel();
                            //40분이 경과했을 경우, 팝업 노출 후 연습페이지 나감
                            AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(mContext);
                            alertDialogBuilder.setMessage("끝났습니다.")
                                    .setPositiveButton("확인", new DialogInterface.OnClickListener() {
                                        @Override
                                        public void onClick(DialogInterface dialog, int which) {
                                            ((Activity)mContext).finish();
                                        }
                                    });
                            alertDialogBuilder.create();
                            alertDialogBuilder.show();
                        }
                    }
                });
            }

            @Override
            public boolean cancel() {
                return super.cancel();
            }
        };
        timer.schedule(totalTimerTask, 0, 1000);
    }


    //타이머 멈추는 함수
    public void stopTotalTimer() {
        if(totalTimerTask != null){
            totalTimerTask.cancel();
            totalTimerTask = null;
        }
    }
}
