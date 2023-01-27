package com.otus.homework.service;

import com.otus.homework.dto.AnswerDTO;
import com.otus.homework.dto.QuestionDTO;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class CsvParseServiceTest {
    private CsvParseService csvParseService;

    @Mock
    private QuestionService questionService;

    @Mock
    private AnswerService answerService;

    @BeforeEach
    public void setup() {
        csvParseService = new CsvParseService("src/test/resources/questions_answers_test.csv", questionService, answerService);
    }

    @Test
    public void parseCsvQuestionsAndAnswersTest() throws IOException {
        // setup
        List<AnswerDTO> answers = new ArrayList<>();
        answers.add(new AnswerDTO("Answer1"));
        answers.add(new AnswerDTO("Answer2"));
        QuestionDTO question = new QuestionDTO("Question 1?", answers);
        List<QuestionDTO> expectedQuestions = new ArrayList<>();
        expectedQuestions.add(question);

        // mocking
        when(answerService.createAnswer("Answer1")).thenReturn(answers.get(0));
        when(answerService.createAnswer("Answer2")).thenReturn(answers.get(1));
        when(questionService.createQuestion("Question 1?", answers)).thenReturn(question);

        // execution
        List<QuestionDTO> actualQuestions = csvParseService.parseCsvQuestionsAndAnswers();

        // assertions
        assertEquals(expectedQuestions, actualQuestions);
        verify(answerService, times(2)).createAnswer(anyString());
        verify(questionService, times(1)).createQuestion(anyString(), anyList());
    }
}
