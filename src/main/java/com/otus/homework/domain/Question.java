package com.otus.homework.domain;

import java.util.Collections;
import java.util.List;

public class Question {
    private String text;
    private List<Answer> answers;

    public Question(String question, List<Answer> answers) {
        this.text = question;
        this.answers = answers;
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

    @Override
    public String toString() {
        return "Question{" +
                "text='" + text + '\'' +
                ", answers=" + answers +
                '}';
    }
}
