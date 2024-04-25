package com.oocode;

import org.junit.jupiter.api.Test;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class AnswererTest {
    @Test
    public void canAnswerMyName() {
        var contents = new Answerer().answerFor("What is your name?");

        assertThat(contents, equalTo("ns"));
    }

    @Test
    public void canAnswerLargestNumber() {
        var contents = new Answerer().answerFor("Which of the following numbers is the largest: 61, 34, 86?");

        assertThat(contents, equalTo("86"));
    }

    @Test
    public void canAnswerAddition() {
        var contents = new Answerer().answerFor("What is 38 plus 26?");

        assertThat(contents, equalTo("64"));
    }

    @Test
    public void canAnswerMultiply() {
        var contents = new Answerer().answerFor("What is 57 multiplied by 40?");

        assertThat(contents, equalTo("2280"));
    }

    @Test
    public void canAnswerSquareCube() {
        var contents = new Answerer().answerFor("Which of the following numbers is both a square and a cube: 2721, 2974, 729, 2116, 2197, 2921, 4780?");

        assertThat(contents, equalTo("729"));
    }
}