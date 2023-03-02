package com.otus.homework.shell;

import com.otus.homework.service.QuizService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.boot.test.mock.mockito.SpyBean;
import org.springframework.shell.InputProvider;
import org.springframework.shell.ResultHandlerService;
import org.springframework.shell.Shell;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.*;

@SpringBootTest
class QuizCLITest {
    private static final String COMMAND_START = "start";
    private static final String COMMAND_INFO = "info";
    private static final String INFO_MESSAGE = "Info!";

    private ArgumentCaptor<Object> argumentCaptor;

    @Mock
    private InputProvider inputProvider;

    @SpyBean
    private ResultHandlerService resultHandlerService;

    @Autowired
    private Shell shell;

    @MockBean
    private QuizService quizService;

    @BeforeEach
    void setUp() {
        argumentCaptor = ArgumentCaptor.forClass(Object.class);
    }

    @Test
    void info() throws Exception {
        when(inputProvider.readInput())
                .thenReturn(() -> COMMAND_INFO)
                .thenReturn(null);

        shell.run(inputProvider);

        verify(resultHandlerService, times(1)).handle(argumentCaptor.capture());
        verify(resultHandlerService).handle(INFO_MESSAGE);

        List<Object> results = argumentCaptor.getAllValues();

        assertThat(results).containsExactlyInAnyOrder(
                String.format(INFO_MESSAGE)
        );
    }

    @Test
    void startQuiz() throws Exception {
        when(inputProvider.readInput())
                .thenReturn(() -> COMMAND_START)
                .thenReturn(null);

        shell.run(inputProvider);

        verify(resultHandlerService, times(1)).handle(argumentCaptor.capture());
        verify(quizService, times(1)).startQuiz();
    }
}