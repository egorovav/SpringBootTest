package org.egorovav.springboottest;

public interface TestQuestion {
    boolean checkAnswer(String answer);

    String getQuestion();

    String getAnswers();
}
