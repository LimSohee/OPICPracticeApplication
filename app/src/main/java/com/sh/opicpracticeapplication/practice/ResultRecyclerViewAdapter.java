package com.sh.opicpracticeapplication.practice;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.sh.opicpracticeapplication.R;
import com.sh.opicpracticeapplication.util.ScriptData;

import java.util.ArrayList;
import java.util.List;

public class ResultRecyclerViewAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    Context mContext;

    PracticeResultClickListener mPracticeResultClickListener;

    private List<ScriptData> itemList;

    public ResultRecyclerViewAdapter(Context context, List<ScriptData> itemList, PracticeResultClickListener practiceResultClickListener) {
        this.mContext = context;
        this.itemList = itemList;
        this.mPracticeResultClickListener = practiceResultClickListener ;
    }

    public void setItemDomainList(List<ScriptData> itemList) {
        this.itemList = itemList;
    }

    /*
     * 뒤에 아이템 추가하는 함수
     * @param item 아이템
     */
    public void addItem(ScriptData item) {
        this.itemList.add(item);
    }


    /*
     * 특정 위치에 아이템 추가하는 함수
     * @param item 아이템
     * @param position 위치
     */
    public void addData(ScriptData newItem, int position) {
        itemList.add(position, newItem);
        notifyItemInserted(position);
    }

    /*
     * 특정 위치의 아이템 삭제하기
     * @param position 위치
     */
    public void removeItem(int position) {
        itemList.remove(position);
        notifyItemRemoved(position);
    }

    /*
     * 모든 아이템 삭제하기
     */
    public void clearAllItem() {
        this.itemList.clear();
    }

    /*
     * 특정 위치의 아이템 가져오기
     */
    public ScriptData getItem(int position) {
        return itemList.get(position);
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        RecyclerView.ViewHolder viewHolder = null;
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_recyclerview_practice_result, parent, false);
        viewHolder = new ResultRecyclerViewHolder(itemView);

        return viewHolder;
    }

    /*
     * 만들어진 ViewHolder에 데이터를 넣는 함수
     * ListView의 getView()와 동일
     */
    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        final ScriptData item = itemList.get(position);

        //파일 이름
        String fileName = item.getFileName();
        ((ResultRecyclerViewHolder) holder).fileNameTextView.setText(fileName);

        //녹음 음성 재생 버튼
        ImageView soundButton = ((ResultRecyclerViewHolder) holder).soundButton;
        soundButton.setTag(position);
        soundButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int position = (int)v.getTag();
                if (mPracticeResultClickListener != null) {
                    mPracticeResultClickListener.onSoundButtonClick(position);
                }
            }
        });

        //스크립트 보기 버튼
        ImageView scriptViewButton = ((ResultRecyclerViewHolder) holder).scriptViewButton;
        scriptViewButton.setTag(position);
        scriptViewButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int position = (int)v.getTag();
                if (mPracticeResultClickListener != null) {
                    mPracticeResultClickListener.onScriptViewButtonClick(position);
                }
            }
        });
    }

    /*
     * 아이템 개수를 가져오는 함수
     */
    @Override
    public int getItemCount() {
        if(itemList == null)
            itemList = new ArrayList<>();

        return itemList.size();
    }

    public interface PracticeResultClickListener {
        void onScriptViewButtonClick(int position);
        void onSoundButtonClick(int position);
    }
}
