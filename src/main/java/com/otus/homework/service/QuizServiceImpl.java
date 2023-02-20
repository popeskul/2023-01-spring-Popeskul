package com.otus.homework.service;

import com.otus.homework.domain.Question;
import com.otus.homework.utils.ScannerWrapper;

import java.util.List;

public class QuizServiceImpl implements QuizService {
    private final QuestionLoader questionLoader;
    private final ScannerWrapper scanner;

    public QuizServiceImpl(QuestionLoader questionLoader, ScannerWrapper scannerWrapper) {
        this.questionLoader = questionLoader;
        this.scanner = scannerWrapper;
    }

    @Override
    public void startQuiz() {
        List<Question> questions = questionLoader.load();
        System.out.print("Enter your last name: ");
        String lastName = scanner.nextLine();
        System.out.print("Enter your first name: ");
        String firstName = scanner.nextLine();

        System.out.println("Hi " + firstName + " " + lastName + ", welcome to the test!");
        int correctAnswers = 0;

        int maxQuestions = Math.min(questions.size(), 5);

        for (int i = 0; i < maxQuestions; i++) {
            Question question = questions.get(i);
            System.out.println("Question " + (i + 1) + ": " + question.getText());
            System.out.println("Choices:");
            for (int j = 0; j < question.getAnswers().size(); j++) {
                System.out.println((j + 1) + ". " + question.getAnswers().get(j).getText());
            }
            System.out.print("Enter your answer (1 to " + question.getAnswers().size() + "): ");
            int answer = scanner.nextInt();
            if (answer == question.getCorrectAnswerIndex()) {
                correctAnswers++;
            }
        }
        System.out.println("You got " + correctAnswers + " out of 5 correct!");
    }
}
