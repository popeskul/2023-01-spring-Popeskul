package com.otus.homework.service;

import com.otus.homework.domain.Answer;
import com.otus.homework.domain.Question;
import com.otus.homework.utils.ScannerWrapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class QuizServiceImplTest {
    private QuizServiceImpl quizService;
    private ScannerWrapper scanner;

    @BeforeEach
    void setUp() {
        scanner = mock(ScannerWrapper.class);

        when(scanner.nextLine()).thenReturn("John", "Smith");
        when(scanner.nextInt()).thenReturn(1);

        List<Answer> answers = new ArrayList<>();
        answers.add(new Answer("Answer1"));
        answers.add(new Answer("Answer2"));
        int correctAnswerIndex = 1;
        Question question = new Question("Question 1?", answers, correctAnswerIndex);
        List<Question> expectedQuestions = new ArrayList<>();
        expectedQuestions.add(question);

        QuestionDaoLoader questionDaoLoader = mock(QuestionDaoLoader.class);
        when(questionDaoLoader.load()).thenReturn(expectedQuestions);

        quizService = new QuizServiceImpl(questionDaoLoader, scanner);
    }

    @Test
    public void startQuiz_shouldAskQuestions() {
        quizService.startQuiz();
        verify(scanner, times(2)).nextLine();
        verify(scanner, times(1)).nextInt();
    }
}
