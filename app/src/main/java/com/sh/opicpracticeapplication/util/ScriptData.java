package com.sh.opicpracticeapplication.util;


import java.io.Serializable;

/*
 * 스크립트 Data Model역할의 Class
 */
public class ScriptData implements Serializable {

    String fileName;
    String question;
    String answer;

    public ScriptData(String fileName, String question, String answer) {
        this.fileName = fileName;
        this.question = question;
        this.answer = answer;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }
}
