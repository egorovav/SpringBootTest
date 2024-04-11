package org.egorovav.springboottest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.util.FileCopyUtils;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.UncheckedIOException;
import java.util.ArrayList;
import java.util.List;

import static java.nio.charset.StandardCharsets.UTF_8;

@Configuration
public class SpringTestApplicationContext {

    @Autowired
    AppProperty appProperty;

    @Bean
    public List<TestQuestion> questions() throws IOException {
        List<TestQuestion> questions = new ArrayList<>();
        InputStream questionStream = this.getClass().getResourceAsStream(appProperty.getPath());
        try (InputStreamReader reader = new InputStreamReader(questionStream, UTF_8)) {
             String questionsString = FileCopyUtils.copyToString(reader);
             String[] questionStrings = questionsString.split("\n");
            for(String questionString : questionStrings) {
                questions.add(new TestQuestionImpl(questionString));
            }
        } catch (IOException e) {
            throw new UncheckedIOException(e);
        }

        return questions;
    }
}
