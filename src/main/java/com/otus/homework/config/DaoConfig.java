package com.otus.homework.config;

import com.otus.homework.service.QuestionDao;
import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@PropertySource("classpath:application.yml")
public class DaoConfig {
    private final CsvHolder csvHolder;

    public DaoConfig(CsvHolder csvHolder) {
        this.csvHolder = csvHolder;
    }

    @Bean
    public QuestionDao questionDao(MessageSource messageSource, LocaleHolder localeHolder, CsvFileNameProvider csvFileNameProvider) {
        String fileName = csvFileNameProvider.getFileName(localeHolder.getLocaleString());
        return new QuestionDao(messageSource, localeHolder, fileName);
    }

    @Bean
    public CsvFileNameProvider csvFileNameProvider() {
        return new CsvFileNameProviderImpl(csvHolder);
    }
}
