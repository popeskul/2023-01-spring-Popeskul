package com.otus.homework.service;

import com.otus.homework.domain.Question;

import java.util.List;

public interface QuestionLoader {
    List<Question> load();
}
