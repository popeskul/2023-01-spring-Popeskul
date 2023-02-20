package com.otus.homework.service;

import com.otus.homework.domain.Question;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class QuestionDaoLoader implements QuestionLoader {
    private final QuestionDao questionDao;

    public QuestionDaoLoader(QuestionDao questionDao) {
        this.questionDao = questionDao;
    }

    @Override
    public List<Question> load() {
        return questionDao.parse();
    }
}
