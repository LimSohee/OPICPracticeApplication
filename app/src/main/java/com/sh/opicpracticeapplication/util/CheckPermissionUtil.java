package com.sh.opicpracticeapplication.util;

import android.Manifest;
import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Build;
import android.support.annotation.NonNull;
import android.support.v7.app.AlertDialog;
import android.widget.Toast;

import com.sh.opicpracticeapplication.exam.ExamActivity;
import com.sh.opicpracticeapplication.practice.PracticeActivity;

import java.util.ArrayList;

public class CheckPermissionUtil {

    private static final int SCRIPT_LOAD_RESULT_CODE = 0;
    private static final int RECORD_AUDIO_RESULT_CODE_FOR_PRACTICE = 1;
    private static final int RECORD_AUDIO_RESULT_CODE_FOR_EXAM = 2;

    public static void checkScriptWriteAndReadPermission(final Context context) {
        final Activity activity = (Activity) context;

        //사용자의 OS 버전이 마시멜로우 이상인지 체크
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            int permissionResult = context.checkSelfPermission(Manifest.permission.WRITE_EXTERNAL_STORAGE);
            if (permissionResult == PackageManager.PERMISSION_DENIED) {
                if (activity.shouldShowRequestPermissionRationale(Manifest.permission.WRITE_EXTERNAL_STORAGE)) {
                    //권한이 필요한 이유 설명이 필요한 경우
                    AlertDialog.Builder dialog = new AlertDialog.Builder(context);
                    dialog.setTitle("권한이 필요합니다.")
                            .setMessage("Script를 저장할 폴더 및 Script파일을 생성 또는 읽어오기 위해서는 단말기의 \"WRITE_EXTERNAL_STORAGE\" 권한이 필요합니다. 계속 하시겠습니까?")
                            .setPositiveButton("네", new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialog, int which) {
                                    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                                        //WRITE_EXTERNAL_STORAGE 권한 요청 함
                                        activity.requestPermissions(new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE}, SCRIPT_LOAD_RESULT_CODE);
                                    }
                                }
                            })
                            .setNegativeButton("아니요", new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialog, int which) {
                                    //WRITE_EXTERNAL_STORAGE 권한 거부 함
                                    Toast.makeText(context, "\"WRITE_EXTERNAL_STORAGE\" 권한을 거부하여 Script를 읽어올 수 없습니다.", Toast.LENGTH_SHORT).show();
                                }
                            })
                            .create()
                            .show();
                } else {
                    ///권한이 필요한 이유 설명이 필요없는 경우, WRITE_EXTERNAL_STORAGE 권한 요청 함
                    activity.requestPermissions(new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE}, SCRIPT_LOAD_RESULT_CODE);
                }
            } else {
                //WRITE_EXTERNAL_STORAGE 권한 획득 상태 임
                //모든 스크립트 읽어오기
                loadAllScript();
            }
        } else {
            //마시멜로우 미만 버전일 때, WRITE_EXTERNAL_STORAGE 권한 획득 상태 임
            //모든 스크립트 읽어오기
            loadAllScript();
        }
    }

    private final static int FROM_PRACTICE = 1;
    private final static int FROM_EXAM = 2;
    public static void checkRecordAudioPermission(final Context context, final int from) {
        final Activity activity = (Activity) context;

        //사용자의 OS 버전이 마시멜로우 이상인지 체크
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            int permissionResult = context.checkSelfPermission(Manifest.permission.RECORD_AUDIO);
            if (permissionResult == PackageManager.PERMISSION_DENIED) {
                if (activity.shouldShowRequestPermissionRationale(Manifest.permission.RECORD_AUDIO)) {
                    //권한이 필요한 이유 설명이 필요한 경우
                    AlertDialog.Builder dialog = new AlertDialog.Builder(context);
                    dialog.setTitle("권한이 필요합니다.")
                            .setMessage("실전 연습하기/시험보기를 이용하기 위해서는 단말기의 \"RECORD_AUDIO\" 권한이 필요합니다. 계속 하시겠습니까?")
                            .setPositiveButton("네", new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialog, int which) {
                                    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                                        //RECORD_AUDIO 권한 요청 함
                                        if(from == FROM_PRACTICE)
                                            activity.requestPermissions(new String[]{Manifest.permission.RECORD_AUDIO}, RECORD_AUDIO_RESULT_CODE_FOR_PRACTICE);
                                        else
                                            activity.requestPermissions(new String[]{Manifest.permission.RECORD_AUDIO}, RECORD_AUDIO_RESULT_CODE_FOR_EXAM);
                                    }
                                }
                            })
                            .setNegativeButton("아니요", new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialog, int which) {
                                    //RECORD_AUDIO 권한 거부 함
                                    Toast.makeText(context, "\"RECORD_AUDIO\" 권한을 거부하여 실전 연습하기/시험보기를 이용할 수 없습니다.", Toast.LENGTH_SHORT).show();
                                }
                            })
                            .create()
                            .show();
                } else {
                    ///권한이 필요한 이유 설명이 필요없는 경우, RECORD_AUDIO 권한 요청 함
                    if(from == FROM_PRACTICE)
                        activity.requestPermissions(new String[]{Manifest.permission.RECORD_AUDIO}, RECORD_AUDIO_RESULT_CODE_FOR_PRACTICE);
                    else
                        activity.requestPermissions(new String[]{Manifest.permission.RECORD_AUDIO}, RECORD_AUDIO_RESULT_CODE_FOR_EXAM);
                }
            } else {
                //RECORD_AUDIO 권한 획득 상태 임
                if(from == FROM_PRACTICE)
                    goPracticeActivity(context); //실전 연습 화면으로 이동
                else
                    goExamActivity(context); //시험보기 화면으로 이동
            }
        } else {
            //마시멜로우 미만 버전일 때, RECORD_AUDIO 권한 획득 상태 임
            if(from == FROM_PRACTICE)
                goPracticeActivity(context); //실전 연습 화면으로 이동
            else
                goExamActivity(context); //시험보기 화면으로 이동
        }
    }

    public static void onRequestPermissionsResult(Context context, int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        if (Build.VERSION.SDK_INT >= 23) {
            if(grantResults[0]== PackageManager.PERMISSION_GRANTED){
                if(requestCode == SCRIPT_LOAD_RESULT_CODE) {
                    //모든 스크립트 읽어오기
                    loadAllScript();
                }
                else if(requestCode == RECORD_AUDIO_RESULT_CODE_FOR_PRACTICE) {
                    //실전 연습 화면으로 이동
                    goPracticeActivity(context);
                }
                else if(requestCode == RECORD_AUDIO_RESULT_CODE_FOR_EXAM) {
                    //시험보기 화면으로 이동
                    goExamActivity(context);
                }
            }
        }
    }

    private static void loadAllScript() {
        //모든 스크립트 읽어오기
        ArrayList<ScriptData> scriptList = new ArrayList<ScriptData>();
        FileUtil.loadAllScript(scriptList);
        CommonData.getInstance().setScriptList(scriptList);
    }

    private static void goPracticeActivity(Context context) {
        //실전 연습 화면으로 이동
        Intent intent = new Intent(context, PracticeActivity.class);
        context.startActivity(intent);
    }

    private static void goExamActivity(Context context) {
        //시험보기 화면으로 이동
        Intent intent = new Intent(context, ExamActivity.class);
        context.startActivity(intent);
    }
}
