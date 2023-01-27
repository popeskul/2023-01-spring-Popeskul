package com.otus.homework.service;

import com.otus.homework.dto.AnswerDTO;
import com.otus.homework.dto.QuestionDTO;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class QuestionService {
    public QuestionDTO createQuestion(String title, List<AnswerDTO> answers) {
        return new QuestionDTO(title, answers);
    }
}
