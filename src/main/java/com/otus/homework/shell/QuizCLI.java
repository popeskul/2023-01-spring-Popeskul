package com.otus.homework.shell;

import com.otus.homework.service.QuizService;
import lombok.RequiredArgsConstructor;
import org.springframework.shell.standard.ShellComponent;
import org.springframework.shell.standard.ShellMethod;

@ShellComponent
@RequiredArgsConstructor
public class QuizCLI {
    private final String INFO_MESSAGE = "Info!";
    private final QuizService quizService;

    @ShellMethod(value = "Info", key = {"info", "i"})
    public String info() {
        return INFO_MESSAGE;
    }

    @ShellMethod(value = "Start quiz", key = {"start", "s"})
    public void startQuiz() {
        quizService.startQuiz();
    }
}
