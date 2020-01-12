package com.sh.opicpracticeapplication.script;


import android.content.Context;
import android.speech.tts.TextToSpeech;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.text.method.ScrollingMovementMethod;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.sh.opicpracticeapplication.R;
import com.sh.opicpracticeapplication.util.ScriptData;

import java.util.List;
import java.util.Locale;


/*
 * ScriptViewPager내 각각의 Item View들에 Data를 binding 시켜주는 역할의 Class
 */
public class ScriptViewPagerAdapter extends PagerAdapter {
    Context mContext;
    List mItemList;

    TextView mQuestionTextView;
    ImageView mQuestionSoundImageView;
    TextView mAnswerTextView;
    ImageView mAnswerSoundImageView;

    private TextToSpeech mTTS;

    public ScriptViewPagerAdapter(Context context, List aItemList) {
        this.mContext = context;
        this.mItemList = aItemList;
        this.mTTS = new TextToSpeech(mContext, new TextToSpeech.OnInitListener() {
            @Override
            public void onInit(int status) {
                if(status != TextToSpeech.ERROR) {
                    //텍스트를 영어 음성으로 변환하도록 설정
                    mTTS.setLanguage(Locale.ENGLISH);
                }
            }
        });
    }

    /*
     * 아이템 개수를 가져오는 함수
     */
    @Override
    public int getCount() {
        return mItemList.size()*3;
    }

    /*
     * instantiateItem에서 생성한 View를 사용할지 여부를 판단하는 함수
     */
    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view == ((LinearLayout) object);
    }

    /*
     * 해당 position의 View의 너비를 설정하는 함수
     */
    @Override
    public float getPageWidth(int position) {
        return 1.0f;
    }

    /*
     * 해당 position의 View를 container에서 설정하는 함수
     * 화면에서 보이는 View를 생성하고 설정한다.
     */
    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        LayoutInflater mInflater = (LayoutInflater) mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View itemView = mInflater.inflate(R.layout.item_viewpager_script, container, false);

        position %= mItemList.size(); //생성할 아이템은 포지션을 3으로 나눈 나머지로 계산

        ScriptData item = (ScriptData) mItemList.get(position);

        //질문
        mQuestionTextView = (TextView) itemView.findViewById(R.id.textview_script_question);
        mQuestionTextView.setText(item.getQuestion());

        mQuestionSoundImageView = (ImageView) itemView.findViewById(R.id.imageview_question_sound);
        mQuestionSoundImageView.setTag(position);
        mQuestionSoundImageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int position = (int) v.getTag();
                startQuestionSpeak(position);
            }
        });

        //답변
        mAnswerTextView = (TextView) itemView.findViewById(R.id.textview_script_answer);
        mAnswerTextView.setMovementMethod(new ScrollingMovementMethod());
        mAnswerTextView.setText(item.getAnwser());

        mAnswerSoundImageView = (ImageView) itemView.findViewById(R.id.imageview_answer_sound);
        mAnswerSoundImageView.setTag(position);
        mAnswerSoundImageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int position = (int) v.getTag();
                startAnswerSpeak(position);
            }
        });

        ((ViewPager) container).addView(itemView);
        return itemView;
    }

    /*
     * 해당 position의 View를 container에서 제거하는 함수
     * 화면에서 사라진 View를 제거한다.
     */
    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        ((ViewPager) container).removeView((LinearLayout) object);
    }

    //스크립트의 질문을 읽어주는 함수
    public void startQuestionSpeak(int position) {
        ScriptData item = (ScriptData) mItemList.get(position);
        String question = item.getQuestion();
        mTTS.speak(question, TextToSpeech.QUEUE_FLUSH, null);
    }

    //스크립트의 답변을 읽어주는 함수
    public void startAnswerSpeak(int position) {
        ScriptData item = (ScriptData) mItemList.get(position);
        String answer = item.getAnwser();
        mTTS.speak(answer, TextToSpeech.QUEUE_FLUSH, null);
    }

    //TTS 리소스 해제하는 함수
    public void endQuestionOrAnswerSpeak() {
        if (mTTS != null) {
            mTTS.stop();
            mTTS.shutdown();
        }
    }
}
