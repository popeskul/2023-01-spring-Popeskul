package com.otus.homework.config;

import com.otus.homework.service.QuestionDao;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@PropertySource("classpath:application.properties")
public class DaoConfig {
    @Value("${questions_answers_csv}")
    private String fileName;

    @Bean
    public QuestionDao questionDao() {
        return new QuestionDao(fileName);
    }
}
