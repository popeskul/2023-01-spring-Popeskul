package com.otus.homework;

import com.otus.homework.dto.QuestionDTO;
import com.otus.homework.service.CsvParseService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.io.IOException;
import java.util.List;

@SpringBootApplication
public class Application {
    public static void main(String[] args) throws IOException {
        SpringApplication.run(Application.class, args);

        ApplicationContext context = new ClassPathXmlApplicationContext("spring-context.xml");
        CsvParseService csvParseService = context.getBean(CsvParseService.class);
        List<QuestionDTO> questionsAndAnswers = csvParseService.parseCsvQuestionsAndAnswers();

        questionsAndAnswers.forEach(System.out::println);
    }
}
