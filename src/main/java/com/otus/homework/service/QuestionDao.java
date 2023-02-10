package com.otus.homework.service;

import com.otus.homework.domain.Answer;
import com.otus.homework.domain.Question;
import com.otus.homework.utils.FileResourcesUtils;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class QuestionDao implements Parser {
    private final String fileName;
    private final String ERROR_MESSAGE_FILED_PARSE = "Failed to parse CSV file";

    public QuestionDao(String fileName) {
        this.fileName = fileName;
    }

    public List<Question> parse() {
        List<Question> questions = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new InputStreamReader(
                new FileResourcesUtils().getFileFromResourceAsStream(fileName), StandardCharsets.UTF_8)
        )) {
            br.readLine();

            String line;
            while ((line = br.readLine()) != null) {
                String[] values = line.split(",");
                String question = values[0];
                int correctAnswerIndex = Integer.parseInt(values[values.length - 1]);

                List<Answer> answers = Arrays.stream(values)
                        .limit(values.length - 1) // get all except last element(correct answer index
                        .skip(1) // skip first element(question)
                        .map(Answer::new)
                        .collect(Collectors.toList());

                questions.add(new Question(question, answers, correctAnswerIndex));
            }
        } catch (IOException e) {
            throw new RuntimeException(ERROR_MESSAGE_FILED_PARSE, e);
        }

        return questions;
    }
}
