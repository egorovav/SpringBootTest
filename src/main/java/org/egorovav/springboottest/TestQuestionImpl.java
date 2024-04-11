package org.egorovav.springboottest;

import java.util.Arrays;

public class TestQuestionImpl implements TestQuestion {

    private String question;
    private String answers;
    private String correctAnswer;

    public TestQuestionImpl(String inputString) {
        String[] inputArray = inputString.split(",");
        question = inputArray[0];
        answers = String.join(",", Arrays.copyOfRange(inputArray, 1, 4));
        correctAnswer = inputArray[4];
    }

    public boolean checkAnswer(String answer) {
        if(answer == null) {
            return false;
        }
        return answer.equals(correctAnswer);
    }

    public String getQuestion() {
        return question;
    }

    public String getAnswers() {
        return answers;
    }
}
