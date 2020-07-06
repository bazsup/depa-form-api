package com.depa.form.model;

import com.depa.form.model.question.ChoiceQuestion;
import com.depa.form.model.question.Question;
import com.depa.form.model.question.QuestionType;
import com.depa.form.model.question.TextQuestion;
import org.junit.Assert;
import org.junit.Test;

public class QuestionTest {
    @Test
    public void shouldAbleToCreateQuestionTextType() {
        Question textQuestion = new TextQuestion();

        Assert.assertEquals(QuestionType.TEXT, textQuestion.getType());
    }

    @Test
    public void shouldAbleToCreateQuestionChoiceType() {
        Question choiceQuestion = new ChoiceQuestion();

        Assert.assertEquals(QuestionType.CHOICE, choiceQuestion.getType());
    }

    @Test
    public void shouldAbleToAddChoiceWhenQuestionTypeIsChoice() {
        int expectedChoicesSize = 2;

        ChoiceQuestion choiceQuestion = new ChoiceQuestion();
        choiceQuestion.addChoice("choice 1");
        choiceQuestion.addChoice("choice 2");

        Assert.assertEquals(expectedChoicesSize, choiceQuestion.getChoices().size());
    }

}
