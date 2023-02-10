package com.otus.homework.config;

import com.otus.homework.service.QuestionDao;
import com.otus.homework.service.QuizService;
import com.otus.homework.utils.ScannerWrapper;
import com.otus.homework.utils.ScannerWrapperImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration
@Import(DaoConfig.class)
public class ServiceConfig {
    @Bean
    public ScannerWrapper scannerWrapper() {
        return new ScannerWrapperImpl();
    }

    @Bean
    public QuizService quizService(QuestionDao questionDao, ScannerWrapper scannerWrapper) {
        return new QuizService(questionDao.parse(), scannerWrapper);
    }
}
