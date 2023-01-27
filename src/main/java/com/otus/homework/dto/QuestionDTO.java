package com.otus.homework.dto;

import java.util.List;

public class QuestionDTO {
    private String text;
    private List<AnswerDTO> answers;

    public QuestionDTO(String text, List<AnswerDTO> answers) {
        this.text = text;
        this.answers = answers;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public List<AnswerDTO> getAnswers() {
        return answers;
    }

    public void setAnswers(List<AnswerDTO> answers) {
        this.answers = answers;
    }
    @Override
    public String toString() {
        return "QuestionDTO{" +
                "text='" + text + '\'' +
                ", answers=" + answers +
                '}';
    }
}
