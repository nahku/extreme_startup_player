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

    @Test
    public void canAnswerPrimes() {
        var contents = new Answerer().answerFor("Which of the following numbers are primes: 66, 19, 61, 33, 2?");

        assertThat(contents, equalTo("19, 61, 2"));
    }

    @Test
    public void canAnswerSub() {
        var contents = new Answerer().answerFor("What is 81 minus 4?");

        assertThat(contents, equalTo("77"));
    }

    @Test
    public void canAnswerPower() {
        var contents = new Answerer().answerFor("What is 2 to the power of 3?");

        assertThat(contents, equalTo("8"));
    }

    @Test
    public void canAnswerPower2() {
        var contents = new Answerer().answerFor("What is 35 to the power of 6?");

        assertThat(contents, equalTo("1838265625"));
    }

    @Test
    public void canAnswerAddMult() {
        var contents = new Answerer().answerFor("What is 65 multiplied by 32 plus 68?");

        assertThat(contents, equalTo("2148"));
    }

    @Test
    public void canAnswerMultAdd() {
        var contents = new Answerer().answerFor("What is 31 plus 72 multiplied by 49?");

        assertThat(contents, equalTo("3559"));
    }

    @Test
    public void canAnswerPower3() {
        var contents = new Answerer().answerFor("What is 33 to the power of 13?");

        assertThat(contents, equalTo("55040353993448503713"));
    }

    @Test
    public void canAnswerAnagram() {
        var contents = new Answerer().answerFor("Which of the following is an anagram of admirer: border, random, dairy, forgot, married?");

        assertThat(contents, equalTo("married"));
    }

    @Test
    public void canAnswerScrabble() {
        var contents = new Answerer().answerFor("What is the scrabble score of cloud?");

        assertThat(contents, equalTo("8"));
    }
}