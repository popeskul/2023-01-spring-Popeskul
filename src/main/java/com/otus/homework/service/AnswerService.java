package com.otus.homework.service;

import com.otus.homework.dto.AnswerDTO;
import org.springframework.stereotype.Service;

@Service
public class AnswerService {
    public AnswerDTO createAnswer(String text) {
        return new AnswerDTO(text);
    }
}
