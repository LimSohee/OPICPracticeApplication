package com.sh.opicpracticeapplication.util;

import android.os.Environment;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;

public class FileUtil {
    //스크립트 저장할 폴더 생성
    public static boolean makeFolder() {
        //OpicPracticeApplication 폴더 존재하는지 확인
        //없으면 OpicPracticeApplication폴더 생성
        File storeDir = new File(Environment.getExternalStorageDirectory(), "OpicPracticeApplication/Script");
        if (!storeDir.exists()) {
            if (!storeDir.mkdirs()) {
                return false;
            }
        }
        return true;
    }

    //모든 스크립트 읽어오는 함수
    public static void loadAllScript(ArrayList<ScriptData> scriptList) {
        //OpicPracticeApplication 폴더 존재하는지 확인
        //없으면 OpicPracticeApplication폴더 생성
        if(makeFolder() == false)
            return;

        //OpicPracticeApplication폴더 안에 있는 파일 모두 읽어오기
        File storeDir = new File(Environment.getExternalStorageDirectory(), "OpicPracticeApplication/Script");
        File[] fileList = storeDir.listFiles();
        if(fileList == null)
            return;

        for ( int i = 0; i < fileList.length; i++ ) {
            loadScript(fileList[i], scriptList);
        }
    }

    //스크립트 1개 읽어오는 함수
    public static void loadScript(File file, ArrayList<ScriptData> scriptList) {
        try {
            String str = "";
            String question = "";
            String answer = "";
            boolean isQuestion = true;

            FileReader fr = null;
            BufferedReader bufrd = null;
            fr = new FileReader(file);
            bufrd = new BufferedReader(fr);
            while ((str = bufrd.readLine()) != null) {
                if(str.isEmpty()) {
                    isQuestion = false;
                    continue;
                }

                if(isQuestion)
                    question += (str + "\n");
                else
                    answer += (str + "\n");
            }
            bufrd.close() ;
            fr.close() ;

            String fileFullName = file.getName();
            int fileNameIndex = fileFullName.lastIndexOf(".");
            String fileName = fileFullName.substring(0, fileNameIndex);

            scriptList.add(new ScriptData(fileName, question, answer));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
