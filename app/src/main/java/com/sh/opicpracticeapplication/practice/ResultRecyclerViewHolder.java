package com.sh.opicpracticeapplication.practice;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.sh.opicpracticeapplication.R;

public class ResultRecyclerViewHolder extends RecyclerView.ViewHolder {
    TextView fileNameTextView;
    ImageView soundButton;
    ImageView scriptViewButton;

    public ResultRecyclerViewHolder(View itemView) {
        super(itemView);

        fileNameTextView = (TextView) itemView.findViewById(R.id.filename_textview);
        soundButton = (ImageView) itemView.findViewById(R.id.sound_button);
        scriptViewButton = (ImageView) itemView.findViewById(R.id.script_view_button);
    }
}
