package com.otus.homework.config;

import com.otus.homework.service.QuestionLoader;
import com.otus.homework.service.QuizServiceImpl;
import com.otus.homework.utils.ScannerWrapper;
import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ServiceConfig {
    @Bean
    public QuizServiceImpl quizService(MessageSource messageSource, AppProps props, QuestionLoader questionLoader, ScannerWrapper scannerWrapper) {
        return new QuizServiceImpl(messageSource, props, questionLoader, scannerWrapper);
    }
}
