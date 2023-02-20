package com.otus.homework.domain;

import java.util.Collections;
import java.util.List;

public class Question {
    private String text;
    private List<Answer> answers;
    private final int correctAnswerIndex;

    public Question(String question, List<Answer> answers, int correctAnswerIndex) {
        this.text = question;
        this.answers = answers;
        this.correctAnswerIndex = correctAnswerIndex;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public List<Answer> getAnswers() {
        return Collections.unmodifiableList(answers);
    }

    public void setAnswers(List<Answer> answers) {
        this.answers = answers;
    }

    public int getCorrectAnswerIndex() {
        return correctAnswerIndex;
    }

    @Override
    public String toString() {
        return "Question{" +
                "text='" + text + '\'' +
                ", answers=" + answers +
                ", correctAnswerIndex=" + correctAnswerIndex +
                '}';
    }
}
