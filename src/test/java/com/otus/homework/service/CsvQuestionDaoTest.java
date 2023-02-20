package com.otus.homework.service;

import com.otus.homework.domain.Answer;
import com.otus.homework.domain.Question;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(MockitoExtension.class)
public class CsvQuestionDaoTest {
    private QuestionDao csvQuestionDao;

    @BeforeEach
    public void setup() {
        csvQuestionDao = new QuestionDao("questions_answers_test.csv");
    }

    @Test
    public void parseCsvQuestionsAndAnswersTest() {
        List<Answer> answers = new ArrayList<>();
        answers.add(new Answer("Answer1"));
        answers.add(new Answer("Answer2"));
        int correctAnswerIndex = 1;
        Question question = new Question("Question 1?", answers, correctAnswerIndex);
        List<Question> expectedQuestions = new ArrayList<>();
        expectedQuestions.add(question);

        List<Question> actualQuestions = csvQuestionDao.parse();

        assertEquals(expectedQuestions.size(), actualQuestions.size());
        assertEquals(expectedQuestions.get(0).getText(), actualQuestions.get(0).getText());

        assertEquals(expectedQuestions.get(0).getAnswers().size(), actualQuestions.get(0).getAnswers().size());
        for (int i = 0; i < expectedQuestions.get(0).getAnswers().size(); i++) {
            assertEquals(expectedQuestions.get(0).getAnswers().get(i).getText(), actualQuestions.get(0).getAnswers().get(i).getText());
        }

        assertEquals(expectedQuestions.get(0).getCorrectAnswerIndex(), actualQuestions.get(0).getCorrectAnswerIndex());
    }
}
