package com.otus.homework.service;

import com.otus.homework.dto.AnswerDTO;
import com.otus.homework.dto.QuestionDTO;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class CsvParseService {
    private final String filePath;
    private final QuestionService questionService;
    private final AnswerService answerService;

    public CsvParseService(String filePath, QuestionService questionService, AnswerService answerService) {
        this.filePath = filePath;
        this.questionService = questionService;
        this.answerService = answerService;
    }

    public List<QuestionDTO> parseCsvQuestionsAndAnswers() throws IOException {
        List<QuestionDTO> questions = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;

            // first line is the header
            br.readLine();

            while ((line = br.readLine()) != null) {
                String[] values = line.split(",");
                String question = values[0];
                List<AnswerDTO> answers = new ArrayList<>();

                for (int i = 1; i < values.length; i++) {
                    answers.add(answerService.createAnswer(values[i]));
                    System.out.println("Answer: " + values[i]);
                }

                questions.add(questionService.createQuestion(question, answers));
            }
        }

        return questions;
    }
}
