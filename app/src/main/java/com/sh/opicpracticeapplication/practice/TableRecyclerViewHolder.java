package com.sh.opicpracticeapplication.practice;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.sh.opicpracticeapplication.R;

public class TableRecyclerViewHolder extends RecyclerView.ViewHolder {
    TextView tvQuestionNumber;

    public TableRecyclerViewHolder(View itemView) {
        super(itemView);

        tvQuestionNumber = (TextView) itemView.findViewById(R.id.question_number_textview);
    }
}
