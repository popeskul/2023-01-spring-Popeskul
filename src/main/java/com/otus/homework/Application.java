package com.otus.homework;

import com.otus.homework.service.QuizService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan
public class Application {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(Application.class);
        QuizService quizService = context.getBean(QuizService.class);
        quizService.startQuiz();
    }
}
