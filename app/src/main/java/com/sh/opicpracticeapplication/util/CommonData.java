package com.sh.opicpracticeapplication.util;

import java.util.ArrayList;

public class CommonData {
    private static final CommonData ourInstance = new CommonData();
    ArrayList<ScriptData> mScriptList;
    ArrayList<ExamData> mExamList;

    public static CommonData getInstance() {
        return ourInstance;
    }

    private CommonData() {
        mScriptList  = new ArrayList<ScriptData>();
    }

    public ArrayList<ScriptData> getScriptList() {
        return mScriptList;
    }

    public void setScriptList(ArrayList<ScriptData> scriptList) {
        this.mScriptList = scriptList;
    }

    public ArrayList<ExamData> getExamList() {
        return mExamList;
    }

    public void setExamList(ArrayList<ExamData> examList) {
        this.mExamList = examList;
    }
}
