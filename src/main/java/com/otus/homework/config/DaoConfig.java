package com.otus.homework.config;

import com.otus.homework.service.QuestionDao;
import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.io.Resource;

@Configuration
@PropertySource("classpath:application.yml")
public class DaoConfig {
    @Bean
    public QuestionDao questionDao(MessageSource messageSource, LocaleHolder localeHolder, CsvFileResourceProvider csvFileResourceProvider) {
        Resource resource = csvFileResourceProvider.getCsvFileResource(localeHolder.getLocaleString());
        return new QuestionDao(messageSource, localeHolder, resource);
    }
}
