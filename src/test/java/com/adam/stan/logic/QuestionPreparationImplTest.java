package com.adam.stan.logic;

import com.adam.stan.clients.AnswerClient;
import com.adam.stan.model.Answer;
import com.adam.stan.model.AnswerType;
import com.adam.stan.model.Category;
import com.adam.stan.model.Question;
import com.adam.stan.util.exceptions.NotEnoughItemsOnListException;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class QuestionPreparationImplTest {
    private final static List<Answer> OPTIONS_WITHOUT_CORRECT_ANSWER = new ArrayList<>();
    private final static List<Answer> OPTIONS_WITH_CORRECT_ANSWER = new ArrayList<>();
    private static Question question;

    QuestionPreparationImpl preparation = new QuestionPreparationImpl();
    private AnswerClient client;

    @BeforeAll
    static void setUpData() {
        Answer correctAnswer = new Answer();
        correctAnswer.setAnswer("answer_correct");
        correctAnswer.setCategory(new Category("cat1"));
        correctAnswer.setType(new AnswerType("type1"));

        question = new Question();
        question.setText("Text???");
        question.setCorrect_answer(correctAnswer);

        OPTIONS_WITH_CORRECT_ANSWER.addAll(Arrays.asList(
                correctAnswer,
                new Answer("ans1"),
                new Answer("ans2"),
                new Answer("ans3")
        ));
        OPTIONS_WITHOUT_CORRECT_ANSWER.addAll(Arrays.asList(
                new Answer("ans1"),
                new Answer("ans2"),
                new Answer("ans4"),
                new Answer("ans5")
        ));
    }

    @BeforeEach
    void setUp() {
        client = mock(AnswerClient.class);
        preparation.setClient(client);
    }

    @ParameterizedTest
    @MethodSource("answerProviders")
    void createQuestionTest(List<Answer> answers) throws NotEnoughItemsOnListException {
        when(client.getAnswersByTypeAndCategory(any(), any())).thenReturn(answers);
        QuestionDto json = preparation.createQuestion(question, 4);
        assertThat(json.getOtherAnswers()).contains(json.getCorrectAnswer());
    }

    @Test
    void createQuestion_notEnoughAnswers() {
        when(client.getAnswersByTypeAndCategory(any(), any())).thenReturn(OPTIONS_WITH_CORRECT_ANSWER);
        assertThrows(NotEnoughItemsOnListException.class, () -> {
            preparation.createQuestion(question, 5);
        });
    }

    public static List<List<Answer>> answerProviders() {
        return List.of(
                OPTIONS_WITH_CORRECT_ANSWER,
                OPTIONS_WITHOUT_CORRECT_ANSWER
        );
    }
}
