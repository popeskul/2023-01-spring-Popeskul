package com.otus.homework;

import com.otus.homework.service.QuestionDao;
import com.otus.homework.service.Parser;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Application {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("spring-context.xml");
        Parser csvParseService = context.getBean(QuestionDao.class);
        csvParseService.parse();
    }
}
