package com.sh.opicpracticeapplication.practice;


public class TableRecyclerViewItem {
    int questionNumber;
    boolean isCurQuestion;

    public TableRecyclerViewItem(int questionNumber, boolean isCurQuestion) {
        this.questionNumber = questionNumber;
        this.isCurQuestion = isCurQuestion;
    }

    public int getQuestionNumber() {
        return questionNumber;
    }

    public void setQuestionNumber(int questionNumber) {
        this.questionNumber = questionNumber;
    }

    public boolean isCurQuestion() {
        return isCurQuestion;
    }

    public void setCurQuestion(boolean curQuestion) {
        isCurQuestion = curQuestion;
    }
}

