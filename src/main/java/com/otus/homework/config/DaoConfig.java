package com.otus.homework.config;

import com.otus.homework.service.QuestionDao;
import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@PropertySource("classpath:application.yml")
public class DaoConfig {
    private final AppProps props;

    public DaoConfig(AppProps props) {
        this.props = props;
    }

    @Bean
    public String fileName() {
        return props.getCsv().get(props.getLocaleString());
    }

    @Bean
    public QuestionDao questionDao(MessageSource messageSource, AppProps props) {
        return new QuestionDao(messageSource, props, fileName());
    }
}
