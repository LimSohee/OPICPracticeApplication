package com.sh.opicpracticeapplication.util;


import com.sh.opicpracticeapplication.exam.EXAM_QUESTION_BANK;

import java.io.Serializable;

/*
 * 시험문제 Data Model역할의 Class
 */
public class ExamData implements Serializable {

    String question;
    EXAM_QUESTION_BANK.SUBJECT subject;
    EXAM_QUESTION_BANK.TYPE type;

    public ExamData(EXAM_QUESTION_BANK.SUBJECT subject, EXAM_QUESTION_BANK.TYPE type, String question) {
        this.subject = subject;
        this.type = type;
        this.question = question;
    }

    public EXAM_QUESTION_BANK.SUBJECT getSubject() {
        return subject;
    }

    public void setSubject(EXAM_QUESTION_BANK.SUBJECT subject) {
        this.subject = subject;
    }

    public EXAM_QUESTION_BANK.TYPE getType() {
        return type;
    }

    public void setType(EXAM_QUESTION_BANK.TYPE type) {
        this.type = type;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }
}
