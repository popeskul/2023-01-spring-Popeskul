package com.otus.homework.dto;

public class AnswerDTO {
    private String text;

    public AnswerDTO(String text) {
        this.text = text;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    @Override
    public String toString() {
        return "AnswerDTO{" +
                "text='" + text + '\'' +
                '}';
    }
}
