package com.otus.homework.config;

import com.otus.homework.service.QuestionLoader;
import com.otus.homework.service.QuizServiceImpl;
import com.otus.homework.utils.ScannerWrapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration
@Import(DaoConfig.class)
public class ServiceConfig {
    @Bean
    public QuizServiceImpl quizService(QuestionLoader questionLoader, ScannerWrapper scannerWrapper) {
        return new QuizServiceImpl(questionLoader, scannerWrapper);
    }
}
