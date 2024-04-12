package org.egorovav.springboottest;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import java.util.List;
import java.util.Scanner;

@SpringBootApplication
public class SpringBootTestApplication {

	public static void main(String[] args) {

		ApplicationContext ctx = SpringApplication.run(SpringBootTestApplication.class, args);

		AppProperty appProperty = ctx.getBean(AppProperty.class);
		MessageFactory messageFactory = ctx.getBean(MessageFactory.class);
		List<TestQuestion> questions = (List<TestQuestion>)ctx.getBean("questions");
		Scanner scanner = new Scanner(System.in);
		System.out.println(messageFactory.getMessage("ask.name"));
		String name = scanner.nextLine();
		System.out.println(messageFactory.getMessage("ask.surname"));
		String surname = scanner.nextLine();
		System.out.println(messageFactory.getMessage("ask.answers", name, surname, questions.size()));
		System.out.println(messageFactory.getMessage("pass.value", appProperty.getPassValue()));
		int correctAnswersAmount = 0;
		for(int i = 0; i < questions.size(); i++) {
			System.out.format("%d. %s.\n", i + 1, questions.get(i).getQuestion());
			System.out.println(messageFactory.getMessage("select.one", questions.get(i).getAnswers()));
			String answer = scanner.nextLine();
			if(questions.get(i).checkAnswer(answer)) {
				correctAnswersAmount++;
			}
		}
		if(correctAnswersAmount < appProperty.getPassValue()) {
			System.out.println(messageFactory.getMessage("pass.fail"));
		} else {
			System.out.println(messageFactory.getMessage("pass.success"));
		}
	}
}
