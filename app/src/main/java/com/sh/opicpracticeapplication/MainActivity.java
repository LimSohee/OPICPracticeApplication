package com.sh.opicpracticeapplication;


import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import com.sh.opicpracticeapplication.description.DescriptionActivity;
import com.sh.opicpracticeapplication.script.ScriptActivity;
import com.sh.opicpracticeapplication.util.CheckPermissionUtil;

public class MainActivity extends AppCompatActivity {
    Context mContext;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mContext = this;

        //스크립트 파일 생성 및 불러올 수 있는 권한이 있는지 확인 후, 스크립트 불러오기
        CheckPermissionUtil.checkScriptWriteAndReadPermission(mContext);

        //스크립트 버튼
        Button scriptBtn = (Button) findViewById(R.id.script_btn);
        scriptBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //스크립트 보기 버튼 Click 시
                //스크립트 화면 이동
                Intent intent = new Intent(mContext, ScriptActivity.class);
                startActivity(intent);
            }
        });

        //실전 연습하기 버튼
        Button practiceBtn = (Button) findViewById(R.id.practice_btn);
        practiceBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //녹음 권한이 있는지 확인 후, 실전연습하기 화면으로 이동
                CheckPermissionUtil.checkRecordAudioPermission(mContext, 1);
            }
        });

        //시험보기 버튼
        Button examBtn = (Button) findViewById(R.id.exam_btn);
        examBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //녹음 권한이 있는지 확인 후, 시험보기 화면으로 이동
                CheckPermissionUtil.checkRecordAudioPermission(mContext, 2);
            }
        });

        //사용법 버튼
        Button descriptionBtn = (Button) findViewById(R.id.description_btn);
        descriptionBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //사용법 버튼 Click 시
                //사용법 화면으로 이동
                Intent intent = new Intent(mContext, DescriptionActivity.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_NO_HISTORY );
                startActivity(intent);
            }
        });
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        CheckPermissionUtil.onRequestPermissionsResult(mContext, requestCode, permissions, grantResults);
    }
}
