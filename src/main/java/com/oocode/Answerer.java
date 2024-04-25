package com.oocode;

public class Answerer {
    public String answerFor(String question) {
        switch (question){
            case "What is your name?":
                return "ns";
            default:
                return "Someone";
        }
    }
}
