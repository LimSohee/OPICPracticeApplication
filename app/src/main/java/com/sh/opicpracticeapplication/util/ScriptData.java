package com.sh.opicpracticeapplication.util;


import java.io.Serializable;

/*
 * 스크립트 Data Model역할의 Class
 */
public class ScriptData implements Serializable {

    String fileName;
    String question;
    String anwser;

    public ScriptData(String fileName, String question, String anwser) {
        this.fileName = fileName;
        this.question = question;
        this.anwser = anwser;
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

    public String getAnwser() {
        return anwser;
    }

    public void setAnwser(String anwser) {
        this.anwser = anwser;
    }
}
