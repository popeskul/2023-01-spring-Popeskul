package com.otus.homework.service;

import com.otus.homework.config.AppProps;
import com.otus.homework.domain.Question;
import com.otus.homework.utils.ScannerWrapper;
import org.springframework.context.MessageSource;

import java.util.List;

public class QuizServiceImpl implements QuizService {
    private final QuestionLoader questionLoader;
    private final ScannerWrapper scanner;
    private final MessageSource messageSource;
    private final AppProps props;

    public QuizServiceImpl(MessageSource messageSource, AppProps props, QuestionLoader questionLoader, ScannerWrapper scannerWrapper) {
        this.messageSource = messageSource;
        this.props = props;
        this.questionLoader = questionLoader;
        this.scanner = scannerWrapper;
    }

    @Override
    public void startQuiz() {
        List<Question> questions = questionLoader.load();

        System.out.print(messageSource.getMessage("quiz_service.enter_name", null, props.getLocale()) + ": ");

        String name = scanner.nextLine();

        System.out.println(messageSource.getMessage("quiz_service.welcome", new String[]{name}, props.getLocale()));

        int correctAnswers = 0;
        int maxQuestions = Math.min(questions.size(), 5);

        for (int i = 0; i < maxQuestions; i++) {
            Question question = questions.get(i);

            System.out.println(messageSource.getMessage("quiz_service.question_title", new Object[]{i + 1, question.getText()}, props.getLocale()));
            System.out.println(messageSource.getMessage("quiz_service.choices", null, props.getLocale()));

            for (int j = 0; j < question.getAnswers().size(); j++) {
                System.out.println((j + 1) + ". " + question.getAnswers().get(j).getText());
            }

            System.out.print(messageSource.getMessage("quiz_service.enter_correct_answer", new Integer[]{question.getAnswers().size()}, props.getLocale()));
            int answer = scanner.nextInt();
            if (answer == question.getCorrectAnswerIndex()) {
                correctAnswers++;
            }
        }

        System.out.println(messageSource.getMessage("quiz_service.correct_answer", new Integer[]{correctAnswers}, props.getLocale()));
    }
}
