package com.sh.opicpracticeapplication.practice;


import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.media.MediaRecorder;
import android.os.Build;
import android.os.Environment;
import android.speech.tts.TextToSpeech;
import android.speech.tts.UtteranceProgressListener;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.sh.opicpracticeapplication.R;
import com.sh.opicpracticeapplication.util.ExamData;
import com.sh.opicpracticeapplication.util.ScriptData;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Locale;
import java.util.Timer;
import java.util.TimerTask;

public class QuestionControlView extends FrameLayout{

    Context mContext;

    private QuestionControlView.QuestionControlListener mQuestionControlListener;

    private TextView mStatusTextView;
    private ImageView mPlayButton;
    private ImageView mReplayButton;
    private ImageView mNextButton;

    public final static int MODE_PRACTICE = 0;
    public final static int MODE_EXAM = 1;
    private int mMode;
    private ArrayList<ScriptData> mScriptList;
    private ArrayList<ExamData> mExamList;
    private int mTotalQuestionCount;
    private int mCurQuestionNum;
    private boolean isReplay;

    private TextToSpeech mTTS;
    private MediaRecorder mMediaRecorder;

    private Timer timer;
    private TimerTask oneQuestionTimerTask;
    private TimerTask canReplayTimerTask;

    public QuestionControlView(Context context, AttributeSet attrs) {
        super(context, attrs);
        mContext = context;

        String infService = Context.LAYOUT_INFLATER_SERVICE;
        LayoutInflater li = (LayoutInflater) getContext().getSystemService(infService);
        View v = li.inflate(R.layout.view_question_control, this, false);
        addView(v);

        mMode = MODE_PRACTICE;
        mTotalQuestionCount = 0;
        mCurQuestionNum = 0;
        isReplay = false;

        mStatusTextView = (TextView) findViewById(R.id.status_textview);
        mStatusTextView.setText(mContext.getString(R.string.click_play_button));

        mPlayButton = (ImageView) findViewById(R.id.play_button);
        mPlayButton.setOnClickListener(playClickListener);
        mPlayButton.setVisibility(VISIBLE);
        mPlayButton.setEnabled(true);

        mReplayButton = (ImageView) findViewById(R.id.replay_button);
        mReplayButton.setOnClickListener(replayClickListener);
        mReplayButton.setVisibility(GONE);

        mNextButton = (ImageView) findViewById(R.id.next_button);
        mNextButton.setOnClickListener(nextClickListener);
        mNextButton.setEnabled(false);

        mTTS = new TextToSpeech(mContext, new TextToSpeech.OnInitListener() {
            @Override
            public void onInit(int status) {
                if(status != TextToSpeech.ERROR) {
                    //텍스트를 영어 음성으로 변환하도록 설정
                    mTTS.setLanguage(Locale.ENGLISH);
                    mTTS.setOnUtteranceProgressListener(UPL);
                }
            }
        });

        timer = new Timer(true);
    }

    UtteranceProgressListener UPL = new UtteranceProgressListener() {
        @Override
        public void onStart(String utteranceId) {
        }

        @Override
        public void onError(String utteranceId) {
        }

        @Override
        public void onDone(String utteranceId) {
            ((Activity)mContext).runOnUiThread(new Runnable() {
                @Override
                public void run() {
                    //녹음 시작
                    startRecord();

                    //Next 버튼 활성화 처리
                    mNextButton.setEnabled(true);

                    if(!isReplay) {
                        //Play버튼을 Click해서 질문 음성이 끝났으면
                        //Play 버튼 숨김 처리
                        //Replay 버튼 활성화 상태로 노출
                        mStatusTextView.setText(mContext.getString(R.string.recording));
                        mPlayButton.setVisibility(GONE);
                        mReplayButton.setVisibility(VISIBLE);
                        mReplayButton.setEnabled(true);

                        //Replay 가능한 시간(5초) 타이머 시작
                        startCanReplayTimer();
                        //질문당 추천 답변 시간(2분) 타이머 시작
                        startOneQuestionTimer();
                    }
                    else {
                        //Replay버튼을 Click해서 질문 음성이 끝났으면
                        //Play 버튼 숨김 처리
                        //Replay 버튼 비활성화 상태로 노출
                        mStatusTextView.setText(mContext.getString(R.string.recording));
                        mPlayButton.setVisibility(GONE);
                        mReplayButton.setVisibility(VISIBLE);
                        mReplayButton.setEnabled(false);

                        //Replay 가능한 시간(5초) 타이머 취소
                        cancelCanReplayTimer();
                        //질문당 추천 답변 시간(2분) 타이머 재시작
                        cancelOneQuestionTimer();
                        startOneQuestionTimer();
                    }
                }
            });
        }
    };

    //Play 버튼 Click 시
    View.OnClickListener playClickListener = new View.OnClickListener(){
        @Override
        public void onClick(View v) {
            isReplay = false;
            mStatusTextView.setText(mContext.getString(R.string.playing));
            //질문 읽어주기
            startQuestionSpeak(false);
            //Play 버튼 비활성화 처리
            mPlayButton.setEnabled(false);
            //Next 버튼 비활성화 처리
            mNextButton.setEnabled(false);
        }
    };

    //Replay 버튼 Click 시
    View.OnClickListener replayClickListener = new View.OnClickListener(){
        @Override
        public void onClick(View v) {
            isReplay = true;
            mStatusTextView.setText(mContext.getString(R.string.playing));
            //질문 읽어주기
            startQuestionSpeak(true);
            //Replay 버튼 비활성화 처리
            mReplayButton.setEnabled(false);
            //Next 버튼 비활성화 처리
            mNextButton.setEnabled(false);
        }
    };

    //Next 버튼 Click 시
    View.OnClickListener nextClickListener = new View.OnClickListener(){
        @Override
        public void onClick(View v) {
            //Replay 가능한 시간(5초) 타이머 취소되어 있지않으면 취소
            cancelCanReplayTimer();
            //질문당 추천 답변 시간(2분) 타이머 취소되어 있지않으면 취소
            cancelOneQuestionTimer();

            //녹음 중지
            endRecord();

            if(mCurQuestionNum < mTotalQuestionCount - 1) {
                mStatusTextView.setText(mContext.getString(R.string.click_play_button));
                //Play 버튼 활성화 상태로 노출
                mPlayButton.setVisibility(VISIBLE);
                mPlayButton.setEnabled(true);
                //Replay 버튼 숨김 처리
                mReplayButton.setVisibility(GONE);
                //Next 버튼 비활성화 처리
                mNextButton.setEnabled(false);

                //다음 질문으로 이동
                mCurQuestionNum++;
                mQuestionControlListener.onClickNextButton();
            }
            else {
                //마지막 스크립트인 경우, 팝업 노출
                AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(mContext);
                alertDialogBuilder.setMessage("모든 질문이 끝났습니다.\n녹음된 나의 답변을 확인하시겠습니까?")
                        .setPositiveButton("확인", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                Intent intent = new Intent(mContext, PracticeResultActivity.class);
                                intent.setFlags(Intent.FLAG_ACTIVITY_NO_HISTORY );
                                ((Activity)mContext).startActivity(intent);
                            }
                        })
                        .setNegativeButton("취소", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                ((Activity)mContext).finish();
                            }
                        });
                alertDialogBuilder.create();
                alertDialogBuilder.show();
            }
        }
    };

    //모드 변경하는 함수
    public void setMode(int mode, ArrayList<?> list) {
        mMode = mode;

        if(mode == MODE_PRACTICE) {
            mScriptList = (ArrayList<ScriptData>) list;
            mTotalQuestionCount = mScriptList.size();
        }
        else {
            mExamList = (ArrayList<ExamData>) list;
            mTotalQuestionCount = mExamList.size();
        }
    }

    //질문을 읽어주는 함수
    public void startQuestionSpeak(boolean isReplay) {
        String question = "";
        if(mMode == MODE_PRACTICE) {
            if((mScriptList == null) || (mTotalQuestionCount <= mCurQuestionNum))
                return;

            ScriptData item = (ScriptData) mScriptList.get(mCurQuestionNum);
            question = item.getQuestion();
        }
        else {
            if((mExamList == null) || (mTotalQuestionCount <= mCurQuestionNum))
                return;

            ExamData item = (ExamData) mExamList.get(mCurQuestionNum);
            question = item.getQuestion();
        }

        String utteranceId = this.hashCode() + "";
        mTTS.stop();
        if(Build.VERSION.SDK_INT < 21)
            mTTS.speak(question, TextToSpeech.QUEUE_FLUSH, null);
        else
            mTTS.speak(question, TextToSpeech.QUEUE_FLUSH, null, utteranceId);
    }

    //TTS 리소스 해제하는 함수
    public void endQuestionSpeak() {
        if (mTTS != null) {
            mTTS.stop();
            mTTS.shutdown();
        }
    }

    //녹음 시작하는 함수
    public void startRecord() {
         try {
            //OpicPracticeApplication 폴더 존재하는지 확인
            //없으면 OpicPracticeApplication폴더 생성
            File storeDir = new File(Environment.getExternalStorageDirectory(), "OpicPracticeApplication/Record");
            if (!storeDir.exists()) {
                if (!storeDir.mkdirs()) {
                    return;
                }
            }

            String fileName = "";
            if(mMode == MODE_PRACTICE) {
                ScriptData item = (ScriptData) mScriptList.get(mCurQuestionNum);
                fileName = item.getFileName();
            }
            else {
                ExamData item = (ExamData) mExamList.get(mCurQuestionNum);
                fileName = "Exam" + mCurQuestionNum;
            }

            if(mMediaRecorder == null)
                mMediaRecorder = new MediaRecorder();
            else {
                mMediaRecorder.stop();
                mMediaRecorder.reset();
            }

            mMediaRecorder.setAudioSource(MediaRecorder.AudioSource.MIC);
            mMediaRecorder.setOutputFormat(MediaRecorder.OutputFormat.THREE_GPP);
            mMediaRecorder.setAudioEncoder(MediaRecorder.AudioEncoder.AMR_NB);
            mMediaRecorder.setOutputFile(storeDir.getAbsolutePath() + "/" + fileName + ".mp3");
            mMediaRecorder.prepare();
            mMediaRecorder.start();
        }
        catch (IOException e) {
            Toast.makeText(mContext, "녹음 시작 실패!", Toast.LENGTH_SHORT).show();
        }
    }

    //녹음 끝내는 함수
    public void endRecord() {
        if(mMediaRecorder == null)
            return;

        mMediaRecorder.stop();
        mMediaRecorder.release();
        mMediaRecorder = null;
    }

    //Replay 가능한 시간(5초) 타이머 시작하는 함수
    public void startCanReplayTimer() {
        canReplayTimerTask = new TimerTask() {
            @Override
            public void run() {
                ((Activity)mContext).runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        //5초 경과했을 경우
                        //Replay 버튼 비활성화 처리
                        mReplayButton.setEnabled(false);
                        //Replay 가능한 시간(5초) 타이머 취소
                        cancelCanReplayTimer();
                    }
                });
            }

            @Override
            public boolean cancel() {
                return super.cancel();
            }
        };
        timer.schedule(canReplayTimerTask, 5000, 5000);
    }

    //Replay 가능한 시간(5초) 타이머 취소하는 함수
    public void cancelCanReplayTimer() {
        if(canReplayTimerTask != null){
            canReplayTimerTask.cancel();
            canReplayTimerTask = null;
        }
    }

    //질문당 추천 답변 시간(2분) 타이머 시작하는 함수
    public void startOneQuestionTimer() {
        oneQuestionTimerTask = new TimerTask() {
            @Override
            public void run() {
                ((Activity)mContext).runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        //2분이 경과했을 경우
                        //다음 문제로 이동하라고 안내
                        mStatusTextView.setText(mContext.getString(R.string.recommend_next_question));
                        //질문당 추천 답변 시간(2분) 타이머 취소
                        cancelOneQuestionTimer();
                    }
                });
            }

            @Override
            public boolean cancel() {
                return super.cancel();
            }
        };
        timer.schedule(oneQuestionTimerTask, 2*60*1000, 1000);
    }

    //질문당 추천 답변 시간(2분) 타이머 취소하는 함수
    public void cancelOneQuestionTimer() {
        if(oneQuestionTimerTask != null){
            oneQuestionTimerTask.cancel();
            oneQuestionTimerTask = null;
        }
    }

    public interface QuestionControlListener {
        void onClickNextButton();
    }

    public void setQuestionControlListener(QuestionControlView.QuestionControlListener questionControlListener) {
        this.mQuestionControlListener = questionControlListener;
    }
}
