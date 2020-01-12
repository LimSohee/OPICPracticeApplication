package com.sh.opicpracticeapplication.practice;

import android.content.Context;
import android.graphics.Color;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.sh.opicpracticeapplication.R;

import java.util.ArrayList;
import java.util.List;

public class TableRecyclerViewAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    Context mContext;

    private List<TableRecyclerViewItem> itemList;

    public TableRecyclerViewAdapter(Context context, List<TableRecyclerViewItem> itemList) {
        this.mContext = context;
        this.itemList = itemList;
    }

    public void setItemDomainList(List<TableRecyclerViewItem> itemList) {
        this.itemList = itemList;
    }

    /*
     * 뒤에 아이템 추가하는 함수
     * @param item 아이템
     */
    public void addItem(TableRecyclerViewItem item) {
        this.itemList.add(item);
    }


    /*
     * 특정 위치에 아이템 추가하는 함수
     * @param item 아이템
     * @param position 위치
     */
    public void addData(TableRecyclerViewItem newItem, int position) {
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
    public TableRecyclerViewItem getItem(int position) {
        return itemList.get(position);
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        RecyclerView.ViewHolder viewHolder = null;
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_recyclerview_question_table, parent, false);
        viewHolder = new TableRecyclerViewHolder(itemView);

        return viewHolder;
    }

    /*
     * 만들어진 ViewHolder에 데이터를 넣는 함수
     * ListView의 getView()와 동일
     */
    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        TableRecyclerViewItem item = itemList.get(position);

        TextView QuestionNumTextView= ((TableRecyclerViewHolder) holder).tvQuestionNumber;
        QuestionNumTextView.setText(String.valueOf(item.getQuestionNumber()));
        if(item.isCurQuestion)
            QuestionNumTextView.setSelected(true);
        else
            QuestionNumTextView.setSelected(false);
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
}
